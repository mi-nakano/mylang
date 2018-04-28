package jp.mizunaka.mylang.ast;

import java.util.ArrayList;
import java.util.List;

public abstract class ASTNode {

    protected List<ASTNode> children = new ArrayList<>();

    public ASTNode() {}

    public void addChild(ASTNode node) {
        children.add(node);
    }

    public abstract Object eval() throws MylangRuntimeException;
}
