class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int maxCandies = candies[0];
        int n = candies.length;
        for (int i = 1; i < n; i++) {
            if (candies[i] > maxCandies) {
                maxCandies = candies[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (candies[i] + extraCandies >= maxCandies) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }
}