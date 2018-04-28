package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.ast.NegativeNode;
import jp.mizunaka.mylang.token.Token;

import java.util.List;

public class FactorParser extends AbstractParser {
    @Override
    public ASTNode parse(List<Token> tokens) throws MylangParseException {
        if(peekToken(tokens).getValue().equals("-")) {
            popToken(tokens);
            ASTNode node = new NegativeNode();
            node.addChild(new PrimaryParser().parse(tokens));
            return node;
        }

        return new PrimaryParser().parse(tokens);
    }
}
