package Lab04.pack;

import java.util.HashSet;
import java.util.Set;

public class MyTrickyLinkedList extends MyLinkedList {
    

    public void q1_rotate_clockwise(int k) {
        q1(k);
    }
    /* solution q1 */
    private void q1(int k) {
        // input  10->20->30->40->50->60, k = 4
        // output 30->40->50->60->10->20
        if (k > this.size())
            return; // for simplicity
        
        Node new_tail = null;
        Node new_head = head;
        int i = 0;
        while (i < (size() - k)) {
            new_tail = new_head;
            new_head = new_head.next;
            i++;
        } // tail is k step left to list's tail; 
          //new_tail is tail's left
        Node tail = new_head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;       // wrap
        new_tail.next = null;   // new tail
        head = new_head;
    }
    private void q1_slow(int k) {
        /*
            loop k times each time locate tail and make it become head (prev of tail becomes tail)
         */
        /* 
            create new MyTricklyLinkedList
            loop k times each time locate tail and append the new list with tail's value (prev of tail becomes tail) 
            loop from original list from head to append (newly created node with node's value) for the remaining
         */
    }
    /* solution q2 */
    public void q2_reverse() {  
        ex4_reverse();
        // ex4_rev_slow();
    }
    private void ex4_reverse() {
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    private void ex4_reverse_backup() {
        // no need 
        // if (size() == 2) {
        //     rear.next = null;
        //     p.next = rear;
        //     head = p;
        //     return;
        // }
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    private void ex4_rev_slow() {
        int val = -1;
        int idx = 0;
        MyLinkedList tmp = new MyLinkedList();
        while (idx < size()) {
            val = this.getAt(idx);
            idx++;
            tmp.add(val);
        }
        head = tmp.head;        
    }
    /* solution q3 */
    public void q3_remove_dup() {
        ex7_removeDupMap();
    }
    public void ex7_removeDupBF() {
        Node p1, p2;
        p1 = head;
        while (p1 != null && p1.next != null) { // for every node except tail
            p2 = p1;

            while (p2.next != null) { 
                if (p1.data == p2.next.data) { // found duplicate
                    p2.next = p2.next.next;
                } else { //need this else
                    p2 = p2.next;
                }
            }
            
            p1 = p1.next;
        }
    }
    public void ex7_removeDupMap() {
        if (head.next == null) 
            return;
        Set<Integer> set = new HashSet<>();
        Node p1, p2;
        p1 = head;
        set.add(p1.data);
        while (p1.next != null) { 
            if (!set.contains(p1.next.data)) {
                set.add(p1.data);
                p1 = p1.next;
                continue;
            }
            p1.next = p1.next.next; // skip
        }
    }
    /* solution q4 */
    public void q4_add_one() {
        // ex8_right_most_not_nine();
        // ex8_reverse_slow();
        ex8_plusOne_number_conversion();
    }
    private void ex8_right_most_not_nine() {
        Node p = head;
        Node lastNotNine = null;
        while (p != null) {
            if (p.data != 9) 
                lastNotNine = p;
            p = p.next;
        }
        if (lastNotNine == null) {
            add(1);
            p = head.next;
            while (p != null) {
                p.data = 0;
                p = p.next;
            }
            return;
        }
        lastNotNine.data++;
        p = lastNotNine.next;
        while (p != null) {
            p.data = 0;
            p = p.next;
        }        
    }
    private void ex8_reverse_slow() {
        ex4_reverse();
        int carry = 1;
        int idx = 0;
        int digit = 0;
        while (carry == 1 && idx < size()) {
            digit = this.getAt(idx) + 1;
            carry = digit / 10;
            digit = digit % 10;
            this.setAt(digit, idx);
            idx++;
            if (carry == 0)
                break;
        }
        ex4_reverse();
        // to handle 9999 prefix the dummie 0
        if (carry == 1) {
            add(1);
        }
    }
    private void ex8_plusOne_number_conversion() {
        int number = sub_ex8_linklistToInt();
        number += 1;
        head = sub_ex8_intToLinkedList(number);
    }
    private int sub_ex8_linklistToInt() {
        int number = 0;
        Node p = head;
    
        while (p != null) {
            number = number * 10 + p.data;
            p = p.next;
        }
    
        return number;
    }    
    private Node sub_ex8_intToLinkedList(int number) {
        if (number == 0) {
            return new Node(0);
        }
    
        Node dummyHead = new Node(-1);
        Node current = dummyHead;
    
        while (number > 0) {
            int digit = number % 10;
            number /= 10;
    
            Node newNode = new Node(digit);
            newNode.next = current.next;
            current.next = newNode;
        }
    
        return dummyHead.next;
    }
    /* solutin q5 */
    public boolean q5_isPalindrome() {
        return ex10_isPalindrome();
    }
    private boolean ex10_isPalindrome() {
        Node tmp = null;
        Node fast,slow;
        fast = slow = head;
        Node n;
        int i = 0;
        while (fast != null && fast.next != null) { 
            slow = slow.next;
            fast = fast.next.next;
            i++;
        }
        if (i % 2 == 1) {
            slow = slow.next; // odd number of nodes
            i--;
        }
        while (slow != null) {
            n = new Node(slow.data);
            n.next = tmp;
            tmp = n;
            slow = slow.next;
        }
        n = tmp;
        
        slow = head; //slow is now traversing first half
        
        while (n != null) { 
            if (n.data != slow.data)
                return false;
            n = n.next;
            slow = slow.next;
        }
        return true;         
    }
    public boolean ex10_isPalindrome_slow() {
        int start = 0;
        int stop = size() - 1;
        while (start < stop) {
            if (this.getAt(start) != this.getAt(stop))
                return false;
            start++;
            stop--;
        }
        return true;
    }
}
