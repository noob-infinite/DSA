package Lab1c3;

public class Lab1c3_BoundingBox {
    static int [][] findBoundingBox(int [][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int rowMin = n, rowMax = -1;
        int colMin = m, colMax = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    if (i < rowMin) rowMin = i;
                    if (i > rowMax) rowMax = i;
                    if (j < colMin) colMin = j;
                    if (j > colMax) colMax = j;
                }
            }
        }

        if (rowMax == -1) {
            return null;  // no 1 found
        }

        return new int[][]{{rowMin, colMin}, {rowMax, colMax}};        
    } 
    static void demo_1() {
        int[][] grid = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0}
        };

        int[][] box = findBoundingBox(grid); 
        if (box == null) {
            System.out.println("No 1s found in the grid.");
        } else {
            System.out.printf("\nTop-left:\t (%d, %d)\n", box[0][0], box[0][1]);
            System.out.printf("Bottom-right:\t (%d, %d)\n", box[1][0], box[1][1]);
        }       
    }
    public static void main(String[] args) {
        demo_1();
    }
}
