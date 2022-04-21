package com.company;

import com.company.Queues.LinkedQueue;
import com.company.Queues.Queue;
import com.company.Stacks.LinkedStack;
import com.company.Stacks.Stack;
import com.company.Utils.Timer.Timer;

public class Main {

    public static void main(String[] args) {
        System.out.println(Timer.getResult(10000));
        Stack<Integer> stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        System.out.println(stack);
        Queue<Integer> queue = new LinkedQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.poll();
        System.out.println(queue);
    }
}
