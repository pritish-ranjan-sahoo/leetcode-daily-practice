class Solution {
    public boolean safeNode(int[][] graph, int node, boolean[] safe, boolean[] vis) {
        if(safe[node]) return true;
        if(vis[node] && !safe[node]) return false;

        vis[node] = true;
        for(int nb : graph[node]) {
            if(!safeNode(graph, nb, safe, vis)) return false;
        }
        vis[node] = false;
        safe[node] = true;
        return true;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        boolean [] safe = new boolean[graph.length];
        boolean [] vis = new boolean[graph.length];

        for(int i =0;i<vis.length; i++) {
            if(!vis[i]) safeNode(graph, i, safe, vis);
        }

        for(int i =0;i<safe.length; i++) {
            if(safe[i]) ans.add(i);
        }

        return ans;

    }
}