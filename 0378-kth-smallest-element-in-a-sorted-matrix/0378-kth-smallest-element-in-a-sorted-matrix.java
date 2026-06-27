class Solution {
    int fun(int[][] a,int n ,int m, int mid){
        int row=n-1;
        int col=0;
        int count=0;
        while(row>=0 && col<m){
            if(a[row][col]<=mid){
                count=count+row+1;
                col++;
            }
            else{
                row--;
            }
        }
        return count;
    }
    public int kthSmallest(int[][] a, int k) {
        int n=a.length;
        int m=a[0].length;
        int low=a[0][0];
        int high=a[n-1][m-1];
        int res=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int ans=fun(a,n,m,mid);
            if(ans<k){
                low=mid+1;
            }
            else{
                res=mid;
                high=mid-1;
            }

            
        }
        return res;
    }
}