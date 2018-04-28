package jp.mizunaka.mylang;

import jp.mizunaka.mylang.ast.MylangRuntimeException;

import java.util.HashMap;
import java.util.Map;

public class Environment {
    private Environment parent = null;
    private Map<String, Object> table = new HashMap<>();

    public Environment() {}
    public Environment(Environment env) {
        this.parent = env;
    }

    public boolean has(String name) {
        if (table.containsKey(name)) {
            return true;
        }
        if (parent != null) {
            return parent.has(name);
        }
        return false;
    }

    public Object get(String name) {
        if (table.containsKey(name)) {
            return table.get(name);
        }
        if (parent != null) {
            return parent.get(name);
        }
        return null;
    }

    public void put(String name, Object value) throws MylangRuntimeException {
        if (table.containsKey(name)) {
            table.put(name, value);
            return;
        } else if (parent != null) {
            parent.put(name, value);
            return;
        }
        throw new MylangRuntimeException();
    }

    public void assign(String name, Object value) throws MylangRuntimeException {
        if (table.containsKey(name)) {
            throw new MylangRuntimeException();
        }
        table.put(name, value);
    }
}
