import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * MyGraph
 * 
 * @param <E>
 */
public class MyGraph<E> implements DynamicGraph<E> {

    private List<Edge>[] edges;
    private List<Vertex<E>> vertices;
    private int numV;
    private boolean directed;

    /**
     * Constructs a graph with the specified number of
     * vertices and directionality.
     * 
     * @param numV     the number of vertices
     * @param directed the directionality flag
     */
    @SuppressWarnings("unchecked")
    public MyGraph(int numV, boolean directed) {
        this.numV = numV;
        this.directed = directed;
        edges = new List[numV];
        vertices = new ArrayList<Vertex<E>>();
        for (int i = 0; i < numV; i++) {
            edges[i] = new LinkedList<Edge>();
        }
    }

    /**
     * Return the number of vertices.
     * 
     * @return The number of vertices
     */
    @Override
    public int getNumV() {
        return numV;
    }

    /**
     * Determine whether this is a directed graph.
     * 
     * @return true if this is a directed graph
     */
    @Override
    public boolean isDirected() {
        return directed;
    }

    /**
     * Insert a new edge into the graph.
     * 
     * @param edge The new edge
     */
    @Override
    public void insert(Edge edge) {
        edges[edge.getSource()].add(edge);
        if (!isDirected()) {
            edges[edge.getDest()].add(new Edge(edge.getDest(),
                    edge.getSource(),
                    edge.getWeight()));
        }
    }

    /**
     * Determine whether an edge exists.
     * 
     * @param source The source vertex
     * @param dest   The destination vertex
     * @return true if there is an edge from source to dest
     */
    @Override
    public boolean isEdge(int source, int dest) {
        if (source >= 0 && source < edges.length) {
            return edges[source].contains(new Edge(source, dest));
        }
        return false;
    }

    /**
     * Get the edge between two vertices. If an
     * edge does not exist, an Edge with a weight
     * of Double.POSITIVE_INFINITY is returned.
     * 
     * @param source The source
     * @param dest   The destination
     * @return the edge between these two vertices
     */
    @Override
    public Edge getEdge(int source, int dest) {
        Edge target = new Edge(source, dest, Double.POSITIVE_INFINITY);
        for (Edge edge : edges[source]) {
            if (edge.equals(target)) // in (override) equals method, weight is not considered.
                return edge; // Desired edge found, return it.
        }
        // Assert: All edges for source checked.
        return target; // Desired edge not found.
    }

    /**
     * Return an iterator to the edges connected
     * to a given vertex.
     * 
     * @param source The source vertex
     * @return An iterator to the vertices
     *         connected to source
     */
    @Override
    public Iterator<Edge> edgeIterator(int source) {
        return edges[source].iterator();
    }

    /**
     * Generates a new vertex by given parameters.
     * 
     * @param label  the label of vertex
     * @param weight the weight of vertex
     * @return the new vertex
     */
    @Override
    public Vertex<E> newVertex(String label, double weight) {
        return new Vertex<E>(label, weight);
    }

    /**
     * Adds the given vertex to the graph if the vertex id is unique.
     * 
     * @param new_vertex the vertex to be added
     * @return true if vertex id is unique, otherwise false
     */
    @Override
    public boolean addVertex(Vertex<E> new_vertex) {
        for (Vertex<E> v : vertices) {
            if (v.getId() == new_vertex.getId()) {
                System.out.println("--Vertex cannot be added to the graph, vertex id must be unique!");
                return false;
            }
        }
        vertices.add(new_vertex);
        return true;
    }

    /**
     * Adds an edge between the given two vertices in the graph. If vertices
     * are not created yet, it does not insert the edge.
     * 
     * @param vertexID1 the source vertex
     * @param vertexID2 the destination vertex
     * @param weight    the edge weight
     */
    @Override
    public boolean addEdge(int vertexID1, int vertexID2, double weight) {
        /* */
        boolean flag1 = false;
        boolean flag2 = false;
        for (Vertex<E> vertex : vertices) {
            if (vertex.getId() == vertexID1)
                flag1 = true;
            else if (vertex.getId() == vertexID2)
                flag2 = true;
            if (flag1 && flag2) {
                insert(new Edge(vertexID1, vertexID2, weight));
                return true;
            }
        }
        System.out.println("edge -> [(" + vertexID1 + ", " + vertexID2 + "): " + weight + "]");
        if (!flag1)
            System.out.println("--Edge cannot be created, " + vertexID1 + " (vertex) is not exist!");
        else if (!flag2)
            System.out.println("--Edge cannot be created, " + vertexID2 + " (vertex) is not exist!");
        else
            System.out.println(
                    "--Edge cannot be created, " + vertexID1 + ", " + vertexID2 + " (vertices) are not exist!");

        return false;
    }

    /**
     * Removes the edge between the given two vertices.
     * 
     * @param vertexID1 the source vertex
     * @param vertexID2 the destination vertex
     * @return true if the edge is on the graph, otherwise false
     */
    @Override
    public boolean removeEdge(int vertexID1, int vertexID2) {
        boolean flag = (isEdge(vertexID1, vertexID2)) ? edges[vertexID1].remove(getEdge(vertexID1, vertexID2)) : false;
        if (!flag) // unsuccessfull
            System.out.println("--Unsuccessfull remove operation. No edge between given vertices! -> (" + vertexID1
                    + ", " + vertexID2 + ")");
        else
            System.out.println("--Edge is removed. (" + vertexID1 + ", " + vertexID2 + ")");
        return flag;
    }

    /**
     * Removes the vertex from the graph with respect to the given vertex id.
     * 
     * @param vertexID the vertex id
     * @return the removed vertex or null (vertex is not on the graph)
     */
    @Override
    public Vertex<E> removeVertex(int vertexID) {

        Vertex<E> returnVertex = null;

        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getId() == vertexID)
                returnVertex = vertices.remove(i);
        }
        if (returnVertex == null)
            System.out.println("--Invalid vertex id!");
        return returnVertex;
    }

    /**
     * Removes the vertices that have the given label from the graph.
     * 
     * @param label the vertex label
     * @return the removed vertex or null (vertex is not on the graph)
     */
    @Override
    public Vertex<E> removeVertex(String label) {

        Vertex<E> returnVertex = null;

        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getLabel().equals(label))
                returnVertex = vertices.remove(i);
        }
        if (returnVertex == null)
            System.out.println("--Invalid vertex label!");
        return returnVertex;
    }

    /**
     * Filters the vertices by the given user-defined property and returns a
     * subgraph
     * of the graph.
     * 
     * @param key    the key, user defined property
     * @param filter the filter to be searched
     * @return the subgraph of the graph
     */
    @Override
    public MyGraph<E> filterVertices(String key, String filter) {

        // numV will be changed after adding vertices to the subgraph.
        MyGraph<E> subGraph = new MyGraph<>(this.numV, this.directed);
        int index = -1;

        try {
            Field[] fields = Vertex.class.getDeclaredFields(); // get data fields of Vertex<E> class
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                if (fields[i].getName().equals(key)) {
                    index = i; // get the index number of data field which equals to the key
                }
            }

            if (index != -1) {
                for (Vertex<E> v : vertices) {
                    try {
                        String str = String.valueOf(fields[index].get(v));
                        if (str.equals(filter)) {
                            subGraph.addVertex(v); // adding vertex to the subgraph
                        }
                    } catch (IllegalArgumentException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                if (subGraph.vertices.size() == 0)
                    System.out.println("NO vertex found with the given filter!");
            } else
                System.out.println("The given key is NOT the data field of the vertex!");

        } catch (SecurityException e) {
            e.printStackTrace();
        }

        subGraph.numV = subGraph.vertices.size(); // subgraph vertex number

        /* Creating edges between vertices on subgraph, if edge is on the graph. */
        for (int j = 0; j < subGraph.numV - 1; j++) {
            for (int k = j + 1; k < subGraph.numV; k++) {
                int source = subGraph.vertices.get(j).getId();
                int dest = subGraph.vertices.get(k).getId();
                if (this.isEdge(source, dest)) { // edge is on the graph
                    double weight = this.getEdge(source, dest).getWeight();
                    subGraph.addEdge(source, dest, weight);
                }
            }
        }
        return subGraph;
    }

    /**
     * Generates the adjacency matrix representation of the graph and returns the
     * matrix.
     * 
     * @return the matrix
     */
    @Override
    public double[][] exportMatrix() {
        double[][] matrix = new double[numV][numV];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = getEdge(i, j).getWeight();
            }
        }
        return matrix;
    }

    /**
     * Prints the graph in adjacency list format.
     */
    @Override
    public void printGraph() {

        int bound = -1;

        if (vertices.size() > 0)
            bound = vertices.get(vertices.size() - 1).getId();
        for (int i = 0; i < bound; i++) {
            Iterator<Edge> itr = edgeIterator(i);
            boolean flag = true;
            while (itr.hasNext()) {
                Edge edge = itr.next();
                if (flag) {
                    System.out.print(edge.getSource() + " -> ");
                    flag = false;
                }
                int dest = edge.getDest();
                System.out.print(dest);
                if (itr.hasNext())
                    System.out.print(" -> ");
            }
            if (!flag)
                System.out.println();

        }
    }

    /* HELPER FUNCTIONS */
    /**
     * Gets the vertex from vertices.
     * 
     * @param vertexID the vertex id
     * @return the vertex
     */
    public Vertex<E> getVertex(int vertexID) {
        return vertices.get(vertexID);
    }

    /**
     * Displays the vertices on the graph.
     */
    public void displayVertices() {
        if (vertices.isEmpty())
            System.out.println("Vertices list is empty.");
        for (Vertex<E> v : vertices)
            System.out.println(v);
    }

    /**
     * Displays the edges on the graph.
     */
    public void displayEdges() {
        if (edges.length == 0)
            System.out.println("Edges list is empty.");

        for (int i = 0; i < edges.length; i++) {
            Iterator<Edge> itr = edgeIterator(i);
            while (itr.hasNext()) {
                System.out.println(itr.next());
            }
        }
    }

    /**
     * Finds the edge with given index.
     * 
     * @param index the index to find edge
     * @return the edge
     */
    public List<Edge> getIndexOfEdge(int index) {
        return edges[index];
    }

    /**
     * Calculates edge list size.
     * 
     * @return the edges list size
     */
    public int getSizeOfEdges() {
        return edges.length;
    }

}
