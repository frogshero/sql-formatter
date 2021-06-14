package com.hubery.formatter.my;

import com.hubery.formatter.grammar.MySqlParser;
import com.hubery.formatter.grammar.MySqlParserBaseListener;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.StringUtils;

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

    @Override public void enterIntervalType(MySqlParser.IntervalTypeContext ctx) { }
    @Override public void exitIntervalType(MySqlParser.IntervalTypeContext ctx) { }
    @Override public void enterSimpleSelect(MySqlParser.SimpleSelectContext ctx) { }
    @Override public void exitSimpleSelect(MySqlParser.SimpleSelectContext ctx) { }
    @Override public void enterParenthesisSelect(MySqlParser.ParenthesisSelectContext ctx) { }
    @Override public void exitParenthesisSelect(MySqlParser.ParenthesisSelectContext ctx) { }
    @Override public void enterUnionSelect(MySqlParser.UnionSelectContext ctx) { }
    @Override public void exitUnionSelect(MySqlParser.UnionSelectContext ctx) { }
    @Override public void enterUnionParenthesisSelect(MySqlParser.UnionParenthesisSelectContext ctx) { }
    @Override public void exitUnionParenthesisSelect(MySqlParser.UnionParenthesisSelectContext ctx) { }
    @Override public void enterOrderByClause(MySqlParser.OrderByClauseContext ctx) { }
    @Override public void exitOrderByClause(MySqlParser.OrderByClauseContext ctx) { }
    @Override public void enterOrderByExpression(MySqlParser.OrderByExpressionContext ctx) { }
    @Override public void exitOrderByExpression(MySqlParser.OrderByExpressionContext ctx) { }
    @Override public void enterTableSources(MySqlParser.TableSourcesContext ctx) { }
    @Override public void exitTableSources(MySqlParser.TableSourcesContext ctx) {
        MySqlParser.FromClauseContext from = ((MySqlParser.FromClauseContext)ctx.parent);
        if (from.WHERE() != null) {
            prtIndent(from.WHERE().getText(), true);
        }
    }
    @Override public void enterTableSourceBase(MySqlParser.TableSourceBaseContext ctx) { }
    @Override public void exitTableSourceBase(MySqlParser.TableSourceBaseContext ctx) { }
    @Override public void enterTableSourceNested(MySqlParser.TableSourceNestedContext ctx) { }
    @Override public void exitTableSourceNested(MySqlParser.TableSourceNestedContext ctx) { }
    @Override public void enterAtomTableItem(MySqlParser.AtomTableItemContext ctx) { }
    @Override public void exitAtomTableItem(MySqlParser.AtomTableItemContext ctx) { }
    @Override public void enterSubqueryTableItem(MySqlParser.SubqueryTableItemContext ctx) { }
    @Override public void exitSubqueryTableItem(MySqlParser.SubqueryTableItemContext ctx) { }
    @Override public void enterTableSourcesItem(MySqlParser.TableSourcesItemContext ctx) { }
    @Override public void exitTableSourcesItem(MySqlParser.TableSourcesItemContext ctx) { }
    @Override public void enterIndexHint(MySqlParser.IndexHintContext ctx) { }
    @Override public void exitIndexHint(MySqlParser.IndexHintContext ctx) { }
    @Override public void enterIndexHintType(MySqlParser.IndexHintTypeContext ctx) { }
    @Override public void exitIndexHintType(MySqlParser.IndexHintTypeContext ctx) { }
    @Override public void enterInnerJoin(MySqlParser.InnerJoinContext ctx) { }
    @Override public void exitInnerJoin(MySqlParser.InnerJoinContext ctx) { }
    @Override public void enterStraightJoin(MySqlParser.StraightJoinContext ctx) { }
    @Override public void exitStraightJoin(MySqlParser.StraightJoinContext ctx) { }
    @Override public void enterOuterJoin(MySqlParser.OuterJoinContext ctx) { }
    @Override public void exitOuterJoin(MySqlParser.OuterJoinContext ctx) { }
    @Override public void enterNaturalJoin(MySqlParser.NaturalJoinContext ctx) { }
    @Override public void exitNaturalJoin(MySqlParser.NaturalJoinContext ctx) { }
    @Override public void enterQueryExpression(MySqlParser.QueryExpressionContext ctx) { }
    @Override public void exitQueryExpression(MySqlParser.QueryExpressionContext ctx) { }
    @Override public void enterQueryExpressionNointo(MySqlParser.QueryExpressionNointoContext ctx) { }
    @Override public void exitQueryExpressionNointo(MySqlParser.QueryExpressionNointoContext ctx) { }
    @Override public void enterQuerySpecification(MySqlParser.QuerySpecificationContext ctx) {
        level++;
        prtIndent( "SELECT", true);
    }
    @Override public void exitQuerySpecification(MySqlParser.QuerySpecificationContext ctx) {
        level--;
    }
    @Override public void enterQuerySpecificationNointo(MySqlParser.QuerySpecificationNointoContext ctx) { }
    @Override public void exitQuerySpecificationNointo(MySqlParser.QuerySpecificationNointoContext ctx) { }
    @Override public void enterUnionParenthesis(MySqlParser.UnionParenthesisContext ctx) { }
    @Override public void exitUnionParenthesis(MySqlParser.UnionParenthesisContext ctx) { }
    @Override public void enterUnionStatement(MySqlParser.UnionStatementContext ctx) { }
    @Override public void exitUnionStatement(MySqlParser.UnionStatementContext ctx) { }
    @Override public void enterSelectSpec(MySqlParser.SelectSpecContext ctx) { }
    @Override public void exitSelectSpec(MySqlParser.SelectSpecContext ctx) { }
    @Override public void enterSelectElements(MySqlParser.SelectElementsContext ctx) {
    }
    @Override public void exitSelectElements(MySqlParser.SelectElementsContext ctx) { }
    @Override public void enterSelectStarElement(MySqlParser.SelectStarElementContext ctx) {
        prtIndent(ctx.getText(), false);
    }
    @Override public void exitSelectStarElement(MySqlParser.SelectStarElementContext ctx) { }
    @Override public void enterSelectColumnElement(MySqlParser.SelectColumnElementContext ctx) {
        prtIndent(ctx.getText(), false);
    }
    @Override public void exitSelectColumnElement(MySqlParser.SelectColumnElementContext ctx) { }
    @Override public void enterSelectFunctionElement(MySqlParser.SelectFunctionElementContext ctx) {
//        prtIndent(ctx.getText(), false);
    }
    @Override public void exitSelectFunctionElement(MySqlParser.SelectFunctionElementContext ctx) { }
    @Override public void enterSelectExpressionElement(MySqlParser.SelectExpressionElementContext ctx) { }
    @Override public void exitSelectExpressionElement(MySqlParser.SelectExpressionElementContext ctx) { }
    @Override public void enterFromClause(MySqlParser.FromClauseContext ctx) {
        prtIndent( "FROM", true);
    }
    @Override public void exitFromClause(MySqlParser.FromClauseContext ctx) { }
    @Override public void enterGroupByClause(MySqlParser.GroupByClauseContext ctx) { }
    @Override public void exitGroupByClause(MySqlParser.GroupByClauseContext ctx) { }
    @Override public void enterHavingClause(MySqlParser.HavingClauseContext ctx) { }
    @Override public void exitHavingClause(MySqlParser.HavingClauseContext ctx) { }
    @Override public void enterGroupByItem(MySqlParser.GroupByItemContext ctx) { }
    @Override public void exitGroupByItem(MySqlParser.GroupByItemContext ctx) { }
    @Override public void enterLimitClause(MySqlParser.LimitClauseContext ctx) { }
    @Override public void exitLimitClause(MySqlParser.LimitClauseContext ctx) { }
    @Override public void enterLimitClauseAtom(MySqlParser.LimitClauseAtomContext ctx) { }
    @Override public void exitLimitClauseAtom(MySqlParser.LimitClauseAtomContext ctx) { }
    @Override public void enterFullId(MySqlParser.FullIdContext ctx) { }
    @Override public void exitFullId(MySqlParser.FullIdContext ctx) { }
    @Override public void enterTableName(MySqlParser.TableNameContext ctx) { }
    @Override public void exitTableName(MySqlParser.TableNameContext ctx) { }
    @Override public void enterFullColumnName(MySqlParser.FullColumnNameContext ctx) { }
    @Override public void exitFullColumnName(MySqlParser.FullColumnNameContext ctx) { }
    @Override public void enterMysqlVariable(MySqlParser.MysqlVariableContext ctx) { }
    @Override public void exitMysqlVariable(MySqlParser.MysqlVariableContext ctx) { }
    @Override public void enterCharsetName(MySqlParser.CharsetNameContext ctx) { }
    @Override public void exitCharsetName(MySqlParser.CharsetNameContext ctx) { }
    @Override public void enterCollationName(MySqlParser.CollationNameContext ctx) { }
    @Override public void exitCollationName(MySqlParser.CollationNameContext ctx) { }
    @Override public void enterUid(MySqlParser.UidContext ctx) {

    }
    @Override public void exitUid(MySqlParser.UidContext ctx) { }
    @Override public void enterSimpleId(MySqlParser.SimpleIdContext ctx) { }
    @Override public void exitSimpleId(MySqlParser.SimpleIdContext ctx) { }
    @Override public void enterDottedId(MySqlParser.DottedIdContext ctx) { }
    @Override public void exitDottedId(MySqlParser.DottedIdContext ctx) { }
    @Override public void enterDecimalLiteral(MySqlParser.DecimalLiteralContext ctx) { }
    @Override public void exitDecimalLiteral(MySqlParser.DecimalLiteralContext ctx) { }
    @Override public void enterStringLiteral(MySqlParser.StringLiteralContext ctx) { }
    @Override public void exitStringLiteral(MySqlParser.StringLiteralContext ctx) { }
    @Override public void enterBooleanLiteral(MySqlParser.BooleanLiteralContext ctx) { }
    @Override public void exitBooleanLiteral(MySqlParser.BooleanLiteralContext ctx) { }
    @Override public void enterHexadecimalLiteral(MySqlParser.HexadecimalLiteralContext ctx) { }
    @Override public void exitHexadecimalLiteral(MySqlParser.HexadecimalLiteralContext ctx) { }
    @Override public void enterNullNotnull(MySqlParser.NullNotnullContext ctx) { }
    @Override public void exitNullNotnull(MySqlParser.NullNotnullContext ctx) { }
    @Override public void enterConstant(MySqlParser.ConstantContext ctx) { }
    @Override public void exitConstant(MySqlParser.ConstantContext ctx) { }
    @Override public void enterConvertedDataType(MySqlParser.ConvertedDataTypeContext ctx) { }
    @Override public void exitConvertedDataType(MySqlParser.ConvertedDataTypeContext ctx) { }
    @Override public void enterLengthOneDimension(MySqlParser.LengthOneDimensionContext ctx) { }
    @Override public void exitLengthOneDimension(MySqlParser.LengthOneDimensionContext ctx) { }
    @Override public void enterLengthTwoDimension(MySqlParser.LengthTwoDimensionContext ctx) { }
    @Override public void exitLengthTwoDimension(MySqlParser.LengthTwoDimensionContext ctx) { }
    @Override public void enterUidList(MySqlParser.UidListContext ctx) { }
    @Override public void exitUidList(MySqlParser.UidListContext ctx) { }
    @Override public void enterExpressions(MySqlParser.ExpressionsContext ctx) { }
    @Override public void exitExpressions(MySqlParser.ExpressionsContext ctx) { }
    @Override public void enterDefaultValue(MySqlParser.DefaultValueContext ctx) { }
    @Override public void exitDefaultValue(MySqlParser.DefaultValueContext ctx) { }
    @Override public void enterCurrentTimestamp(MySqlParser.CurrentTimestampContext ctx) { }
    @Override public void exitCurrentTimestamp(MySqlParser.CurrentTimestampContext ctx) { }
    @Override public void enterSpecificFunctionCall(MySqlParser.SpecificFunctionCallContext ctx) { }
    @Override public void exitSpecificFunctionCall(MySqlParser.SpecificFunctionCallContext ctx) { }
    @Override public void enterAggregateFunctionCall(MySqlParser.AggregateFunctionCallContext ctx) { }
    @Override public void exitAggregateFunctionCall(MySqlParser.AggregateFunctionCallContext ctx) { }
    @Override public void enterScalarFunctionCall(MySqlParser.ScalarFunctionCallContext ctx) { }
    @Override public void exitScalarFunctionCall(MySqlParser.ScalarFunctionCallContext ctx) { }
    @Override public void enterUdfFunctionCall(MySqlParser.UdfFunctionCallContext ctx) { }
    @Override public void exitUdfFunctionCall(MySqlParser.UdfFunctionCallContext ctx) { }
    @Override public void enterPasswordFunctionCall(MySqlParser.PasswordFunctionCallContext ctx) { }
    @Override public void exitPasswordFunctionCall(MySqlParser.PasswordFunctionCallContext ctx) { }
    @Override public void enterSimpleFunctionCall(MySqlParser.SimpleFunctionCallContext ctx) { }
    @Override public void exitSimpleFunctionCall(MySqlParser.SimpleFunctionCallContext ctx) { }
    @Override public void enterDataTypeFunctionCall(MySqlParser.DataTypeFunctionCallContext ctx) { }
    @Override public void exitDataTypeFunctionCall(MySqlParser.DataTypeFunctionCallContext ctx) { }
    @Override public void enterValuesFunctionCall(MySqlParser.ValuesFunctionCallContext ctx) { }
    @Override public void exitValuesFunctionCall(MySqlParser.ValuesFunctionCallContext ctx) { }
    @Override public void enterCaseExpressionFunctionCall(MySqlParser.CaseExpressionFunctionCallContext ctx) { }
    @Override public void exitCaseExpressionFunctionCall(MySqlParser.CaseExpressionFunctionCallContext ctx) { }
    @Override public void enterCaseFunctionCall(MySqlParser.CaseFunctionCallContext ctx) { }
    @Override public void exitCaseFunctionCall(MySqlParser.CaseFunctionCallContext ctx) { }
    @Override public void enterCharFunctionCall(MySqlParser.CharFunctionCallContext ctx) { }
    @Override public void exitCharFunctionCall(MySqlParser.CharFunctionCallContext ctx) { }
    @Override public void enterPositionFunctionCall(MySqlParser.PositionFunctionCallContext ctx) { }
    @Override public void exitPositionFunctionCall(MySqlParser.PositionFunctionCallContext ctx) { }
    @Override public void enterSubstrFunctionCall(MySqlParser.SubstrFunctionCallContext ctx) { }
    @Override public void exitSubstrFunctionCall(MySqlParser.SubstrFunctionCallContext ctx) { }
    @Override public void enterTrimFunctionCall(MySqlParser.TrimFunctionCallContext ctx) { }
    @Override public void exitTrimFunctionCall(MySqlParser.TrimFunctionCallContext ctx) { }
    @Override public void enterWeightFunctionCall(MySqlParser.WeightFunctionCallContext ctx) { }
    @Override public void exitWeightFunctionCall(MySqlParser.WeightFunctionCallContext ctx) { }
    @Override public void enterExtractFunctionCall(MySqlParser.ExtractFunctionCallContext ctx) { }
    @Override public void exitExtractFunctionCall(MySqlParser.ExtractFunctionCallContext ctx) { }
    @Override public void enterGetFormatFunctionCall(MySqlParser.GetFormatFunctionCallContext ctx) { }
    @Override public void exitGetFormatFunctionCall(MySqlParser.GetFormatFunctionCallContext ctx) { }
    @Override public void enterJsonValueFunctionCall(MySqlParser.JsonValueFunctionCallContext ctx) { }
    @Override public void exitJsonValueFunctionCall(MySqlParser.JsonValueFunctionCallContext ctx) { }
    @Override public void enterCaseFuncAlternative(MySqlParser.CaseFuncAlternativeContext ctx) { }
    @Override public void exitCaseFuncAlternative(MySqlParser.CaseFuncAlternativeContext ctx) { }
    @Override public void enterLevelWeightList(MySqlParser.LevelWeightListContext ctx) { }
    @Override public void exitLevelWeightList(MySqlParser.LevelWeightListContext ctx) { }
    @Override public void enterLevelWeightRange(MySqlParser.LevelWeightRangeContext ctx) { }
    @Override public void exitLevelWeightRange(MySqlParser.LevelWeightRangeContext ctx) { }
    @Override public void enterLevelInWeightListElement(MySqlParser.LevelInWeightListElementContext ctx) { }
    @Override public void exitLevelInWeightListElement(MySqlParser.LevelInWeightListElementContext ctx) { }
    @Override public void enterAggregateWindowedFunction(MySqlParser.AggregateWindowedFunctionContext ctx) { }
    @Override public void exitAggregateWindowedFunction(MySqlParser.AggregateWindowedFunctionContext ctx) { }
    @Override public void enterScalarFunctionName(MySqlParser.ScalarFunctionNameContext ctx) { }
    @Override public void exitScalarFunctionName(MySqlParser.ScalarFunctionNameContext ctx) { }
    @Override public void enterPasswordFunctionClause(MySqlParser.PasswordFunctionClauseContext ctx) { }
    @Override public void exitPasswordFunctionClause(MySqlParser.PasswordFunctionClauseContext ctx) { }
    @Override public void enterFunctionArgs(MySqlParser.FunctionArgsContext ctx) { }
    @Override public void exitFunctionArgs(MySqlParser.FunctionArgsContext ctx) { }
    @Override public void enterFunctionArg(MySqlParser.FunctionArgContext ctx) { }
    @Override public void exitFunctionArg(MySqlParser.FunctionArgContext ctx) { }
    @Override public void enterIsExpression(MySqlParser.IsExpressionContext ctx) { }
    @Override public void exitIsExpression(MySqlParser.IsExpressionContext ctx) { }
    @Override public void enterNotExpression(MySqlParser.NotExpressionContext ctx) { }
    @Override public void exitNotExpression(MySqlParser.NotExpressionContext ctx) { }
    @Override public void enterLogicalExpression(MySqlParser.LogicalExpressionContext ctx) { }
    @Override public void exitLogicalExpression(MySqlParser.LogicalExpressionContext ctx) { }
    @Override public void enterPredicateExpression(MySqlParser.PredicateExpressionContext ctx) { }
    @Override public void exitPredicateExpression(MySqlParser.PredicateExpressionContext ctx) { }
    @Override public void enterSoundsLikePredicate(MySqlParser.SoundsLikePredicateContext ctx) { }
    @Override public void exitSoundsLikePredicate(MySqlParser.SoundsLikePredicateContext ctx) { }
    @Override public void enterExpressionAtomPredicate(MySqlParser.ExpressionAtomPredicateContext ctx) { }
    @Override public void exitExpressionAtomPredicate(MySqlParser.ExpressionAtomPredicateContext ctx) { }
    @Override public void enterSubqueryComparisonPredicate(MySqlParser.SubqueryComparisonPredicateContext ctx) { }
    @Override public void exitSubqueryComparisonPredicate(MySqlParser.SubqueryComparisonPredicateContext ctx) { }
    @Override public void enterJsonMemberOfPredicate(MySqlParser.JsonMemberOfPredicateContext ctx) { }
    @Override public void exitJsonMemberOfPredicate(MySqlParser.JsonMemberOfPredicateContext ctx) { }
    @Override public void enterBinaryComparisonPredicate(MySqlParser.BinaryComparisonPredicateContext ctx) { }
    @Override public void exitBinaryComparisonPredicate(MySqlParser.BinaryComparisonPredicateContext ctx) { }
    @Override public void enterInPredicate(MySqlParser.InPredicateContext ctx) { }
    @Override public void exitInPredicate(MySqlParser.InPredicateContext ctx) { }
    @Override public void enterBetweenPredicate(MySqlParser.BetweenPredicateContext ctx) { }
    @Override public void exitBetweenPredicate(MySqlParser.BetweenPredicateContext ctx) { }
    @Override public void enterIsNullPredicate(MySqlParser.IsNullPredicateContext ctx) { }
    @Override public void exitIsNullPredicate(MySqlParser.IsNullPredicateContext ctx) { }
    @Override public void enterLikePredicate(MySqlParser.LikePredicateContext ctx) { }
    @Override public void exitLikePredicate(MySqlParser.LikePredicateContext ctx) { }
    @Override public void enterRegexpPredicate(MySqlParser.RegexpPredicateContext ctx) { }
    @Override public void exitRegexpPredicate(MySqlParser.RegexpPredicateContext ctx) { }
    @Override public void enterUnaryExpressionAtom(MySqlParser.UnaryExpressionAtomContext ctx) { }
    @Override public void exitUnaryExpressionAtom(MySqlParser.UnaryExpressionAtomContext ctx) { }
    @Override public void enterCollateExpressionAtom(MySqlParser.CollateExpressionAtomContext ctx) { }
    @Override public void exitCollateExpressionAtom(MySqlParser.CollateExpressionAtomContext ctx) { }
    @Override public void enterMysqlVariableExpressionAtom(MySqlParser.MysqlVariableExpressionAtomContext ctx) { }
    @Override public void exitMysqlVariableExpressionAtom(MySqlParser.MysqlVariableExpressionAtomContext ctx) { }
    @Override public void enterNestedExpressionAtom(MySqlParser.NestedExpressionAtomContext ctx) { }
    @Override public void exitNestedExpressionAtom(MySqlParser.NestedExpressionAtomContext ctx) { }
    @Override public void enterNestedRowExpressionAtom(MySqlParser.NestedRowExpressionAtomContext ctx) { }
    @Override public void exitNestedRowExpressionAtom(MySqlParser.NestedRowExpressionAtomContext ctx) { }
    @Override public void enterMathExpressionAtom(MySqlParser.MathExpressionAtomContext ctx) { }
    @Override public void exitMathExpressionAtom(MySqlParser.MathExpressionAtomContext ctx) { }
    @Override public void enterExistsExpressionAtom(MySqlParser.ExistsExpressionAtomContext ctx) { }
    @Override public void exitExistsExpressionAtom(MySqlParser.ExistsExpressionAtomContext ctx) { }
    @Override public void enterIntervalExpressionAtom(MySqlParser.IntervalExpressionAtomContext ctx) { }
    @Override public void exitIntervalExpressionAtom(MySqlParser.IntervalExpressionAtomContext ctx) { }
    @Override public void enterJsonExpressionAtom(MySqlParser.JsonExpressionAtomContext ctx) { }
    @Override public void exitJsonExpressionAtom(MySqlParser.JsonExpressionAtomContext ctx) { }
    @Override public void enterSubqueryExpressionAtom(MySqlParser.SubqueryExpressionAtomContext ctx) {
        prtIndent(ctx.LR_BRACKET().getText(), false);
    }
    @Override public void exitSubqueryExpressionAtom(MySqlParser.SubqueryExpressionAtomContext ctx) {
        prtIndent(ctx.RR_BRACKET().getText(), false);
    }
    @Override public void enterConstantExpressionAtom(MySqlParser.ConstantExpressionAtomContext ctx) { }
    @Override public void exitConstantExpressionAtom(MySqlParser.ConstantExpressionAtomContext ctx) { }
    @Override public void enterFunctionCallExpressionAtom(MySqlParser.FunctionCallExpressionAtomContext ctx) { }
    @Override public void exitFunctionCallExpressionAtom(MySqlParser.FunctionCallExpressionAtomContext ctx) { }
    @Override public void enterBinaryExpressionAtom(MySqlParser.BinaryExpressionAtomContext ctx) { }
    @Override public void exitBinaryExpressionAtom(MySqlParser.BinaryExpressionAtomContext ctx) { }
    @Override public void enterFullColumnNameExpressionAtom(MySqlParser.FullColumnNameExpressionAtomContext ctx) { }
    @Override public void exitFullColumnNameExpressionAtom(MySqlParser.FullColumnNameExpressionAtomContext ctx) { }
    @Override public void enterBitExpressionAtom(MySqlParser.BitExpressionAtomContext ctx) { }
    @Override public void exitBitExpressionAtom(MySqlParser.BitExpressionAtomContext ctx) { }
    @Override public void enterUnaryOperator(MySqlParser.UnaryOperatorContext ctx) { }
    @Override public void exitUnaryOperator(MySqlParser.UnaryOperatorContext ctx) { }
    @Override public void enterComparisonOperator(MySqlParser.ComparisonOperatorContext ctx) { }
    @Override public void exitComparisonOperator(MySqlParser.ComparisonOperatorContext ctx) { }
    @Override public void enterLogicalOperator(MySqlParser.LogicalOperatorContext ctx) { }
    @Override public void exitLogicalOperator(MySqlParser.LogicalOperatorContext ctx) { }
    @Override public void enterBitOperator(MySqlParser.BitOperatorContext ctx) { }
    @Override public void exitBitOperator(MySqlParser.BitOperatorContext ctx) { }
    @Override public void enterMathOperator(MySqlParser.MathOperatorContext ctx) { }
    @Override public void exitMathOperator(MySqlParser.MathOperatorContext ctx) { }
    @Override public void enterJsonOperator(MySqlParser.JsonOperatorContext ctx) { }
    @Override public void exitJsonOperator(MySqlParser.JsonOperatorContext ctx) { }
    @Override public void enterCharsetNameBase(MySqlParser.CharsetNameBaseContext ctx) { }
    @Override public void exitCharsetNameBase(MySqlParser.CharsetNameBaseContext ctx) { }
    @Override public void enterIntervalTypeBase(MySqlParser.IntervalTypeBaseContext ctx) { }
    @Override public void exitIntervalTypeBase(MySqlParser.IntervalTypeBaseContext ctx) { }
    @Override public void enterDataTypeBase(MySqlParser.DataTypeBaseContext ctx) { }
    @Override public void exitDataTypeBase(MySqlParser.DataTypeBaseContext ctx) { }
    @Override public void enterKeywordsCanBeId(MySqlParser.KeywordsCanBeIdContext ctx) { }
    @Override public void exitKeywordsCanBeId(MySqlParser.KeywordsCanBeIdContext ctx) { }
    @Override public void enterFunctionNameBase(MySqlParser.FunctionNameBaseContext ctx) { }
    @Override public void exitFunctionNameBase(MySqlParser.FunctionNameBaseContext ctx) { }
    @Override public void enterEveryRule(ParserRuleContext ctx) { }
    @Override public void exitEveryRule(ParserRuleContext ctx) { }
    @Override public void visitTerminal(TerminalNode node) { }
    @Override public void visitErrorNode(ErrorNode node) { }
}
