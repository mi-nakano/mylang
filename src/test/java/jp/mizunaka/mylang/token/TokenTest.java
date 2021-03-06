package jp.mizunaka.mylang.token;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
