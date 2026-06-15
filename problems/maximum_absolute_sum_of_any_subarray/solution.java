class Solution {
    public int maxAbsoluteSum(int[] a) {
        int i=0;
        int maxsum=a[0];
        int minsum=a[0];
        int ans=Math.abs(a[0]);
        for(i=1;i<a.length;i++){
            int v1=maxsum+a[i];
            int v2=a[i];
            maxsum=Math.max(v1,v2);
            int v3=minsum+a[i];
            int v4=a[i];
            minsum=Math.min(v3,v4);
            int absmax=Math.abs(maxsum);
            int absmin=Math.abs(minsum);
            ans=Math.max(ans,Math.max(absmax,absmin));
        }
        return ans;
    }
}