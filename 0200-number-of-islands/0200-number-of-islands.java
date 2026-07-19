class Solution {
    boolean valid(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    void dfs(char[][] grid, int n, int m, int row, int col, ArrayList<ArrayList<Boolean>> vis) {
        vis.get(row).set(col, true);
        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int newRow = row + x[k];
            int newCol = col + y[k];
            if (valid(newRow, newCol, n, m) && grid[newRow][newCol] == '1' && vis.get(newRow).get(newCol) == false) {
                dfs(grid, n, m, newRow, newCol, vis);
            }
        }
        return;
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;

        ArrayList<ArrayList<Boolean>> vis = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Boolean> t = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                t.add(false);
            }
            vis.add(t);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && vis.get(i).get(j) == false) {
                    dfs(grid, n, m, i, j, vis);
                    res++;
                }
            }
        }
        return res;
    }
}