package Collections.Tree;

import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

class AVLTreeTest {

    @Test
    @Order(1)
    void add() {
        addAndSearch(new AVLTree<>(), 1000);
        addAndSearch(new AVLTree<>(), 10000);
        addAndSearch(new AVLTree<>(), 100000);
        addAndSearch(new AVLTree<>(), 200000);
    }

    private void addAndSearch(Tree<Integer> mapLinkedList, int limit) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < limit; i++) {
            int val = ThreadLocalRandom.current().nextInt();
            mapLinkedList.add(val);
        }
        stopwatch.stop();
        System.out.println("Insert " + limit + " elements in tree time: " + stopwatch
                + " and 500 elements search time: " + contains500Elements(mapLinkedList));
    }

    private Stopwatch contains500Elements(Tree<Integer> tree) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < 500; i++) {
            int val = ThreadLocalRandom.current().nextInt();
            tree.contains(val);
        }
        return stopwatch;
    }
}