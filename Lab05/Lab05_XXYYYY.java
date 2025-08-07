package Lab05;

import java.util.StringTokenizer;

import Lab05.pack.MyRPN;
import Lab05.pack.MyStack;

public class Lab05_XXYYYY {
    static void demo_0() {
        MyStack<Integer> stack = new MyStack<>();
        for (int i = 1; i < 4; i++)
            stack.push(i);
        System.out.println(stack);
    }
    static void demo_1() {
        String toBeRPN = "8 5 - 4 2 + 3 / *";
        StringTokenizer st = new StringTokenizer(toBeRPN);
        int i = 0;
        String t = "";
        while (st.hasMoreTokens()) {
            t = st.nextToken();
            if (MyRPN.isNumeric(t))
                System.out.println("Token " + i++ + " = " + t);
            else   
                System.out.println("Token " + i++ + " = " + t + " is an operator");
        }
    }
    static void demo_2() {
        String postfixString = "8 5 - 4 2 + 3 / *";
        System.out.println(postfixString + " = " + MyRPN.computeRPN(postfixString));
    }
    public static void main(String[] args) {
        demo_0();
        // demo_1();
        // demo_2();
    }
}
