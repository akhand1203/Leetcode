class Solution {
    public int findMaxLength(int[] a) {
        HashMap <Integer,Integer> f=new HashMap<>();
        int zero=0;
        int one=0;
        int res=0;
        for(int i=0;i<a.length;i++){
            if(a[i]==0){
                zero++;
            }
            else{
                one++;
            }
            int diff=zero-one;
            if(diff==0){
                res=Math.max(res,i+1);
                continue;
            }
           if (!f.containsKey(diff)) {
                f.put(diff, i);
            }
            else{
                int idx=f.get(diff);
                int len=i-idx;
                res=Math.max(res,len);
            }
        }
        return res;
    }
}