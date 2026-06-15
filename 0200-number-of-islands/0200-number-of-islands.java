class Solution {
    class Node{
        int src;
        int dest;
        
        Node(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public void bfs(char[][] grid, Node source){
        Queue<Node> q = new ArrayDeque<>();
        int m = grid.length - 1;
        int n = grid[0].length - 1;

        grid[source.src][source.dest] = '2'; 
        q.add(source);
        
        while(!q.isEmpty()) {
            Node first = q.remove();

            // Top
            if (first.src != 0 && grid[first.src - 1][first.dest] == '1') {
                grid[first.src - 1][first.dest] = '2';
                q.add(new Node(first.src - 1, first.dest));
            }

            // bottom
            if (first.src != m && grid[first.src + 1][first.dest] == '1') {
                grid[first.src + 1][first.dest] = '2';
                q.add(new Node(first.src + 1, first.dest));
            }

            // left
            if (first.dest != 0 && grid[first.src][first.dest - 1] == '1') {
                grid[first.src][first.dest - 1] = '2';
                q.add(new Node(first.src, first.dest - 1));
            }

            // right
            if (first.dest != n && grid[first.src][first.dest + 1] == '1') {
                grid[first.src][first.dest + 1] = '2';
                q.add(new Node(first.src, first.dest + 1));
            }
        }
    }

    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid,new Node(i,j));
                    ans++;
                }
            }
        }

        return ans;
    }
}