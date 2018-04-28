package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.ast.WhileNode;
import jp.mizunaka.mylang.token.Token;

import java.util.List;

public class WhileParser extends AbstractParser {
    @Override
    public ASTNode parse(List<Token> tokens) throws MylangParseException {
        if(!popToken(tokens).getValue().equals("while")) {
            throw new MylangParseException();
        }
        ASTNode node = new WhileNode();
        node.addChild(new ExpressionParser().parse(tokens));
        node.addChild(new BlockParser().parse(tokens));
        return node;
    }
}
