class Solution {
    public boolean searchMatrix(int[][] a, int target) {
        int n=a.length;
        int m=a[0].length;
        int low=0;
        int high=n*m-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int row=mid/m;
            int col=mid%m;
            if(a[row][col]==target){
                return true;
            }
            else if(a[row][col]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return false;
    }
}