package jp.mizunaka.mylang.ast;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperatorNodeTest {
    @Test
    public void evalPlus() throws MylangRuntimeException {
        OperatorNode node = new OperatorNode('+');
        node.addChild(new NumberNode(1));
        node.addChild(new NumberNode(2));
        assertEquals(new Integer(3), (Integer) node.eval());
    }
}
