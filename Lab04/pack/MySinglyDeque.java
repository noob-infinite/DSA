package Lab04.pack;

public class MySinglyDeque {
    private class Node {
        int data;
        Node next;
        Node(int d) { data = d; }
    }
    private Node head;
    private Node tail;
    private Node prevTail; // won't improve pop_back() to O(1) hence leave this out
    private int size;
    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }
    
    public void push_front(int d) {
        Node n = new Node(d);
        n.next = head;
        head = n;
        if (tail == null) tail = head;
        size++;
    }

    public void push_back(int d) {
        Node n = new Node(d);
        if (isEmpty()) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        size++;
    }

    public void pop_front() {
        if (isEmpty()) return;
        // Node prev = head;
        head = head.next;
        // prev.next = null;
        if (head == null) tail = null;
        size--;
    }

    public void pop_back() {
        if (isEmpty()) return;
        if (head == tail) {
            head = tail = null;
        } else {
            Node cur = head;
            while (cur.next != tail) {
                cur = cur.next;
            }
            cur.next = null;
            tail = cur;
        }
        size--;
    }

    public int peek_front() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        return head.data;
    }
    public int peek_back() {
        if (isEmpty()) throw new RuntimeException("Empty list");
        return tail.data;        
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node cur = head;
        while (cur != null) {
            sb.append(cur.data);
            if (cur.next != null)
                sb.append(", ");
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }
    static void demo_1() {
        MySinglyDeque dq = new MySinglyDeque();

        dq.push_back(10);
        dq.push_front(5);
        dq.push_back(20);
        System.out.println(dq); // [5, 10, 20]

        System.out.println("Front: " + dq.peek_front()); // 5
        System.out.println("Back : " + dq.peek_back());  // 20

        dq.pop_front();
        System.out.println(dq); // [10, 20]

        dq.pop_back();
        System.out.println(dq); // [10]

        dq.pop_back();
        System.out.println(dq); // []
    }
    public static void main(String[] args) {
        demo_1();
    }
}
