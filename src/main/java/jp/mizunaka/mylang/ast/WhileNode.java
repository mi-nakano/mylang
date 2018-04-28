package jp.mizunaka.mylang.ast;

import jp.mizunaka.mylang.Environment;

public class WhileNode extends ASTNode {
    @Override
    public Object eval(Environment env) throws MylangRuntimeException {
        Object result = null;
        Environment newEnv = new Environment(env);
        while ((Integer) children.get(0).eval(newEnv) != 0) {
            result = children.get(1).eval(newEnv);
        }
        return result;
    }
}
