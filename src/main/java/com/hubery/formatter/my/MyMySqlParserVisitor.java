package com.hubery.formatter.my;

import com.hubery.formatter.grammar.MySqlParser;
import com.hubery.formatter.grammar.MySqlParserBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

import static com.hubery.formatter.grammar.MySqlParser.*;

public class MyMySqlParserVisitor extends MySqlParserBaseVisitor<String> {
    private int[] NEXT_LINE_KEY = {SELECT, FROM, WHERE, INNER, LEFT, AND, GROUP, LIMIT, ORDER};
    private char[] NO_SPACE_AFTER = {'.', '(', '!'};
    private char[] NO_SPACE_BEFORE = {' ', ',', '.', '(', ')'};
    private char NEXT_LINE = '\n';
    private int MAX_LINE_LEN = 80;
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

    /**
     * 是否换行？取决于特定关键字
     * @param node
     * @return
     */
    @Override
    public String visitTerminal(TerminalNode node) {
        boolean nextLine = Arrays.stream(NEXT_LINE_KEY).anyMatch(e -> e == node.getSymbol().getType());
        //+ (node.getSymbol().getType() == SELECT ? "\n" : "")
        return (nextLine ? NEXT_LINE
                + StringUtils.repeat(" ", level*4) : "") + node.getText();
    }

    @Override
    public String visitSelectElements(MySqlParser.SelectElementsContext ctx) {
        //字段列表换行
        String nextLineAppend = "\n" + StringUtils.repeat(" ", (level+1)*4);
        StringBuilder sb = new StringBuilder();
//        StringBuilder sbLine = new StringBuilder();
        for (SelectElementContext child : ctx.selectElement()) {
            String childStr = visit(child);
            sb.append(childStr);
            if (!isLastOne(ctx.selectElement(), child)) {
                sb.append(", ");
                if (hasSubQuery(child)) {
                    sb.append("\n" + nextLineAppend);
                } else if (childStr.length() > 50) {
                    sb.append(nextLineAppend);
                }
            }
            //sb.append(hasSubQuery(child) && !isLastOne(ctx.selectElement(), child) ? "\n" + nextLineAppend : "");
        }
        return sb.toString();
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

    /**
     * select SQL的嵌套层次
     * @param ctx
     * @return
     */
    @Override
    public String visitQuerySpecification(QuerySpecificationContext ctx) {
        level++;
        String ret = visitChildren(ctx);
        level--;
        return ret;
    }

}
