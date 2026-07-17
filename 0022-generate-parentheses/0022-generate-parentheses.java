class Solution {
    List<String> solve(int n) {
    if (n == 0) {
        return Arrays.asList("");
    }
    List<String> ans = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        List<String> left = solve(i);
        List<String> right = solve(n - 1 - i);
        for (String l : left) {
            for (String r : right) {
                ans.add("(" + l + ")" + r);
            }
        }
    }
    return ans;
}
    public List<String> generateParenthesis(int n) {
        return solve(n);
    }
}