package uvg.edu.gt;

public interface PriorityQueue<E extends Comparable<E>> {
    void add(E value);
    E remove();
    boolean isEmpty();
    int size();
    void clear();
    E getFirst();
    void add(E value, double priority);
}