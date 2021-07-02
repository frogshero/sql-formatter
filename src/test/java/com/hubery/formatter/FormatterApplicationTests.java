package com.hubery.formatter;

import com.hubery.formatter.common.CaseChangingCharStream;
import com.hubery.formatter.grammar.MySqlLexer;
import com.hubery.formatter.grammar.MySqlParser;
import com.hubery.formatter.my.MyMySqlParserListener;
import com.hubery.formatter.my.MyMySqlParserVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class FormatterApplicationTests {

  		private String simple = "SELECT " +
				" cfc.*, " +
				" ( " +
				"SELECT " +
				" cfc.flow_value - flow_value  " +
				"FROM " +
				" collect_flow_coburg  " +
				"WHERE equipment_name = cfc.equipment_name  " +
				" AND create_date = DATE_SUB( create_date, INTERVAL 1 DAY )  " +
				" )  " +
				"FROM " +
				" collect_flow_coburg cfc  " +
				"WHERE " +
				" create_date > '2021-06-13'  " +
				"; " +
				"select * from collect_flow_coburg " +
				"WHERE create_date > '2021-06-13' ";

  		private String shortSql = "SELECT * FROM abc";

	@Test
	public void testVisitor() throws IOException {
		ParseTree tree = getParseTree(shortSql);
//		ParseTree tree = getParseTreeFromFile("E:\\wgf\\antlr4\\sqls\\xx.sql");
//		ParseTree tree = getParseTreeFromFile("E:\\wgf\\antlr4\\sqls\\monthReport.txt");
//		ParseTree tree = getParseTreeFromFile("E:\\wgf\\antlr4\\sqls\\boardMonth.txt");
		MyMySqlParserVisitor visitor = new MyMySqlParserVisitor();
		String ret = visitor.visit(tree);
		System.out.println(ret);
	}

	private ParseTree getParseTreeFromFile(String fname) throws IOException {
		CharStream input = CharStreams.fromFileName(fname);
		CaseChangingCharStream cc = new CaseChangingCharStream(input, true);
		MySqlLexer lexer = new MySqlLexer(cc);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MySqlParser parser = new MySqlParser(tokens);
		ParseTree tree = parser.selectStatement();
		return tree;
	}

	private ParseTree getParseTree(String testSql) {
		CharStream input = CharStreams.fromString(testSql);
		CaseChangingCharStream cc = new CaseChangingCharStream(input, true);
		MySqlLexer lexer = new MySqlLexer(cc);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MySqlParser parser = new MySqlParser(tokens);
		ParseTree tree = parser.selectStatement();
		return tree;
	}

  	@Test
	public void testTokens() {
		CharStream input = CharStreams.fromString(simple);
		CaseChangingCharStream cc = new CaseChangingCharStream(input, true);
		MySqlLexer lexer = new MySqlLexer(cc);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		tokens.fill();
		List<Token> tks = tokens.getTokens();
		for (Token tk : tks) {
			System.out.println(tk.getText());
		}
	}

	@Test
	public void test() {
		ParseTree tree = getParseTree(shortSql);
		ParseTreeWalker ptw = new ParseTreeWalker();
		ptw.walk(new MyMySqlParserListener(), tree);
	}

	char[] NO_SPACE_BEFORE = {',', '(', ')'};
	@Test
	public void testSearch() {
		if (NO_SPACE_BEFORE[0] == ',') {
			System.out.println("XX");
		}
		int ret = Arrays.binarySearch(NO_SPACE_BEFORE, ',');
		System.out.println(ret);
	}

}
