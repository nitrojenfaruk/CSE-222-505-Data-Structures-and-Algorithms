import java.util.*;

/**
 * A class for calling Boosted Dijkstra's algorithm.
 * 
 */

public class BoostedDijkstrasAlgorithm {

    /**
     * Dijkstra’s Shortest-Path algorithm.
     * 
     * @param graph  The weighted graph to be searched
     * @param startV The start vertex
     */
    public static <E> void dijkstrasAlgorithm(MyGraph<E> graph, Vertex<E> startV) {

        int numV = graph.getNumV();
        HashSet<Integer> vMinusS = new HashSet<Integer>(numV);

        /* Contains the predecessors in the shortest path */
        int[] pred = new int[numV];
        /* Contains the distance in the shortest path */
        double[] dist = new double[numV];

        // Initialize V–S.
        for (int i = 0; i < numV; i++) {
            if (i != startV.getId()) {
                vMinusS.add(i);
            }
        }
        // Initialize pred and dist.
        for (int v : vMinusS) {
            pred[v] = startV.getId();
            dist[v] = graph.getEdge(startV.getId(), v).getWeight();
        }
        // Main loop
        while (vMinusS.size() != 0) {
            // Find the value u in V–S with the smallest dist[u].
            double minDist = Double.POSITIVE_INFINITY;
            int u = -1;
            for (int v : vMinusS) {
                if (dist[v] < minDist) {
                    minDist = dist[v];
                    u = v;
                }
            }
            // Remove u from vMinusS.
            vMinusS.remove(u);
            // Update the distances.
            Iterator<Edge> itr = graph.edgeIterator(u);
            while (itr.hasNext()) {
                Edge edge = itr.next();
                int v = edge.getDest();
                if (vMinusS.contains((Integer)v)) {
                    double weight = edge.getWeight();
                    E boost = graph.getVertex(u).getBoostVal();   // get the boost value of vertex u.
                    if (dist[u] + weight - (double) boost < dist[v]) {   // subtract boost value from distance + weight
                        dist[v] = dist[u] + weight - (double) boost;
                        pred[v] = u;
                    }
                }
            }

        }

        System.out.println("Vertex \t\t Shortest Distance");
        for (int i = 0; i < numV; i++)
            System.out.println(graph.getVertex(i).getId() + " \t\t " + dist[i]);

    }
}