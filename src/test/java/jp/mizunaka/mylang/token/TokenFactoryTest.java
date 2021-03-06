package jp.mizunaka.mylang.token;

import jp.mizunaka.mylang.Rule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TokenFactoryTest {
    @Test
    public void createSeparatorToken() {
        for(char c : Rule.SEPARATORS) {
            Token t = TokenFactory.createToken(c, 1);
            assertTrue(t instanceof SeparatorToken);
        }
    }

    @Test
    public void createOperatorToken() {
        for(char c : Rule.OPERATORS) {
            Token t = TokenFactory.createToken(c, 1);
            assertTrue(t instanceof OperatorToken);
        }
    }


    @Test
    public void createNumToken() {
        Token t = TokenFactory.createToken("123", 1);
        assertTrue(t instanceof NumToken);
    }

    @Test
    public void createIdToken() {
        Token t = TokenFactory.createToken("123foo", 1);
        assertTrue(t instanceof IdToken);
    }
}
