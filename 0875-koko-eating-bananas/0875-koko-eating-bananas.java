class Solution {
    long fun(int[] a, int n, int s) {  
        long h = 0;
        for (int i = 0; i < n; i++) {
            h = h + a[i] / s;
            if (a[i] % s != 0) {
                h++;
            }
        }
        return h;
    }

    public int minEatingSpeed(int[] a, int h) {
        int n = a.length;
        int low = 1;
        int high = 0;
        for (int x : a) high = Math.max(high, x);
        int res = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long hour = fun(a, n, mid);

            if (hour > h) {
                low = mid + 1;
            } else {
                res = mid;
                high = mid - 1;
            }
        }

        return res;
    }
}