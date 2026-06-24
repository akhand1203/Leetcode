class Solution {
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        Stack<int[]> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (!st.isEmpty() && st.peek()[0] == ch) {
                st.peek()[1]++;
                if (st.peek()[1] == k) {
                    st.pop();
                }
            } else {
                st.push(new int[] { ch, 1 });
            }
        }
        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            int[] top = st.pop();
            for (int j = 0; j < top[1]; j++) {
                res.append((char) top[0]);
            }
        }
        return res.reverse().toString();
    }
}