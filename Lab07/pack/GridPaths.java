package Lab07.pack;

public class GridPaths {
    public int numberOfPaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        if (grid[0][0] == 1) return 0;
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) continue;
                if (i > 0) dp[i][j] += dp[i - 1][j];
                if (j > 0) dp[i][j] += dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }   
    public int numberOfPaths_optimized(int[][] grid) { 
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];

        // Initialize first row
        dp[0] = (grid[0][0] == 0) ? 1 : 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[j] = 0; // no paths through obstacles
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
                // dp[j] = dp[j] (from top) + dp[j - 1] (from left)
            }
        }

        return dp[n - 1];        
    }
}