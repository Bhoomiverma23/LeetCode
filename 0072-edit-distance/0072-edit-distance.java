class Solution {
     public int solve(int i, int j, String word1, String word2,int dp[][]) {
        if (i == word1.length()) {
            return word2.length() - j;
        }

        if (j == word2.length()) {
            return word1.length() - i;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = solve(i + 1, j + 1, word1, word2,dp);
        }

        int insert = 1 + solve(i, j + 1, word1, word2,dp);
        int delete = 1 + solve(i + 1, j, word1, word2,dp);
        int replace = 1 + solve(i + 1, j + 1, word1, word2,dp);

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(0,0,word1,word2,dp);
    }
}