class Solution {
    public int findMin(int[] a) {
        int n=a.length;
        int low = 0;
        int high = n-1;
        while (low < high) {
            int mid = (low + high) / 2;
            if(a[mid]>a[high]){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return a[low];
    }
}