package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.ast.ArgumentsNode;
import jp.mizunaka.mylang.token.Token;
import jp.mizunaka.mylang.token.TokenList;

public class PostfixParser implements Parser {
    @Override
    public ASTNode parse(TokenList tokens) throws MylangParseException {
        if(!tokens.popToken().getValue().equals("(")) {
            throw new MylangParseException();
        }
        ASTNode node = new ArgumentsNode();
        Token t = tokens.peekToken();
        if(t.getValue().equals(")")) {
            tokens.popToken();
            return node;
        }

        Parser ep = new ExpressionParser();
        while(true) {
            node.addChild(ep.parse(tokens));
            t = tokens.popToken();
            if(t.getValue().equals(")")) {
                break;
            }
            if(!t.getValue().equals(",")) {
                throw new MylangParseException();
            }
        }
        return node;
    }
}
