class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                }
                return b[0] - a[0];
            }
        );
        for (int i = 0; i < arr.length; i++) {
            int distance = Math.abs(arr[i] - x);
            maxHeap.offer(new int[]{distance, arr[i]});
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            ans.add(maxHeap.poll()[1]);
        }
        Collections.sort(ans);
        return ans;
    }
}