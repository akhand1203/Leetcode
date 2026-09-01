class Solution {
    public int minMaxDifference(int num) {
        String s = Integer.toString(num);
        
        // For max: find first digit that isn't '9', replace all its occurrences with '9'
        String maxStr = s;
        for (char c : s.toCharArray()) {
            if (c != '9') {
                maxStr = s.replace(c, '9');
                break;
            }
        }
        
        // For min: replace all occurrences of the first digit with '0'
        char firstDigit = s.charAt(0);
        String minStr = s.replace(firstDigit, '0');
        
        int max = Integer.parseInt(maxStr);
        int min = Integer.parseInt(minStr);
        
        return max - min;
    }
}