package com.company.Queues;

import com.company.Lists.SinglyLinkedList;

public class LinkedQueue<T> implements Queue<T> {
    private final SinglyLinkedList<T> singlyLinkedList = new SinglyLinkedList<>();

    @Override
    public void add(T element) {
        singlyLinkedList.add(element);
    }

    @Override
    public T poll() {
        return singlyLinkedList.remove(0);
    }

    @Override
    public T peek() {
        return singlyLinkedList.getFirst();
    }

    @Override
    public int size() {
        return singlyLinkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return singlyLinkedList.isEmpty();
    }

    @Override
    public String toString() {
        return singlyLinkedList.toString().replaceFirst("Singly linked list: ", "Queue: ");
    }
}
