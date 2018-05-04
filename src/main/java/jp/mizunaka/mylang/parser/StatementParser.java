package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.token.TokenList;

public class StatementParser implements Parser {

    @Override
    public ASTNode parse(TokenList tokens) throws MylangParseException {
        ASTNode node;
        if(tokens.peekToken().getValue().equals("var")){
            return new DeclarationParser().parse(tokens);
        } else if (tokens.peekToken().getValue().equals("if")) {
            return new IfParser().parse(tokens);
        } else if (tokens.peekToken().getValue().equals("while")) {
            return new WhileParser().parse(tokens);
        } else {
            node = new ExpressionParser().parse(tokens);
            if (!tokens.popToken().getValue().equals(";")) {
                throw new MylangParseException();
            }
            return node;
        }
    }
}
