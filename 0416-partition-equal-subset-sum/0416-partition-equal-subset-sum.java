class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0)
            return false;
        int target = sum / 2;
        boolean dp[][] = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int index = 1; index < n; index++) {
            for (int t = 1; t <= target; t++) {
                boolean notTake = dp[index - 1][t];
                boolean take = false;
                if (nums[index] <= t) {
                    take = dp[index - 1][t - nums[index]];
                }
                dp[index][t] = take || notTake;
            }
        }
        return dp[n - 1][target];
    }
}