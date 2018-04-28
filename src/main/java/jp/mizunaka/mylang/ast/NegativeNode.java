package jp.mizunaka.mylang.ast;

public class NegativeNode extends ASTNode {
    public NegativeNode() {}

    @Override
    public Object eval() throws MylangRuntimeException {
        return new Integer(- (Integer)children.get(0).eval());
    }
}
