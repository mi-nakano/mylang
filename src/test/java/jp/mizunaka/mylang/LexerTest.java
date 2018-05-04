package jp.mizunaka.mylang;

import jp.mizunaka.mylang.token.Token;
import jp.mizunaka.mylang.token.TokenList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LexerTest {
    @Test
    public void tokenize() throws Exception {
        String text =
                "  int   foo=123;\n" +
                " test-   x; (hey)";

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
        expected.add(new Token("(", 2));
        expected.add(new Token("hey", 2));
        expected.add(new Token(")", 2));

        TokenList actual = Lexer.tokenize(text);
        int index = 0;
        while(!actual.isEmpty()) {
            assertEquals(expected.get(index), actual.popToken());
            index++;
        }
        assertEquals(expected.size(), actual.getSize());
    }

}
