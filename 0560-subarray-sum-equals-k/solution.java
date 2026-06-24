class Solution {
    public int subarraySum(int[] a, int k) {
        HashMap<Integer, Integer> f = new HashMap<>();
        f.put(0, 1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
            int que = sum - k;
            int freq = f.getOrDefault(que, 0);
            res = res + freq;
            f.put(sum, f.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}