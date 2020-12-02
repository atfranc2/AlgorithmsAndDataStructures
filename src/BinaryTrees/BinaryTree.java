package BinaryTrees;

import java.security.PrivilegedAction;
import java.sql.SQLOutput;

public class BinaryTree {
    private Node root;

    public BinaryTree(int value) {
        root = new Node(value);
    }

    public void insert(int value) {
        var current = root;
        Node previousNode;

        while (true) {
            previousNode = current;
            current = getChild(current, value);
            if (current == null) break;
        }

        var newNode = new Node(value);
        if (previousNode.value > value)
            previousNode.leftChild = newNode;
        else
            previousNode.rightChild = newNode;

    }

    private Node getChild(Node currentNode, int incomingValue) {
        return (currentNode.value > incomingValue) ? currentNode.leftChild : currentNode.rightChild;
    }



    private Node getRightTreeValues(Node node) {
        if (node == null)
            return null;
        getLeftTreeValues(node.leftChild);
        System.out.println(node.value);
        return getRightTreeValues(node.rightChild);
    }

    private Node getLeftTreeValues(Node node) {
        if (node == null)
            return null;
        getRightTreeValues(node.rightChild);
        System.out.println(node.value);
        return getLeftTreeValues(node.leftChild);
    }

    public void printTree() {
        System.out.println(root.value);
        getLeftTreeValues(root.leftChild);
        getRightTreeValues(root.rightChild);
    }

    private class Node {
        public int value;
        public Node leftChild;
        public Node rightChild;

        public Node(int value) {
            this.value = value;
        }
    }
}
