class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> f = new HashMap<>();

        for (char ch : s.toCharArray()) {
            f.put(ch, f.getOrDefault(ch, 0) + 1);
        }

        int res = 0;
        boolean oddFound = false;

        for (int freq : f.values()) {
            if (freq % 2 == 0) {
                res = res + freq;
            } else {
                res = res + freq - 1;
                oddFound = true;
            }
        }

        if (oddFound)
            res = res + 1;

        return res;
    }
}