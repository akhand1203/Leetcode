class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> f = new HashMap<>();
        for (char ch : text.toCharArray()) {
            f.put(ch, f.getOrDefault(ch, 0) + 1);
        }
        int res = Integer.MAX_VALUE;
        res = Math.min(res, f.getOrDefault('b', 0) / 1);
        res = Math.min(res, f.getOrDefault('a', 0) / 1);
        res = Math.min(res, f.getOrDefault('l', 0) / 2);
        res = Math.min(res, f.getOrDefault('o', 0) / 2); 
        res = Math.min(res, f.getOrDefault('n', 0) / 1);

        return res;
    }
}