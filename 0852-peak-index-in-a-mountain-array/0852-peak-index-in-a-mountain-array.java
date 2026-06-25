class Solution {
    public int peakIndexInMountainArray(int[] a) {
        int low = 1, high = a.length - 2;
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