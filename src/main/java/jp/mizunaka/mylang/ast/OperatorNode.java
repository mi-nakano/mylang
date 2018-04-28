package jp.mizunaka.mylang.ast;

public class OperatorNode extends ASTNode {

    private final char opcode;

    public OperatorNode(String opcode) {
        this(opcode.charAt(0));
    }
    public OperatorNode(char opcode) {
        this.opcode = opcode;
    }

    @Override
    public Object eval() throws MylangRuntimeException {
        int left = (Integer) children.get(0).eval();
        int right = (Integer) children.get(1).eval();
        switch (opcode) {
            case '+':
                return left + right;
            case '-':
                return left - right;
            case '*':
                return left * right;
            case '/':
                return left / right;
        }
        throw new MylangRuntimeException();
    }
}
