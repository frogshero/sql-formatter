package com.hubery.formatter.walker;

import com.hubery.formatter.grammar.MySqlParser;
import com.hubery.formatter.grammar.MySqlParser.*;
import com.hubery.formatter.grammar.MySqlParserBaseListener;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@Slf4j
public class MyMySqlParserListener extends MySqlParserBaseListener {
    private int level = 0;

    private void prt(String ident, String str) {
        System.out.println(ident + str);
    }

    private void prtIndent(String str, boolean ret) {
        if (ret) {
            System.out.println();
            System.out.print(StringUtils.repeat(' ', level * 4));
        } else {
            System.out.print(" ");
        }
        System.out.print(str);
    }

    @Override public void enterUid(MySqlParser.UidContext ctx) {
        prtIndent(ctx.getText(), false);
    }

    @Override public void exitTableSources(TableSourcesContext ctx) {
        FromClauseContext from = ((FromClauseContext)ctx.parent);
        if (from.WHERE() != null) {
            prtIndent(from.WHERE().getText(), true);
        }
    }

    @Override
    public void enterQuerySpecification(QuerySpecificationContext ctx) {
        level++;
        prtIndent( "SELECT", true);
    }

    @Override
    public void exitQuerySpecification(QuerySpecificationContext ctx) {
        level--;
//        prt("exitQuerySpecification", ctx.getText());
    }

    @Override
    public void enterFromClause(MySqlParser.FromClauseContext ctx) {
        prtIndent( "FROM", true);
    }

    @Override public void enterSelectElements(MySqlParser.SelectElementsContext ctx) {
        prtIndent(ctx.getText(), false);
    }

}
