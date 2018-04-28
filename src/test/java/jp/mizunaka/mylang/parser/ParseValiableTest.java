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

public class ParseValiableTest {
    @Test
    public void parseDeclarationStatment() throws Exception {
        Environment env = new Environment();
        List<Token> tokens = Lexer.tokenize("var x = 1;");
        ASTNode node = new StatementParser().parse(tokens);
        node.eval(env);
        tokens = Lexer.tokenize("x + 2;");
        node = new StatementParser().parse(tokens);
        assertEquals(new Integer(3), node.eval(env));
    }

    @Test
    public void parseAssignAfterDeclarationStatment() throws Exception {
        Environment env = new Environment();
        List<Token> tokens = Lexer.tokenize("var x;");
        ASTNode node = new StatementParser().parse(tokens);
        node.eval(env);
        tokens = Lexer.tokenize("x = 2;");
        node = new StatementParser().parse(tokens);
        node.eval(env);
        tokens = Lexer.tokenize("x;");
        node = new StatementParser().parse(tokens);
        assertEquals(new Integer(2), node.eval(env));
    }

    @Test
    public void parseReAssignStatment() throws Exception {
        Environment env = new Environment();
        List<Token> tokens = Lexer.tokenize("var x = 1;");
        ASTNode node = new StatementParser().parse(tokens);
        node.eval(env);
        tokens = Lexer.tokenize("x = 2;");
        node = new StatementParser().parse(tokens);
        node.eval(env);
        tokens = Lexer.tokenize("x;");
        node = new StatementParser().parse(tokens);
        assertEquals(new Integer(2), node.eval(env));
    }

    @Test
    public void referenceAndAssign() throws Exception {
        Environment env = new Environment();
        List<Token> tokens = Lexer.tokenize("var x = 1;");
        ASTNode node = new StatementParser().parse(tokens);
        node.eval(env);
        tokens = Lexer.tokenize("x = x - 1;");
        node = new StatementParser().parse(tokens);
        node.eval(env);
        tokens = Lexer.tokenize("x;");
        node = new StatementParser().parse(tokens);
        assertEquals(new Integer(0), node.eval(env));
    }

    @Test
    public void referenceUnassignedValue() throws Exception {
        Environment env = new Environment();
        List<Token> tokens = Lexer.tokenize("x;");
        ASTNode node = new StatementParser().parse(tokens);
        assertThrows(MylangRuntimeException.class, () -> {
            node.eval(env);
        });

    }
}
