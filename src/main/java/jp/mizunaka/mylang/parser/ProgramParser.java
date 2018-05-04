package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.ast.StatementsNode;
import jp.mizunaka.mylang.token.Token;

import java.util.List;

public class ProgramParser extends AbstractParser {

    @Override
    public ASTNode parse(List<Token> tokens) throws MylangParseException {
        AbstractParser parser = new StatementParser();
        ASTNode node = new StatementsNode();
        while(tokens.size() > 0) {
           node.addChild(parser.parse(tokens));
        }
        return node;
    }
}
