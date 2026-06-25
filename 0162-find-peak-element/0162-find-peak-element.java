class Solution {
    public int findPeakElement(int[] a) {
        int low = 0, high = a.length - 2;
        if (a.length == 1) {
            return 0;
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] > a[mid + 1])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}