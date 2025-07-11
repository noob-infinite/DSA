package PlayGround.p1_add_two_num;

import java.util.Stack;

public class P1_add_two_num_list {
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) System.out.print(", ");
            head = head.next;
        }
        System.out.println();
    }
    static void demo_1() {
        // given 2 list representing two nums
        // return head node of result of summing the two nums
        MyLinkedList num1 = new MyLinkedList();
        num1.add(new int[]{7,2,4,3}); //7,243
        MyLinkedList num2 = new MyLinkedList();
        num2.add(new int[]{5,6,4});

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        int v1 = 0, v2 = 0;
        for (int i = 0; i < num1.size(); i++) {
            // v1 *= 10;
            // v1 += num1.getAt(i);
            s1.push(num1.getAt(i)); 
        }
        // System.out.println("v1= " + v1);
        for (int i = 0; i < num2.size(); i++) {
            s2.push(num2.getAt(i)); 
        }

        int carry = 0;
        Node result = null;
        int d1, d2;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            d1 = s1.isEmpty() ? 0 : s1.pop(); // 
            d2 = s2.isEmpty() ? 0 : s2.pop();
            int d_sum = d1 + d2 + carry;
            carry = d_sum / 10;

            Node newNode = new Node(d_sum % 10);
            newNode.next = result;
            result = newNode;
        }
        printList(result);
        // return result;
    }
    public static void main(String[] args) {
        demo_1();
    }
}
