package Map.Impls;

import Map.Containers.Impls.BinaryTree;
import Map.Containers.Impls.LinkedList;
import Map.Map;
import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;


class MapImplTest {

    @Test
    @Order(1)
    void timeComplexityTest() {
        putAndSearch(new MapImpl<>(new LinkedList<>()), 1000, "linked list");
        putAndSearch(new MapImpl<>(new LinkedList<>()), 10000, "linked list");
        putAndSearch(new MapImpl<>(new LinkedList<>()), 100000, "linked list");
        putAndSearch(new MapImpl<>(new LinkedList<>()), 200000, "linked list");
        putAndSearch(new MapImpl<>(new BinaryTree<>()), 1000, "binary tree");
        putAndSearch(new MapImpl<>(new BinaryTree<>()), 10000, "binary tree");
        putAndSearch(new MapImpl<>(new BinaryTree<>()), 100000, "binary tree");
        putAndSearch(new MapImpl<>(new BinaryTree<>()), 200000, "binary tree");
        putAndSearch(new MapImpl<>(new LinkedList<>()), 1000, "linked list");
        putAndSearch(new MapImpl<>(new LinkedList<>()), 10000, "linked list");
        putAndSearch(new MapImpl<>(new LinkedList<>()), 100000, "linked list");
        putAndSearch(new MapImpl<>(new LinkedList<>()), 200000, "linked list");
        putAndSearch(new MapImpl<>(new BinaryTree<>()), 1000, "binary tree");
        putAndSearch(new MapImpl<>(new BinaryTree<>()), 10000, "binary tree");
        putAndSearch(new MapImpl<>(new BinaryTree<>()), 100000, "binary tree");
        putAndSearch(new MapImpl<>(new BinaryTree<>()), 200000, "binary tree");
    }

    private void putAndSearch(Map<Integer, Integer> mapLinkedList, int limit, String container) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < limit; i++) {
            int val = ThreadLocalRandom.current().nextInt();
            mapLinkedList.put(val, val);
        }
        stopwatch.stop();
        System.out.println("Insert " + limit + " elements in map with " + container + " container: " + stopwatch
        + " and 500 elements search time: " + contains500Elements(mapLinkedList));
    }

    private Stopwatch contains500Elements(Map<Integer, Integer> map) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < 500; i++) {
            int val = ThreadLocalRandom.current().nextInt();
            map.contains(val);
        }
        return stopwatch;
    }
}