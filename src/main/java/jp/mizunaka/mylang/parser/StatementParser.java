package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.token.Token;
import jp.mizunaka.mylang.token.TokenList;

public class StatementParser implements Parser {

    @Override
    public ASTNode parse(TokenList tokens) throws MylangParseException {
        ASTNode node;
        Token t = tokens.peekToken();
        if(t.getValue().equals("var")){
            return new DeclarationParser().parse(tokens);
        } else if (t.getValue().equals("if")) {
            return new IfParser().parse(tokens);
        } else if (t.getValue().equals("while")) {
            return new WhileParser().parse(tokens);
        } else if (t.getValue().equals("def")) {
            return new FunctionParser().parse(tokens);
        } else {
            node = new ExpressionParser().parse(tokens);
            if (!tokens.popToken().getValue().equals(";")) {
                throw new MylangParseException();
            }
            return node;
        }
    }
}
