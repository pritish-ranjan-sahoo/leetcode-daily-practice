class Solution {
    class Node {
        int src;
        int dest;
        int time;

        Node(int s, int d, int t) {
            this.src = s;
            this.dest = d;
            this.time = t;
        }
    }

    public void findSource(int[][] grid, Queue<Node> q) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Node(i, j, 0));
                }
            }
        }
    }

    public boolean allRotten(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public int orangesRotting(int[][] grid) {
        Queue<Node> q = new ArrayDeque<>();
        int m = grid.length - 1;
        int n = grid[0].length - 1;

        findSource(grid, q);
        int maxTime = 0;

        while (!q.isEmpty()) {
            Node first = q.remove();

            // check 4-Direction
            // Top
            if (first.src != 0 && grid[first.src - 1][first.dest] == 1) {
                grid[first.src - 1][first.dest] = 2;
                q.add(new Node(first.src - 1, first.dest, first.time+1));
                maxTime = Math.max(maxTime, first.time+1);
            }

            // bottom
            if (first.src != m && grid[first.src + 1][first.dest] == 1) {
                grid[first.src + 1][first.dest] = 2;
                q.add(new Node(first.src + 1, first.dest, first.time+1));
                maxTime = Math.max(maxTime, first.time+1);
            }

            // left
            if (first.dest != 0 && grid[first.src][first.dest - 1] == 1) {
                grid[first.src][first.dest - 1] = 2;
                q.add(new Node(first.src, first.dest - 1, first.time+1));
                maxTime = Math.max(maxTime, first.time+1);
            }

            // right
            if (first.dest != n && grid[first.src][first.dest + 1] == 1) {
                grid[first.src][first.dest + 1] = 2;
                q.add(new Node(first.src, first.dest + 1, first.time+1));
                maxTime = Math.max(maxTime, first.time+1);
            }

        }

        return allRotten(grid) ? maxTime : -1;
    }
}