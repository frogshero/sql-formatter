package com.hubery.caller.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
public interface Java8ParserVisitor<T> extends ParseTreeVisitor<T> {
	T visitLiteral(Java8Parser.LiteralContext ctx);
	T visitPrimitiveType(Java8Parser.PrimitiveTypeContext ctx);
	T visitNumericType(Java8Parser.NumericTypeContext ctx);
	T visitIntegralType(Java8Parser.IntegralTypeContext ctx);
	T visitFloatingPointType(Java8Parser.FloatingPointTypeContext ctx);
	T visitReferenceType(Java8Parser.ReferenceTypeContext ctx);
	T visitClassOrInterfaceType(Java8Parser.ClassOrInterfaceTypeContext ctx);
	T visitClassType(Java8Parser.ClassTypeContext ctx);
	T visitClassType_lf_classOrInterfaceType(Java8Parser.ClassType_lf_classOrInterfaceTypeContext ctx);
	T visitClassType_lfno_classOrInterfaceType(Java8Parser.ClassType_lfno_classOrInterfaceTypeContext ctx);
	T visitInterfaceType(Java8Parser.InterfaceTypeContext ctx);
	T visitInterfaceType_lf_classOrInterfaceType(Java8Parser.InterfaceType_lf_classOrInterfaceTypeContext ctx);
	T visitInterfaceType_lfno_classOrInterfaceType(Java8Parser.InterfaceType_lfno_classOrInterfaceTypeContext ctx);
	T visitTypeVariable(Java8Parser.TypeVariableContext ctx);
	T visitArrayType(Java8Parser.ArrayTypeContext ctx);
	T visitDims(Java8Parser.DimsContext ctx);
	T visitTypeParameter(Java8Parser.TypeParameterContext ctx);
	T visitTypeParameterModifier(Java8Parser.TypeParameterModifierContext ctx);
	T visitTypeBound(Java8Parser.TypeBoundContext ctx);
	T visitAdditionalBound(Java8Parser.AdditionalBoundContext ctx);
	T visitTypeArguments(Java8Parser.TypeArgumentsContext ctx);
	T visitTypeArgumentList(Java8Parser.TypeArgumentListContext ctx);
	T visitTypeArgument(Java8Parser.TypeArgumentContext ctx);
	T visitWildcard(Java8Parser.WildcardContext ctx);
	T visitWildcardBounds(Java8Parser.WildcardBoundsContext ctx);
	T visitPackageName(Java8Parser.PackageNameContext ctx);
	T visitTypeName(Java8Parser.TypeNameContext ctx);
	T visitPackageOrTypeName(Java8Parser.PackageOrTypeNameContext ctx);
	T visitExpressionName(Java8Parser.ExpressionNameContext ctx);
	T visitMethodName(Java8Parser.MethodNameContext ctx);
	T visitAmbiguousName(Java8Parser.AmbiguousNameContext ctx);
	T visitCompilationUnit(Java8Parser.CompilationUnitContext ctx);
	T visitPackageDeclaration(Java8Parser.PackageDeclarationContext ctx);
	T visitPackageModifier(Java8Parser.PackageModifierContext ctx);
	T visitImportDeclaration(Java8Parser.ImportDeclarationContext ctx);
	T visitSingleTypeImportDeclaration(Java8Parser.SingleTypeImportDeclarationContext ctx);
	T visitTypeImportOnDemandDeclaration(Java8Parser.TypeImportOnDemandDeclarationContext ctx);
	T visitSingleStaticImportDeclaration(Java8Parser.SingleStaticImportDeclarationContext ctx);
	T visitStaticImportOnDemandDeclaration(Java8Parser.StaticImportOnDemandDeclarationContext ctx);
	T visitTypeDeclaration(Java8Parser.TypeDeclarationContext ctx);
	T visitClassDeclaration(Java8Parser.ClassDeclarationContext ctx);
	T visitNormalClassDeclaration(Java8Parser.NormalClassDeclarationContext ctx);
	T visitClassModifier(Java8Parser.ClassModifierContext ctx);
	T visitTypeParameters(Java8Parser.TypeParametersContext ctx);
	T visitTypeParameterList(Java8Parser.TypeParameterListContext ctx);
	T visitSuperclass(Java8Parser.SuperclassContext ctx);
	T visitSuperinterfaces(Java8Parser.SuperinterfacesContext ctx);
	T visitInterfaceTypeList(Java8Parser.InterfaceTypeListContext ctx);
	T visitClassBody(Java8Parser.ClassBodyContext ctx);
	T visitClassBodyDeclaration(Java8Parser.ClassBodyDeclarationContext ctx);
	T visitClassMemberDeclaration(Java8Parser.ClassMemberDeclarationContext ctx);
	T visitFieldDeclaration(Java8Parser.FieldDeclarationContext ctx);
	T visitFieldModifier(Java8Parser.FieldModifierContext ctx);
	T visitVariableDeclaratorList(Java8Parser.VariableDeclaratorListContext ctx);
	T visitVariableDeclarator(Java8Parser.VariableDeclaratorContext ctx);
	T visitVariableDeclaratorId(Java8Parser.VariableDeclaratorIdContext ctx);
	T visitVariableInitializer(Java8Parser.VariableInitializerContext ctx);
	T visitUnannType(Java8Parser.UnannTypeContext ctx);
	T visitUnannPrimitiveType(Java8Parser.UnannPrimitiveTypeContext ctx);
	T visitUnannReferenceType(Java8Parser.UnannReferenceTypeContext ctx);
	T visitUnannClassOrInterfaceType(Java8Parser.UnannClassOrInterfaceTypeContext ctx);
	T visitUnannClassType(Java8Parser.UnannClassTypeContext ctx);
	T visitUnannClassType_lf_unannClassOrInterfaceType(Java8Parser.UnannClassType_lf_unannClassOrInterfaceTypeContext ctx);
	T visitUnannClassType_lfno_unannClassOrInterfaceType(Java8Parser.UnannClassType_lfno_unannClassOrInterfaceTypeContext ctx);
	T visitUnannInterfaceType(Java8Parser.UnannInterfaceTypeContext ctx);
	T visitUnannInterfaceType_lf_unannClassOrInterfaceType(Java8Parser.UnannInterfaceType_lf_unannClassOrInterfaceTypeContext ctx);
	T visitUnannInterfaceType_lfno_unannClassOrInterfaceType(Java8Parser.UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext ctx);
	T visitUnannTypeVariable(Java8Parser.UnannTypeVariableContext ctx);
	T visitUnannArrayType(Java8Parser.UnannArrayTypeContext ctx);
	T visitMethodDeclaration(Java8Parser.MethodDeclarationContext ctx);
	T visitMethodModifier(Java8Parser.MethodModifierContext ctx);
	T visitMethodHeader(Java8Parser.MethodHeaderContext ctx);
	T visitResult(Java8Parser.ResultContext ctx);
	T visitMethodDeclarator(Java8Parser.MethodDeclaratorContext ctx);
	T visitFormalParameterList(Java8Parser.FormalParameterListContext ctx);
	T visitFormalParameters(Java8Parser.FormalParametersContext ctx);
	T visitFormalParameter(Java8Parser.FormalParameterContext ctx);
	T visitVariableModifier(Java8Parser.VariableModifierContext ctx);
	T visitLastFormalParameter(Java8Parser.LastFormalParameterContext ctx);
	T visitReceiverParameter(Java8Parser.ReceiverParameterContext ctx);
	T visitThrows_(Java8Parser.Throws_Context ctx);
	T visitExceptionTypeList(Java8Parser.ExceptionTypeListContext ctx);
	T visitExceptionType(Java8Parser.ExceptionTypeContext ctx);
	T visitMethodBody(Java8Parser.MethodBodyContext ctx);
	T visitInstanceInitializer(Java8Parser.InstanceInitializerContext ctx);
	T visitStaticInitializer(Java8Parser.StaticInitializerContext ctx);
	T visitConstructorDeclaration(Java8Parser.ConstructorDeclarationContext ctx);
	T visitConstructorModifier(Java8Parser.ConstructorModifierContext ctx);
	T visitConstructorDeclarator(Java8Parser.ConstructorDeclaratorContext ctx);
	T visitSimpleTypeName(Java8Parser.SimpleTypeNameContext ctx);
	T visitConstructorBody(Java8Parser.ConstructorBodyContext ctx);
	T visitExplicitConstructorInvocation(Java8Parser.ExplicitConstructorInvocationContext ctx);
	T visitEnumDeclaration(Java8Parser.EnumDeclarationContext ctx);
	T visitEnumBody(Java8Parser.EnumBodyContext ctx);
	T visitEnumConstantList(Java8Parser.EnumConstantListContext ctx);
	T visitEnumConstant(Java8Parser.EnumConstantContext ctx);
	T visitEnumConstantModifier(Java8Parser.EnumConstantModifierContext ctx);
	T visitEnumBodyDeclarations(Java8Parser.EnumBodyDeclarationsContext ctx);
	T visitInterfaceDeclaration(Java8Parser.InterfaceDeclarationContext ctx);
	T visitNormalInterfaceDeclaration(Java8Parser.NormalInterfaceDeclarationContext ctx);
	T visitInterfaceModifier(Java8Parser.InterfaceModifierContext ctx);
	T visitExtendsInterfaces(Java8Parser.ExtendsInterfacesContext ctx);
	T visitInterfaceBody(Java8Parser.InterfaceBodyContext ctx);
	T visitInterfaceMemberDeclaration(Java8Parser.InterfaceMemberDeclarationContext ctx);
	T visitConstantDeclaration(Java8Parser.ConstantDeclarationContext ctx);
	T visitConstantModifier(Java8Parser.ConstantModifierContext ctx);
	T visitInterfaceMethodDeclaration(Java8Parser.InterfaceMethodDeclarationContext ctx);
	T visitInterfaceMethodModifier(Java8Parser.InterfaceMethodModifierContext ctx);
	T visitAnnotationTypeDeclaration(Java8Parser.AnnotationTypeDeclarationContext ctx);
	T visitAnnotationTypeBody(Java8Parser.AnnotationTypeBodyContext ctx);
	T visitAnnotationTypeMemberDeclaration(Java8Parser.AnnotationTypeMemberDeclarationContext ctx);
	T visitAnnotationTypeElementDeclaration(Java8Parser.AnnotationTypeElementDeclarationContext ctx);
	T visitAnnotationTypeElementModifier(Java8Parser.AnnotationTypeElementModifierContext ctx);
	T visitDefaultValue(Java8Parser.DefaultValueContext ctx);
	T visitAnnotation(Java8Parser.AnnotationContext ctx);
	T visitNormalAnnotation(Java8Parser.NormalAnnotationContext ctx);
	T visitElementValuePairList(Java8Parser.ElementValuePairListContext ctx);
	T visitElementValuePair(Java8Parser.ElementValuePairContext ctx);
	T visitElementValue(Java8Parser.ElementValueContext ctx);
	T visitElementValueArrayInitializer(Java8Parser.ElementValueArrayInitializerContext ctx);
	T visitElementValueList(Java8Parser.ElementValueListContext ctx);
	T visitMarkerAnnotation(Java8Parser.MarkerAnnotationContext ctx);
	T visitSingleElementAnnotation(Java8Parser.SingleElementAnnotationContext ctx);
	T visitArrayInitializer(Java8Parser.ArrayInitializerContext ctx);
	T visitVariableInitializerList(Java8Parser.VariableInitializerListContext ctx);
	T visitBlock(Java8Parser.BlockContext ctx);
	T visitBlockStatements(Java8Parser.BlockStatementsContext ctx);
	T visitBlockStatement(Java8Parser.BlockStatementContext ctx);
	T visitLocalVariableDeclarationStatement(Java8Parser.LocalVariableDeclarationStatementContext ctx);
	T visitLocalVariableDeclaration(Java8Parser.LocalVariableDeclarationContext ctx);
	T visitStatement(Java8Parser.StatementContext ctx);
	T visitStatementNoShortIf(Java8Parser.StatementNoShortIfContext ctx);
	T visitStatementWithoutTrailingSubstatement(Java8Parser.StatementWithoutTrailingSubstatementContext ctx);
	T visitEmptyStatement(Java8Parser.EmptyStatementContext ctx);
	T visitLabeledStatement(Java8Parser.LabeledStatementContext ctx);
	T visitLabeledStatementNoShortIf(Java8Parser.LabeledStatementNoShortIfContext ctx);
	T visitExpressionStatement(Java8Parser.ExpressionStatementContext ctx);
	T visitStatementExpression(Java8Parser.StatementExpressionContext ctx);
	T visitIfThenStatement(Java8Parser.IfThenStatementContext ctx);
	T visitIfThenElseStatement(Java8Parser.IfThenElseStatementContext ctx);
	T visitIfThenElseStatementNoShortIf(Java8Parser.IfThenElseStatementNoShortIfContext ctx);
	T visitAssertStatement(Java8Parser.AssertStatementContext ctx);
	T visitSwitchStatement(Java8Parser.SwitchStatementContext ctx);
	T visitSwitchBlock(Java8Parser.SwitchBlockContext ctx);
	T visitSwitchBlockStatementGroup(Java8Parser.SwitchBlockStatementGroupContext ctx);
	T visitSwitchLabels(Java8Parser.SwitchLabelsContext ctx);
	T visitSwitchLabel(Java8Parser.SwitchLabelContext ctx);
	T visitEnumConstantName(Java8Parser.EnumConstantNameContext ctx);
	T visitWhileStatement(Java8Parser.WhileStatementContext ctx);
	T visitWhileStatementNoShortIf(Java8Parser.WhileStatementNoShortIfContext ctx);
	T visitDoStatement(Java8Parser.DoStatementContext ctx);
	T visitForStatement(Java8Parser.ForStatementContext ctx);
	T visitForStatementNoShortIf(Java8Parser.ForStatementNoShortIfContext ctx);
	T visitBasicForStatement(Java8Parser.BasicForStatementContext ctx);
	T visitBasicForStatementNoShortIf(Java8Parser.BasicForStatementNoShortIfContext ctx);
	T visitForInit(Java8Parser.ForInitContext ctx);
	T visitForUpdate(Java8Parser.ForUpdateContext ctx);
	T visitStatementExpressionList(Java8Parser.StatementExpressionListContext ctx);
	T visitEnhancedForStatement(Java8Parser.EnhancedForStatementContext ctx);
	T visitEnhancedForStatementNoShortIf(Java8Parser.EnhancedForStatementNoShortIfContext ctx);
	T visitBreakStatement(Java8Parser.BreakStatementContext ctx);
	T visitContinueStatement(Java8Parser.ContinueStatementContext ctx);
	T visitReturnStatement(Java8Parser.ReturnStatementContext ctx);
	T visitThrowStatement(Java8Parser.ThrowStatementContext ctx);
	T visitSynchronizedStatement(Java8Parser.SynchronizedStatementContext ctx);
	T visitTryStatement(Java8Parser.TryStatementContext ctx);
	T visitCatches(Java8Parser.CatchesContext ctx);
	T visitCatchClause(Java8Parser.CatchClauseContext ctx);
	T visitCatchFormalParameter(Java8Parser.CatchFormalParameterContext ctx);
	T visitCatchType(Java8Parser.CatchTypeContext ctx);
	T visitFinally_(Java8Parser.Finally_Context ctx);
	T visitTryWithResourcesStatement(Java8Parser.TryWithResourcesStatementContext ctx);
	T visitResourceSpecification(Java8Parser.ResourceSpecificationContext ctx);
	T visitResourceList(Java8Parser.ResourceListContext ctx);
	T visitResource(Java8Parser.ResourceContext ctx);
	T visitPrimary(Java8Parser.PrimaryContext ctx);
	T visitPrimaryNoNewArray(Java8Parser.PrimaryNoNewArrayContext ctx);
	T visitPrimaryNoNewArray_lf_arrayAccess(Java8Parser.PrimaryNoNewArray_lf_arrayAccessContext ctx);
	T visitPrimaryNoNewArray_lfno_arrayAccess(Java8Parser.PrimaryNoNewArray_lfno_arrayAccessContext ctx);
	T visitPrimaryNoNewArray_lf_primary(Java8Parser.PrimaryNoNewArray_lf_primaryContext ctx);
	T visitPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(Java8Parser.PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext ctx);
	T visitPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(Java8Parser.PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext ctx);
	T visitPrimaryNoNewArray_lfno_primary(Java8Parser.PrimaryNoNewArray_lfno_primaryContext ctx);
	T visitPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(Java8Parser.PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext ctx);
	T visitPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(Java8Parser.PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext ctx);
	T visitClassInstanceCreationExpression(Java8Parser.ClassInstanceCreationExpressionContext ctx);
	T visitClassInstanceCreationExpression_lf_primary(Java8Parser.ClassInstanceCreationExpression_lf_primaryContext ctx);
	T visitClassInstanceCreationExpression_lfno_primary(Java8Parser.ClassInstanceCreationExpression_lfno_primaryContext ctx);
	T visitTypeArgumentsOrDiamond(Java8Parser.TypeArgumentsOrDiamondContext ctx);
	T visitFieldAccess(Java8Parser.FieldAccessContext ctx);
	T visitFieldAccess_lf_primary(Java8Parser.FieldAccess_lf_primaryContext ctx);
	T visitFieldAccess_lfno_primary(Java8Parser.FieldAccess_lfno_primaryContext ctx);
	T visitArrayAccess(Java8Parser.ArrayAccessContext ctx);
	T visitArrayAccess_lf_primary(Java8Parser.ArrayAccess_lf_primaryContext ctx);
	T visitArrayAccess_lfno_primary(Java8Parser.ArrayAccess_lfno_primaryContext ctx);
	T visitMethodInvocation(Java8Parser.MethodInvocationContext ctx);
	T visitMethodInvocation_lf_primary(Java8Parser.MethodInvocation_lf_primaryContext ctx);
	T visitMethodInvocation_lfno_primary(Java8Parser.MethodInvocation_lfno_primaryContext ctx);
	T visitArgumentList(Java8Parser.ArgumentListContext ctx);
	T visitMethodReference(Java8Parser.MethodReferenceContext ctx);
	T visitMethodReference_lf_primary(Java8Parser.MethodReference_lf_primaryContext ctx);
	T visitMethodReference_lfno_primary(Java8Parser.MethodReference_lfno_primaryContext ctx);
	T visitArrayCreationExpression(Java8Parser.ArrayCreationExpressionContext ctx);
	T visitDimExprs(Java8Parser.DimExprsContext ctx);
	T visitDimExpr(Java8Parser.DimExprContext ctx);
	T visitConstantExpression(Java8Parser.ConstantExpressionContext ctx);
	T visitExpression(Java8Parser.ExpressionContext ctx);
	T visitLambdaExpression(Java8Parser.LambdaExpressionContext ctx);
	T visitLambdaParameters(Java8Parser.LambdaParametersContext ctx);
	T visitInferredFormalParameterList(Java8Parser.InferredFormalParameterListContext ctx);
	T visitLambdaBody(Java8Parser.LambdaBodyContext ctx);
	T visitAssignmentExpression(Java8Parser.AssignmentExpressionContext ctx);
	T visitAssignment(Java8Parser.AssignmentContext ctx);
	T visitLeftHandSide(Java8Parser.LeftHandSideContext ctx);
	T visitAssignmentOperator(Java8Parser.AssignmentOperatorContext ctx);
	T visitConditionalExpression(Java8Parser.ConditionalExpressionContext ctx);
	T visitConditionalOrExpression(Java8Parser.ConditionalOrExpressionContext ctx);
	T visitConditionalAndExpression(Java8Parser.ConditionalAndExpressionContext ctx);
	T visitInclusiveOrExpression(Java8Parser.InclusiveOrExpressionContext ctx);
	T visitExclusiveOrExpression(Java8Parser.ExclusiveOrExpressionContext ctx);
	T visitAndExpression(Java8Parser.AndExpressionContext ctx);
	T visitEqualityExpression(Java8Parser.EqualityExpressionContext ctx);
	T visitRelationalExpression(Java8Parser.RelationalExpressionContext ctx);
	T visitShiftExpression(Java8Parser.ShiftExpressionContext ctx);
	T visitAdditiveExpression(Java8Parser.AdditiveExpressionContext ctx);
	T visitMultiplicativeExpression(Java8Parser.MultiplicativeExpressionContext ctx);
	T visitUnaryExpression(Java8Parser.UnaryExpressionContext ctx);
	T visitPreIncrementExpression(Java8Parser.PreIncrementExpressionContext ctx);
	T visitPreDecrementExpression(Java8Parser.PreDecrementExpressionContext ctx);
	T visitUnaryExpressionNotPlusMinus(Java8Parser.UnaryExpressionNotPlusMinusContext ctx);
	T visitPostfixExpression(Java8Parser.PostfixExpressionContext ctx);
	T visitPostIncrementExpression(Java8Parser.PostIncrementExpressionContext ctx);
	T visitPostIncrementExpression_lf_postfixExpression(Java8Parser.PostIncrementExpression_lf_postfixExpressionContext ctx);
	T visitPostDecrementExpression(Java8Parser.PostDecrementExpressionContext ctx);
	T visitPostDecrementExpression_lf_postfixExpression(Java8Parser.PostDecrementExpression_lf_postfixExpressionContext ctx);
	T visitCastExpression(Java8Parser.CastExpressionContext ctx);
}