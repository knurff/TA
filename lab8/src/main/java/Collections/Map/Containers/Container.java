package Collections.Map.Containers;

import Collections.Collection;

public interface Container<T> extends Collection {
    void add(T element);

    boolean contains(T element);

    void remove(T element);

    T getFirst();

    T getNext(T current);
}
