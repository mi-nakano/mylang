package jp.mizunaka.mylang.lexer;

import jp.mizunaka.mylang.lexer.Token;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TokenTest {
    Token foo = new Token("foo");

    @Test
    public void getValue() {
        assertEquals("foo", foo.getValue());
    }

    @Test
    public void equal() {
        assertTrue(foo.equals(new Token(foo.getValue())));
    }

    @Test
    public void isNotequal() {
        assertFalse(foo.equals(null));
        assertFalse(foo.equals(new Token("hoge")));
    }
}
