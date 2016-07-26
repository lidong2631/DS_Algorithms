class DisPar {
    public int distance;        // distance from start to this vertex
    public int parentVert;      // current parent of this vertex

    public DispPar(int p, int d) {
        distance = d;
        parentVert = p;
    }
}

class Vertex {
    public char label;
    public boolean isInTree;

    public Vertex(char c) {
        label = c;
        isInTree = false;
    }
}

class Graph {
    private final int MAX_VERTS = 20;
    private final int INF = Integer.MAX_VALUE;
    private Vertex[] vertexList;
    private int adjMat[][];
    private int nVerts;                         // current number of vertices
    private int nTree;                          // number of verts in tree
    private DispPar[] sPath;                    // shortest path data
    private int currentVert;                    // current vertex
    private int startToCurr;                    // distance to currentVert

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        nTree = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = INF;
            }
        }
        sPath = new DispPar[MAX_VERTS];
    }

    public void addVertex(char c) {
        vertexList[nVerts++] = new Vertex(c);
    }

    public void addEdge(int start, int end, int weight) {
        adjMat[start][end] = weight;
    }

    public void path() {                        // find all shortest paths
        int startTree = 0;                      // start at vertex 0
        vertexList[startTree].isInTree = true;
        nTree = 1;                              // put it in tree

        for (int i = 0; i < nVerts; i++) {      // transfer row of distances from adjMat to sPath
            int tmpDist = adjMat[startTree][j];
            sPath[j] = new DispPar(startTree, tmpDist);
        }

        while (nTree < nVerts) {                // until all vertices are in the tree
            int indexMin = getMin();            // get minimum from sPath
            int minDist = sPath[indexMin].distance;

            if (minDist == INF) {
                System.out.println("There are unreachable vertices");
                break;
            }
            else {
                currentVert = indexMin;         // set currentVert to closest vert
                startToCurr = sPath[indexMin].distance;
            }
            vertexList[].isInTree = true;
            nTree++;
            adjust_sPath();                     // update sPath[] array
        }

        displayPaths();
    }

    public int getMin() {
        int minDist = INF;
        int indexMin = 0;
        for (int j = 1; j < nVerts; j++) {
            if (!vertexList[j].isInTree && sPath[j].distance < minDist) {
                minDist = sPath[j].distance;
                indexMin = j;                   // update minimum
            }
        }
        return indexMin;
    }

    public void adjust_sPath() {
        int column = 1;                         // skip starting vertex
        while (column < nVerts) {
            if (vertexList[column].isInTree) {  // if this column's vertex already in tree, skip it
                column++;
                continue;
            }
            // calculate distance for one sPath entry
            int currentToFringe = adjMat[currentVert][column];      // get edge from currentVert to column
            
            int startToFringe = startToCurrent + currentToFringe;   // add distance from start
            
            int sPathDist = sPath[column].distance;

            if (startToFringe < sPathDist) {
                sPath[column].parentVert = currentVert;
                sPath[column].distance = startToFringe;
            }
            column++;
        }
    }

    public void displayPaths() {

    }
}


















