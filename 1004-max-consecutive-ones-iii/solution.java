class Solution {
    public int longestOnes(int[] arr, int k) {
        int low = 0;
        int res = 0;
        int n = arr.length;
        int countzero = 0;
        for (int high = 0; high < n; high++) {
            if (arr[high] == 0) {
                countzero++;
            }
            while (countzero > k) {
                if (arr[low] == 0) {
                    countzero--;
                }
                low++;
            }
            int len = high - low + 1;
            res = Math.max(res, len);
        }
        return res;
    }

}
