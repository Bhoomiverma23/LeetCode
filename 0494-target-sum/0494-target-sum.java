class Solution {
    public int f(int index, int currSum, int[] nums, int target){
        if(index == nums.length){
           if(currSum == target){
            return 1;
           }
           return 0;
        }
        int plus = f(index+1,currSum+nums[index],nums,target);
        int minus = f(index+1,currSum-nums[index],nums,target);
        return plus+minus;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return f(0,0,nums,target);
    }
}