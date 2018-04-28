package jp.mizunaka.mylang;

import java.util.HashMap;
import java.util.Map;

public class Environment {
    private Map<String, Object> table = new HashMap<>();

    public Environment() {}
    public Environment(Environment env) {
        this.table.putAll(env.table);
    }

    public boolean has(String name) {
        return table.containsKey(name);
    }

    public Object get(String name) {
        return table.get(name);
    }

    public void put(String name, Object value) {
        table.put(name, value);
    }
}
