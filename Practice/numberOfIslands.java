import java.util.Scanner;

/*
Given a 2d grid of 1's (land) and 0's (water) count the no. of island.
An island is surrounded by water and is formed by connecting
adjacent lands horizontally or vertically.

You may assume the four edges of the grid are surrounded by water.

Input:
11110
11010
11000
00000

Output: 1
 */
/*
Breath first search
 */
public class numberOfIslands {
    public static void callBFS(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0)
            return;
        grid[i][i] = '0';
        callBFS(grid, i + 1, j);    // up
        callBFS(grid, i - 1, j);    // down
        callBFS(grid, i, j - 1);    // left
        callBFS(grid, i, j + 1);    //right
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    callBFS(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] arr = new char[n][m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.next().toCharArray();
        }
        System.out.println(numIslands(arr));
    }
}
