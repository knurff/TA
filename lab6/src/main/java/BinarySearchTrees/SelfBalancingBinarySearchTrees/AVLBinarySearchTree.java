package BinarySearchTrees.SelfBalancingBinarySearchTrees;

import BinarySearchTrees.BinarySearchTree;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class AVLBinarySearchTree<T extends Comparable<T>> implements BinarySearchTree<T> {
    private static class Node<T> {
        T element;
        Node<T> left;
        Node<T> right;
        int height;

        private Node(T element) {
            this.element = element;
        }

        public static <T> Node<T> valueOf(T element) {
            return new Node<>(element);
        }
    }

    private Node<T> root;

    @SafeVarargs
    public static <T extends Comparable<T>> AVLBinarySearchTree<T> of(T... elements) {
        AVLBinarySearchTree<T> bst = new AVLBinarySearchTree<>();
        Stream.of(elements)
                .forEach(bst::insert);
        return bst;
    }

    @Override
    public void insert(T element) {
        Objects.requireNonNull(element);
        root = insert(root, element);
    }

   private Node<T> insert(Node<T> node, T element) {
        if (node == null) {
            return Node.valueOf(element);
        }
        if (element.compareTo(node.element) < 0)
            node.left = insert(node.left, element);
        else if (element.compareTo(node.element) > 0)
            node.right = insert(node.right, element);
        else
            return node;
        node.height = 1 + Math.max(height(node.left),
                height(node.right));
        int balance = getBalance(node);
        if (balance > 1 && element.compareTo(node.left.element) < 0)
            return rightRotate(node);
        if (balance < -1 && element.compareTo(node.right.element) > 0)
            return leftRotate(node);
        if (balance > 1 && element.compareTo(node.left.element) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && element.compareTo(node.right.element) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    @Override
    public void delete(T element) {
        Objects.requireNonNull(element);
        root = deleteNode(root, element);
    }

    private Node<T> deleteNode(Node<T> root, T element) {
        if (root == null) return root;
        if (element.compareTo(root.element) < 0)
            root.left = deleteNode(root.left, element);
        else if (element.compareTo(root.element) > 0)
            root.right = deleteNode(root.right, element);
        else {
            if ((root.left == null) || (root.right == null)) {
                Node<T> temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;
                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {
                Node<T> temp = minValueNode(root.right);
                root.element = temp.element;

                root.right = deleteNode(root.right, temp.element);
            }
        }
        if (root == null) return root;
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        int balance = getBalance(root);
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    private Node<T> minValueNode(Node<T> node) {
        Node<T> current = node;
        while (current.left != null)
            current = current.left;
        return current;
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

    private int height(Node<T> N) {
        if (N == null)
            return 0;
        return N.height;
    }

    private Node<T> rightRotate(Node<T> y) {
        Node<T> x = y.left;
        Node<T> T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    private Node<T> leftRotate(Node<T> x) {
        Node<T> y = x.right;
        Node<T> T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    private int getBalance(Node<T> N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }
}
