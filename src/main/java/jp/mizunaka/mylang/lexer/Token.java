package jp.mizunaka.mylang.lexer;

public class Token {

    private final String value;
    private final int lineNumber;

    public Token(String value, int lineNumber) {
        this.value = value;
        this.lineNumber = lineNumber;
    }

    public String getValue() {
        return value;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public boolean isNum() {
        return false;
    }

    public boolean isId() {
        return false;
    }

    public boolean isOperator() {
        return false;
    }

    public boolean isSeparator() {
        return false;
    }

    @Override
    public int hashCode() {
        if (value == null) {
            return 0;
        }
        return value.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Token)) {
            return false;
        }
        Token t = (Token) o;
        if (this.hashCode() != t.hashCode()) {
            return false;
        }
        if (this.lineNumber != t.lineNumber) {
            return false;
        }
        if (this.value == null && t.value == null)  {
            return true;
        }
        return this.value.equals(t.value);
    }
}
