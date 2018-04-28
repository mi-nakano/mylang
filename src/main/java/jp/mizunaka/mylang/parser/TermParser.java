package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.ast.OperatorNode;
import jp.mizunaka.mylang.token.Token;

import java.util.List;

public class TermParser extends AbstractParser{
    @Override
    public ASTNode parse(List<Token> tokens) throws MylangParseException {
        ASTNode left = new FactorParser().parse(tokens);
        while(true) {
            if(tokens.isEmpty()) {
                break;
            }
            Token t = peekToken(tokens);
            if(!t.getValue().equals("*") && !t.getValue().equals("/")) {
                break;
            }

            popToken(tokens);
            ASTNode node = new OperatorNode(t.getValue());
            node.addChild(left);
            node.addChild(new FactorParser().parse(tokens));
            left = node;
        }
        return left;
    }
}
