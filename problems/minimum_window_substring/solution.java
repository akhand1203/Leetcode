class Solution {
    public String minWindow(String s, String t) {
        int[] need = new int[128];
        int[] window = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        int have = 0;
        int total = 0;
        for (int i = 0; i < 128; i++) {
            if (need[i] > 0)
                total++;
        }
        int low = 0;
        int minLen = Integer.MAX_VALUE;
        String res = "";
        for (int high = 0; high < s.length(); high++) {
            char ch = s.charAt(high);
            window[ch]++;
            if (need[ch] > 0 && window[ch] == need[ch]) {
                have++;
            }
            while (have == total) {
                int windowSize = high - low + 1;
                if (windowSize < minLen) {
                    minLen = windowSize;
                    res = s.substring(low, high + 1);
                }
                char leftChar = s.charAt(low);
                window[leftChar]--;
                if (need[leftChar] > 0 && window[leftChar] < need[leftChar]) {
                    have--;
                }

                low++;
            }
        }

        return res;
    }
}