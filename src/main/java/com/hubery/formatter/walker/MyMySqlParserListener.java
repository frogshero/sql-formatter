package com.hubery.formatter.walker;

import com.hubery.formatter.grammar.MySqlParser;
import com.hubery.formatter.grammar.MySqlParserBaseListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyMySqlParserListener extends MySqlParserBaseListener {
    @Override
    public void enterSimpleSelect(MySqlParser.SimpleSelectContext ctx) {
        log.info(ctx.getText());
    }

    @Override
    public void exitSimpleSelect(MySqlParser.SimpleSelectContext ctx) {
        log.info(ctx.getText());
    }

    @Override
    public void exitFromClause(MySqlParser.FromClauseContext ctx) {
        log.info(ctx.getText());
    }

    @Override
    public void enterFromClause(MySqlParser.FromClauseContext ctx) {
        log.info(ctx.getText());
    }
}
