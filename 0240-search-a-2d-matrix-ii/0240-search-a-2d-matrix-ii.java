class Solution {
    public boolean searchMatrix(int[][] a, int target) {
        int n=a.length;
        int m=a[0].length;
        int row=n-1;
        int col=0;
        while(row>=0 && col<m){
            if(a[row][col]==target){
                return true;
            }
            else if(a[row][col]>target){
                row--;
            }
            else{
                col++;
            }
        }
        return false;
    }
}