package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.ast.StatementsNode;
import jp.mizunaka.mylang.token.TokenList;

public class ProgramParser implements Parser {

    @Override
    public ASTNode parse(TokenList tokens) throws MylangParseException {
        Parser parser = new StatementParser();
        ASTNode node = new StatementsNode();
        while(tokens.getSize() > 0) {
           node.addChild(parser.parse(tokens));
        }
        return node;
    }
}
