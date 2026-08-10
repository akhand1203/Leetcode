class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        if (hour <= n - 1) return -1;

        int left = 1, right = 10_000_000;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canReach(dist, hour, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canReach(int[] dist, double hour, int speed) {
        int n = dist.length;
        double time = 0;

        for (int i = 0; i < n - 1; i++) {
            time += Math.ceil((double) dist[i] / speed);
        }

        time += (double) dist[n - 1] / speed;

        return time <= hour;
    }
}