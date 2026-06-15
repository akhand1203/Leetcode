class Solution {
    public int maxSubarraySumCircular(int[] a) {
        int i = 0;
        int maxsum = a[0];
        int minsum = a[0];
        int totalSum = a[0];
        int ans = a[0];
        int globalMin = a[0];

        for (i = 1; i < a.length; i++) {
            totalSum = totalSum + a[i];
            int v1 = maxsum + a[i];
            int v2 = a[i];
            maxsum = Math.max(v1, v2);
            ans = Math.max(ans, maxsum);
            int v3 = minsum + a[i];
            int v4 = a[i];
            minsum = Math.min(v3, v4);
            globalMin = Math.min(globalMin, minsum);
        }

        if (totalSum != globalMin) {
            ans = Math.max(ans, totalSum - globalMin);
        }

        return ans;
    }
}