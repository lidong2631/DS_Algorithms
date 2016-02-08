Minimum Weighted Spanning Tree

1 Find all the edges from the newest vertex to other vertices that are not in the tree. Put these edges in the priority queue.

2 Pick the edge with the lowest weight, and add this edge and its destination vertex to the tree.


Extraneous Edges

We should not have any edges in the priority queue that lead to vertices that are already in the tree. We could go through the

queue looking for and removing any such edges each time we added a new vertex to the tree. As it turns out, it is easier to keep

only one edge from the tree to a given fringe vertex in the prioirty queue at any given time. That is, the queue should contain

only one edge to each category 2 vertex.



1 The current vertex is placed in the tree

2 The edges adjacent to this vertex are placed in the priority queue

3 The edge with the minimum weight is removed from the priority queue. The destination vertex of this edge becomes the current vertex





The PriorityQ class uses an array to hold the members. As we noted, in a program dealing with large graphs, a heap would be more appropriate

than the array shown here. The PriorityQ class has been augmented with various methods. Find an edge with a given destination vertex with find().

It can also peek at an arbitrary member with peekN(), and remove an arbitrary member with removeN().

class Edge {
    public int srcVert;     //index of a vertex starting edge
    public int destVert;    //index of a vertex ending edge
    public int distance;    //distance from src to dest

    public Edge(int sv, int dv, int d) {
        srcVert = sv;
        destVert = dv;
        distance = d;
    }
}   //end class Edge



class PriorityQ {
    //array in sorted order, from max at 0 to min at size-1
    private final int SIZE = 20;
    private Edge[] queArray;
    private int size;

    public PriorityQ() {
        queArray = new Edge[SIZE];
        size = 0;
    }

    public void insert(Edge item) {
        int j;

        for(j=0; j<size; j++) {     //find place to insert
            if(item.distance>=queArray[j].distance)
                break;
        }

        for(int k=size-1; k>=j; k--)    //move items up
            queArray[k+1] = queArray[k];

        queArray[j] = item;     //insert item
        size++;
    }

    public Edge removeMin() {   //remove minimum item
        return queArray[--size];
    }

    public void removeN(int n) {    //remove item at n
        for(int j=n; j<size-1; j++)
            queArray[j] = queArray[j+1];
        size--;
    }

    public Edge peekMin() {     //peek at minimum item
        return queArray[size-1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public Edge peekN(int n) {
        return queArray[n];
    }

    public int find(int findDex) {      //find item with specified destVert value
        for(int j=0; j<size; j++) {
            if(queArray[j].destVert = findDex)
                return j;
        }
        return -1;
    }
}   //end class PriorityQ



class Vertex {
    public char label;
    public boolean isInTree;

    public Vertex(char lab) {
        label = lab;
        isInTree = false;
    }
}   //end class Vertex



class Graph {
    private final int MAX_VERTS = 20;
    private final int INFINITY = 1000000;
    private Vertex vertexList[];    //list of vertices
    private int adjMat[][]          //adjacency matrix
    private int nVerts;             //current number of vertices
    private int currentVert
    private PriorityQ thePQ;
    private int nTree;              //number of verts in tree


    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for(int j=0; j<MAX_VERTS; j++) {
            for(int k=0; k<MAX_VERTS; k++) {
                adjMat[j][k] = INFINITY;
            }
        }
        thePQ = new PriorityQ();
    }


    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }


    public void addEdge(int start, int end, int weight) {
        adjMat[start][end] = weight;
        adjMat[end][start] = weight;
    }


    public void mstw() {        //The method that creates the minimum spanning tree for a weighted graph, mstw()
        currVert = 0;

        while(nTree < nVerts-1) {
            vertexList[currVert].isInTree = true;
            nTree++;

            //insert edges adjacent to currVert into PQ
            for(int j=0; j<nVerts; j++) {    //for each vertex
                if(j==currVert)
                    continue;
                if(vertexList[j].isInTree)
                    continue;
                int distance = adjMat[currVert][j];
                if(distance==INFINITY)
                    continue;
                putInPQ(j, distance);
            }
            if(thePQ.size()==0) {
                System.out.println("GRAPH NOT CONNECTED!");
                return;
            }

            //remove edge with minimum distance, from PQ
            Edge theEdge = thePQ.removeMin();
            int sourceVert = theEdge.srcVert;
            currVert = theEdge.destVert;

            //display edge from source to current
            System.out.print(vertexList[sourceVert].label);
            System.out.print(vertexList[currentVert].label);
            System.out.print(" ");
        }   //end while(not all verts in tree)

        //mst is complete
        for(int j=0; j<nVerts; j++)
            vertexList[j].isInTree = false;
    }   //end mstw


    public void putInPQ(int newVert, int newDist) {
        //is there another edge with the same destination vertex?
        int queueIndex = thePQ.find(newVert);   //get edge's index
        if(queueIndex!=-1) {    //if there is one
            Edge tmpEdge = thePQ.peekN(queueIndex);
            int oldDist = tmpEdge.distance;
            if(oldDist > newDist) {     //if new edge shorter
                thePQ.removeN(queueIndex);  //remove old edge
                Edge theEdge = new Edge(currVert, newVert, newDist);
                thePQ.insert(theEdge);  //insert new edge
            }
            //else not action; just leave the old vertex there
        }
        else {  //no edge with same destination vertex
            Edge theEdge = new Edge(currVert, newVert, newDist);
            thePQ.insert(theEdge);
        }
    }    
}


































