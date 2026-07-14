class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    Boolean[][] dp;
    public boolean canCross(int[] stones) {
        int n = stones.length;
        if (stones[1] != 1) {
            return false;
        }
        dp = new Boolean[n][n + 1];
        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }
        return solve(stones, 1, 1);
    }

    public boolean solve(int[] stones, int index, int lastJump) {
        if (index == stones.length - 1) {
            return true;
        }
        if (dp[index][lastJump] != null) {
            return dp[index][lastJump];
        }
        boolean ans = false;
        for (int jump = lastJump - 1; jump <= lastJump + 1; jump++) {
            if (jump <= 0) {
                continue;
            }
            int nextStone = stones[index] + jump;
            if (map.containsKey(nextStone)) {
                int nextIndex = map.get(nextStone);
                if (solve(stones, nextIndex, jump)) {
                    ans = true;
                    break;
                }
            }
        }
        return dp[index][lastJump] = ans;
    }
}