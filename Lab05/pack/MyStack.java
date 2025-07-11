package Lab05.pack;

import java.util.ArrayList;

public class MyStack<T> extends ArrayList<T> {
    // private ArrayList<T> items = new ArrayList<>();
    public void push(T data) {
        this.add(data);
        // items.add(data);
    }
    public T pop() {
        return remove(size() - 1);
        // return items.remove(items.size()-1);
    }
    public T peek() {
        return get(size() - 1);
        // return items.get(items.size() - 1);
    }
    public int size() {
        return this.size();
    }
    public boolean isEmpty() {
        return size() == 0;
        // return items.size() == 0;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = size() - 1; i > 0; i--)
            sb.append(this.get(i) + ", "); 
        if (this.size() > 0)
            sb.append(this.get(0));
        sb.append("]");
        return sb.toString();
    }
}
