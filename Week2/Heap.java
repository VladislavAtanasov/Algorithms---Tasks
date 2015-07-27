package binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Heap<T extends Comparable<T>> {

    public static final int ROOT = -1;
    private List<T> heap;
    private int size;
    
    public Heap() {
        this.heap = new ArrayList<T>(1);
        this.size = 0;
    }
    
    public int parent(int i) {
        return i == 0 ? ROOT : i / 2;
    }
    
    public int left(int i) {
        return 2 * i + 1;
    }
    
    public int right(int i) {
        return 2 * i + 2;
    }
    
    public int size() {
        return size;
    }
    
    public void siftUp(int i) {
        if (parent(i) == ROOT) {
            return;
        }
        
        if (heap.get(i).compareTo(heap.get(parent(i))) < 0) {
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
    
    public void heapify(List<T> elements, int size) {
        this.heap = new ArrayList<T>();
        this.size = size;
        
        for (int i = 0; i < size; ++i) {
            this.heap.add(elements.get(i));
        }
        
        for (int i = size - 1; i >= 0; --i) {
            siftDown(i);
        }
    }
    
    public void siftDown(int p) {
        int childIndex = left(p);
        int minIndex = p;
        
        for (int i = 0; i < 2; ++i) {
            if (childIndex + i < size) {
                if (heap.get(childIndex + i).compareTo(heap.get(minIndex)) < 0) {
                    minIndex = childIndex + i;
                }
            }
        }
        
        if (minIndex != p) {  
            Collections.swap(heap, minIndex, p);
            siftDown(minIndex);
        }
    }
    
    public T getMin() {
        if (size == 0) {
            throw new IllegalStateException("No elements in heap!");
        }
        return heap.get(0);
    }
    
    public T extractMin() {
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
            arr.set(i, extractMin());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<Integer> numbers = new ArrayList<Integer>(count);
        
        for (int i = 0; i < count; ++i) {
            numbers.add(scanner.nextInt());
        }
        
        new Heap<Integer>().sort(numbers);
            
        for (int i = 0; i < count; ++i) {
            System.out.print(numbers.get(i) + " ");
        }
        
        scanner.close();
    }
        
}

