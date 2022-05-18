package Map;

public interface Map<K, V> {
    void put(K key, V value);

    boolean contains(K key);

    void remove(K key);
}
