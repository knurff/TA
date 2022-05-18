package Map.Containers;

public interface Container<T> {
    void add(T element);

    boolean contains(T element);

    void remove(T element);

    T getFirst();

    T getNext(T current);
}
