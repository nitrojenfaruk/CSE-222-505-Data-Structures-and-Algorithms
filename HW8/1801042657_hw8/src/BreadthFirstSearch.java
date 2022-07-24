import java.util.*;

/**
 * Class to implement the breadth-first search algorithm.
 * 
 */

public class BreadthFirstSearch {

    /**
     * 
     * @param <E>
     * @param graph the graph
     * @return      the total distance of the path when accessing each vertex
     */
    public static <E> double wrapperBFS(MyGraph<E> graph){
        return breadthFirstSearch(graph, 0);
    }   
    /**
     * Perform a breadth-first search of a graph.
     * 
     * @param graph The graph to be searched
     * @param start The start vertex
     * @return The array of parents
     */
    private static <E> double breadthFirstSearch(MyGraph<E> graph, int start) {

        List<Integer> theQueue = new ArrayList<Integer>();
        double totalDistance = 0;
        
        List<Edge> identified = new ArrayList<Edge>(graph.getNumV());
        for (int i = 0; i < graph.getNumV(); i++) {
            identified.add(null);
        }
        /*
         * Mark the start vertex as identified and insert it
         * into the queue
         */
        Iterator<Edge> iter = graph.edgeIterator(0);

        identified.set(0, iter.next());  // edge
        theQueue.add(start);   // id 
        

        /* While the queue is not empty */
        while (!theQueue.isEmpty()) {
            /*
             * Take a vertex, current, out of the queue.
             * (Begin visiting current).
             */
            int current = theQueue.remove(0);   
            /* Examine each vertex, neighbor, adjacent to current. */
            Iterator<Edge> itr = graph.edgeIterator(current);

            while (itr.hasNext()) {
                Edge edge = itr.next();
                int neighbor = edge.getDest();
                /* ADDED PART - BEGIN*/
                if(identified.get(neighbor) != null){
                    double weight = identified.get(neighbor).getWeight();  // get weight of the neighbor
                    if(weight > edge.getWeight()){  // if old weight is bigger than current weight, remove old data. 
                        int index = theQueue.indexOf(neighbor);  // finds neighbor
                        if(index != -1){    
                            theQueue.remove(index);   // remove old value
                            theQueue.add(neighbor);   // add new value to the queue
                            totalDistance -= weight - edge.getWeight();  // calculating the new total distance
                        }
                    }
                }
                /* END */
                // If neighbor has not been identified
                if (identified.get(neighbor) == null) {
                    // Mark it identified.
                    identified.set(neighbor, edge);
                    // Place it into the queue.
                    theQueue.add(neighbor);
                    // total distance calculation
                    totalDistance += edge.getWeight();   // calculating the new total distance
                }
                
            }
            // Finished visiting current.
        }
        return totalDistance;
    }
}
