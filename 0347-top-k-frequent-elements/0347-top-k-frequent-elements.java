class Solution {
    public int[] topKFrequent(int[] a, int k) {
        int n = a.length;

        class Pair {
            int first;
            int second;

            Pair(int f, int s) {
                first = f;
                second = s;
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (x, y) -> {
                if (x.first != y.first)
                    return x.first - y.first;
                return x.second - y.second;
            }
        );
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int num = a[i];
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        List<Integer> keys = new ArrayList<>(hm.keySet());
        for (int i = 0; i < keys.size(); i++) {
            int number = keys.get(i);
            int frequency = hm.get(number);
            pq.add(new Pair(frequency, number));

            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll().second;
        }
        return result;
    }
}