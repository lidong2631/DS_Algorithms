class Graph {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[];        //array of vertices
    private int adjMat[][];     //adjacency matrix
    private int nVerts;         //current number of vertices

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for(int j=0; j<MAX_VERTS; j++)      //set adjacency matrix to 0
            for(int k=0; k<MAX_VERTS; k++)
                adjMat[j][k] = 0;
    }

    public void addVertex(char c) {
        vertexList[nVerts++] = new Vertex(c);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }
}