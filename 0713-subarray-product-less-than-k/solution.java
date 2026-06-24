class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
         if (k <= 1) return 0;
        int low=0;
        int high=0;
        int p=1;
        int n=nums.length;
        int count=0;
        for(high=0;high<n;high++){
            p=p*nums[high];
            while(p>=k){
                p=p/nums[low];
                low++;
            }
            int res=high-low+1;
            count=count+res;
        }
        return count;
    }
}