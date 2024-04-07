package uvg.edu.gt;

// Interfaz que define los métodos que debe implementar una cola con prioridad.
public interface PriorityQueue<E extends Comparable<E>> {
    void add(E value);
    E remove();
    boolean isEmpty();
    int size();
    void clear();
    E getFirst();
    void add(E value, double priority);
}