package jp.mizunaka.mylang.ast;

import jp.mizunaka.mylang.Environment;

public class IdNode extends ASTNode {
    private final String name;

    public IdNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Object eval(Environment env) throws MylangRuntimeException {
        if (!env.has(name)) {
            throw new MylangRuntimeException();
        }
        return env.get(name);
    }
}
