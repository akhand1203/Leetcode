class Solution {
    public int maxArea(int[] a) {
        int maxarea=0;
        int i=0;
        int j=a.length-1;
        while(i<j){
            int h=Math.min(a[i],a[j]);
            int w=j-i;
           int area=h*w;
            maxarea=Math.max(maxarea,area);
            if(a[i]<a[j]){
                i++;
            }
            else{
                j--;
            }
            
        }
        return maxarea;
    }
}