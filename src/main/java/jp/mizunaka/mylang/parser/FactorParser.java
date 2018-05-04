package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.ast.NegativeNode;
import jp.mizunaka.mylang.token.TokenList;

public class FactorParser implements Parser {
    @Override
    public ASTNode parse(TokenList tokens) throws MylangParseException {
        if(tokens.peekToken().getValue().equals("-")) {
            tokens.popToken();
            ASTNode node = new NegativeNode();
            node.addChild(new PrimaryParser().parse(tokens));
            return node;
        }

        return new PrimaryParser().parse(tokens);
    }
}
