package jp.mizunaka.mylang.ast;


import jp.mizunaka.mylang.Environment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberNodeTest {
    @Test
    public void eval(Environment env) {
        NumberNode node = new NumberNode(1);
        assertEquals(new Integer(1), (Integer) node.eval(env));
    }
}
