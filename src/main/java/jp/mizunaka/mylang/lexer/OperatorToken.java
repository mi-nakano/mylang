package jp.mizunaka.mylang.lexer;

public class OperatorToken extends Token {

    public OperatorToken(String value, int lineNumber) {
        super(value, lineNumber);
    }

    @Override
    public boolean isOperator() {
        return true;
    }
}
