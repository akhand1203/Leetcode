class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        int n = s.length();
        int blockSize = n / k;
        
        Map<String, Integer> freq = new HashMap<>();
        
        for (int i = 0; i < n; i += blockSize) {
            String block = s.substring(i, i + blockSize);
            freq.merge(block, 1, Integer::sum);
        }
        
        for (int i = 0; i < n; i += blockSize) {
            String block = t.substring(i, i + blockSize);
            int count = freq.getOrDefault(block, 0);
            if (count == 0) {
                return false;
            }
            freq.put(block, count - 1);
        }
        
        return true;
    }
}