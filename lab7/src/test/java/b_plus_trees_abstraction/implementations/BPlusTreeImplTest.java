package b_plus_trees_abstraction.implementations;

import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


class BPlusTreeImplTest {
    @Test
    @Order(1)
    void insertTimeComplexityTest() {
        BPlusTreeImpl<Integer, Integer> bTree = new BPlusTreeImpl<>();
        int limit = 10_000;
        Stopwatch stopwatchR = Stopwatch.createStarted();
        for (int i = 0; i < limit; i++) {
            int val = ThreadLocalRandom.current().nextInt();
            bTree.insert(val, val);
        }
        stopwatchR.stop();
        System.out.println("B tree insert random values: " + stopwatchR);
        bTree = new BPlusTreeImpl<>();
        Stopwatch stopwatchC = Stopwatch.createStarted();
        for (int i = 0; i < limit; i++) {
            bTree.insert(i, i);
        }
        stopwatchC.stop();
        System.out.println("B tree insert consecutive values: " + stopwatchC);
    }

    @Test
    @Order(2)
    void deleteTimeComplexityTest() {
        BPlusTreeImpl<Integer, Integer> bTree = new BPlusTreeImpl<>();
        List<Integer> tempList = new ArrayList<>();
        int limit = 10_000;
        for (int i = 0; i < limit; i++) {
            int val = ThreadLocalRandom.current().nextInt();
            tempList.add(val);
            bTree.insert(val, val);
        }
        Stopwatch stopwatchR = Stopwatch.createStarted();
        for (Integer i : tempList) {
            bTree.delete(i);
        }
        stopwatchR.stop();
        System.out.println("B tree delete random values: " + stopwatchR);
        bTree = new BPlusTreeImpl<>();
        tempList = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            tempList.add(i);
            bTree.insert(i, i);
        }
        Stopwatch stopwatchC = Stopwatch.createStarted();
        for (Integer i : tempList) {
            bTree.delete(i);
        }
        stopwatchC.stop();
        System.out.println("B tree delete consecutive values: " + stopwatchC);
    }

    @Test
    @Order(3)
    void containsTimeComplexityTest() {
        BPlusTreeImpl<Integer, Integer> bTree = new BPlusTreeImpl<>();
        List<Integer> tempList = new ArrayList<>();
        int limit = 10_000;
        for (int i = 0; i < limit; i++) {
            int val = ThreadLocalRandom.current().nextInt();
            tempList.add(val);
            bTree.insert(val, val);
        }
        Stopwatch stopwatchR = Stopwatch.createStarted();
        for (Integer i : tempList) {
            bTree.search(i);
        }
        stopwatchR.stop();
        System.out.println("B tree search random values: " + stopwatchR);
        bTree = new BPlusTreeImpl<>();
        tempList = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            tempList.add(i);
            bTree.insert(i, i);
        }
        Stopwatch stopwatchC = Stopwatch.createStarted();
        for (Integer i : tempList) {
            bTree.search(i);
        }
        stopwatchC.stop();
        System.out.println("B tree search consecutive values: " + stopwatchC);
    }

}