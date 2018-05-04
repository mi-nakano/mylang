package jp.mizunaka.mylang.ast;

import jp.mizunaka.mylang.Environment;

import java.util.ArrayList;
import java.util.List;

public class ArgumentsNode extends ASTNode {

    @Override
    public Object eval(Environment env) throws MylangRuntimeException {
        List<Object> arguments = new ArrayList<>();
        for (ASTNode child : children) {
            arguments.add(child.eval(env));
        }
        return arguments;
    }
}
