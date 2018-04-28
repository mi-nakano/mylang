package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.ast.DeclarationNode;
import jp.mizunaka.mylang.token.Token;

import java.util.List;

public class DeclarationParser extends AbstractParser {
    @Override
    public ASTNode parse(List<Token> tokens) throws MylangParseException {
        if (!popToken(tokens).getValue().equals("var")) {
            throw new MylangParseException();
        }

        Token t = popToken(tokens);
        if(!t.isId()) {
            throw new MylangParseException();
        }
        String name = t.getValue();
        ASTNode node = new DeclarationNode(name);
        if (peekToken(tokens).getValue().equals(";")) {
            return node;
        }

        t = popToken(tokens);
        if (t.getValue().equals("=")) {
            node.addChild(new ExpressionParser().parse(tokens));
        }
        return node;
    }
}
