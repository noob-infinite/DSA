package Lab06.pack;

import java.nio.channels.Pipe.SourceChannel;
import java.util.StringTokenizer;

import Lab05.pack.MyRPN;
import Lab05.pack.MyStack;

public class MyShuntingYard {
    private static int order(String c) {
        return switch (c) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> 0;
        };
    }
    public static String infixToPostfix(String infixString) {
        MyQueueL_XXYYYY<String> queue = new MyQueueL_XXYYYY<>();
        MyStack<String> stack = new MyStack<>();

        StringTokenizer st = new StringTokenizer(infixString);
        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            if (MyRPN.isNumeric(t)) {
                queue.enqueue(t);
            } else if (t.equals("(")) {
                stack.push(t);
            } else if (t.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    queue.enqueue(stack.pop());
                }
                if (stack.isEmpty()) {
                    throw new IllegalArgumentException("Mismatched parentheses in expression.");
                }
                stack.pop(); // Discard "("
            } else { // operator
                while (!stack.isEmpty() && order(stack.peek()) >= order(t)) {
                    queue.enqueue(stack.pop());
                }
                stack.push(t);
            }
        }

        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for (String token : queue) {
            sb.append(token).append(" ");
        }
        return sb.toString().trim();
    }
}
