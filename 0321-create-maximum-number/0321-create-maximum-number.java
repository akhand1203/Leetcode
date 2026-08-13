class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] best = new int[k];
        Arrays.fill(best, -1);

        for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {
            int[] candidate1 = maxArray(nums1, i);
            int[] candidate2 = maxArray(nums2, k - i);
            int[] merged = merge(candidate1, candidate2);
            if (greater(merged, 0, best, 0)) {
                best = merged;
            }
        }

        return best;
    }

    private int[] maxArray(int[] nums, int k) {
        int[] stack = new int[k];
        int top = -1;
        int drop = nums.length - k;

        for (int num : nums) {
            while (top >= 0 && stack[top] < num && drop > 0) {
                top--;
                drop--;
            }
            if (top < k - 1) {
                stack[++top] = num;
            } else {
                drop--;
            }
        }

        return stack;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int i = 0, j = 0, r = 0;

        while (i < nums1.length || j < nums2.length) {
            if (greater(nums1, i, nums2, j)) {
                result[r++] = nums1[i++];
            } else {
                result[r++] = nums2[j++];
            }
        }

        return result;
    }

    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        if (j == nums2.length) {
            return true;
        }
        if (i == nums1.length) {
            return false;
        }
        return nums1[i] > nums2[j];
    }
}