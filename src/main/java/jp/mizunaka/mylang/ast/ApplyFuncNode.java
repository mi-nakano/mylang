package jp.mizunaka.mylang.ast;

import jp.mizunaka.mylang.Environment;

import java.util.List;

public class ApplyFuncNode extends ASTNode {

    @Override
    public Object eval(Environment env) throws MylangRuntimeException {
        MylangFunction func = (MylangFunction) children.get(0).eval(env);
        List<Object> arguments = (List<Object>) children.get(1).eval(env);
        Environment newEnv = new Environment(env);
        for (int i=0; i < func.getParamLength(); i++) {
            newEnv.assign(func.getParamName(i), arguments.get(i));
        }
        return func.eval(newEnv);
    }
}
