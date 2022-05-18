package Collections.Map.Impls;

import Collections.Map.Containers.Impls.BinaryTree;
import Collections.Map.Containers.Container;
import Collections.Map.Containers.Impls.LinkedList;
import Collections.Map.Map;

import java.util.Arrays;
import java.util.Objects;

public class MapImpl<K extends Comparable<K>, V> implements Map<K, V> {

    static class Entry<K extends Comparable<K>, V> implements Comparable<Entry<K, V>> {
        private final K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public V getValue() {
            return this.value;
        }

        public boolean hasSameKey(K key) {
            return Objects.equals(this.key, key);
        }

        @Override
        public int compareTo(Entry<K, V> o) {
            return this.getKey().compareTo(o.getKey());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return Objects.equals(key, entry.key);
        }
    }

    private final static int DEFAULT_CAPACITY = 16;
    private final static double DEFAULT_LOAD_FACTOR = 0.75;
    private int capacity;
    private final double loadFactor;
    private int size;
    private Container<Entry<K, V>>[] elements;
    private final Object containerType;

    public MapImpl(Object o) {
        this(o, DEFAULT_LOAD_FACTOR, DEFAULT_CAPACITY);
    }

    public MapImpl(Object o, int loadFactor) {
        this(o, DEFAULT_CAPACITY, loadFactor);
    }

    public MapImpl(Object o, double loadFactor, int capacity) {
        this.containerType = o;
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        if (containerType instanceof Container) {
            if (containerType instanceof BinaryTree)
                this.elements = (BinaryTree<Entry<K, V>>[]) new BinaryTree[capacity];
            else this.elements = (LinkedList<Entry<K, V>>[]) new LinkedList[capacity];
        } else throw new IllegalArgumentException("Invalid container class type!");
    }

    @Override
    public void put(K key, V value) {
        extension();
        int index = getBucketByHash(key);
        if (elements[index] == null) {
            if (containerType instanceof BinaryTree) elements[index] = new BinaryTree<>();
            else elements[index] = new LinkedList<>();
        }

        if (this.contains(key)) {
            Entry<K, V> current = elements[index].getFirst();
            while (current != null) {
                if (current.hasSameKey(key)) {
                    current.setValue(value);
                    break;
                }
                current = elements[index].getNext(current);
            }
        } else elements[index].add(new Entry<>(key, value));
        size++;
    }

    @Override
    public boolean contains(K key) {
        int index = getBucketByHash(key);
        if (elements[index] == null) {
            return false;
        }
        return elements[index].contains(new Entry<>(key, null));
    }

    @Override
    public void remove(K key) {
        int index = getBucketByHash(key);
        removeByKey(key, elements[index]);
        size--;
    }

    private void removeByKey(K key, Container<Entry<K, V>> element1) {
        Entry<K, V> current = element1.getFirst();
        while (current != null) {
            if (current.hasSameKey(key)) {
                element1.remove(current);
                break;
            }
            current = element1.getNext(current);
        }
    }

    private int getBucketByHash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode()) % capacity;
    }

    private void extension() {
        if (Double.compare(size / loadFactor, capacity) >= 0)
            elements = Arrays.copyOf(elements, capacity <<= 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < capacity; k++) {
            if (elements[k] != null) {
                sb.append("[").append(k).append("] -> {");
                Entry<K, V> current = elements[k].getFirst();
                while (current != null) {
                    sb.append(current.getKey()).append(" = ").append(current.getValue());
                    current = elements[k].getNext(current);
                }
                sb.append("}\n");
            }
        }
        return sb.toString();
    }
}
