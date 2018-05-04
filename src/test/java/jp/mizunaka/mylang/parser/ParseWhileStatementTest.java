package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.Environment;
import jp.mizunaka.mylang.Lexer;
import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.token.Token;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseWhileStatementTest {
    @Test
    public void whileStatement() throws Exception {
        Environment env = new Environment();
        List<Token> tokens = Lexer.tokenize(
            "var x = 0;" +
            "var count = 3;" +
            "while(count) { count = count - 1; x = x + 1; }" +
            "x;"
        );
        ASTNode node = new ProgramParser().parse(tokens);
        assertEquals(new Integer(3), node.eval(env));
    }
}
