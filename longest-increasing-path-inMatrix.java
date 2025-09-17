class Solution {
    private final int[][] DIRS = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    private int rows, cols;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        rows = matrix.length;
        cols = matrix[0].length;
        if (cols == 0) return 0;
        int[][] memo = new int[rows][cols]; // memo[r][c] = longest path starting from (r,c)
        int ans = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                ans = Math.max(ans, dfs(matrix, r, c, memo));
            } }
        return ans;
    }    private int dfs(int[][] matrix, int r, int c, int[][] memo) {
        if (memo[r][c] != 0) return memo[r][c]; // already computed
        int best = 1; // path length at least 1 (the cell itself)
        for (int[] d : DIRS) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols 
                && matrix[nr][nc] > matrix[r][c]) {
                best = Math.max(best, 1 + dfs(matrix, nr, nc, memo));
            } }
        memo[r][c] = best;
        return best;
    }
}
