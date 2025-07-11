package PlayGround.p1_add_two_num;

import java.util.Stack;

public class P3_palindrome {
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
        demo.add(new int[] {21,32,44,33,21});
        Node head = demo.head;

        Node currNode = head;
        Stack<Integer> s = new Stack<>();
        while (currNode != null) {
            s.push(currNode.data);
            currNode = currNode.next;
        }
        int d;
        currNode = head;
        boolean isPalin = true;
        while (currNode != null) { // could test only half
            d = s.pop();
            if (currNode.data != d) {
                isPalin = false;
                System.out.println(false);
                break;
                // return isPalin;
            }
            currNode = currNode.next;
        }
        // return isPalin;
        if (isPalin)
            System.out.println(true);
        return head;
    }
    public static void main(String[] args) {
        demo_1();
    }     
}
