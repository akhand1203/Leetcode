class Solution {
    public int search(int[] a, int x) {
        int n = a.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == x) {
                return mid;
            }

            if (a[mid] > a[n - 1]) {
                if (a[mid] < x) {
                    low = mid + 1;
                } else {
                    if (a[0] > x) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            } else {
                if (a[mid] > x) {
                    high = mid - 1;
                } else {
                    if (a[n - 1] < x) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
}