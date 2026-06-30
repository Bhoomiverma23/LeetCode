class Solution {
    public int f(int nums[],int index , int dp[]){
        if(index == 0){
            return nums[0];
        }
        if(index < 1){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int take = nums[index] + f(nums,index-2,dp);
        int notTake = f(nums,index-1,dp);
        dp[index] = Math.max(take,notTake);
        return dp[index];
    }
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return f(nums,nums.length-1,dp);
    }
}