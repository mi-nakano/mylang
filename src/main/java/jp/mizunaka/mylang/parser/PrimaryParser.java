package jp.mizunaka.mylang.parser;

import jp.mizunaka.mylang.ast.ASTNode;
import jp.mizunaka.mylang.ast.ApplyFuncNode;
import jp.mizunaka.mylang.ast.IdNode;
import jp.mizunaka.mylang.ast.NumberNode;
import jp.mizunaka.mylang.token.TokenList;


public class PrimaryParser implements Parser {
    @Override
    public ASTNode parse(TokenList tokens) throws MylangParseException {
        if (tokens.peekToken().isNum()) {
            return new NumberNode(tokens.popToken().getValue());
        }
        if (tokens.peekToken().isId()) {
            ASTNode idNode = new IdNode(tokens.popToken().getValue());
            if(tokens.peekToken().getValue().equals("(")) {
                ASTNode applyFuncNode = new ApplyFuncNode();
                applyFuncNode.addChild(idNode);
                applyFuncNode.addChild(new PostfixParser().parse(tokens));
                return applyFuncNode;
            } else {
                return idNode;
            }
        }
        if(tokens.popToken().getValue().equals("(")) {
            ExpressionParser ep = new ExpressionParser();
            ASTNode node = ep.parse(tokens);
            if(tokens.popToken().getValue().equals(")")) {
                return node;
            }
        }
        throw new MylangParseException();
    }
}
