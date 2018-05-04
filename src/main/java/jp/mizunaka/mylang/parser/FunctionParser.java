package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.ast.FunctionDefNode;
import jp.mizunaka.mylang.token.Token;
import jp.mizunaka.mylang.token.TokenList;

import java.util.ArrayList;
import java.util.List;

public class FunctionParser implements Parser {
    @Override
    public ASTNode parse(TokenList tokens) throws MylangParseException {
        if (!tokens.popToken().getValue().equals("def")) {
            throw new MylangParseException();
        }

        Token t = tokens.popToken();
        if(!t.isId()) {
            throw new MylangParseException();
        }
        String name = t.getValue();
        ASTNode node = new FunctionDefNode(name, parseParams(tokens));
        node.addChild(new BlockParser().parse(tokens));

        return node;
    }

    private List<String> parseParams(TokenList tokens) throws MylangParseException {
        List<String> params = new ArrayList<>();
        Token t = tokens.popToken();
        if(!t.getValue().equals("(")) {
            throw  new  MylangParseException();
        }
        t = tokens.peekToken();
        if(t.getValue().equals(")")) {
            tokens.popToken();
            return params;
        }

        while(true) {
            t = tokens.popToken();
            if(!t.isId()) {
                throw new MylangParseException();
            }
            params.add(t.getValue());
            t = tokens.popToken();
            if(t.getValue().equals(")")) {
                break;
            }
            if(!t.getValue().equals(",")) {
                throw new MylangParseException();
            }
        }

        return params;
    }
}
