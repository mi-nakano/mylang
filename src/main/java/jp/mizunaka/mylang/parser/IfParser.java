package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.ast.IfNode;
import jp.mizunaka.mylang.token.Token;
import jp.mizunaka.mylang.token.TokenList;

public class IfParser implements Parser {
    @Override
    public ASTNode parse(TokenList tokens) throws MylangParseException {
        Token t = tokens.popToken();
        if(!t.getValue().equals("if")) {
            throw new MylangParseException();
        }

        ASTNode node = new IfNode();
        node.addChild(new ExpressionParser().parse(tokens));
        node.addChild(new BlockParser().parse(tokens));

        return node;
    }
}
