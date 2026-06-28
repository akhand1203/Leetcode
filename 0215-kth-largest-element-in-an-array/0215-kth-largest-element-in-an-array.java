class Solution {
    public int findKthLargest(int[] a, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < a.length; i++) {
            pq.add(a[i]);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}