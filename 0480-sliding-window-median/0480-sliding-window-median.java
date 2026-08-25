class Solution {
    private PriorityQueue<Integer> low;  // max-heap, smaller half
    private PriorityQueue<Integer> high; // min-heap, larger half
    private Map<Integer, Integer> delayed = new HashMap<>();
    private int lowSize = 0, highSize = 0;

    public double[] medianSlidingWindow(int[] nums, int k) {
        low = new PriorityQueue<>(Collections.reverseOrder());
        high = new PriorityQueue<>();
        double[] result = new double[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            addNum(nums[i]);
        }
        result[0] = getMedian(k);

        for (int i = k; i < nums.length; i++) {
            addNum(nums[i]);
            removeNum(nums[i - k]);
            rebalance();
            result[i - k + 1] = getMedian(k);
        }

        return result;
    }

    private void addNum(int num) {
        if (low.isEmpty() || num <= low.peek()) {
            low.offer(num);
            lowSize++;
        } else {
            high.offer(num);
            highSize++;
        }
        rebalance();
    }

    private void removeNum(int num) {
        delayed.merge(num, 1, Integer::sum);
        if (num <= low.peek()) {
            lowSize--;
            if (num == low.peek()) prune(low);
        } else {
            highSize--;
            if (num == high.peek()) prune(high);
        }
    }

    private void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty() && delayed.getOrDefault(heap.peek(), 0) > 0) {
            int top = heap.peek();
            delayed.merge(top, -1, Integer::sum);
            if (delayed.get(top) == 0) delayed.remove(top);
            heap.poll();
        }
    }

    private void rebalance() {
        if (lowSize > highSize + 1) {
            high.offer(low.poll());
            lowSize--;
            highSize++;
            prune(low);
        } else if (lowSize < highSize) {
            low.offer(high.poll());
            highSize--;
            lowSize++;
            prune(high);
        }
        prune(low);
        prune(high);
    }

    private double getMedian(int k) {
        if (k % 2 == 1) {
            return low.peek();
        }
        return ((double) low.peek() + high.peek()) / 2.0;
    }
}