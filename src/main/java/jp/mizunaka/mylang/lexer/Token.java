package jp.mizunaka.mylang.lexer;

public class Token {

    private final String value;

    public Token(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
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
        if (this.value == null && t.value == null)  {
            return true;
        }
        if (this.hashCode() != t.hashCode()) {
            return false;
        }
        return this.value.equals(t.value);
    }
}
