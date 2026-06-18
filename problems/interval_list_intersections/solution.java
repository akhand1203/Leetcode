class Solution {
    public int[][] intervalIntersection(int[][] a, int[][] b) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {
            int st1  = a[i][0];
            int end1 = a[i][1];
            int st2  = b[j][0];
            int end2 = b[j][1];

            int s = Math.max(st1, st2);
            int e = Math.min(end1, end2);
            if (s <= e) {
                res.add(new int[]{s, e});
            }

            if (end1 <= end2) {
                i++;
            } else {
                j++;
            }
        }

        return res.toArray(new int[0][]);
    }
}