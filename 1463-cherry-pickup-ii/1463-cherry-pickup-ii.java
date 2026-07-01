class Solution {
    int m, n;
    public int f(int i, int j1, int j2, int[][] grid, int[][][] dp) {
        if (j1 < 0 || j1 >= n || j2 < 0 || j2 >= n) {
            return (int) -1e9;
        }
        if (i == m - 1) {
            if (j1 == j2) {
                return grid[i][j1];
            }
            return grid[i][j1] + grid[i][j2];
        }
        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }
        int maxi = 0;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value;
                if (j1 == j2) {
                    value = grid[i][j1];
                } else {
                    value = grid[i][j1] + grid[i][j2];
                }
                value += f(i + 1, j1 + dj1, j2 + dj2, grid, dp);
                maxi = Math.max(maxi, value);
            }
        }
        return dp[i][j1][j2] = maxi;
    }

    public int cherryPickup(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return f(0, 0, n - 1, grid, dp);
    }
}