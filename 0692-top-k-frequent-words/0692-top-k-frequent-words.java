class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        List<String> unique = new ArrayList<>(freq.keySet());
        unique.sort((a, b) -> {
            if (!freq.get(a).equals(freq.get(b))) {
                return freq.get(b) - freq.get(a); // higher freq first
            }
            return a.compareTo(b); // lexicographical order
        });

        return unique.subList(0, k);
    }
}