class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        List<int[]>[] graph = new ArrayList[n];
        int[] indegree = new int[n];
        int maxEdge = 0;
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            indegree[e[1]]++;
            maxEdge = Math.max(maxEdge, e[2]);
        }
        List<Integer> topo = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            topo.add(u);
            for (int[] edge : graph[u]) {
                if (--indegree[edge[0]] == 0)
                    q.offer(edge[0]);
            }
        }
        int low = 0;
        int high = maxEdge;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canReach(mid, graph, topo, online, k, n)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean canReach(int minEdge,List<int[]>[] graph,List<Integer> topo,boolean[] online,long k,int n) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        for (int u : topo) {
            if (dist[u] == Long.MAX_VALUE)
                continue;
            if (u != 0 && u != n - 1 && !online[u])
                continue;
            for (int[] edge : graph[u]) {
                int v = edge[0];
                int w = edge[1];
                if (w < minEdge)
                    continue;
                if (v != n - 1 && !online[v])
                    continue;
                dist[v] = Math.min(dist[v], dist[u] + w);
            }
        }
        return dist[n - 1] <= k;
    }
}