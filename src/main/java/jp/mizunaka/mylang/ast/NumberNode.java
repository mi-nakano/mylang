package jp.mizunaka.mylang.ast;

public class NumberNode extends ASTNode {
    private final int num;

    public NumberNode(int num) {
        this.num = num;
    }
    public NumberNode(String num) {
        this(Integer.valueOf(num));
    }

    @Override
    public Object eval() {
        return new Integer(num);
    }
}
