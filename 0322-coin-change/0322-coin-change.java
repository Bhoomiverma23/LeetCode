class Solution {
    public int f(int index, int amount, int coins[], int[][] dp) {
        if (index == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            } else {
                return (int) 1e9;
            }
        }
        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }
        int notTake = f(index - 1, amount, coins, dp);
        int take = (int) 1e9;
        if (coins[index] <= amount) {
            take = 1 + f(index, amount - coins[index], coins, dp);
        }
        dp[index][amount] = Math.min(take, notTake);
        return dp[index][amount];
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = f(n - 1, amount, coins, dp);
        if (ans >= (int) 1e9) {
            return -1;
        }
        return ans;
    }
}