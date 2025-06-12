package com.herrera;

import java.util.List;

import com.herrera.tree.Node;
import com.herrera.tree.samples.Tree;

public class App {
    public static void main(String[] args) throws Exception {

        Node<String> parents = new Tree("parent");
        Node<String> parent2 = new Tree("parent2");
        Node<String> child1 = new Tree("child1");

        parents.addChild(child1); // added child1 as child of parents
        parent2.addChild(parents); // added parents as child of parent2
        // parent2.getChildrenDatas();
        List<String> datas = parent2.getDescendantsData();
        for (String string : datas) {
            System.out.println(string);
        }
    }
}
