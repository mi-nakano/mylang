package jp.mizunaka.mylang.ast;

import jp.mizunaka.mylang.Environment;

import java.util.List;

public class FunctionDefNode extends ASTNode {
    private final String name;
    private final List<String> params;

    public FunctionDefNode(String name, List<String> params) {
        this.name = name;
        this.params = params;
    }

    @Override
    public Object eval(Environment env) throws MylangRuntimeException {
        env.assign(name, new MylangFunction(params, children.get(0)));
        return null;
    }
}
