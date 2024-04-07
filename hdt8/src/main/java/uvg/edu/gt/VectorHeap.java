package uvg.edu.gt;

import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    // El vector que contiene los elementos del heap
    protected Vector<E> data;

    public VectorHeap() {
        data = new Vector<>();
    }

    public VectorHeap(Vector<E> v) {
        int i;
        // Crea un nuevo vector con el mismo tamaño que v
        data = new Vector<>(v.size());
        // Agrega los elementos de v al heap
        for (i = 0; i < v.size(); i++) {
            add(v.get(i));
        }
    }

    // Método que devuelve el índice del padre de un nodo dado
    protected static int parent(int i) {
        return (i - 1) / 2;
    }

    // Método que devuelve el índice del hijo izquierdo de un nodo dado
    protected static int left(int i) {
        return 2 * i + 1;
    }

    // Método protegido que devuelve el índice del hijo derecho de un nodo dado
    protected static int right(int i) {
        return 2 * (i + 1);
    }

    // Método que ajusta el heap hacia arriba a partir de un nodo dado
    protected void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 && (value.compareTo(data.get(parent)) < 0)) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }


    // Método que agrega un elemento al heap y ajusta el heap hacia arriba si es necesario
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    // Método que ajusta el heap hacia abajo a partir de la raíz
    protected void pushDownRoot(int root) {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize) {
                if ((right(root) < heapSize) && ((data.get(childpos + 1)).compareTo(data.get(childpos)) < 0)) {
                    childpos++;
                }
                if ((data.get(childpos)).compareTo(value) < 0) {
                    data.set(root, data.get(childpos));
                    root = childpos;
                } else {
                    data.set(root, value);
                    return;
                }
            } else {
                data.set(root, value);
                return;
            }
        }
    }

    // Método que elimina y devuelve el elemento de mayor prioridad del heap
    public E remove() {
        E minVal = getFirst();
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);
        if (data.size() > 1) pushDownRoot(0);
        return minVal;
    }

    // Método que verifica si el heap está vacío
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // Método que devuelve el número de elementos en el heap
    @Override
    public int size() {
        return data.size();
    }

    // Método que elimina todos los elementos del heap
    @Override
    public void clear() {
        data.clear();
    }

    // Método que devuelve el elemento de mayor prioridad en el heap sin eliminarlo
    @Override
    public E getFirst() {
        return data.firstElement();
    }

    // Método que agrega un elemento al heap con la prioridad especificada
    @Override
    public void add(E value, double priority) {
        add(value);
    }
}