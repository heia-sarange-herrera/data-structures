package com.herrera.tree;

import java.util.ArrayList;
import java.util.List;

public abstract class Node<T> {

    protected T datas;
    protected Node<T> parent;
    protected List<Node<T>> childrens;

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
            if (child.containsNode(node))
                return true;
        }
        return false;
    }

    public List<T> getChildrenData() {
        List<T> dataList = new ArrayList<>();
        for (Node<T> child : this.childrens) {
            dataList.add(child.getData());
        }
        return dataList;
    }

    public List<T> getDescendantsData() {
        List<T> result = new ArrayList<>();
        for (Node<T> child : childrens) {
            result.add(child.getData());
            result.addAll(child.getDescendantsData());
        }
        return result;
    }

}
