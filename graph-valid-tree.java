class Solution {
    public boolean validTree(int n, int [][]edges) {
        int m = edges.length;
        if (m != n - 1) return false;  // condition for tree

        boolean vis[] = new boolean[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // build undirected graph
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // BFS traversal
        int cnt = 1;
        Queue<Integer> q = new LinkedList<>();
        vis[0] = true;
        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int nei : adj.get(curr)) {
                if (!vis[nei]) {
                    vis[nei] = true;
                    cnt++;
                    q.add(nei);
                }
            }
        }

        // valid tree if all nodes visited
        return cnt == n;
    }
}
