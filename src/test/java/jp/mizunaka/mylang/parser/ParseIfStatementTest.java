package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.Environment;
import jp.mizunaka.mylang.Lexer;
import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.ast.MylangRuntimeException;
import jp.mizunaka.mylang.token.Token;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParseIfStatementTest {
    @Test
    public void ifStatement() throws Exception {
        Environment env = new Environment();
        List<Token> tokens = Lexer.tokenize("var x = 1;");
        ASTNode node = new StatementParser().parse(tokens);
        node.eval(env);
        tokens = Lexer.tokenize("if(1) { x = 2; }");
        node = new StatementParser().parse(tokens);
        node.eval(env);
        tokens = Lexer.tokenize("x;");
        node = new StatementParser().parse(tokens);
        assertEquals(new Integer(2), node.eval(env));
    }

    @Test
    public void ifNotStatement() throws Exception {
        Environment env = new Environment();
        List<Token> tokens = Lexer.tokenize("var x = 1;");
        ASTNode node = new StatementParser().parse(tokens);
        node.eval(env);
        tokens = Lexer.tokenize("if(0) { x = 2; }");
        node = new StatementParser().parse(tokens);
        node.eval(env);
        tokens = Lexer.tokenize("x;");
        node = new StatementParser().parse(tokens);
        assertEquals(new Integer(1), node.eval(env));
    }

    @Test
    public void localVariable() throws Exception {
        assertThrows(MylangRuntimeException.class, () -> {
            Environment env = new Environment();
            List<Token> tokens = Lexer.tokenize("if(1) { var x = 1; }");
            ASTNode node = new StatementParser().parse(tokens);
            node.eval(env);
            tokens = Lexer.tokenize("x;");
            node = new StatementParser().parse(tokens);
            node.eval(env);
        });
    }
}
