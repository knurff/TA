package BinarySearchTrees;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class RecursiveBinarySearchTree<T extends Comparable<T>> implements BinarySearchTree<T> {
    private static class Node<T> {
        T element;
        Node<T> left;
        Node<T> right;

        private Node(T element) {
            this.element = element;
        }

        public static <T> Node<T> valueOf(T element) {
            return new Node<>(element);
        }
    }

    private Node<T> root;

    @SafeVarargs
    public static <T extends Comparable<T>> RecursiveBinarySearchTree<T> of(T... elements) {
        RecursiveBinarySearchTree<T> bst = new RecursiveBinarySearchTree<>();
        Stream.of(elements)
                .forEach(bst::insert);
        return bst;
    }

    @Override
    public void insert(T element) {
        Objects.requireNonNull(element);
        insertElement(element);
    }

    @Override
    public void delete(T element) {
        deleteElement(root, element);
    }

    public Node<T> deleteElement(Node<T> root, T element) {
        if (root == null) return null;
        if (element.compareTo(root.element) < 0) {
            root.left = deleteElement(root.left, element);
        } else if (element.compareTo(root.element) > 0) {
            root.right = deleteElement(root.right, element);
        } else {
            if (root.left == null) {
                Node<T> node = root.right;
                if (this.root.equals(root)) this.root = node;
                return node;
            } else if (root.right == null) {
                Node<T> node = root.left;
                if (this.root.equals(root)) this.root = node;
                return node;
            }
            root.element = getMinValue(root.right);
            root.right = deleteElement(root.right, root.element);
        }
        return root;
    }

    private T getMinValue(Node<T> root) {
        T minimum = root.element;
        while (root.left != null) {
            minimum = root.left.element;
            root = root.left;
        }
        return minimum;
    }

    private void insertElement(T element) {
        if (root == null) {
            root = Node.valueOf(element);
        } else {
            insertIntoSubTree(root, element);
        }
    }

    private boolean insertIntoSubTree(Node<T> subTreeRoot, T element) {
        if (subTreeRoot.element.compareTo(element) > 0) {
            return insertIntoLeftSubtree(subTreeRoot, element);
        } else if (subTreeRoot.element.compareTo(element) < 0) {
            return insertIntoRightSubtree(subTreeRoot, element);
        } else {
            return false;
        }
    }

    private boolean insertIntoLeftSubtree(Node<T> node, T element) {
        if (node.left != null) {
            return insertIntoSubTree(node.left, element);
        } else {
            node.left = Node.valueOf(element);
            return true;
        }
    }

    private boolean insertIntoRightSubtree(Node<T> node, T element) {
        if (node.right != null) {
            return insertIntoSubTree(node.right, element);
        } else {
            node.right = Node.valueOf(element);
            return true;
        }
    }


    @Override
    public boolean contains(T element) {
        Objects.requireNonNull(element);
        return findChildNodeByElement(root, element) != null;
    }

    private Node<T> findChildNodeByElement(Node<T> node, T element) {
        if (node == null) {
            return null;
        } else if (node.element.compareTo(element) > 0) {
            return findChildNodeByElement(node.left, element);
        } else if (node.element.compareTo(element) < 0) {
            return findChildNodeByElement(node.right, element);
        } else {
            return node;
        }
    }

    @Override
    public int depth() {
        return root != null ? depth(root) - 1 : 0;
    }

    private int depth(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(depth(node.left), depth(node.right));
        }
    }

    @Override
    public void inOrderTraversal(Consumer<T> consumer) {
        inOrderTraversal(root, consumer);
    }

    private void inOrderTraversal(Node<T> node, Consumer<T> consumer) {
        if (node != null) {
            inOrderTraversal(node.left, consumer);
            consumer.accept(node.element);
            inOrderTraversal(node.right, consumer);
        }
    }
}
