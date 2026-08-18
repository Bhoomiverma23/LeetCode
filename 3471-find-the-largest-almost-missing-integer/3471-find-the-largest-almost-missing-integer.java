class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        if (k == n) {
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                maxValue = Math.max(maxValue, nums[i]);
            }
            return maxValue;
        }

        if (k == 1) {
            int maxValue = -1;
            for (int i = 0; i < n; i++) {
                if (map.get(nums[i]) == 1 && nums[i] > maxValue) {
                    maxValue = nums[i];
                }
            }
            return maxValue;
        }
        n = n - 1;
        if (nums[0] == nums[n]) {
            return -1;
        }
        if (map.get(nums[0]) == 1 && map.get(nums[n]) == 1) {
            return Math.max(nums[0], nums[n]);
        }
        if (map.get(nums[0]) == 1 && map.get(nums[n]) > 1) {
            return nums[0];
        }
        if (map.get(nums[n]) == 1 && map.get(nums[0]) > 1) {
            return nums[n];
        }
        return -1;
    }
}