package com.company.Utils.Timer;

import com.company.Lists.DoublyLinkedList;
import com.company.Lists.List;
import com.company.Lists.SinglyLinkedList;
import com.company.Utils.TimerHelper.TimerHelper;
import com.google.common.base.Stopwatch;

public class Timer {
    public static String getResult(int n){
        insertAndDeleteFront(n);
        insertAndDeleteEnd(n);
        insertAndDeleteAGN(n);
        indexing(n);
        return insertAndDeleteFront(n) +
                "\n" + insertAndDeleteEnd(n) +
                "\n" + insertAndDeleteAGN(n) +
                "\n" + indexing(n);
    }

    private static String insertAndDeleteFront(int n) {
        StringBuilder result = new StringBuilder("Insertion front: ");
        List<Integer> doublyLinkedList = new DoublyLinkedList<>();
        Stopwatch timerDoubly = Stopwatch.createStarted();
        TimerHelper.fillListFront(doublyLinkedList, n);
        timerDoubly.stop();
        result.append(" Doubly linked list: ").append(timerDoubly);
        List<Integer> singlyLinkedList = new SinglyLinkedList<>();
        Stopwatch timerSingly = Stopwatch.createStarted();
        TimerHelper.fillListFront(singlyLinkedList, n);
        timerSingly.stop();
        result.append(" Singly linked list: ").append(timerSingly);

        result.append("\n").append("Delete front: ");
        Stopwatch timerDoublyDel = Stopwatch.createStarted();
        TimerHelper.dellListFront(doublyLinkedList);
        timerDoublyDel.stop();
        result.append(" Doubly linked list: ").append(timerDoublyDel);


        Stopwatch timerSinglyDel = Stopwatch.createStarted();
        TimerHelper.dellListFront(singlyLinkedList);
        timerSinglyDel.stop();
        result.append(" Singly linked list: ").append(timerSinglyDel);

        return result.toString();
    }

    private static String insertAndDeleteEnd(int n) {
        StringBuilder result = new StringBuilder("Insertion end: ");
        List<Integer> doublyLinkedList = new DoublyLinkedList<>();
        Stopwatch timerDoubly = Stopwatch.createStarted();
        TimerHelper.fillListEnd(doublyLinkedList, n);
        timerDoubly.stop();
        result.append(" Doubly linked list: ").append(timerDoubly);
        List<Integer> singlyLinkedList = new SinglyLinkedList<>();
        Stopwatch timerSingly = Stopwatch.createStarted();
        TimerHelper.fillListEnd(singlyLinkedList, n);
        timerSingly.stop();
        result.append(" Singly linked list: ").append(timerSingly);

        result.append("\n").append("Delete end: ");
        Stopwatch timerDoublyDel = Stopwatch.createStarted();
        TimerHelper.dellListEnd(doublyLinkedList);
        timerDoublyDel.stop();
        result.append(" Doubly linked list: ").append(timerDoublyDel);


        Stopwatch timerSinglyDel = Stopwatch.createStarted();
        TimerHelper.dellListEnd(singlyLinkedList);
        timerSinglyDel.stop();
        result.append(" Singly linked list: ").append(timerSinglyDel);

        return result.toString();
    }

    private static String insertAndDeleteAGN(int n) {
        StringBuilder result = new StringBuilder("Insertion a.g.n.: ");
        List<Integer> doublyLinkedList = new DoublyLinkedList<>();
        Stopwatch timerDoubly = Stopwatch.createStarted();
        TimerHelper.fillListAGN(doublyLinkedList, n);
        timerDoubly.stop();
        result.append(" Doubly linked list: ").append(timerDoubly);
        List<Integer> singlyLinkedList = new SinglyLinkedList<>();
        Stopwatch timerSingly = Stopwatch.createStarted();
        TimerHelper.fillListAGN(singlyLinkedList, n);
        timerSingly.stop();
        result.append(" Singly linked list: ").append(timerSingly);

        result.append("\n").append("Delete a.g.n.: ");
        Stopwatch timerDoublyDel = Stopwatch.createStarted();
        TimerHelper.dellListAGN(doublyLinkedList);
        timerDoublyDel.stop();
        result.append(" Doubly linked list: ").append(timerDoublyDel);


        Stopwatch timerSinglyDel = Stopwatch.createStarted();
        TimerHelper.dellListAGN(singlyLinkedList);
        timerSinglyDel.stop();
        result.append(" Singly linked list: ").append(timerSinglyDel);

        return result.toString();
    }

    private static String indexing(int n) {
        StringBuilder result = new StringBuilder("Indexing: ");
        List<Integer> doublyLinkedList = new DoublyLinkedList<>();
        TimerHelper.fillListFront(doublyLinkedList, n);
        List<Integer> singlyLinkedList = new SinglyLinkedList<>();
        TimerHelper.fillListFront(singlyLinkedList, n);
        int searchValueSingly = TimerHelper.indexingPrepare(doublyLinkedList, singlyLinkedList);
        if (searchValueSingly != Integer.MIN_VALUE){
            Stopwatch timerDoubly = Stopwatch.createStarted();
            TimerHelper.indexing(doublyLinkedList, searchValueSingly, n);
            timerDoubly.stop();
            result.append(" Doubly linked list: ").append(timerDoubly);
            Stopwatch timerSingly = Stopwatch.createStarted();
            TimerHelper.indexing(singlyLinkedList, searchValueSingly, n);
            timerSingly.stop();
            result.append(" Singly linked list: ").append(timerSingly);
        }
        return result.toString();
    }
}
