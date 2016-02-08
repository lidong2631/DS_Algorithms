import java.util.*;

class Graph {
    int V;      //No. of vertices
    List<List<Integer>> adj;      //adjacency list

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<List<Integer>>();
        for(int i=0; i<V; i++) {
            List<Integer> tmp = new ArrayList<Integer>();
            adj.add(tmp);
        }
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    public void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        for(int i=0; i<adj.get(v).size(); i++)  //参照clone graph
            if(!visited[adj.get(v).get(i)])
                DFSUtil(adj.get(v).get(i), visited);
    }

    public void DFS(int v) {
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++)
            visited[i] = false;
        DFSUtil(v, visited);
    }
}

http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/

//注意java中不能create an array of generic type 即不能以ArrayList为元素建立数组 
//见http://stackoverflow.com/questions/8559092/create-an-array-of-arraylists