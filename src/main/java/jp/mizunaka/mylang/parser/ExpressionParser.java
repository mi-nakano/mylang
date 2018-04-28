package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.ast.OperatorNode;
import jp.mizunaka.mylang.token.Token;

import java.util.List;

public class ExpressionParser extends AbstractParser {

    @Override
    public ASTNode parse(List<Token> tokens) throws MylangParseException {
        AbstractParser parser = new TermParser();
        ASTNode left = parser.parse(tokens);
        while(true) {
            if (tokens.isEmpty()) {
                break;
            }
            Token t = peekToken(tokens);
            if (!peekToken(tokens).getValue().equals("+") && !peekToken(tokens).getValue().equals("-")
                    && !peekToken(tokens).getValue().equals("=")) {
                break;
            }
            popToken(tokens);
            ASTNode node = new OperatorNode(t.getValue());
            node.addChild(left);

            ASTNode right = new TermParser().parse(tokens);
            node.addChild(right);
            left = node;
        }
        return left;
    }
}
