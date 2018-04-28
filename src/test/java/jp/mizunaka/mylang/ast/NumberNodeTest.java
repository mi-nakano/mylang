package jp.mizunaka.mylang.ast;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberNodeTest {
    @Test
    public void eval() {
        NumberNode node = new NumberNode(1);
        assertEquals(new Integer(1), (Integer) node.eval());
    }
}
