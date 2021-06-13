package com.hubery.formatter.grammar;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
public class MySqlParserBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements MySqlParserVisitor<T> {
	@Override public T visitSimpleSelect(MySqlParser.SimpleSelectContext ctx) { return visitChildren(ctx); }
	@Override public T visitParenthesisSelect(MySqlParser.ParenthesisSelectContext ctx) { return visitChildren(ctx); }
	@Override public T visitUnionSelect(MySqlParser.UnionSelectContext ctx) { return visitChildren(ctx); }
	@Override public T visitUnionParenthesisSelect(MySqlParser.UnionParenthesisSelectContext ctx) { return visitChildren(ctx); }
	@Override public T visitOrderByClause(MySqlParser.OrderByClauseContext ctx) { return visitChildren(ctx); }
	@Override public T visitOrderByExpression(MySqlParser.OrderByExpressionContext ctx) { return visitChildren(ctx); }
	@Override public T visitTableSources(MySqlParser.TableSourcesContext ctx) { return visitChildren(ctx); }
	@Override public T visitTableSourceBase(MySqlParser.TableSourceBaseContext ctx) { return visitChildren(ctx); }
	@Override public T visitTableSourceNested(MySqlParser.TableSourceNestedContext ctx) { return visitChildren(ctx); }
	@Override public T visitAtomTableItem(MySqlParser.AtomTableItemContext ctx) { return visitChildren(ctx); }
	@Override public T visitSubqueryTableItem(MySqlParser.SubqueryTableItemContext ctx) { return visitChildren(ctx); }
	@Override public T visitTableSourcesItem(MySqlParser.TableSourcesItemContext ctx) { return visitChildren(ctx); }
	@Override public T visitIndexHint(MySqlParser.IndexHintContext ctx) { return visitChildren(ctx); }
	@Override public T visitIndexHintType(MySqlParser.IndexHintTypeContext ctx) { return visitChildren(ctx); }
	@Override public T visitInnerJoin(MySqlParser.InnerJoinContext ctx) { return visitChildren(ctx); }
	@Override public T visitStraightJoin(MySqlParser.StraightJoinContext ctx) { return visitChildren(ctx); }
	@Override public T visitOuterJoin(MySqlParser.OuterJoinContext ctx) { return visitChildren(ctx); }
	@Override public T visitNaturalJoin(MySqlParser.NaturalJoinContext ctx) { return visitChildren(ctx); }
	@Override public T visitQueryExpression(MySqlParser.QueryExpressionContext ctx) { return visitChildren(ctx); }
	@Override public T visitQueryExpressionNointo(MySqlParser.QueryExpressionNointoContext ctx) { return visitChildren(ctx); }
	@Override public T visitQuerySpecification(MySqlParser.QuerySpecificationContext ctx) { return visitChildren(ctx); }
	@Override public T visitQuerySpecificationNointo(MySqlParser.QuerySpecificationNointoContext ctx) { return visitChildren(ctx); }
	@Override public T visitUnionParenthesis(MySqlParser.UnionParenthesisContext ctx) { return visitChildren(ctx); }
	@Override public T visitUnionStatement(MySqlParser.UnionStatementContext ctx) { return visitChildren(ctx); }
	@Override public T visitSelectSpec(MySqlParser.SelectSpecContext ctx) { return visitChildren(ctx); }
	@Override public T visitSelectElements(MySqlParser.SelectElementsContext ctx) { return visitChildren(ctx); }
	@Override public T visitSelectStarElement(MySqlParser.SelectStarElementContext ctx) { return visitChildren(ctx); }
	@Override public T visitSelectColumnElement(MySqlParser.SelectColumnElementContext ctx) { return visitChildren(ctx); }
	@Override public T visitSelectFunctionElement(MySqlParser.SelectFunctionElementContext ctx) { return visitChildren(ctx); }
	@Override public T visitSelectExpressionElement(MySqlParser.SelectExpressionElementContext ctx) { return visitChildren(ctx); }
	@Override public T visitFromClause(MySqlParser.FromClauseContext ctx) { return visitChildren(ctx); }
	@Override public T visitGroupByClause(MySqlParser.GroupByClauseContext ctx) { return visitChildren(ctx); }
	@Override public T visitHavingClause(MySqlParser.HavingClauseContext ctx) { return visitChildren(ctx); }
	@Override public T visitGroupByItem(MySqlParser.GroupByItemContext ctx) { return visitChildren(ctx); }
	@Override public T visitLimitClause(MySqlParser.LimitClauseContext ctx) { return visitChildren(ctx); }
	@Override public T visitLimitClauseAtom(MySqlParser.LimitClauseAtomContext ctx) { return visitChildren(ctx); }
	@Override public T visitFullId(MySqlParser.FullIdContext ctx) { return visitChildren(ctx); }
	@Override public T visitTableName(MySqlParser.TableNameContext ctx) { return visitChildren(ctx); }
	@Override public T visitFullColumnName(MySqlParser.FullColumnNameContext ctx) { return visitChildren(ctx); }
	@Override public T visitMysqlVariable(MySqlParser.MysqlVariableContext ctx) { return visitChildren(ctx); }
	@Override public T visitCharsetName(MySqlParser.CharsetNameContext ctx) { return visitChildren(ctx); }
	@Override public T visitCollationName(MySqlParser.CollationNameContext ctx) { return visitChildren(ctx); }
	@Override public T visitUid(MySqlParser.UidContext ctx) { return visitChildren(ctx); }
	@Override public T visitSimpleId(MySqlParser.SimpleIdContext ctx) { return visitChildren(ctx); }
	@Override public T visitDottedId(MySqlParser.DottedIdContext ctx) { return visitChildren(ctx); }
	@Override public T visitDecimalLiteral(MySqlParser.DecimalLiteralContext ctx) { return visitChildren(ctx); }
	@Override public T visitStringLiteral(MySqlParser.StringLiteralContext ctx) { return visitChildren(ctx); }
	@Override public T visitBooleanLiteral(MySqlParser.BooleanLiteralContext ctx) { return visitChildren(ctx); }
	@Override public T visitHexadecimalLiteral(MySqlParser.HexadecimalLiteralContext ctx) { return visitChildren(ctx); }
	@Override public T visitNullNotnull(MySqlParser.NullNotnullContext ctx) { return visitChildren(ctx); }
	@Override public T visitConstant(MySqlParser.ConstantContext ctx) { return visitChildren(ctx); }
	@Override public T visitConvertedDataType(MySqlParser.ConvertedDataTypeContext ctx) { return visitChildren(ctx); }
	@Override public T visitLengthOneDimension(MySqlParser.LengthOneDimensionContext ctx) { return visitChildren(ctx); }
	@Override public T visitLengthTwoDimension(MySqlParser.LengthTwoDimensionContext ctx) { return visitChildren(ctx); }
	@Override public T visitUidList(MySqlParser.UidListContext ctx) { return visitChildren(ctx); }
	@Override public T visitExpressions(MySqlParser.ExpressionsContext ctx) { return visitChildren(ctx); }
	@Override public T visitDefaultValue(MySqlParser.DefaultValueContext ctx) { return visitChildren(ctx); }
	@Override public T visitCurrentTimestamp(MySqlParser.CurrentTimestampContext ctx) { return visitChildren(ctx); }
	@Override public T visitSpecificFunctionCall(MySqlParser.SpecificFunctionCallContext ctx) { return visitChildren(ctx); }
	@Override public T visitAggregateFunctionCall(MySqlParser.AggregateFunctionCallContext ctx) { return visitChildren(ctx); }
	@Override public T visitScalarFunctionCall(MySqlParser.ScalarFunctionCallContext ctx) { return visitChildren(ctx); }
	@Override public T visitUdfFunctionCall(MySqlParser.UdfFunctionCallContext ctx) { return visitChildren(ctx); }
	@Override public T visitPasswordFunctionCall(MySqlParser.PasswordFunctionCallContext ctx) { return visitChildren(ctx); }
	@Override public T visitIntervalType(MySqlParser.IntervalTypeContext ctx) { return visitChildren(ctx); }
	@Override public T visitSimpleFunctionCall(MySqlParser.SimpleFunctionCallContext ctx) { return visitChildren(ctx); }
	@Override public T visitDataTypeFunctionCall(MySqlParser.DataTypeFunctionCallContext ctx) { return visitChildren(ctx); }
	@Override public T visitValuesFunctionCall(MySqlParser.ValuesFunctionCallContext ctx) { return visitChildren(ctx); }
	@Override public T visitCaseExpressionFunctionCall(MySqlParser.CaseExpressionFunctionCallContext ctx) { return visitChildren(ctx); }
	@Override public T visitCaseFunctionCall(MySqlParser.CaseFunctionCallContext ctx) { return visitChildren(ctx); }
	@Override public T visitCharFunctionCall(MySqlParser.CharFunctionCallContext ctx) { return visitChildren(ctx); }
	@Override public T visitPositionFunctionCall(MySqlParser.PositionFunctionCallContext ctx) { return visitChildren(ctx); }
	@Override public T visitSubstrFunctionCall(MySqlParser.SubstrFunctionCallContext ctx) { return visitChildren(ctx); }
	@Override public T visitTrimFunctionCall(MySqlParser.TrimFunctionCallContext ctx) { return visitChildren(ctx); }
	@Override public T visitWeightFunctionCall(MySqlParser.WeightFunctionCallContext ctx) { return visitChildren(ctx); }
	@Override public T visitExtractFunctionCall(MySqlParser.ExtractFunctionCallContext ctx) { return visitChildren(ctx); }
	@Override public T visitGetFormatFunctionCall(MySqlParser.GetFormatFunctionCallContext ctx) { return visitChildren(ctx); }
	@Override public T visitJsonValueFunctionCall(MySqlParser.JsonValueFunctionCallContext ctx) { return visitChildren(ctx); }
	@Override public T visitCaseFuncAlternative(MySqlParser.CaseFuncAlternativeContext ctx) { return visitChildren(ctx); }
	@Override public T visitLevelWeightList(MySqlParser.LevelWeightListContext ctx) { return visitChildren(ctx); }
	@Override public T visitLevelWeightRange(MySqlParser.LevelWeightRangeContext ctx) { return visitChildren(ctx); }
	@Override public T visitLevelInWeightListElement(MySqlParser.LevelInWeightListElementContext ctx) { return visitChildren(ctx); }
	@Override public T visitAggregateWindowedFunction(MySqlParser.AggregateWindowedFunctionContext ctx) { return visitChildren(ctx); }
	@Override public T visitScalarFunctionName(MySqlParser.ScalarFunctionNameContext ctx) { return visitChildren(ctx); }
	@Override public T visitPasswordFunctionClause(MySqlParser.PasswordFunctionClauseContext ctx) { return visitChildren(ctx); }
	@Override public T visitFunctionArgs(MySqlParser.FunctionArgsContext ctx) { return visitChildren(ctx); }
	@Override public T visitFunctionArg(MySqlParser.FunctionArgContext ctx) { return visitChildren(ctx); }
	@Override public T visitIsExpression(MySqlParser.IsExpressionContext ctx) { return visitChildren(ctx); }
	@Override public T visitNotExpression(MySqlParser.NotExpressionContext ctx) { return visitChildren(ctx); }
	@Override public T visitLogicalExpression(MySqlParser.LogicalExpressionContext ctx) { return visitChildren(ctx); }
	@Override public T visitPredicateExpression(MySqlParser.PredicateExpressionContext ctx) { return visitChildren(ctx); }
	@Override public T visitSoundsLikePredicate(MySqlParser.SoundsLikePredicateContext ctx) { return visitChildren(ctx); }
	@Override public T visitExpressionAtomPredicate(MySqlParser.ExpressionAtomPredicateContext ctx) { return visitChildren(ctx); }
	@Override public T visitSubqueryComparisonPredicate(MySqlParser.SubqueryComparisonPredicateContext ctx) { return visitChildren(ctx); }
	@Override public T visitJsonMemberOfPredicate(MySqlParser.JsonMemberOfPredicateContext ctx) { return visitChildren(ctx); }
	@Override public T visitBinaryComparisonPredicate(MySqlParser.BinaryComparisonPredicateContext ctx) { return visitChildren(ctx); }
	@Override public T visitInPredicate(MySqlParser.InPredicateContext ctx) { return visitChildren(ctx); }
	@Override public T visitBetweenPredicate(MySqlParser.BetweenPredicateContext ctx) { return visitChildren(ctx); }
	@Override public T visitIsNullPredicate(MySqlParser.IsNullPredicateContext ctx) { return visitChildren(ctx); }
	@Override public T visitLikePredicate(MySqlParser.LikePredicateContext ctx) { return visitChildren(ctx); }
	@Override public T visitRegexpPredicate(MySqlParser.RegexpPredicateContext ctx) { return visitChildren(ctx); }
	@Override public T visitUnaryExpressionAtom(MySqlParser.UnaryExpressionAtomContext ctx) { return visitChildren(ctx); }
	@Override public T visitCollateExpressionAtom(MySqlParser.CollateExpressionAtomContext ctx) { return visitChildren(ctx); }
	@Override public T visitMysqlVariableExpressionAtom(MySqlParser.MysqlVariableExpressionAtomContext ctx) { return visitChildren(ctx); }
	@Override public T visitNestedExpressionAtom(MySqlParser.NestedExpressionAtomContext ctx) { return visitChildren(ctx); }
	@Override public T visitNestedRowExpressionAtom(MySqlParser.NestedRowExpressionAtomContext ctx) { return visitChildren(ctx); }
	@Override public T visitMathExpressionAtom(MySqlParser.MathExpressionAtomContext ctx) { return visitChildren(ctx); }
	@Override public T visitExistsExpressionAtom(MySqlParser.ExistsExpressionAtomContext ctx) { return visitChildren(ctx); }
	@Override public T visitIntervalExpressionAtom(MySqlParser.IntervalExpressionAtomContext ctx) { return visitChildren(ctx); }
	@Override public T visitJsonExpressionAtom(MySqlParser.JsonExpressionAtomContext ctx) { return visitChildren(ctx); }
	@Override public T visitSubqueryExpressionAtom(MySqlParser.SubqueryExpressionAtomContext ctx) { return visitChildren(ctx); }
	@Override public T visitConstantExpressionAtom(MySqlParser.ConstantExpressionAtomContext ctx) { return visitChildren(ctx); }
	@Override public T visitFunctionCallExpressionAtom(MySqlParser.FunctionCallExpressionAtomContext ctx) { return visitChildren(ctx); }
	@Override public T visitBinaryExpressionAtom(MySqlParser.BinaryExpressionAtomContext ctx) { return visitChildren(ctx); }
	@Override public T visitFullColumnNameExpressionAtom(MySqlParser.FullColumnNameExpressionAtomContext ctx) { return visitChildren(ctx); }
	@Override public T visitBitExpressionAtom(MySqlParser.BitExpressionAtomContext ctx) { return visitChildren(ctx); }
	@Override public T visitUnaryOperator(MySqlParser.UnaryOperatorContext ctx) { return visitChildren(ctx); }
	@Override public T visitComparisonOperator(MySqlParser.ComparisonOperatorContext ctx) { return visitChildren(ctx); }
	@Override public T visitLogicalOperator(MySqlParser.LogicalOperatorContext ctx) { return visitChildren(ctx); }
	@Override public T visitBitOperator(MySqlParser.BitOperatorContext ctx) { return visitChildren(ctx); }
	@Override public T visitMathOperator(MySqlParser.MathOperatorContext ctx) { return visitChildren(ctx); }
	@Override public T visitJsonOperator(MySqlParser.JsonOperatorContext ctx) { return visitChildren(ctx); }
	@Override public T visitCharsetNameBase(MySqlParser.CharsetNameBaseContext ctx) { return visitChildren(ctx); }
	@Override public T visitIntervalTypeBase(MySqlParser.IntervalTypeBaseContext ctx) { return visitChildren(ctx); }
	@Override public T visitDataTypeBase(MySqlParser.DataTypeBaseContext ctx) { return visitChildren(ctx); }
	@Override public T visitKeywordsCanBeId(MySqlParser.KeywordsCanBeIdContext ctx) { return visitChildren(ctx); }
	@Override public T visitFunctionNameBase(MySqlParser.FunctionNameBaseContext ctx) { return visitChildren(ctx); }
}