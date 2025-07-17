package Lab04.pack;

public class MyCirList {
    class Node {
        int data;
        Node prev;
        Node next;
        Node() {    }
        Node(int d) {
            data = d;
        }
    }
    Node sentinel = new Node();
    int size;

    public MyCirList() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void push_back(int d) {
        insert(sentinel, d);
    }
    public void push_front(int d) {
        insert(sentinel.next, d);
    }
    public void pop_back() {
        if (!isEmpty())
            remove(sentinel.prev);
    }
    public void pop_front() {
        if (!isEmpty())
            remove(sentinel.next);
    }
    public void insert(Node it, int d) {
        Node n = new Node(d);
        n.next = it;
        n.prev = it.prev;
        it.prev.next = n;
        it.prev = n;
        size++;
    }
    public void remove(Node node) {
        if (node == sentinel)   // likely not needed
            return;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }
    public void print() { 
        if (isEmpty()) {
            System.out.println("Empty List");
            return;
        }
        Node cur = sentinel.next;
        while (cur.next != sentinel) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println(cur.data);
    }
    @Override 
    public String toString() {    
        if (isEmpty()) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder();
        Node cur = sentinel.next;
        sb.append("[");
        while (cur.next != sentinel) {
            sb.append(cur.data + ", ");
            cur = cur.next;
        }
        sb.append(cur.data + "]");
        return sb.toString();        
    }
    public static void main(String[] args) {
        MyCirList list = new MyCirList();

        System.out.println("Initial list (should be empty):");
        list.print();
        System.out.println(list.toString());
        System.out.println("Size: " + list.size());

        System.out.println("\n== Push back 10, 20 ==");
        list.push_back(10);
        list.push_back(20);
        list.print(); // 10 20
        System.out.println(list.toString());
        System.out.println("Size: " + list.size()); // 2

        System.out.println("\n== Push front 5 ==");
        list.push_front(5);
        list.print(); // 5 10 20
        System.out.println(list.toString());
        System.out.println("Size: " + list.size()); // 3

        System.out.println("\n== Pop front ==");
        list.pop_front();
        list.print(); // 10 20
        System.out.println(list.toString());
        System.out.println("Size: " + list.size()); // 2

        System.out.println("\n== Pop back ==");
        list.pop_back();
        list.print(); // 10
        System.out.println(list.toString());
        System.out.println("Size: " + list.size()); // 1

        System.out.println("\n== Pop front ==");
        list.pop_front();
        list.print(); // (empty)
        System.out.println(list.toString());
        System.out.println("Size: " + list.size()); // 0

        System.out.println("\n== Pop back on empty list ==");
        list.pop_back(); // should not crash
        list.print();
        System.out.println(list.toString());
        System.out.println("Size: " + list.size()); // 0

        System.out.println("\n== Push back 100, 200, 300 ==");
        list.push_back(100);
        list.push_back(200);
        list.push_back(300);
        list.print(); // 100 200 300 
        System.out.println(list.toString());
    }
}


