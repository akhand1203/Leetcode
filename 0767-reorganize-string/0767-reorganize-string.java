class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        class Pair {
            int first;
            char second;

            Pair(int f, char s) {
                first = f;
                second = s;
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (x, y) -> y.first - x.first);

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.add(new Pair(freq[i], (char) (i + 'a')));
            }
        }

        StringBuilder res = new StringBuilder();

        while (pq.size() >= 2) {
            Pair first = pq.poll();
            Pair second = pq.poll();

            res.append(first.second);
            res.append(second.second);

            first.first--;
            second.first--;

            if (first.first > 0)
                pq.add(first);
            if (second.first > 0)
                pq.add(second);
        }

        if (!pq.isEmpty()) {
            Pair last = pq.poll();
            if (last.first > 1) {
                return "";
            }
            res.append(last.second);
        }

        return res.toString();
    }
}