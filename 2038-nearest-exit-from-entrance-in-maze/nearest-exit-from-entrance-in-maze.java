class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        // Add entrance to queue
        queue.offer(new int[] { entrance[0], entrance[1], 0 }); // row, col, steps
        visited[entrance[0]][entrance[1]] = true;

        int[][] directions = { {1,0}, {0,1}, {-1,0}, {0,-1} };

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1], steps = curr[2];

            // If it's not entrance and is at the border → exit
            if ((r == 0 || c == 0 || r == m - 1 || c == n - 1) && (r != entrance[0] || c != entrance[1])) {
                return steps;
            }

            for (int[] dir : directions) {
                int newR = r + dir[0];
                int newC = c + dir[1];

                if (newR >= 0 && newR < m && newC >= 0 && newC < n && maze[newR][newC] == '.' && !visited[newR][newC]) {
                    visited[newR][newC] = true;
                    queue.offer(new int[] { newR, newC, steps + 1 });
                }
            }
        }

        return -1; // No exit found
    }
}
