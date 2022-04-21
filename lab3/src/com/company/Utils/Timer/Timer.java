package com.company.Utils.Timer;

import com.company.Lists.DoublyLinkedList;
import com.company.Lists.List;
import com.company.Lists.SinglyLinkedList;
import com.company.Utils.ElementsGenerator.ElementsGenerator;
import com.google.common.base.Stopwatch;

public class Timer {
    public static String getResult(int n){
        getStarted(n);
        return insertAndDeleteFront(n) +
                "\n" + insertAndDeleteEnd(n) +
                "\n" + insertAndDeleteAGN(n) +
                "\n" + indexing(n);
    }

    private static String insertAndDeleteFront(int n) {
        StringBuilder result = new StringBuilder("Insertion front: ");
        List<Integer> doublyLinkedList = new DoublyLinkedList<>();
        Stopwatch timerDoubly = Stopwatch.createStarted();
        ElementsGenerator.fillListFront(doublyLinkedList, n);
        timerDoubly.stop();
        result.append(" Doubly linked list: ").append(timerDoubly);
        List<Integer> singlyLinkedList = new SinglyLinkedList<>();
        Stopwatch timerSingly = Stopwatch.createStarted();
        ElementsGenerator.fillListFront(singlyLinkedList, n);
        timerSingly.stop();
        result.append(" Singly linked list: ").append(timerSingly);

        result.append("\n").append("Delete front: ");
        Stopwatch timerDoublyDel = Stopwatch.createStarted();
        ElementsGenerator.dellListFront(doublyLinkedList);
        timerDoublyDel.stop();
        result.append(" Doubly linked list: ").append(timerDoublyDel);


        Stopwatch timerSinglyDel = Stopwatch.createStarted();
        ElementsGenerator.dellListFront(singlyLinkedList);
        timerSinglyDel.stop();
        result.append(" Singly linked list: ").append(timerSinglyDel);

        return result.toString();
    }

    private static String insertAndDeleteEnd(int n) {
        StringBuilder result = new StringBuilder("Insertion end: ");
        List<Integer> doublyLinkedList = new DoublyLinkedList<>();
        Stopwatch timerDoubly = Stopwatch.createStarted();
        ElementsGenerator.fillListEnd(doublyLinkedList, n);
        timerDoubly.stop();
        result.append(" Doubly linked list: ").append(timerDoubly);
        List<Integer> singlyLinkedList = new SinglyLinkedList<>();
        Stopwatch timerSingly = Stopwatch.createStarted();
        ElementsGenerator.fillListEnd(singlyLinkedList, n);
        timerSingly.stop();
        result.append(" Singly linked list: ").append(timerSingly);

        result.append("\n").append("Delete end: ");
        Stopwatch timerDoublyDel = Stopwatch.createStarted();
        ElementsGenerator.dellListEnd(doublyLinkedList);
        timerDoublyDel.stop();
        result.append(" Doubly linked list: ").append(timerDoublyDel);


        Stopwatch timerSinglyDel = Stopwatch.createStarted();
        ElementsGenerator.dellListEnd(singlyLinkedList);
        timerSinglyDel.stop();
        result.append(" Singly linked list: ").append(timerSinglyDel);

        return result.toString();
    }

    private static String insertAndDeleteAGN(int n) {
        StringBuilder result = new StringBuilder("Insertion a.g.n.: ");
        List<Integer> doublyLinkedList = new DoublyLinkedList<>();
        Stopwatch timerDoubly = Stopwatch.createStarted();
        ElementsGenerator.fillListAGN(doublyLinkedList, n);
        timerDoubly.stop();
        result.append(" Doubly linked list: ").append(timerDoubly);
        List<Integer> singlyLinkedList = new SinglyLinkedList<>();
        Stopwatch timerSingly = Stopwatch.createStarted();
        ElementsGenerator.fillListAGN(singlyLinkedList, n);
        timerSingly.stop();
        result.append(" Singly linked list: ").append(timerSingly);

        result.append("\n").append("Delete a.g.n.: ");
        Stopwatch timerDoublyDel = Stopwatch.createStarted();
        ElementsGenerator.dellListAGN(doublyLinkedList);
        timerDoublyDel.stop();
        result.append(" Doubly linked list: ").append(timerDoublyDel);


        Stopwatch timerSinglyDel = Stopwatch.createStarted();
        ElementsGenerator.dellListAGN(singlyLinkedList);
        timerSinglyDel.stop();
        result.append(" Singly linked list: ").append(timerSinglyDel);

        return result.toString();
    }

    private static String indexing(int n) {
        StringBuilder result = new StringBuilder("Indexing: ");
        List<Integer> doublyLinkedList = new DoublyLinkedList<>();
        ElementsGenerator.fillListFront(doublyLinkedList, n);
        List<Integer> singlyLinkedList = new SinglyLinkedList<>();
        ElementsGenerator.fillListFront(singlyLinkedList, n);
        int searchValueSingly = ElementsGenerator.indexingPrepare(doublyLinkedList, singlyLinkedList);
        if (searchValueSingly != Integer.MIN_VALUE){
            Stopwatch timerDoubly = Stopwatch.createStarted();
            ElementsGenerator.indexing(doublyLinkedList, searchValueSingly, n);
            timerDoubly.stop();
            result.append(" Doubly linked list: ").append(timerDoubly);
            Stopwatch timerSingly = Stopwatch.createStarted();
            ElementsGenerator.indexing(singlyLinkedList, searchValueSingly, n);
            timerSingly.stop();
            result.append(" Doubly linked list: ").append(timerSingly);
        }
        return result.toString();
    }

    private static void getStarted(int n){
        insertAndDeleteFront(n);
        //insertAndDeleteEnd(n);
    }
}
