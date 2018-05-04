package jp.mizunaka.mylang.ast;

import jp.mizunaka.mylang.Environment;

public class StatementsNode extends ASTNode {
    @Override
    public Object eval(Environment env) throws MylangRuntimeException {
        Object result = null;
        for (ASTNode child : children) {
            result = child.eval(env);
        }
        return result;
    }
}
