package jp.mizunaka.mylang.ast;

import jp.mizunaka.mylang.Environment;

import java.util.ArrayList;
import java.util.List;

public class MylangFunction {

    private final List<String> params;
    private final ASTNode body;

    public MylangFunction(ASTNode body) {
        this(new ArrayList<>(), body);
    }

    public MylangFunction(List<String> params, ASTNode body) {
        this.params = params;
        this.body = body;
    }

    public int getParamLength() {
        return params.size();
    }

    public List<String> getParams() {
        return params;
    }

    public String getParamName(int index) {
        return params.get(index);
    }

    public Object eval(Environment env) throws MylangRuntimeException {
        return body.eval(env);
    }
}
