package jp.mizunaka.mylang.token;

import jp.mizunaka.mylang.token.Token;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TokenTest {
    Token foo = new Token("foo", 1);

    @Test
    public void getValue() {
        assertEquals("foo", foo.getValue());
    }

    @Test
    public void equal() {
        assertTrue(foo.equals(new Token(foo.getValue(), foo.getLineNumber())));
    }

    @Test
    public void isNotequal() {
        assertFalse(foo.equals(null));
        assertFalse(foo.equals(new Token("hoge", foo.getLineNumber())));
        assertFalse(foo.equals(new Token(foo.getValue(), 0)));
    }
}
