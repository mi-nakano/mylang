package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.ast.IdNode;
import jp.mizunaka.mylang.ast.NumberNode;
import jp.mizunaka.mylang.token.Token;

import java.util.List;

public class PrimaryParser extends AbstractParser {
    @Override
    public ASTNode parse(List<Token> tokens) throws MylangParseException {
        if (peekToken(tokens).isNum()) {
            return new NumberNode(popToken(tokens).getValue());
        }
        if (peekToken(tokens).isId()) {
            return new IdNode(popToken(tokens).getValue());
        }
        if(popToken(tokens).getValue().equals("(")) {
            ExpressionParser ep = new ExpressionParser();
            ASTNode node = ep.parse(tokens);
            if(popToken(tokens).getValue().equals(")")) {
                return node;
            }
        }
        throw new MylangParseException();
    }
}
