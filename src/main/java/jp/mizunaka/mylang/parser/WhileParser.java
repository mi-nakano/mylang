package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.ast.WhileNode;
import jp.mizunaka.mylang.token.TokenList;

public class WhileParser implements Parser {
    @Override
    public ASTNode parse(TokenList tokens) throws MylangParseException {
        if(!tokens.popToken().getValue().equals("while")) {
            throw new MylangParseException();
        }
        ASTNode node = new WhileNode();
        node.addChild(new ExpressionParser().parse(tokens));
        node.addChild(new BlockParser().parse(tokens));
        return node;
    }
}
