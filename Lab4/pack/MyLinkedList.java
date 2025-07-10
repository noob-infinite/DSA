package Lab4.pack;

public class MyLinkedList {
    public class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
            next = null; // explicit
        }
        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return "Node.data = " + data;
        }
    }

    Node head = null;
    private int size = 0;

    public String toString() {
        StringBuffer sb = new StringBuffer("head");
        Node p = head;
        while (p != null) {
            sb.append("->(");
            sb.append(p.data);
            sb.append(")");
            p = p.next;
        }
        sb.append("->null");
        return new String(sb);
    }


    public int getAt(int i) {
        Node p = head;
        while (i > 0) {
            p = p.next;
            i--;
        }
        return p.data;
    }

    public void setAt(int d, int i) {
        Node p = head;
        while (i > 0) {
            p = p.next;
            i--;
        }
        p.data = d;
    }
    public int size() {
        return size;
    }
    public void add(int ... d) {
        for (int i = d.length-1; i >= 0; i--)
            add(d[i]);
    }
    public void add(int d) {
        Node p = new Node(d);
        if (head == null)
            head = p;
        else {
            p.next = head;
            head = p;
        }
        size++;
    }

    public int find(int d) {
        Node p = head;
        int idx = 0;
        while (p != null) {
            if (p.data == d)
                return idx;
            p = p.next;
            idx++;
        }
        return -1;
    }
    public boolean isFound(int d) {
        return (find(d) >= 0);
    }

    // public void delete(Node p) {
    //     p.next = p.next.next;
    // }

    public void delete(int d) {
        if (head == null)
            return;
        Node t = new Node(d + 1); // dummie
        t.next = head;
        Node p = t;
        while ((p.next != null) && (p.next.data != d)) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next;
            size--;
        }
        head = t.next;
    }

    public void insert2(int d) {
        // insert / prior to /* to toggle block
        // prevent case prior to head or head
        Node temp = new Node(d - 1);
        temp.next = head;
        Node x = temp;
        while (x.next != null && x.next.data < d) {
            x = x.next;
        }
        Node y = new Node(d);
        y.next = x.next;
        x.next = y;
        size++;
    }
    public void insert(int ... d) {
        for (int i = 0; i < d.length; i++)
            insert(d[i]);
    }
    public void insert(int d) {
        // check null for insert tail
        // check null at head
        // check insert prior to head
        if (head == null) {
            head = new Node(d);
            size++;
            return;
        }
        if (head.data > d) {
            Node q = new Node(d);
            q.next = head;
            head = q;
            size++;
            return;
        }
        Node p = head;
        //Node prev = null;
        while (p.next != null && p.next.data < d) {
        //while (p.next.data < d && p.next != null ) {
            //prev = p;
            p = p.next;
        }
        //move back one step p = prev;
        Node q = new Node(d);
        q.next = p.next;
        p.next = q;
        size++;
    } 
}

