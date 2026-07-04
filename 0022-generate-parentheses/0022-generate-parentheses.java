class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        List<Character> tmp = new ArrayList<>();
        fun(0, 0, n, tmp, res);
        return res;
    }

    void fun(int open, int close, int n, List<Character> tmp, List<String> res) {
        if (open == n && close == n) {
            StringBuilder sb = new StringBuilder();
            for (char ch : tmp) {
                sb.append(ch);
            }
            res.add(sb.toString());
            return;
        }
        if (open < n) {
            tmp.add('(');
            fun(open + 1, close, n, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
        if (close < open) {
            tmp.add(')');
            fun(open, close + 1, n, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }
}