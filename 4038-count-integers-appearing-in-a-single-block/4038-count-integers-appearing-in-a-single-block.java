class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        map.put(nums[0], 1);
        for(int i = 1; i < n; i++){
            if(nums[i] != nums[i - 1]){
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        int cnt = 0;
        for(Map.Entry<Integer, Integer> p : map.entrySet()){
            if(p.getValue() == 1){
                cnt++;
            }
        }
        return cnt;
    }
}