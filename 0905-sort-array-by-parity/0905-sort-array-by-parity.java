class Solution {
    public int[] sortArrayByParity(int[] a) {
        int i = 0, j = 0;
        while (j < a.length) {
            if (a[j] % 2 == 0) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
            j++;
        }
        return a;
    }
}