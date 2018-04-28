package jp.mizunaka.mylang.token;

import jp.mizunaka.mylang.Rule;

public class TokenFactory {
    public static Token createToken(char c, int lineNumber) {
        return createToken(String.valueOf(c), lineNumber);
    }

    public static Token createToken(String value, int lineNumber) {
        if (value.length() == 1) {
            char valueChar = value.charAt(0);
            if (valueChar == Rule.SEPARATOR) {
                return new SeparatorToken(value, lineNumber);
            }
            if (Rule.OPERATORS.contains(valueChar)) {
                return new OperatorToken(value, lineNumber);
            }
        }
        try {
            Integer.parseInt(value);
            return new NumToken(value, lineNumber);
        } catch (Exception e) {
           // nothing
        }

        return new IdToken(value, lineNumber);
    }
}
