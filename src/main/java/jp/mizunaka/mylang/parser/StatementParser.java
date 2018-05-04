package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.token.TokenList;

public class StatementParser implements Parser {

    @Override
    public ASTNode parse(TokenList tokens) throws MylangParseException {
        ASTNode node;
        if(tokens.peekToken().getValue().equals("var")){
            DeclarationParser dp = new DeclarationParser();
            node = dp.parse(tokens);

            if (!tokens.popToken().getValue().equals(";")) {
                throw new MylangParseException();
            }
        } else if (tokens.peekToken().getValue().equals("if")) {
            IfParser ip = new IfParser();
            node = ip.parse(tokens);
        } else if (tokens.peekToken().getValue().equals("while")) {
            WhileParser wp = new WhileParser();
            node = wp.parse(tokens);
        } else {
            ExpressionParser ep = new ExpressionParser();
            node = ep.parse(tokens);
            if (!tokens.popToken().getValue().equals(";")) {
                throw new MylangParseException();
            }
        }

        return node;
    }
}
