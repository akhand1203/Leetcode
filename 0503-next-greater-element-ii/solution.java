class Solution {
    public int[] nextGreaterElements(int[] a) {
        int n = a.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * n; i++) {
            int idx = i % n;
            while (!st.isEmpty() && a[st.peek()] < a[idx]) {
                res[st.pop()] = a[idx];
            }
            if (i < n) {
                st.push(idx);
            }
        }
        return res;
    }
}