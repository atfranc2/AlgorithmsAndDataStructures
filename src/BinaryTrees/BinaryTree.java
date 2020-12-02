package BinaryTrees;

public class BinaryTree {
    private Node root;

    public BinaryTree(int value) {
        root = new Node(value);
    }

    public void insert(int value) {
        var current = root;

        while (true) {
            var child = getChild(current, value);
            if (child == null) break;
            current = child;
        }

        var newNode = new Node(value);
        if (current.value > value) current.leftChild = newNode;
        else current.rightChild = newNode;

    }

    public boolean find(int value){
        var current = root;
        while(true) {
            if (current.value == value) return true;
            var child = getChild(current, value);
            if (child == null) return false;
            current = child;
        }
    }

    public boolean equals(BinaryTree tree) {
        var treeNode = tree.root;
        return equals(root, treeNode);
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public void nodesAtDistanceK(int k) {
        nodesAtDistanceK(root, k);
    }

    public void printTree() {
        getTreeValues(root);
    }

    private Node getChild(Node currentNode, int incomingValue) {
        return (currentNode.value > incomingValue) ? currentNode.leftChild : currentNode.rightChild;
    }

    private void getTreeValues(Node node) {
        if (node == null)
            return;
        getTreeValues(node.rightChild);
        getTreeValues(node.leftChild);
        System.out.println(node.value);
    }

    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }

    private boolean equals(Node node1, Node node2) {
        if(node1 == null && node2 == null)
            return true;

        else if(node1 != null && node2 != null)
            return node1.value == node2.value && equals(node1.leftChild, node2.leftChild) && equals(node1.rightChild, node2.rightChild);

        return false;
    }

    private boolean isBinarySearchTree(Node node, int min, int max) {
        if (node == null)
            return true;

        if (node.value < min || node.value > max)
            return false;

        return isBinarySearchTree(node.leftChild, min, node.value) && isBinarySearchTree(node.rightChild, node.value, max);
    }

    private void nodesAtDistanceK(Node node, int k) {
        if (node == null)
            return;

        if (k == 0) {
            System.out.println(node.value);
            return;
        }

        nodesAtDistanceK(node.leftChild, k - 1);
        nodesAtDistanceK(node.rightChild, k - 1);
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
