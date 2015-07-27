package Week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Heap<T> {

    public static final int ROOT_BOUND = -1;
    
    private List<T> heap;
    private int size;
    private Comparator<T> comp;
    
    public Heap(Comparator<T> comp) {
        this.heap = new ArrayList<T>(1);
        this.size = 0;
        this.comp = comp;
    }
    
    private int parent(int i) {
        return i == 0 ? ROOT_BOUND : i / 2;
    }
    
    private int left(int i) {
        return 2 * i + 1;
    }
        
    public int size() {
        return size;
    }
    
    private void siftUp(int i) {
        if (parent(i) == ROOT_BOUND) {
            return;
        }
        
        if (comp.compare(heap.get(i), heap.get(parent(i))) < 0) {
            Collections.swap(heap, i, parent(i));
            siftUp(parent(i));
        }
    }
    
    public void insert(T elem) {
        if (size == heap.size()) {
            heap.add(elem);
        }
        heap.set(size, elem);
        siftUp(size);
        ++size;
    }
    
    private void heapify(List<T> elements, int size) {
        this.heap = new ArrayList<T>();
        this.size = size;
        
        for (int i = 0; i < size; ++i) {
            this.heap.add(elements.get(i));
        }
        
        for (int i = size - 1; i >= 0; --i) {
            siftDown(i);
        }
    }
    
    private void siftDown(int p) {
        int childIndex = left(p);
        int minIndex = p;
        
        for (int i = 0; i < 2; ++i) {
            if (childIndex + i < size) {
                if (comp.compare(heap.get(childIndex + i), heap.get(minIndex)) < 0) { // heap.get(childIndex + i).compareTo(heap.get(minIndex))
                    minIndex = childIndex + i;
                }
            }
        }
        
        if (minIndex != p) {    // if smaller child exists
            Collections.swap(heap, minIndex, p);
            siftDown(minIndex);
        }
    }
    
    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("No elements in heap!");
        }
        return heap.get(0);
    }
    
    public T remove() {
        if (size == 0) {
            throw new IllegalStateException("No elements in heap!");
        }
        
        T min = heap.get(0);
        heap.set(0, heap.get(size - 1));
        --size;
        siftDown(0);
        return min;
    }
    
    public void sort(List<T> arr) {
        heapify(arr, arr.size());
        
        for (int i = 0; i < arr.size(); ++i) {
            arr.set(i, remove());
        }
    }
        
}