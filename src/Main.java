import BinaryTrees.BinaryTree;

public class Main {
    public static void main(String[] args) {
        var btree = new BinaryTree(10);
        btree.insert(5);
        btree.insert(15);
        btree.insert(6);
        btree.insert(1);
        btree.insert(8);
        btree.insert(12);
        btree.insert(18);
        btree.insert(17);
        btree.printTree();
    }
}
