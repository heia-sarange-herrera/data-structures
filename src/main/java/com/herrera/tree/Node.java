package com.herrera.tree;

import java.util.ArrayList;
import java.util.List;

public abstract class Node<T> {

    private T datas;
    private Node<T> parent;
    private List<Node<T>> childrens;

    // constructors

    public Node(T datas) {
        this.datas = datas;
        this.childrens = new ArrayList<>();
    }

    // methods

    public void addChild(Node<T> child) {
        if (containsNode(child)) {
            throw new IllegalArgumentException("Cycle detected! Cannot add a parent as a child.");
        }   
        child.setParent(this);
        childrens.add(child);
    }

    private void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public boolean isRoot() {
        return parent == null;
    }

    public boolean isLeaf() {
        return childrens.isEmpty();
    }

    public T getData() {
        return datas;
    }

    public List<Node<T>> getChildren() {
        return childrens;
    }

    // prevents cyclic relations
    public boolean containsNode(Node<T> node) {
        if (this == node)
            return true;
        for (Node<T> child : childrens) {
            if (child.containsNode(child))
                return true;
        }
        return false;
    }

}
