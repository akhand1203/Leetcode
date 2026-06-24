class Solution {
    public int[][] merge(int[][] a) {
        Arrays.sort(a, (x, y) -> x[0] - y[0]);
        List<int[]> res = new ArrayList<>();
        int st1 = a[0][0];
        int end1 = a[0][1];
        for (int i = 1; i < a.length; i++) {
            int st2 = a[i][0];
            int end2 = a[i][1]; 
            if (end1 >= st2) {
                st1 = st1;
                end1 = Math.max(end1, end2);
                continue;
            }
            res.add(new int[]{st1, end1});
            st1 = st2;
            end1 = end2;
        }
        res.add(new int[]{st1, end1});
        return res.toArray(new int[0][]);
    }
}