
/**
 * DynamicGraph interface
 * 
 * @param <E>
 */
public interface DynamicGraph<E> extends Graph {

    /**
     * Generates a new vertex by given parameters.
     * 
     * @param label  the label of vertex
     * @param weight the weight of vertex
     * @return the new vertex
     */
    Vertex<E> newVertex(String label, double weight);

    /**
     * Adds the given vertex to the graph.
     * 
     * @param new_vertex the vertex to be added
     * @return true if vertex id is unique, otherwise false
     */
    boolean addVertex(Vertex<E> new_vertex);

    /**
     * Adds an edge between the given two vertices in the graph.
     * 
     * @param vertexID1 the source vertex
     * @param vertexID2 the destination vertex
     * @param weight    the edge weight
     * @return          true if vertices exist, otherwise false
     */
    boolean addEdge(int vertexID1, int vertexID2, double weight);

    /**
     * Removes the edge between the given two vertices.
     * 
     * @param vertexID1 the source vertex
     * @param vertexID2 the destination vertex
     * @return true if the edge is on the graph, otherwise false
     */
    boolean removeEdge(int vertexID1, int vertexID2);

    /**
     * Removes the vertex from the graph with respect to the given vertex id.
     * 
     * @param vertexID the vertex id
     * @return the removed vertex or null (vertex is not on the graph)
     */
    Vertex<E> removeVertex(int vertexID);

    /**
     * Removes the vertices that have the given label from the graph.
     * 
     * @param label the vertex label
     * @return the removed vertex or null (vertex is not on the graph)
     */
    Vertex<E> removeVertex(String label);

    /**
     * Filters the vertices by the given user-defined property and returns a subgraph
     * of the graph.
     * 
     * @param key    the key, user defined property
     * @param filter the filter to be searched
     * @return the subgraph of the graph
     */
    MyGraph<E> filterVertices(String key, String filter);

    /**
     * Generates the adjacency matrix representation of the graph and returns the
     * matrix.
     * 
     * @return the matrix
     */
    double[][] exportMatrix();

    /**
     * Prints the graph in adjacency list format.
     */
    void printGraph();
}
