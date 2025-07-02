package Lab1c2;
import java.util.*;



public class Lab1c2_infectionSpread {

    static class Cell { // bug
        int row, col, level; // level: 0=100%, 1=80%, 2=60%

        Cell(int r, int c, int level) {
            this.row = r;
            this.col = c;
            this.level = level;
        }
    }

    static final int[] LEVELS = {100, 80, 60};
    static final int[] DR = {-1, 1, 0, 0}; // directions: up, down, left, right
    static final int[] DC = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // rows
        int m = sc.nextInt(); // cols
        int k = sc.nextInt(); // initially infected count
        sc.close();
        
        int[][] grid = new int[n][m];
        Queue<Cell> queue = new LinkedList<>();

        // Initialize infected cells at 100%
        for (int i = 0; i < k; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            grid[r][c] = 100;
            queue.add(new Cell(r, c, 0)); // level 0 means 100%
        }

        // BFS to spread infection
        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            int nextLevel = current.level + 1;
            if (nextLevel >= LEVELS.length) continue; // stop at 60%

            int infectionValue = LEVELS[nextLevel];

            for (int d = 0; d < 4; d++) {
                int nr = current.row + DR[d];
                int nc = current.col + DC[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;

                // Only update if new infection level is higher
                if (grid[nr][nc] >= infectionValue) continue;

                grid[nr][nc] = infectionValue;
                queue.add(new Cell(nr, nc, nextLevel));
            }
        }

        // Print final grid and count zeros
        int zeroCount = 0;
        System.out.println("Final infection grid:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) zeroCount++;
                System.out.printf("%4d", grid[i][j]);
            }
            System.out.println();
        }

        System.out.println("\nNumber of 0% infected cells: " + zeroCount);
    }
}


