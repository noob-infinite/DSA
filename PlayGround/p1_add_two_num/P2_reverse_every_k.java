package PlayGround.p1_add_two_num;

import java.util.Stack;

public class P2_reverse_every_k {
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) System.out.print(", ");
            head = head.next;
        }
        System.out.println();
    }
    static Node demo_1() {
        // Reverse a Linked List in groups of given size
        int k = 2;
        MyLinkedList demo = new MyLinkedList();
        demo.add(new int[] {1,2,3,4,5,6});
        Node head = demo.head;

        if (demo.head == null || k == 1)
            return demo.head;
        
        Stack<Node> st = new Stack<>();
        Node curr = head;
        Node prev = null;
        int count;
        while (curr != null) {
            count = 0;
            while (curr != null && count < k) {
                st.push(curr);
                curr = curr.next;
                count++;
            }
            while (!st.isEmpty()) {
                if (prev == null) {
                    prev = st.pop();
                    head = prev;
                } else {
                    prev.next = st.pop();
                    prev = prev.next;
                }
            }
        }
        // set the next reference of the last node to null
        prev.next = null;
        printList(head);
        return head;
    }
    public static void main(String[] args) {
        demo_1();
    }    
}
