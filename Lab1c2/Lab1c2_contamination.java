package Lab1c2;
import java.util.*;
//Contamination
public class Lab1c2_contamination {

    static class Cell {
        int row, col;
        int level; // 0: 100%, 1: 80%, 2: 60%

        Cell(int r, int c, int l) {
            row = r;
            col = c;
            level = l;
        }
    }

    public static int solution(int n, int m, List<int[]> infected) {
        boolean[][] contaminated = new boolean[n][m];
        boolean[][] visited = new boolean[n][m];

        Queue<Cell> queue = new LinkedList<>();

        // Directions: up, down, left, right
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        // Add all 100% infected cells
        for (int[] coord : infected) {
            int r = coord[0], c = coord[1];
            queue.add(new Cell(r, c, 0));
            contaminated[r][c] = true;
            visited[r][c] = true;
        }

        // BFS up to 2 levels
        while (!queue.isEmpty()) {
            Cell curr = queue.poll();

            if (curr.level >= 2) continue;

            for (int[] d : dirs) {
                int nr = curr.row + d[0];
                int nc = curr.col + d[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (!visited[nr][nc]) {
                        visited[nr][nc] = true;
                        contaminated[nr][nc] = true;
                        queue.add(new Cell(nr, nc, curr.level + 1));
                    }
                }
            }
        }

        // Count uncontaminated cells
        int clean = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!contaminated[i][j]) clean++;
            }
        }

        return clean;
    }

    // Example usage
    public static void main(String[] args) {
        int n = 4, m = 5;
        List<int[]> infected = new ArrayList<>();
        infected.add(new int[]{1, 1});
        infected.add(new int[]{2, 3});

        System.out.println(solution(n, m, infected)); // Output should be 2
    }
}
