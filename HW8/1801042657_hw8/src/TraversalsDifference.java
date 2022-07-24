
/**
 * Class for using the Breadth and Depth first traversals to find the difference.
 */
public class TraversalsDifference {
    
    /**
     * 
     * @param <E>
     * @param graph the graph
     * @return      the difference between the total distances of two traversal methods
     */
    public static <E> double traversalDifference(MyGraph<E> graph) {

        double bfsResult = BreadthFirstSearch.wrapperBFS(graph);
        System.out.println("Shortest Path BFS Algorithm");
        System.out.println(bfsResult + "\n");

        DepthFirstSearch<E> dfs = new DepthFirstSearch<E>();
        double dfsResult = dfs.depthFirstSearch(graph);
        System.out.println("Shortest Path DFS Algorithm");
        System.out.println(dfsResult + "\n");
       
        System.out.println("Difference");
        return (bfsResult > dfsResult) ? (bfsResult - dfsResult) : (dfsResult - bfsResult);
    }
}
