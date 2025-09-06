class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Sort by distance from origin
        Arrays.sort(points, (a, b) -> distance(a) - distance(b));

        // Return first k points
        return Arrays.copyOfRange(points, 0, k);
    }

    // Squared distance (no sqrt needed)
    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}