package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.ast.OperatorNode;
import jp.mizunaka.mylang.token.Token;
import jp.mizunaka.mylang.token.TokenList;

public class ExpressionParser implements Parser {

    @Override
    public ASTNode parse(TokenList tokens) throws MylangParseException {
        Parser parser = new TermParser();
        ASTNode left = parser.parse(tokens);
        while(true) {
            if (tokens.isEmpty()) {
                break;
            }
            Token t = tokens.peekToken();
            if (!t.getValue().equals("+") && !t.getValue().equals("-")
                    && !t.getValue().equals("=")) {
                break;
            }
            tokens.popToken();
            if (t.getValue().equals("=")) {     // 変数の代入の場合
                ASTNode node = new OperatorNode(t.getValue());
                node.addChild(left);
                node.addChild(this.parse(tokens));
                return node;
            }
            ASTNode node = new OperatorNode(t.getValue());
            node.addChild(left);

            ASTNode right = new TermParser().parse(tokens);
            node.addChild(right);
            left = node;
        }
        return left;
    }
}
