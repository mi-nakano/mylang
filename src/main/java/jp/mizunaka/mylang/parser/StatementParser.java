package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.token.Token;

import java.util.List;

public class StatementParser extends AbstractParser {

    @Override
    public ASTNode parse(List<Token> tokens) throws MylangParseException {
        ASTNode node;
        if(peekToken(tokens).getValue().equals("var")){
            DeclarationParser dp = new DeclarationParser();
            node = dp.parse(tokens);
        } else {
            ExpressionParser ep = new ExpressionParser();
            node = ep.parse(tokens);
        }

        if (!popToken(tokens).getValue().equals(";")) {
            throw new MylangParseException();
        }
        return node;
    }
}
