package Lab05.pack;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class MyRPN {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    public static boolean isNumeric(String strNum) {
        if (strNum == null)
            return false;
        return pattern.matcher(strNum).matches();
    }
    public static double computeRPN(String rpn) {
        /* your code */
        MyStack<Double> stack = new MyStack<>();
        StringTokenizer st = new StringTokenizer(rpn);
        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            System.out.println("token = " + t);
            if (isNumeric(t)) {
                stack.push(Double.parseDouble(t));
            } else {
                double b = stack.pop();
                double a = stack.pop();
                if (t.equals("-")) {
                    stack.push(a-b);
                } else if (t.equals("+")) {
                    stack.push(a+b);
                } else if (t.equals("*")) {
                    stack.push(a*b);
                }
                else if (t.equals("/")) {
                    stack.push(a/b);
                }
            }
            System.out.println("stack state " + stack);
        } //while
        return stack.pop();
    }
}

