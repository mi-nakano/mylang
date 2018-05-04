package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.ast.DeclarationNode;
import jp.mizunaka.mylang.token.Token;
import jp.mizunaka.mylang.token.TokenList;

public class DeclarationParser implements Parser {
    @Override
    public ASTNode parse(TokenList tokens) throws MylangParseException {
        if (!tokens.popToken().getValue().equals("var")) {
            throw new MylangParseException();
        }

        Token t = tokens.popToken();
        if(!t.isId()) {
            throw new MylangParseException();
        }
        String name = t.getValue();
        ASTNode node = new DeclarationNode(name);
        if (tokens.peekToken().getValue().equals(";")) {
            return node;
        }

        t = tokens.popToken();
        if (t.getValue().equals("=")) {
            node.addChild(new ExpressionParser().parse(tokens));
        }
        return node;
    }
}
