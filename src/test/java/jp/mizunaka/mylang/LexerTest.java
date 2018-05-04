package jp.mizunaka.mylang;

import jp.mizunaka.mylang.token.Token;
import jp.mizunaka.mylang.token.TokenList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LexerTest {
    @Test
    public void tokenize() throws Exception {
        String text =
                "  foo=123;\n" +
                " def foo(a, b,c){\n" +
                "  1;\n" +
                "}\n";

        List<Token> expected = new ArrayList<>();
        expected.add(new Token("foo", 1));
        expected.add(new Token("=", 1));
        expected.add(new Token("123", 1));
        expected.add(new Token(";", 1));
        expected.add(new Token("def",2));
        expected.add(new Token("foo",2));
        expected.add(new Token("(",2));
        expected.add(new Token("a",2));
        expected.add(new Token(",",2));
        expected.add(new Token("b",2));
        expected.add(new Token(",",2));
        expected.add(new Token("c",2));
        expected.add(new Token(")",2));
        expected.add(new Token("{",2));
        expected.add(new Token("1",3));
        expected.add(new Token(";",3));
        expected.add(new Token("}",4));

        TokenList actual = Lexer.tokenize(text);
        assertEquals(expected.size(), actual.getSize());
        int index = 0;
        while(!actual.isEmpty()) {
            assertEquals(expected.get(index), actual.popToken());
            index++;
        }
    }

}
