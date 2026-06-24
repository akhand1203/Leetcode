class Solution {
    public int maxProduct(int[] arr) {
        int i=0;
        int maxend=arr[0];
        int minend=arr[0];
        int ans=arr[0];
        for(i=1;i<arr.length;i++){
            int v1=arr[i];
            int v2=maxend*arr[i];
            int v3=minend*arr[i];
            maxend=Math.max(v1,Math.max(v2,v3));
            minend=Math.min(v1,Math.min(v2,v3));
            ans=Math.max(ans,Math.max(maxend,minend));
        }
        return ans;
    }
}