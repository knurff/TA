package BinarySearchTrees;

import java.util.function.Consumer;

public interface BinarySearchTree<T extends Comparable<T>> {
    void insert(T element);

    void delete(T element);

    boolean contains(T element);

    int depth();

    void inOrderTraversal(Consumer<T> consumer);
}
