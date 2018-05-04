package jp.mizunaka.mylang.token;

import jp.mizunaka.mylang.parser.MylangParseException;

import java.util.ArrayList;
import java.util.List;

public class TokenList {
    private final List<Token> list;

    public TokenList() {
        this(new ArrayList<>());
    }
    public TokenList(List<Token> list) {
        this.list = list;
    }

    /**
     * tokenのリストの先頭要素を取り出し、リストから削除する
     *
     * @return リストの先頭のtoken
     * @throws MylangParseException tokenの参照に失敗した場合に発生
     */
    public Token popToken() throws MylangParseException {
        try {
            return list.remove(0);
        } catch (Exception e) {
            throw new MylangParseException();
        }
    }

    /**
     * tokenのリストの先頭要素を参照する
     *
     * @return リストの先頭のtoken
     * @throws MylangParseException tokenの参照に失敗した場合に発生
     */
    public Token peekToken() throws MylangParseException {
        try {
            return list.get(0);
        } catch (Exception e) {
            throw new MylangParseException();
        }
    }

    public int getSize() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
