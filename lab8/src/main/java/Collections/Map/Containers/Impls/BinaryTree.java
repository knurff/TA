package Collections.Map.Containers.Impls;

import Collections.Tree.Tree;

import java.util.Objects;

public class BinaryTree<T extends Comparable<T>> implements Tree<T> {

    private static class Node<T> {
        T element;
        Node<T> left;
        Node<T> right;
        Node<T> parent;

        private Node(T element) {
            this.element = element;
        }

        public static <T> Node<T> valueOf(T element) {
            return new Node<>(element);
        }

        Node<T> getLeftMost() {
            Node<T> n = this;
            while (n.left != null) {
                n = n.left;
            }
            return n;
        }
        Node<T> getNext() {
            if (right != null) {
                return right.getLeftMost();
            } else {
                Node<T> n = this;
                while (n.parent != null && n == n.parent.right) {
                    n = n.parent;
                }
                return n.parent;
            }
        }
    }

    private Node<T> root;

    @Override
    public void add(T element) {
        Objects.requireNonNull(element);
        insertElement(element);
    }

    @Override
    public void remove(T element) {
        deleteElement(root, element);
    }

    @Override
    public T getFirst() {
        return root != null ? root.getLeftMost().element : null;
    }

    @Override
    public T getNext(T current) {
        if (root != null && root.getNext() != null)
            return root.getNext().element;
        else return null;
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
}
