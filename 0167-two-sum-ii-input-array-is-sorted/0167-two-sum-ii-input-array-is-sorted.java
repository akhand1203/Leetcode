class Solution {
    public int[] twoSum(int[] a, int x) {
        int n=a.length;
        int i=0;
        int j=n-1;
        while(i<j){
            int sum=a[i]+a[j];
            if(sum==x) return new int[]{i+1,j+1};
            if(sum<x){
                i++;
            }
            else{
                j--;
            }
        }
        return new int[]{i+1,j+1};
    }
}