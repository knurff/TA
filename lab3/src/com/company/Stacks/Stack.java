package com.company.Stacks;

public interface Stack<T> {
    void push(T element);
    T pop();
    T pick();
    int size();
    boolean isEmpty();
}
