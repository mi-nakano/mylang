package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.Lexer;
import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.token.Token;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ParseCalculatingStatementTest {

    public static Map<String, Integer> testMap = new HashMap<String, Integer>(){{
        put("1", 1);
        put("(1)", 1);
        put("-1", -1);
        put("(-1)", -1);
        put(" 1  + 2 + 3", 6);
        put(" 1  - 2 - 3", -4);
        put(" 1  - 2 * 3", -5);
        put(" 1  - 4 / 2", -1);
        put(" (2  - 4) / 2", -1);
    }};


    @Test
    public void parseInput() throws Exception {
        for (Map.Entry<String, Integer> entry : testMap.entrySet()) {
            List<Token> tokens = Lexer.tokenize(entry.getKey());
            ASTNode node = new StatementParser().parse(tokens);
            assertEquals(entry.getValue(), node.eval());
        }
    }

}
