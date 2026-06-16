class Solution {
    public int subarraysDivByK(int[] a, int k) {
       HashMap <Integer,Integer> f=new HashMap<>();
       f.put(0,1);
       int sum=0;
        int res=0;
        for(int i=0;i<a.length;i++){
            sum=sum+a[i];
            int rem=sum%k;
            if(rem<0){
                rem=rem+k;
            }
            int freq=f.getOrDefault(rem,0);
            res=res+freq;
            int d=f.getOrDefault(rem,0)+1;
            f.put(rem,d);
        }
        return res;
    }
}