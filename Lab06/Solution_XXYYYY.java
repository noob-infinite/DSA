package Lab06;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_XXYYYY {
        public int maxLandArea(int[][] grid) {
        int max = 0;

        return max;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 0, 0},
            {1, 0, 0, 1},
            {0, 0, 1, 1},
            {1, 1, 0, 0}
        };
        Solution s = new Solution();
        int result = s.maxLandArea(grid);
        System.out.println("Largest land area: " + result);
    }
}
