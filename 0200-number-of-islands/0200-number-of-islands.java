class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int i, int j) {
        // out of bounds or water or already visited -> stop
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';  // mark as visited (sink it)

        dfs(grid, i + 1, j);  // down
        dfs(grid, i - 1, j);  // up
        dfs(grid, i, j + 1);  // right
        dfs(grid, i, j - 1);  // left
    }
}