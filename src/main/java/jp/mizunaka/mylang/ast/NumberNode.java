package jp.mizunaka.mylang.ast;

import jp.mizunaka.mylang.Environment;

public class NumberNode extends ASTNode {
    private final int num;

    public NumberNode(int num) {
        this.num = num;
    }
    public NumberNode(String num) {
        this(Integer.valueOf(num));
    }

    @Override
    public Object eval(Environment env) {
        return new Integer(num);
    }
}
