package com.company.Lists;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;

public class DoublyLinkedList<T> implements List<T> {

    static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> previous;

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
    public static <T> DoublyLinkedList<T> of(T... elements) {
        DoublyLinkedList<T> doublyLinkedList = new DoublyLinkedList<>();
        Stream.of(elements)
                .forEach(doublyLinkedList::add);
        return doublyLinkedList;
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

    private Node<T> findNodeByIndex(int index) {
        Objects.checkIndex(index, size);
        if (index == size - 1) {
            return last;
        } else {
            return nodeAt(index);
        }
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
        } else if (index == size - 1){
            deletedElement = last.value;
            removeTail();
        } else {
            Node<T> previousNode = findNodeByIndex(index - 1);
            deletedElement = previousNode.next.value;
            previousNode.next = previousNode.next.next;
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

    private void addAsTail(Node<T> newNode) {
        last.next = newNode;
        newNode.previous = last;
        last = newNode;
    }

    private void add(int index, Node<T> newNode) {
        Node<T> node = findNodeByIndex(index - 1);
        newNode.next = node.next;
        newNode.next.previous = newNode;
        node.next = newNode;
        newNode.previous = node;
    }

    private void addAsHead(Node<T> newNode) {
        newNode.next = first;
        newNode.previous = null;
        if (first != null) first.previous = newNode;
        first = newNode;
        if (first.next == null) last = first;
    }

    private void removeTail() {
        last = last.previous;
        if (last == null) first = null;
        else last.next = null;
    }

    private void removeHead() {
        first = first.next;
        if (first == null) last = null;
        else first.previous = null;
    }

    private void checkElementsExist() {
        if (first == null) {
            throw new NoSuchElementException();
        }
    }

    private Node<T> nodeAt(int index) {
        Node<T> currentNode = first;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
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
        return "Doubly linked list: " + result.substring(0, result.length() - 2);

    }
}
