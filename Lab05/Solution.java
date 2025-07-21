package Lab05;
import java.util.Stack;
// https://leetcode.com/problems/make-the-string-great/description/
public class Solution {
        public String makeGood(String str) { 
        // beat 55.50%
        Stack<Character> stack = new Stack<>();
        char ch, tmp = '/'; // dummie
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }
            tmp = stack.peek();
            if (Math.abs(tmp - ch) == 32) { // lower-case vs upper-case 
                stack.pop();
                continue;
            }
            stack.push(ch); 
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();    
    }
    static void demo_1() { 

        char ch1 = 'a';
        char ch2 = 'A';
        int diff = Math.abs(ch1 - ch2); // 32
        System.out.println(diff);

        String s1 = "abBAcC";
        // String s1 = "leEeetcode";
        Solution s = new Solution();
        System.out.println( s.makeGood(s1) );
    }
    public static void main(String[] args) {
        demo_1();
    }
}
