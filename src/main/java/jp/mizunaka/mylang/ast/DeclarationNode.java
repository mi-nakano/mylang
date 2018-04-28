package jp.mizunaka.mylang.ast;

import jp.mizunaka.mylang.Environment;

public class DeclarationNode extends ASTNode {
    private String name;

    public DeclarationNode(String name) {
        this.name = name;
    }

    @Override
    public Object eval(Environment env) throws MylangRuntimeException {
        // 変数宣言のみの場合
        if (children.size() == 0) {
            env.put(name, null);
            return null;
        }

        Object value = children.get(0).eval(env);
        env.put(name, value);
        return value;
    }
}
