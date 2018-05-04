package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.ast.IdNode;
import jp.mizunaka.mylang.ast.NumberNode;
import jp.mizunaka.mylang.token.TokenList;


public class PrimaryParser implements Parser {
    @Override
    public ASTNode parse(TokenList tokens) throws MylangParseException {
        if (tokens.peekToken().isNum()) {
            return new NumberNode(tokens.popToken().getValue());
        }
        if (tokens.peekToken().isId()) {
            return new IdNode(tokens.popToken().getValue());
        }
        if(tokens.popToken().getValue().equals("(")) {
            ExpressionParser ep = new ExpressionParser();
            ASTNode node = ep.parse(tokens);
            if(tokens.popToken().getValue().equals(")")) {
                return node;
            }
        }
        throw new MylangParseException();
    }
}
