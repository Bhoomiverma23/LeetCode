class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> ans = new ArrayList<>();
        if(n == 0){
            return ans;
        }
        int i = 0;
        while(i<n){
            int start = nums[i];
            int j = i;
            while(j+1<n && nums[j+1] == nums[j]+1){
                j++;
            }
            if(nums[j] == start){
                ans.add(String.valueOf(start));
            }else{
                ans.add(start + "->" + nums[j]);
            }
            i = j+1;
        }
        return ans;
    }
}