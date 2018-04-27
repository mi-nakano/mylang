package jp.mizunaka.mylang.lexer;

public class SeparatorToken extends Token {

    public SeparatorToken(String value, int lineNumber) {
        super(value, lineNumber);
    }

    @Override
    public boolean isSeparator() {
        return true;
    }
}
