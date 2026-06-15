class Solution {
    public int maximumSum(int[] a) {
        int i = 0;
        int noDel = a[0];
        int oneDel = 0;
        int ans = a[0];

        for (i = 1; i < a.length; i++) {
            int prevNoDel = noDel;

            int v1 = noDel + a[i];
            int v2 = a[i];
            noDel = Math.max(v1, v2);

            int v3 = oneDel + a[i];  
            int v4 = prevNoDel;       
            int v5 = a[i];            
            oneDel = Math.max(v3, Math.max(v4, v5));

            ans = Math.max(ans, Math.max(noDel, oneDel));
        }

        return ans;
    }
}