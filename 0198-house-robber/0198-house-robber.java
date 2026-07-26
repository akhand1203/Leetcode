class Solution {
    int[] dp;

    int fun(int[] nums, int n, int i) {
        if (i >= n) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }

        int pick = nums[i] + fun(nums, n, i + 2);  
        int skip = fun(nums, n, i + 1);

        int ans = Math.max(pick, skip);
        dp[i] = ans;
        return ans;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return fun(nums, n, 0);
    }
}