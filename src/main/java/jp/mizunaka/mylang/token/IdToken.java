package jp.mizunaka.mylang.token;

public class IdToken extends Token {

    public IdToken(String value, int lineNumber) {
        super(value, lineNumber);
    }

    @Override
    public boolean isId() {
        return true;
    }
}
