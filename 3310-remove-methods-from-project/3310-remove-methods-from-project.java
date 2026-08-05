class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> rev = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            rev.add(new ArrayList<>());
        }
        for (int[] e : invocations) {
            graph.get(e[0]).add(e[1]);
            rev.get(e[1]).add(e[0]);
        }
        boolean[] suspicious = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(k);
        suspicious[k] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph.get(u)) {
                if (!suspicious[v]) {
                    suspicious[v] = true;
                    q.offer(v);
                }
            }
        }
        for (int[] e : invocations) {
            if (!suspicious[e[0]] && suspicious[e[1]]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}