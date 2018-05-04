package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.ast.BlockNode;
import jp.mizunaka.mylang.token.Token;
import jp.mizunaka.mylang.token.TokenList;


public class BlockParser implements Parser {
    @Override
    public ASTNode parse(TokenList tokens) throws MylangParseException {
        Token t = tokens.popToken();
        if (!t.getValue().equals("{")) {
            throw new MylangParseException();
        }
        ASTNode node = new BlockNode();
        StatementParser sp = new StatementParser();
        while(!tokens.peekToken().getValue().equals("}")) {
            node.addChild(sp.parse(tokens));
        }
        t = tokens.popToken();
        return node;
    }
}
