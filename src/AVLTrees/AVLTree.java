package AVLTrees;

// An AVL binary search tree is a self balancing tree that rebalances itself when one side becomes more than on node longer than the other side.
// Rebalancing is done using rotations after each node addition (left, right, left-right, and right-left)
    // When heavy on the right side, perform a left rotation (counterclockwise) and vice-versa
    //



public class AVLTree {
    private AVLNode root;

    public void insert(int value) {
        root = insert(value, root);
    }

    private AVLNode insert(int value, AVLNode node) {
        if (node == null)
            return new AVLNode(value);

        if(value < node.value)
            node.leftChild = insert(value, node.leftChild);
        else
            node.rightChild = insert(value, node.rightChild);

        node.height = Math.max(
                height(node.leftChild),
                height(node.rightChild)) + 1;

        if(isRightHeavy(node))
            System.out.println(node.value);
            if(balanceFactor(node.rightChild) > 0)
                performRightLeftRotation(node);
            else
                performLeftRotation(node);

        return node;
    }

    private void performRightLeftRotation(AVLNode node){
        var temp = node.rightChild;
        node.rightChild = temp.leftChild;
        temp.leftChild = null;
        node.rightChild.rightChild = temp;

        performLeftRotation(node);
    }

    private void performRightRotation(AVLNode node) {
        int nodeValue = node.value;
        var newNode = new AVLNode(nodeValue);
        node.value =
    }

    private void performLeftRotation(AVLNode node) {
        int nodeValue = node.value;
        node.value = node.rightChild.value;
        node.leftChild = new AVLNode(nodeValue);
        node.rightChild.value = node.rightChild.rightChild.value;
        node.rightChild.rightChild = null;
    }

    private int balanceFactor(AVLNode node){
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node){
        return balanceFactor(node) < -1;
    }

    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }

    private boolean isLeaf(AVLNode node) {
        return (node.leftChild == null) && (node.rightChild == null);
    }

    private AVLNode getChild(AVLNode node, int value) {
        return (value < node.value) ? node.leftChild : node.rightChild;
    }

    private class AVLNode {
        public int value;
        public int height;
        public AVLNode leftChild;
        public AVLNode rightChild;

        public AVLNode(int value) {
            this.value = value;
            height = 0;
        }

        @Override
        public String toString() {
            return "Node = " + value;
        }
    }
}
