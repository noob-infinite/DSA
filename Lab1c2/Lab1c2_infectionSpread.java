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

    static int solution(int n, int m, List<int[]> infected) {
        int[][] grid = new int[n][m];
        Queue<Cell> queue = new LinkedList<>();

        int k = infected.size();
        // Initialize infected cells at 100%
        for (int i = 0; i < k; i++) {
            int r = (infected.get(i))[0];
            int c = (infected.get(i))[1];
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
        return zeroCount;
    }
    static void demo_2() {
        int n = 8, m = 9;
        List<int[]> infected = new ArrayList<>();  
        List<int []> tmp = Arrays.asList(new int[] {1,1}, new int[] {3,5}, new int [] {6,2}, new int [] {7,8});
        infected.addAll(tmp);     
        System.out.println(solution(n, m, infected)); // output = 11 
    }
    static void demo_1() {
        int n = 4, m = 5;
        List<int[]> infected = new ArrayList<>();
        infected.add(new int[]{1, 1});
        infected.add(new int[]{2, 3});

        System.out.println(solution(n, m, infected)); // Output should be 2
    }
    public static void main(String[] args) {
        demo_1();
        System.out.println("xxxx");
        demo_2();

    }
}


