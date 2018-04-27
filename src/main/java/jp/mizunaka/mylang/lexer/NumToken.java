package jp.mizunaka.mylang.lexer;

public class NumToken extends Token {

    public NumToken(String value, int lineNumber) {
        super(value, lineNumber);
    }

    @Override
    public boolean isNum() {
        return true;
    }
}
