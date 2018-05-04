package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.token.TokenList;

public interface Parser {

    /**
     * tokenのリストからいくつかの要素を読み、抽象構文木の要素を作成して返す
     * 使用したtokenはリストから除外する
     *
     * @param tokens トークンのリスト
     * @return 文法規則を適用した結果生成された、抽象構文木の要素
     * @throws MylangParseException パースに失敗した場合に発生
     */
    ASTNode parse(TokenList tokens) throws MylangParseException;

}
