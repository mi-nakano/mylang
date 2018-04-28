package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.ast.IfNode;
import jp.mizunaka.mylang.token.Token;

import java.util.List;

public class IfParser extends AbstractParser{
    @Override
    public ASTNode parse(List<Token> tokens) throws MylangParseException {
        Token t = popToken(tokens);
        if(!t.getValue().equals("if")) {
            throw new MylangParseException();
        }

        ASTNode node = new IfNode();
        node.addChild(new ExpressionParser().parse(tokens));
        node.addChild(new BlockParser().parse(tokens));

        return node;
    }
}
