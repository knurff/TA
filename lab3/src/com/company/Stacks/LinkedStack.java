package com.company.Stacks;

import com.company.Lists.DoublyLinkedList;

public class LinkedStack<T> implements Stack<T> {
    private final DoublyLinkedList<T> doublyLinkedList = new DoublyLinkedList<>();

    @Override
    public void push(T element) {
        doublyLinkedList.add(element);
    }

    @Override
    public T pop() {
        return doublyLinkedList.remove(doublyLinkedList.size() - 1);
    }

    @Override
    public T pick() {
       return doublyLinkedList.getLast();
    }

    @Override
    public int size() {
        return doublyLinkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return doublyLinkedList.isEmpty();
    }

    @Override
    public String toString() {
        return doublyLinkedList.toString().replaceFirst("Doubly linked list: ", "Stack: ");
    }
}
