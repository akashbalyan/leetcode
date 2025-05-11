class Solution {
    public int findCircleNum(int[][] isConnected) {
    int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinceCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, isConnected, visited);
                provinceCount++;
            }
        }

        return provinceCount;
    }

    private void dfs(int city, int[][] isConnected, boolean[] visited) {
        visited[city] = true;
        for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
            if (isConnected[city][neighbor] == 1 && !visited[neighbor]) {
                dfs(neighbor, isConnected, visited);
            }
        }
    }
}