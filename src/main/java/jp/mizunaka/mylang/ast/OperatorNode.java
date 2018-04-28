package jp.mizunaka.mylang.ast;

import jp.mizunaka.mylang.Environment;

public class OperatorNode extends ASTNode {

    private final char opcode;

    public OperatorNode(String opcode) {
        this(opcode.charAt(0));
    }
    public OperatorNode(char opcode) {
        this.opcode = opcode;
    }

    @Override
    public Object eval(Environment env) throws MylangRuntimeException {
        int right = (Integer) children.get(1).eval(env);
        if (opcode == '=' && children.get(0) instanceof IdNode) {
            String name = ((IdNode) children.get(0)).getName();
            if (!env.has(name)) {
                throw new MylangRuntimeException();
            }
            env.put(name, right);

            return env.get(name);
        }

        int left = (Integer) children.get(0).eval(env);
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
