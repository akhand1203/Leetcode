class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (int i = 0; i < n; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Count, s2Count)) return true;

        for (int i = n; i < m; i++) {
            s2Count[s2.charAt(i) - 'a']++;
            s2Count[s2.charAt(i - n) - 'a']--;

            if (Arrays.equals(s1Count, s2Count)) return true;
        }

        return false;
    }
}