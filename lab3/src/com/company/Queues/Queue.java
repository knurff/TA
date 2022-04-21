package com.company.Queues;

public interface Queue<T> {
    void add(T element);
    T poll();
    T peek();
    int size();
    boolean isEmpty();
}