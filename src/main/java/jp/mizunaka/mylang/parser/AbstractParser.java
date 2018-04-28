package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.token.Token;

import java.util.List;

public abstract class AbstractParser {

    /**
     * tokenのリストからいくつかの要素を読み、抽象構文木の要素を作成して返す
     * 使用したtokenはリストから除外する
     *
     * @param tokens トークンのリスト
     * @return 文法規則を適用した結果生成された、抽象構文木の要素
     * @throws MylangParseException パースに失敗した場合に発生
     */
    abstract public ASTNode parse(List<Token> tokens) throws MylangParseException;

    /**
     * tokenのリストの先頭要素を取り出し、リストから削除する
     *
     * @param tokens tokenのリスト
     * @return リストの先頭のtoken
     * @throws MylangParseException tokenの参照に失敗した場合に発生
     */
    protected Token popToken(List<Token> tokens) throws MylangParseException {
        try {
            return tokens.remove(0);
        } catch (Exception e) {
            throw new MylangParseException();
        }
    }

    /**
     * tokenのリストの先頭要素を参照する
     *
     * @param tokens tokenのリスト
     * @return リストの先頭のtoken
     * @throws MylangParseException tokenの参照に失敗した場合に発生
     */
    protected Token peekToken(List<Token> tokens) throws MylangParseException {
        try {
            return tokens.get(0);
        } catch (Exception e) {
            throw new MylangParseException();
        }
    }
}
