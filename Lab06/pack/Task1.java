package Lab06.pack;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Task1<T> {
    private List<T> items = new LinkedList<>(); // remove(0) is O(1)
    public void enqueue(T d) {
        /* your code */
    }
    public T dequeue() {
        /* your code */
    }
    public T peek() { 
        /* your code */
    }
    public boolean isEmpty() {
        return items.isEmpty();
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("top->");
        for (T item : items)
            sb.append(item).append("-> ");
        sb.append("bottom");
        return sb.toString();
    }
  
}
