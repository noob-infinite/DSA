package Lab06.pack;

public class UnusedMyStackL<T> {
    private Node<T> head;
    private int size = 0;
    public void push(T d) {
        Node<T> n = new Node<>(d);
        n.next = head;
        head = n;
        size++;
    }
    public T pop() {
        Node<T> ans = head;
        head = head.next;
        size--;
        return ans.get();
    }
    public T peek() {
        return head.get();
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> tmp = head;
        sb.append("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(tmp.toString() + ", ");
            tmp = tmp.next;
        }
        if (size > 0) 
            sb.append(tmp.get());
        sb.append("]");
        return sb.toString();
    }
}
class Node<T> {
    T data;
    Node<T> next;
    public Node(T v) {
        data = v;
    }
    T get() {
        return data;
    }
    public String toString() {
        return "" + data;
    }
}
