class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int totalSum = 0;
        for (int stone : stones) {
            totalSum += stone;
        }
        boolean dp[][] = new boolean[n][totalSum + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (stones[0] <= totalSum) {
            dp[0][stones[0]] = true;
        }
        for (int index = 1; index < n; index++) {
            for (int target = 1; target <= totalSum; target++) {
                boolean notTake = dp[index - 1][target];
                boolean take = false;
                if (stones[index] <= target) {
                    take = dp[index - 1][target - stones[index]];
                }
                dp[index][target] = take || notTake;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int s1 = 0; s1 <= totalSum / 2; s1++) {
            if (dp[n - 1][s1]) {
                ans = Math.min(ans, totalSum - 2 * s1);
            }
        }
        return ans;
    }
}