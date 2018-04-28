package jp.mizunaka.mylang.ast;

import jp.mizunaka.mylang.Environment;

public class NegativeNode extends ASTNode {
    public NegativeNode() {}

    @Override
    public Object eval(Environment env) throws MylangRuntimeException {
        return new Integer(- (Integer)children.get(0).eval(env));
    }
}
