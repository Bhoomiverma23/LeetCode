class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), ans);
        return ans;
    }

    void backtrack(int[] nums, boolean[] used,List<Integer> temp, List<List<Integer>> ans) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == false) {
                temp.add(nums[i]);
                used[i] = true;
                backtrack(nums, used, temp, ans);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}