class Solution {
    public int[] sortedSquares(int[] nums) {
        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();
        for (int num : nums) {
            if (num < 0) neg.add(num);
            else pos.add(num);
        }


        for (int i = 0; i < pos.size(); i++)
            pos.set(i, pos.get(i) * pos.get(i));


        for (int i = 0; i < neg.size(); i++)
            neg.set(i, neg.get(i) * neg.get(i));
        Collections.reverse(neg);


        int[] result = new int[nums.length];
        int i = 0, j = 0, id = 0;

        while (i < neg.size() && j < pos.size()) {
            if (neg.get(i) < pos.get(j))
                result[id++] = neg.get(i++);
            else
                result[id++] = pos.get(j++);
        }

        while (i < neg.size()) result[id++] = neg.get(i++);
        while (j < pos.size()) result[id++] = pos.get(j++);

        return result;
    }
}