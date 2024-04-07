package uvg.edu.gt;

import static org.junit.Assert.*;
import org.junit.Test;

public class AppTest {
    
    @Test
    public void testAdd() {
        VectorHeap<Integer> heap = new VectorHeap<>();
        heap.add(5);
        heap.add(3);
        heap.add(8);
        assertEquals(3, heap.getFirst().intValue());
    }
    
    @Test
    public void testRemove() {
        VectorHeap<Integer> heap = new VectorHeap<>();
        heap.add(5);
        heap.add(3);
        heap.add(8);
        assertEquals(3, heap.remove().intValue());
        assertEquals(5, heap.getFirst().intValue());
    }
}
