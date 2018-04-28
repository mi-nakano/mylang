package jp.mizunaka.mylang.token;

public class OperatorToken extends Token {

    public OperatorToken(String value, int lineNumber) {
        super(value, lineNumber);
    }

    @Override
    public boolean isOperator() {
        return true;
    }
}
