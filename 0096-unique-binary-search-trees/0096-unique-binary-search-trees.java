class Solution {
    public int solve(int n) {
    if (n <= 1)
        return 1;
    int ans = 0;
    for (int root = 1; root <= n; root++) {
        ans += solve(root - 1) * solve(n - root);
    }
    return ans;
    }
    public int numTrees(int n) {
        return solve(n);   
    }
}