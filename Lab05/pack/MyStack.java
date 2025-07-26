package Lab05.pack;

import java.util.ArrayList;

public class MyStack<T> {   // extends ArrayList<T> {
                            // extends would expose MyStack object for calling any of the ArrayList's methods
    private ArrayList<T> items = new ArrayList<>();
    public void push(T data) {
        items.add(data);
    }
    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty!");
        return items.remove(items.size()-1);
    }
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty!");
        return items.get(items.size() - 1);
    }
    public int size() {
        return items.size();
    }
    public boolean isEmpty() {
        return items.isEmpty();
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = size() - 1; i > 0; i--)
            sb.append(items.get(i) + ", "); 
        if (items.size() > 0)
            sb.append(items.get(0));
        sb.append("]");
        return sb.toString();
    }
}
