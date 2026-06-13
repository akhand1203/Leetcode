class Solution {
    public int totalFruit(int[] fruits) {
        int low = 0, high = 0;
        int n = fruits.length;
        int res = 0;
        HashMap<Integer, Integer> basket = new HashMap<>();

        for (high = 0; high < n; high++) {
            int fruit = fruits[high];
            int count = basket.getOrDefault(fruit, 0);
            basket.put(fruit, count + 1);
            while (basket.size() > 2) {
                int f = fruits[low];
                basket.put(f, basket.get(f) - 1);
                if (basket.get(f) == 0)
                    basket.remove(f);
                low++;
            }
            int len = high - low + 1;
            res = Math.max(res, len);
        }

        return res;
    }
}