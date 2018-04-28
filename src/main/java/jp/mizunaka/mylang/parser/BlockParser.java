package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.ast.BlockNode;
import jp.mizunaka.mylang.token.Token;

import java.util.List;

public class BlockParser extends AbstractParser {
    @Override
    public ASTNode parse(List<Token> tokens) throws MylangParseException {
        Token t = popToken(tokens);
        if (!t.getValue().equals("{")) {
            throw new MylangParseException();
        }
        ASTNode node = new BlockNode();
        StatementParser sp = new StatementParser();
        while(!peekToken(tokens).getValue().equals("}")) {
            node.addChild(sp.parse(tokens));
        }
        t = popToken(tokens);
        return node;
    }
}
