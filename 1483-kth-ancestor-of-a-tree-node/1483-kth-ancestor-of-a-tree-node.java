class TreeAncestor {
    int[][] up;
    int LOG;
    public TreeAncestor(int n, int[] parent) {
        LOG = 1;
        while ((1 << LOG) <= n) {
            LOG++;
        }
        up = new int[n][LOG];
        for (int i = 0; i < n; i++) {
            up[i][0] = parent[i];
        }
        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                int p = up[i][j - 1];
                if (p == -1) {
                    up[i][j] = -1;
                } else {
                    up[i][j] = up[p][j - 1];
                }
            }
        }
    }
    public int getKthAncestor(int node, int k) {
        for (int j = 0; j < LOG && node != -1; j++) {
            if ((k & (1 << j)) != 0) {
                node = up[node][j];
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */