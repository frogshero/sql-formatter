package com.hubery.formatter.my;

import com.hubery.formatter.grammar.MySqlParser;
import com.hubery.formatter.grammar.MySqlParserBaseVisitor;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

import static com.hubery.formatter.grammar.MySqlParser.*;

public class MyMySqlParserVisitor extends MySqlParserBaseVisitor<String> {
    private int[] NEXT_LINE_KEY = {SELECT, FROM, WHERE, INNER, LEFT, AND, GROUP, LIMIT, ORDER, UNION};
    private char[] NO_SPACE_AFTER = {'.', '(', '!', '>', '<'};
    private char[] NO_SPACE_BEFORE = {' ', ',', '.', '(', ')'};
    private char NEXT_LINE = '\n';
    private int MAX_LINE_LEN = 120;
    private int MAX_AS_LEN = 80;
    private int level = 0;

    private String nvl(String s) {
        return s == null ? "" : s;
    }
    private boolean noSpaceBefore(char c) {
        for (char cc : NO_SPACE_BEFORE) {
            if (cc == c) {
                return true;
            }
        }
        return false;
    }
    private boolean noSpaceAfter(char c) {
        for (char cc : NO_SPACE_AFTER) {
            if (cc == c) {
                return true;
            }
        }
        return false;
    }
    private boolean hasSubQuery(ParseTree ctx) {
        for (int i=0; i<ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof QuerySpecificationContext) {
                return true;
            } else {
                boolean childHas = hasSubQuery(child);
                if (childHas) return true;
            }
        }
        return false;
    }

    /**
     * 是否添加空格取决于空格两边的字符，覆盖了AbstractParseTreeVisitor的方法
     * @param aggregate
     * @param nextResult
     * @return
     */
    @Override
    protected String aggregateResult(String aggregate, String nextResult) {
        boolean appendSpace = true;
        if (StringUtils.isBlank(aggregate)) {
            appendSpace = false;
        } else {
            if (noSpaceAfter(aggregate.charAt(nvl(aggregate).length() - 1))) {
                appendSpace = false;
            }
        }

        if (StringUtils.isBlank(nextResult)) {
            appendSpace = false;
        } else {
            if (noSpaceBefore(nextResult.charAt(0))) {
                appendSpace = false;
            }
        }

        return nvl(aggregate) + (appendSpace ? " " : "") + nvl(nextResult);
    }
    private boolean isLastOne(List list, Object o) {
        return o == list.get(list.size() - 1);
    }

    private String nextLinePrefix(int indent) {
        return NEXT_LINE + StringUtils.repeat(" ", (level + indent) * 4);
    }
    /**
     * 是否换行？取决于特定关键字
     * @param node
     * @return
     */
    @Override
    public String visitTerminal(TerminalNode node) {
//        if (node.getSymbol().getType() == STAR) {
//            System.out.print("xxx");
//        }
        boolean nextLine = Arrays.stream(NEXT_LINE_KEY).anyMatch(e -> e == node.getSymbol().getType());
        //+ (node.getSymbol().getType() == SELECT ? "\n" : "")
        return (nextLine ? nextLinePrefix(0) : "") + node.getText();
    }


    @Override
    public String visitSelectElements(MySqlParser.SelectElementsContext ctx) {
        //字段列表换行
        SelectElementsWrapperBuilder wrapperBuilder = new SelectElementsWrapperBuilder(MAX_AS_LEN, MAX_LINE_LEN, nextLinePrefix(1));

        //star='*' | selectElement
        if (ctx.selectElement().size() == 0) {
            wrapperBuilder.addText(ctx.star.getText());
        } else {
            for (SelectElementContext child : ctx.selectElement()) {
                String childStr = visit(child);
                wrapperBuilder.addText(childStr);
            }
        }
        return wrapperBuilder.getText();
    }

//    @Override public String visitSelectFunctionElement(SelectFunctionElementContext ctx) {
//        return visitChildren(ctx) + (hasSubQuery(ctx) ? NEXT_LINE : "");
//    }
//    @Override public String visitSelectExpressionElement(SelectExpressionElementContext ctx) {
//        return visitChildren(ctx) + (hasSubQuery(ctx) ? NEXT_LINE : "");
//    }

//    @Override
//    public String visitSubqueryExpressionAtom(SubqueryExpressionAtomContext ctx) {
//        return "(" + visit(ctx.selectStatement()) + ")\n";
//    }

    private String enterSelect(ParserRuleContext ctx) {
        level++;
        String ret = visitChildren(ctx);
        level--;
        return ret + nextLinePrefix(1);
    }
    /**
     * select SQL的嵌套层次
     * @param ctx
     * @return
     */
    @Override
    public String visitQuerySpecification(QuerySpecificationContext ctx) {
        return enterSelect(ctx);
    }

    @Override
    public String visitQuerySpecificationNointo(QuerySpecificationNointoContext ctx) {
        return enterSelect(ctx);
    }

//    @Override public String visitCaseFunctionCall(MySqlParser.CaseFunctionCallContext ctx) {
//        return visitChildren(ctx);
//    }
    //When子句
    @Override
    public String visitCaseFuncAlternative(MySqlParser.CaseFuncAlternativeContext ctx) {
        String childStr = visitChildren(ctx);
        if (!StringUtils.isBlank(childStr) && ctx != ctx.parent.getChild(1)) {
            return  nextLinePrefix(2) + childStr;
        } else {
            return childStr;
        }
    }
}
