class Solution {
    public int characterReplacement(String s, int k) {

        int low = 0;
        int res = 0;
        int n = s.length();

        int[] freq = new int[26];

        int maxFreq = 0;

        for (int high = 0; high < n; high++) {

            char ch = s.charAt(high);

            int idx = ch - 'A';

            freq[idx]++;

            maxFreq = Math.max(maxFreq, freq[idx]);

            int windowSize = high - low + 1;
            int replacementsNeeded = windowSize - maxFreq;

            while (replacementsNeeded > k) {

                char leftChar = s.charAt(low);
                int leftIdx = leftChar - 'A';
                freq[leftIdx]--;
                low++;

                windowSize = high - low + 1;
                replacementsNeeded = windowSize - maxFreq;
            }

            int len = high - low + 1;
            res = Math.max(res, len);
        }

        return res;
    }
}