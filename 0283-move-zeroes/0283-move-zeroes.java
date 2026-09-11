class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = 0;
        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            if(nums[i] != 0) {
                result[j] = nums[i];
                j++;
            }
        }

        for(int i = 0; i < j; i++) {
            nums[i] = result[i];
        }

        for(int i = j; i < n; i++) {
            nums[i] = 0;
        }
    }
}