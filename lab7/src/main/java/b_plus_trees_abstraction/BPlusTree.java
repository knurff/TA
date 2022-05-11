package b_plus_trees_abstraction;

public interface BPlusTree<K extends Comparable<? super K>, V> {
    V search(K key);

    void insert(K key, V value);

    void delete(K key);
}
