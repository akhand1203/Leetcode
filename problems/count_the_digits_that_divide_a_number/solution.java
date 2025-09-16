class Solution {
    public int countDigits(int num) {
        int m=num;
        int count=0;
        while(m!=0){
            int a=m%10;
            m=m/10;
            if(a!=0&&num%a==0){
                count++;
            }
        }
        return count;
    }
}