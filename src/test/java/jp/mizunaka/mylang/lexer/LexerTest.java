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
        expected.add(new Token("int"));
        expected.add(new Token("foo"));
        expected.add(new Token("="));
        expected.add(new Token("123"));
        expected.add(new Token(";"));
        expected.add(new Token("test"));
        expected.add(new Token("-"));
        expected.add(new Token("x"));
        expected.add(new Token(";"));
        expected.add(new Token("hey"));

        List<Token> actual = Lexer.tokenize(text);
        for(int i=0; i < actual.size(); i++){
            assertEquals(expected.get(i), actual.get(i));
        }
        assertEquals(expected.size(), actual.size());
    }

}
