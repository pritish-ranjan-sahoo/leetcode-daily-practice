class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] inDeg = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i =0;i<numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int [] preq : prerequisites) {
            graph.get(preq[1]).add(preq[0]);
            inDeg[preq[0]]++;
        }

        for(int i = 0; i<inDeg.length; i++) {
            if(inDeg[i]==0) q.add(i);
        }

        int count = 0;
        while(!q.isEmpty()){
            int node = q.remove();

            for(int i : graph.get(node)) {
                inDeg[i]--;
                if(inDeg[i]==0) {
                    q.add(i);
                }
            }
            count++;
        }

        return count==numCourses;    
    }
}