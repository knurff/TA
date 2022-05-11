import b_plus_trees_abstraction.BPlusTree;
import b_plus_trees_abstraction.implementations.BPlusTreeImpl;

public class Main {
    public static void main(String[] args) {
        BPlusTree<Integer, Integer> bPlusTree = new BPlusTreeImpl<>(3);
        bPlusTree.insert(1, 1);
        bPlusTree.insert(2, 2);
        bPlusTree.insert(3, 3);
        bPlusTree.insert(4, 4);
        bPlusTree.delete(2);
        System.out.println(bPlusTree.search(1));
        System.out.println(bPlusTree);
    }
}
