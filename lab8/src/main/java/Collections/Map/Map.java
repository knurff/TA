package Collections.Map;

import Collections.Collection;

public interface Map<K, V> extends Collection {
    void put(K key, V value);

    boolean contains(K key);

    void remove(K key);
}
