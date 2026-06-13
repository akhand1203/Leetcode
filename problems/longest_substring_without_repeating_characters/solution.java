class Solution {
    public int lengthOfLongestSubstring(String s) {
        int low = 0;
        int res = 0;
        int n = s.length();
        HashSet<Character> set = new HashSet<>();

        for (int high = 0; high < n; high++) {
            char ch = s.charAt(high);

            while (set.contains(ch)) {
                char leftChar = s.charAt(low);
                set.remove(leftChar);
                low++;
            }

            set.add(ch);
            int windowSize = high - low + 1;
            res = Math.max(res, windowSize);
        }

        return res;
    }
}