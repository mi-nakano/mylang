package jp.mizunaka.mylang.lexer;

import jp.mizunaka.mylang.lexer.Lexer;
import jp.mizunaka.mylang.lexer.Token;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LexerTest {
    @Test
    public void tokenize() throws IOException {
        String text =
                "  int   foo=123;\n" +
                " test-   x; hey";

        List<Token> expected = new ArrayList<>();
        expected.add(new Token("int", 1));
        expected.add(new Token("foo", 1));
        expected.add(new Token("=", 1));
        expected.add(new Token("123", 1));
        expected.add(new Token(";", 1));
        expected.add(new Token("test", 2));
        expected.add(new Token("-", 2));
        expected.add(new Token("x", 2));
        expected.add(new Token(";", 2));
        expected.add(new Token("hey", 2));

        List<Token> actual = Lexer.tokenize(text);
        for(int i=0; i < actual.size(); i++){
            assertEquals(expected.get(i), actual.get(i));
        }
        assertEquals(expected.size(), actual.size());
    }

}