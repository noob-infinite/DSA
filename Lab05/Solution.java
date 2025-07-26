package Lab05;
import java.util.Stack;
// https://leetcode.com/problems/make-the-string-great/description/
public class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '#') {
                if (!s1.isEmpty())
                    s1.pop();
            } else { 
                s1.push(ch);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            ch = t.charAt(i);
            if (ch == '#') {
                if (!s2.isEmpty())
                    s2.pop();
            } else { 
                s2.push(ch);
            }
        }
        // System.out.println("s1" + s1.toString());
        // System.out.println("s2" + s2.toString());
        if (s1.size() != s2.size())
            return false;
        return s1.equals(s2);
    }    
    static void demo_1() {
        String a = "ab#c";
        String b = "ad#c";
        Solution s = new Solution();
        System.out.println( s.backspaceCompare(a, b) );
    }
    static void demo_2() {
        String a = "ab##";
        String b = "c#d#";
        Solution s = new Solution();
        System.out.println( s.backspaceCompare(a, b) );
    }
    static void demo_3() {
        String a = "a#c";
        String b = "b";
        Solution s = new Solution();
        System.out.println( s.backspaceCompare(a, b) );
    }
    public static void main(String[] args) {
        demo_1();
        demo_2();
        demo_3();
    }
}
