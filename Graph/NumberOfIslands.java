package Graph;

public class NumberOfIslands {
    static int directions[][] = {
            { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }
    };

    public static int no_of_islands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean vis[][] = new boolean[m][n];
        int islands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    islands++;
                    dfs(grid, i, j, vis);
                }
            }
        }

        return islands;
    }

    private static void dfs(int[][] grid, int r, int c, boolean[][] vis) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length ||
                grid[r][c] != 1 || vis[r][c])
            return;

        vis[r][c] = true;

        for (int dir[] : directions) {
            int new_r = r + dir[0];
            int new_c = c + dir[1];

            dfs(grid, new_r, new_c, vis);
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 1, 1 },
                { 0, 0, 0, 1, 0 },
                { 0, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 1 }
        };
        int result = no_of_islands(grid);
        System.out.println("Number of islands: " + result);
    }
}
