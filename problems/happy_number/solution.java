class Solution {
    int fun(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            sum = sum + (d * d);
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = fun(slow);          
            fast = fun(fun(fast));     
        } while (slow != fast);        

        return fast == 1;      
    }
}