class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = find(nums, target, true);
        int last = find(nums, target, false);
        return new int[] { first, last };
    }

    private int find(int[] a, int x, boolean findFirst) {
        int low = 0, high = a.length - 1, res = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] < x) {
                low = mid + 1;
            } else if (a[mid] > x) {
                high = mid - 1;
            } else {
                res = mid;
                if (findFirst)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        return res;
    }
}