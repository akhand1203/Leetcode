class Solution {
    public void moveZeroes(int[] a) {
        int n=a.length;
        int i=0;
        int j=0;
        while(j<n){
            if(a[j]!=0){
                int tmp=a[i];
                a[i]=a[j];
                a[j]=tmp;
                i++;
            }
            j++;
        }
        
    }
}