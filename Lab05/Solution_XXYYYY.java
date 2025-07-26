package Lab05;

public class Solution_XXYYYY {
    public boolean backspaceCompare(String s, String t) {
        return false;
    }

    static void demo_1() {
        String a = "ab#c";
        String b = "ad#c";
        Solution_XXYYYY s = new Solution_XXYYYY();
        System.out.println( s.backspaceCompare(a, b) );
    }
    static void demo_2() {
        String a = "ab##";
        String b = "c#d#";
        Solution_XXYYYY s = new Solution_XXYYYY();
        System.out.println( s.backspaceCompare(a, b) );
    }
    static void demo_3() {
        String a = "a#c";
        String b = "b";
        Solution_XXYYYY s = new Solution_XXYYYY();
        System.out.println( s.backspaceCompare(a, b) );
    }
    public static void main(String[] args) {

    }
}

