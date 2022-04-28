package BinarySearchTrees.SelfBalancingBinarySearchTrees;

import BinarySearchTrees.BinarySearchTree;
import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class AVLBinarySearchTreeTest {

    @Test
    @Order(1)
    void insertTimeComplexityTest() {
        BinarySearchTree<Integer> binarySearchTree = new AVLBinarySearchTree<>();
        int limit = 10_000;
        Stopwatch stopwatchR = Stopwatch.createStarted();
        for (int i = 0; i < limit; i++) {
            int val = ThreadLocalRandom.current().nextInt();
            binarySearchTree.insert(val);
        }
        stopwatchR.stop();
        System.out.println("AVL binary search tree insert random values: " + stopwatchR);
        binarySearchTree = new AVLBinarySearchTree<>();
        Stopwatch stopwatchC = Stopwatch.createStarted();
        for (int i = 0; i < limit; i++) {
            binarySearchTree.insert(i);
        }
        stopwatchC.stop();
        System.out.println("AVL binary search tree insert consecutive values: " + stopwatchC);
    }

    @Test
    @Order(3)
    void deleteTimeComplexityTest() {
        BinarySearchTree<Integer> binarySearchTree = new AVLBinarySearchTree<>();
        List<Integer> tempList = new ArrayList<>();
        int limit = 10_000;
        for (int i = 0; i < limit; i++) {
            int val = ThreadLocalRandom.current().nextInt();
            tempList.add(val);
            binarySearchTree.insert(val);
        }
        Stopwatch stopwatchR = Stopwatch.createStarted();
        for (Integer i : tempList) {
            binarySearchTree.delete(i);
        }
        stopwatchR.stop();
        System.out.println("AVL binary search tree delete random values: " + stopwatchR);
        binarySearchTree = new AVLBinarySearchTree<>();
        tempList = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            tempList.add(i);
            binarySearchTree.insert(i);
        }
        Stopwatch stopwatchC = Stopwatch.createStarted();
        for (Integer i : tempList) {
            binarySearchTree.delete(i);
        }
        stopwatchC.stop();
        System.out.println("AVL binary search tree delete consecutive values: " + stopwatchC);
    }

    @Test
    @Order(2)
    void containsTimeComplexityTest() {
        BinarySearchTree<Integer> binarySearchTree = new AVLBinarySearchTree<>();
        List<Integer> tempList = new ArrayList<>();
        int limit = 10_000;
        for (int i = 0; i < limit; i++) {
            int val = ThreadLocalRandom.current().nextInt();
            tempList.add(val);
            binarySearchTree.insert(val);
        }
        Stopwatch stopwatchR = Stopwatch.createStarted();
        for (Integer i : tempList) {
            binarySearchTree.contains(i);
        }
        stopwatchR.stop();
        System.out.println("AVL binary search tree search random values: " + stopwatchR);
        binarySearchTree = new AVLBinarySearchTree<>();
        tempList = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            tempList.add(i);
            binarySearchTree.insert(i);
        }
        Stopwatch stopwatchC = Stopwatch.createStarted();
        for (Integer i : tempList) {
            binarySearchTree.contains(i);
        }
        stopwatchC.stop();
        System.out.println("AVL binary search tree search consecutive values: " + stopwatchC);
    }
}