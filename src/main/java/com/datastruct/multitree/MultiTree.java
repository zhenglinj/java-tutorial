package com.datastruct.multitree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MultiTree<T> {
    private Node<T> root;

    public MultiTree(T rootData) {
        root = new Node<T>(rootData);
        root.children = new ArrayList<Node<T>>();
    }

    public MultiTree(Node<T> rootNode) {
        root = rootNode;
        root.children = new ArrayList<Node<T>>();
    }

    public Node<T> findTreeNode(Comparable<T> cmp) {
        return null;
    }

    public static class Node<T> implements Visiable {
        private T data;
        private Node<T> parent;
        private List<Node<T>> children;

        public Node() {
        }

        public Node(T data) {
            this.data = data;
            this.children = new ArrayList<Node<T>>();
        }

        public boolean isRoot() {
            return parent == null;
        }

        public boolean isLeaf() {
            return children == null || children.size() == 0;
        }

        public Node<T> addNewChild(T child) {
            Node<T> childNode = new Node<T>(child);
            return addChild(childNode);
        }

        public Node<T> addChild(Node<T> childNode) {
            childNode.parent = this;
            this.children.add(childNode);
            return childNode;
        }

        public int getLevel() {
            if (this.isRoot()) {
                return 0;
            } else {
                return parent.getLevel() + 1;
            }
        }

        @Override
        public void accept(Visitor v) {

        }

        @Override
        public String toString() {
            return data != null ? data.toString() : "[null]";
        }
    }
}
