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
  String sql = "SELECT SUM(a), SUM(b), SUM(c), SUM(d), SUM(e), SUM(f), SUM(num) FROM (" +
		"SELECT (SELECT SUM(IFNULL(c100, c9))" +
		"  FROM jm_t41" +
		"  WHERE a3 = 1" +
		"    AND SUBSTR(IFNULL(c33, c3), 1, 8) = T.batch_no" +
		"	) a, " +
		"	IFNULL((" +
		"		SELECT SUM(num)" +
		"		FROM oa_stock_in_detail asid" +
		"			LEFT JOIN oa_stock_in osi ON asid.stock_in_id = osi.id" +
		"			LEFT JOIN wrk_product_batch wpb ON wpb.id = asid.batch_id" +
		"		WHERE IFNULL(asid.drossing_type, 0) != 0" +
		"			AND asid.enableflg = 1" +
		"			AND wpb.batch_no = T.batch_no" +
		"	), 0) b," +
		"	 IFNULL((" +
		"		SELECT SUM(osid.num)" +
		"		FROM oa_stock_in_detail osid" +
		"			LEFT JOIN base_equipment_accounts bea1 ON bea1.id = osid.furnace_id" +
		"		WHERE SUBSTR(T.batch_no, 1, 4) = DATE_FORMAT(osid.created_time, '%y%m')" +
		"			AND materiel_id = 5712" +
		"			AND osid.enableflg = 1" +
		"			AND IFNULL(product_batch, 0) = 0" +
		"			AND bea1.remark LIKE CONCAT('%', T.id, '%')" +
		"	) / (" +
		"		SELECT COUNT(0)" +
		"		FROM wrk_product_batch" +
		"			LEFT JOIN base_equipment_accounts bea2 ON bea2.id = wrk_product_batch.equipment_id" +
		"		WHERE IFNULL(bea2.remark1, 0) != 2" +
		"			AND SUBSTR(T.batch_no, 1, 4) = SUBSTR(wrk_product_batch.batch_no, 1, 4)" +
		"	), 0) c," +
		"	 IFNULL((" +
		"		SELECT SUM(num)" +
		"		FROM oa_stock_in_detail asid" +
		"			LEFT JOIN oa_stock_in osi ON asid.stock_in_id = osi.id" +
		"			LEFT JOIN wrk_product_batch wpb ON wpb.id = asid.batch_id" +
		"		WHERE asid.materiel_id = 5663" +
		"			AND asid.enableflg = 1" +
		"			AND wpb.batch_no = T.batch_no" +
		"	), 0) d," +
		"	 IFNULL((" +
		"		SELECT SUM(num / (" +
		"				SELECT COUNT(0)" +
		"				FROM wrk_product_batch" +
		"				WHERE SUBSTR(batch_no, 1, 4) = DATE_FORMAT(asid.created_time, '%y%m')" +
		"			))" +
		"		FROM oa_stock_in_detail asid" +
		"			LEFT JOIN oa_stock_in osi ON asid.stock_in_id = osi.id" +
		"		WHERE IFNULL(asid.drossing_type, 0) != 0" +
		"			AND asid.enableflg = 1" +
		"			AND IFNULL(product_batch, 0) = 0" +
		"			AND DATE_FORMAT(asid.created_time, '%y%m') = SUBSTR(T.batch_no, 1, 4)" +
		"	), 0) e," +
		"	 IFNULL((" +
		"		SELECT SUM((" +
		"				SELECT IFNULL(c100, c9)" +
		"				FROM jm_t41" +
		"				WHERE a3 = 1" +
		"					AND IFNULL(c33, c3) = wmo.batch_no" +
		"					AND IFNULL(a0, 0) != 0" +
		"			) - IFNULL((" +
		"				SELECT SUM(wmod.suttle_weight)" +
		"				FROM wrk_materiel_other_detail wmod" +
		"					LEFT JOIN base_materiel bm1 ON bm1.id = wmod.materiel_id" +
		"				WHERE bm1.type_id != 91" +
		"					AND wmod.other_id IN (wmo.id)" +
		"			), 0))" +
		"		FROM wrk_materiel_other wmo" +
		"		WHERE wmo.relevance_batch_no = T.batch_no" +
		"			AND state = 3" +
		"	), 0) f," +
		"	 IFNULL((" +
		"		SELECT SUM(IFNULL(c100, c9))" +
		"		FROM wrk_materiel_other wmo" +
		"			LEFT JOIN jm_t41 jt" +
		"			ON jt.a3 = 1" +
		"				AND IFNULL(jt.c33, jt.c3) = wmo.batch_no" +
		"				AND IFNULL(jt.a0, 0) != 0" +
		"		WHERE wmo.relevance_batch_no = T.batch_no" +
		"			AND wmo.state = 2" +
		"	), 0) AS num" +
		"	FROM (" +
		"		SELECT" +
		"			wpb.id AS batchId," +
		"			wpb.batch_no," +
		"			wpb.material_id," +
		"			wpb.create_time," +
		"			wpb.stop_time," +
		"			bea.equipment_name," +
		"			bea.id," +
		"			wpb.remark," +
		"			SUBSTR(wpb.batch_no,3,2) state" +
		"		FROM wrk_product_batch AS wpb" +
		"		LEFT JOIN base_equipment_accounts AS bea ON bea.id = wpb.equipment_id" +
		"		WHERE wpb.show_flg != 1" +
		"		AND ifnull(wpb.create_time,0)!=0" +
		"		AND ifnull(bea.remark2,0) !=2" +
		"		AND SUBSTR(wpb.batch_no,1,2) = DATE_FORMAT(now(),'%y')	" +
		"		AND SUBSTR(wpb.batch_no,3,2) = '01'" +
		"		) T" +
		"		) T1";

  		private String simple = "SELECT SUM(osid.num) x, id as id" +
				"		FROM oa_stock_in_detail osid" +
				"			LEFT JOIN base_equipment_accounts bea1 ON bea1.id = osid.furnace_id" +
				"		WHERE SUBSTR(T.batch_no, 1, 4) = DATE_FORMAT(osid.created_time, '%y%m')" +
				"			AND materiel_id = 5712" +
				"			AND osid.enableflg = 1" +
				"			AND IFNULL(product_batch, 0) = 0" +
				"			AND bea1.remark LIKE CONCAT('%', T.id, '%')";

  		private String shortSql = "SELECT A, C2, IFNULL((SELECT X FROM YY),0) C FROM (SELECT A, B FROM QQ WHERE A=3) AS ABC WHERE 1=(SELECT COUNT(*) FROM WW)";

	@Test
	public void testVisitor() throws IOException {
//		ParseTree tree = getParseTree(sql);
		ParseTree tree = getParseTreeFromFile("D:\\wgf\\antlr4\\longQuery.txt");
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
