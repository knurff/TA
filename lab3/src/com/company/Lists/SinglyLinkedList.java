package com.company.Lists;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;

public class SinglyLinkedList<T> implements List<T> {

    static class Node<T> {
        private T value;
        private Node<T> next;

        private Node(T value) {
            this.value = value;
        }

        public static <T> Node<T> valueOf(T value) {
            return new Node<>(value);
        }
    }

    private Node<T> first;
    private Node<T> last;
    private int size;

    @SafeVarargs
    public static <T> SinglyLinkedList<T> of(T... elements) {
        SinglyLinkedList<T> singlyLinkedList = new SinglyLinkedList<>();
        Stream.of(elements)
                .forEach(singlyLinkedList::add);
        return singlyLinkedList;
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (size == 0) first = last = newNode;
        else addAsTail(newNode);
        size++;
    }

    @Override
    public void add(int index, T element) {
        Node<T> newNode = Node.valueOf(element);
        if (index == 0) {
            addAsHead(newNode);
        } else if (index == size) {
            addAsTail(newNode);
        } else {
            add(index, newNode);
        }
        size++;
    }

    @Override
    public void set(int index, T element) {
        Node<T> node = findNodeByIndex(index);
        node.value = element;
    }

    @Override
    public T get(int index) {
        Node<T> node = findNodeByIndex(index);
        return node.value;
    }

    @Override
    public T getFirst() {
        checkElementsExist();
        return first.value;
    }

    @Override
    public T getLast() {
        checkElementsExist();
        return last.value;
    }

    @Override
    public T remove(int index) {
        T deletedElement;
        if (index == 0) {
            deletedElement = first.value;
            removeHead();
        } else {
            Node<T> previousNode = findNodeByIndex(index - 1);
            deletedElement = previousNode.next.value;
            previousNode.next = previousNode.next.next;
            if (index == size - 1) {
                last = previousNode;
            }
        }
        size--;
        return deletedElement;
    }

    @Override
    public boolean contains(T element) {
        Node<T> currentNode = first;
        while (currentNode != null) {
            if (currentNode.value.equals(element)) return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public int getByValue(T element) {
        Node<T> currentNode = first;
        int index = 0;
        while (currentNode != null) {
            if (currentNode.value.equals(element)) return index;
            currentNode = currentNode.next;
            index++;
        }
        throw new NoSuchElementException();
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = last = null;
        size = 0;
    }

    private void addAsHead(Node<T> newNode) {
        newNode.next = first;
        first = newNode;
        if (first.next == null) last = first;
    }

    private void addAsTail(Node<T> newNode) {
        last.next = newNode;
        last = newNode;
    }

    private void add(int index, Node<T> newNode) {
        Node<T> node = findNodeByIndex(index - 1);
        newNode.next = node.next;
        node.next = newNode;
    }

    private Node<T> findNodeByIndex(int index) {
        Objects.checkIndex(index, size);
        if (index == size - 1) {
            return last;
        } else {
            return nodeAt(index);
        }
    }

    private Node<T> nodeAt(int index) {
        Node<T> currentNode = first;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    private void removeHead() {
        first = first.next;
        if (first == null) last = null;
    }

    private void checkElementsExist() {
        if (first == null) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<T> current = first;
        while(current != null){
            result.append(current.value);
            result.append(", ");
            current = current.next;
        }
        return "Singly linked list: " + result.substring(0, result.length() - 2);

    }
}
