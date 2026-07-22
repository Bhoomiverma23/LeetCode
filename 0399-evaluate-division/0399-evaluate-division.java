class Solution {

    public double dfs(String src, String dest,HashMap<String, HashMap<String, Double>> graph,HashSet<String> visited) {
        if (graph.get(src).containsKey(dest)) {
            return graph.get(src).get(dest);
        }
        visited.add(src);
        for (String neighbour : graph.get(src).keySet()) {
            if (visited.contains(neighbour)) {
                continue;
            }
            double ans = dfs(neighbour, dest, graph, visited);
            if (ans != -1.0) {
                return graph.get(src).get(neighbour) * ans;
            }
        }
        return -1.0;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double value = values[i];
            if (!map.containsKey(dividend)) {
                map.put(dividend, new HashMap<>());
            }
            if (!map.containsKey(divisor)) {
                map.put(divisor, new HashMap<>());
            }
            map.get(dividend).put(divisor, value);
            map.get(divisor).put(dividend, 1.0 / value);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);
            if (!map.containsKey(dividend) || !map.containsKey(divisor)) {
                res[i] = -1.0;
            } else if (dividend.equals(divisor)) {
                res[i] = 1.0;
            } else {
                res[i] = dfs(dividend, divisor, map, new HashSet<>());
            }
        }
        return res;
    }
}