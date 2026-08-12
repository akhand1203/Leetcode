class Solution {
    public int minLength(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && ((stack.peek() == 'A' && c == 'B') || (stack.peek() == 'C' && c == 'D'))) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.size();
    }
}