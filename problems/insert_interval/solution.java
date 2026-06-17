class Solution {
    public int[][] insert(int[][] a, int[] b) {
        List<int[]> res = new ArrayList<>();
        boolean insert = false;
        int st1 = b[0];
        int end1 = b[1]; 
        for (int i = 0; i < a.length; i++) {
            int st2 = a[i][0];
            int end2 = a[i][1];   
            if (!insert && st1 > end2) {
                res.add(a[i]);
            }
            else if (st2 > end1) {
                if (!insert) {
                    res.add(new int[]{st1, end1});
                    insert = true;
                }
                res.add(a[i]);
            }
            else {
                st1 = Math.min(st1, st2);
                end1 = Math.max(end1, end2);
            }
        }
        if (!insert) {
            res.add(new int[]{st1, end1});
        } 
        return res.toArray(new int[0][]);
    }
}