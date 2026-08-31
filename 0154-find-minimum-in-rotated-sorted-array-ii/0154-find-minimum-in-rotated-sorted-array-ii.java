class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (nums[mid] > nums[hi]) {
                // min is in the right half
                lo = mid + 1;
            } else if (nums[mid] < nums[hi]) {
                // min is in the left half (including mid)
                hi = mid;
            } else {
                // nums[mid] == nums[hi], can't decide side, shrink safely
                hi--;
            }
        }
        
        return nums[lo];
    }
}