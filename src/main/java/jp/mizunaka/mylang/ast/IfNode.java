package jp.mizunaka.mylang.ast;

import jp.mizunaka.mylang.Environment;

public class IfNode extends ASTNode {
    @Override
    public Object eval(Environment env) throws MylangRuntimeException {
        if ((Integer)children.get(0).eval(env) != 0) {
           return children.get(1).eval(env);
        }
        return null;
    }
}
