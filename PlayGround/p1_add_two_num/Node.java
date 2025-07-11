package PlayGround.p1_add_two_num;

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
