class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int xor = 0;
        boolean nonZero = false;

        for (int i = 0; i < n; i++) {
            xor = xor ^ nums[i];
            if (nums[i] != 0) {
                nonZero = true;
            }
        }
        if (xor != 0) {
            return n;
        }
        if (nonZero) {
            return n - 1;
        }
        return 0;
    }
}