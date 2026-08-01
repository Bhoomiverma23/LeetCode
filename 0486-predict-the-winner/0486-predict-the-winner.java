class Solution {
    public int recursion(int i, int j, int[] nums) {
        if (i == j) {
            return nums[i];
        }
        int takeLeft = nums[i] - recursion(i + 1, j, nums);
        int takeRight = nums[j] - recursion(i, j - 1, nums);
        return Math.max(takeLeft, takeRight);
    }
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int total_score = 0;
        for (int i = 0; i < n; i++) {
            total_score += nums[i];
        }
        int player1 = recursion(0, n - 1, nums);
        int player2 = total_score - player1;
        return recursion(0, nums.length - 1, nums) >= 0;
    }
}