class Solution {
    public String reorganizeString(String s) {

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        class Pair {
            int first;
            char second;

            Pair(int first, char second) {
                this.first = first;
                this.second = second;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> b.first - a.first
        );

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new Pair(freq[i], (char)(i + 'a')));
            }
        }

        StringBuilder res = new StringBuilder();

        while (!pq.isEmpty()) {

            Pair p = pq.poll();

            if (res.length() == 0 ||
                res.charAt(res.length() - 1) != p.second) {

                res.append(p.second);
                p.first--;

                if (p.first > 0) {
                    pq.offer(p);
                }

            } else {

                if (pq.isEmpty()) {
                    return "";
                }

                Pair q = pq.poll();

                res.append(q.second);
                q.first--;

                if (q.first > 0) {
                    pq.offer(q);
                }

                pq.offer(p);
            }
        }

        return res.toString();
    }
}