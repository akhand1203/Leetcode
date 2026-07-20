class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);   // -1 means uncolored

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!bfs(graph, i, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean bfs(int[][] graph, int start, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int i = 0; i < graph[node].length; i++) {
                int neigh = graph[node][i];

                if (color[neigh] == -1) {
                    color[neigh] = 1 - color[node];   // opposite color
                    q.add(neigh);
                } else if (color[neigh] == color[node]) {
                    return false;   // same color as neighbor -> conflict
                }
            }
        }
        return true;
    }
}