class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int last = stack.pop();
                int score = (last == 0) ? 1 : 2 * last;
                stack.push(stack.pop() + score);
            }
        }

        return stack.pop();
    }
}