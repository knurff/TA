import BinarySearchTrees.BinarySearchTree;
import BinarySearchTrees.RecursiveBinarySearchTree;
import BinarySearchTrees.SelfBalancingBinarySearchTrees.AVLBinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = RecursiveBinarySearchTree.of(5,4,3,2,1, 8, 9);
        binarySearchTree.delete(5);
        binarySearchTree.inOrderTraversal(System.out::println);
        System.out.println("Depth: " + binarySearchTree.depth());
        BinarySearchTree<Integer> binarySearchTreeAVL = AVLBinarySearchTree.of(5,4,3,2,1, 8, 9);
        binarySearchTreeAVL.delete(5);
        binarySearchTreeAVL.inOrderTraversal(System.out::println);
        System.out.println("Depth(self balanced): " + binarySearchTreeAVL.depth());
    }
}
