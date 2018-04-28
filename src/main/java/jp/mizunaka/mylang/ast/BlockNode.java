package jp.mizunaka.mylang.ast;

import jp.mizunaka.mylang.Environment;

public class BlockNode extends ASTNode {
    @Override
    public Object eval(Environment env) throws MylangRuntimeException {
        Object result = null;
        for (ASTNode node : children) {
            result = node.eval(new Environment(env));
        }
        return result;
    }
}
