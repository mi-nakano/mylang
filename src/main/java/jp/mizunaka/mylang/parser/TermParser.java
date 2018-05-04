package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.ast.OperatorNode;
import jp.mizunaka.mylang.token.Token;
import jp.mizunaka.mylang.token.TokenList;

public class TermParser implements Parser {
    @Override
    public ASTNode parse(TokenList tokens) throws MylangParseException {
        ASTNode left = new FactorParser().parse(tokens);
        while(true) {
            if(tokens.isEmpty()) {
                break;
            }
            Token t = tokens.peekToken();
            if(!t.getValue().equals("*") && !t.getValue().equals("/")) {
                break;
            }

            tokens.popToken();
            ASTNode node = new OperatorNode(t.getValue());
            node.addChild(left);
            node.addChild(new FactorParser().parse(tokens));
            left = node;
        }
        return left;
    }
}
