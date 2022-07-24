
/**
 * Main Class
 * @author Sefa
 *
 */
public class Main {

    public static <T> void main(String[] args) throws Exception {
    

    MyGraph<Integer> graph = new MyGraph<>(5, true);
    

    System.out.println("Vertices list:");
    graph.displayVertices();
    System.out.println("------");
    System.out.println("vertex: " + graph.newVertex("v0", 10));
    System.out.println("------");
    System.out.println("Vertices list:");
    graph.displayVertices();
    System.out.println("--New vertex is created but has not added to the vertices list.");
    System.out.println();
    System.out.println();
       
    Vertex.count = -1; // necessary for contiguous id's

    Vertex<Integer> v0 = graph.newVertex("v0", 10);
    Vertex<Integer> v1 = graph.newVertex("v1", 20);
    Vertex<Integer> v2= graph.newVertex("v2", 30);
    Vertex<Integer> v3 = graph.newVertex("v3", 40);
    Vertex<Integer> v4 = graph.newVertex("v4", 50);
    System.out.println("Vertices to be added:");
    System.out.println("vertex -> " + v0);
    System.out.println("vertex -> " + v1);
    System.out.println("vertex -> " + v2);
    System.out.println("vertex -> " + v3);
    System.out.println("vertex -> " + v4);
    graph.addVertex(v0);
    graph.addVertex(v1);
    graph.addVertex(v2);
    graph.addVertex(v3);
    graph.addVertex(v4);
    System.out.println("Vertices list:");
    System.out.println("--------------");
    graph.displayVertices();
    System.out.println();

    System.out.println("Invalid vertex addition to the graph:");
    System.out.println("vertex -> " + v4);
    graph.addVertex(v4);
    System.out.println();
    System.out.println();

    
    graph.addEdge(0, 1, 10);
    graph.addEdge(0, 3, 20);
    graph.addEdge(1, 2, 30);
    graph.addEdge(2, 4, 40);
    graph.addEdge(3, 0, 50);
    graph.addEdge(4, 3, 60);
    System.out.println("Added edges:");
    System.out.println("------------");
    graph.displayEdges();
    System.out.println();
    System.out.println("Invalid edge addition to the graph:");
    graph.addEdge(9, 2, 100);
    System.out.println();
   
    
    System.out.println("Invalid remove operation:");
    System.out.println("------------------------");
    System.out.println("Edges on the graph:");
    graph.displayEdges();
    System.out.println();
    graph.removeEdge(7, 0);
    System.out.println();
    System.out.println();

    System.out.println("Successfull remove operation:");
    System.out.println("-----------------------------");
    System.out.println("Edges on the graph:");
    graph.displayEdges();
    System.out.println();
    graph.removeEdge(0, 1);
    System.out.println();
    System.out.println("Edges on the graph after removing the edge:");
    graph.displayEdges();
    System.out.println();
    System.out.println();

    
    System.out.println("Remove vertex with id:");
    System.out.println("-----------------------");
    System.out.println("Vertices on the graph:");
    graph.displayVertices();
    System.out.println();
    System.out.println("Vertex to be removed -> " + v4);
    System.out.println();
    graph.removeVertex(v4.getId());
    System.out.println("Vertices on the graph after remove operation:");
    graph.displayVertices();
    System.out.println();
    System.out.println();

    Vertex<Integer> v89 = graph.newVertex("v89", 100);

    System.out.println("(Unsuccessfull) Remove vertex with id:");
    System.out.println("-----------------------");
    System.out.println("Vertices on the graph:");
    graph.displayVertices();
    System.out.println();
    System.out.println("Vertex to be removed -> " + v89);
    System.out.println();
    graph.removeVertex(v89.getId());
    System.out.println();
    System.out.println("Vertices on the graph after remove operation:");
    graph.displayVertices();
    System.out.println();
    System.out.println();
    System.out.println();


    System.out.println("Remove vertex with label:");
    System.out.println("-----------------------");
    System.out.println("Vertices on the graph:");
    graph.displayVertices();
    System.out.println();
    System.out.println("Vertex to be removed -> " + v3);
    System.out.println();
    graph.removeVertex(v3.getLabel());
    System.out.println("Vertices on the graph after remove operation:");
    graph.displayVertices();
    System.out.println();
    System.out.println();


    System.out.println("(Unsuccessfull) Remove vertex with label:");
    System.out.println("-----------------------");
    System.out.println("Vertices on the graph:");
    graph.displayVertices();
    System.out.println();
    System.out.println("Vertex to be removed -> " + v89);
    System.out.println();
    graph.removeVertex(v89.getLabel());
    System.out.println();
    System.out.println("Vertices on the graph after remove operation:");
    graph.displayVertices();
    System.out.println();
    System.out.println();

    MyGraph<Integer> graphTest2 = new MyGraph<Integer>(7, true);
    Vertex.count = -1; // necessary for contiguous id's

    graphTest2.addVertex(graphTest2.newVertex("v0", 5));
    graphTest2.addVertex(graphTest2.newVertex("v1", 10));
    graphTest2.addVertex(graphTest2.newVertex("v2", 5));
    graphTest2.addVertex(graphTest2.newVertex("v1", 20));
    graphTest2.addVertex(graphTest2.newVertex("v1", 30));
    graphTest2.addVertex(graphTest2.newVertex("v1", 5));
    graphTest2.addVertex(graphTest2.newVertex("v1", 5));

    graphTest2.addEdge(0, 1, 30);
    graphTest2.addEdge(0, 2, 40);
    graphTest2.addEdge(0, 3, 60);
    graphTest2.addEdge(0, 4, 70);
    graphTest2.addEdge(1, 3, 40);
    graphTest2.addEdge(1, 4, 35);
    graphTest2.addEdge(2, 5, 30);
    graphTest2.addEdge(2, 6, 50);
    graphTest2.addEdge(3, 4, 50);
    graphTest2.addEdge(5, 6, 40);
    
    String key = "weight";
    String filter = "5.0";
    System.out.println("key: " + key + " | " + "filter" + ": " + filter); // ...
    System.out.println("--------------------------");
    System.out.println();
    System.out.println("Graph:");
    System.out.println("------");
    graphTest2.displayVertices();
    graphTest2.printGraph();
    System.out.println();
    System.out.println("SubGraph:");
    System.out.println("---------");
    (graphTest2.filterVertices(key, filter)).displayVertices();
    (graphTest2.filterVertices(key, filter)).printGraph();
    System.out.println();
    System.out.println();
    
    key = "label";
    filter = "v1";
    System.out.println("key: " + key + " | " + "filter" + ": " + filter); // ...
    System.out.println("--------------------------");
    System.out.println();
    System.out.println("Graph:");
    System.out.println("------");
    graphTest2.displayVertices();
    graphTest2.printGraph();
    System.out.println();
    System.out.println("SubGraph:");
    System.out.println("---------");
    (graphTest2.filterVertices(key, filter)).displayVertices();
    (graphTest2.filterVertices(key, filter)).printGraph();
    System.out.println();
    System.out.println();

    key = "label";
    filter = "v35";
    System.out.println("key: " + key + " | " + "filter" + ": " + filter); // ...
    System.out.println("--------------------------");
    System.out.println();
    System.out.println("Graph:");
    System.out.println("------");
    graphTest2.displayVertices();
    graphTest2.printGraph();
    System.out.println();
    System.out.println("SubGraph:");
    System.out.println("---------");
    (graphTest2.filterVertices(key, filter)).printGraph();
    System.out.println();
    System.out.println();


    key = "dummy";
    filter = "v0";
    System.out.println("key: " + key + " | " + "filter" + ": " + filter); // ...
    System.out.println("--------------------------");
    System.out.println();
    System.out.println("Graph:");
    System.out.println("------");
    graphTest2.displayVertices();
    graphTest2.printGraph();
    System.out.println();
    System.out.println("SubGraph:");
    System.out.println("---------");
    (graphTest2.filterVertices(key, filter)).printGraph();
    System.out.println();
    System.out.println();
    

    MyGraph<Integer> graphForMatrix = new MyGraph<Integer>(7, true);
    Vertex.count = -1; // necessary for contiguous id's

    graphForMatrix.addVertex(graphForMatrix.newVertex("v0", 10));
    graphForMatrix.addVertex(graphForMatrix.newVertex("v1", 20));
    graphForMatrix.addVertex(graphForMatrix.newVertex("v2", 30));
    graphForMatrix.addVertex(graphForMatrix.newVertex("v3", 40));
    graphForMatrix.addVertex(graphForMatrix.newVertex("v4", 50));
    graphForMatrix.addVertex(graphForMatrix.newVertex("v5", 60));
    graphForMatrix.addVertex(graphForMatrix.newVertex("v6", 70));

    graphForMatrix.addEdge(0, 1, 30);
    graphForMatrix.addEdge(0, 2, 40);
    graphForMatrix.addEdge(0, 3, 60);
    graphForMatrix.addEdge(0, 4, 70);
    graphForMatrix.addEdge(1, 3, 40);
    graphForMatrix.addEdge(1, 4, 35);
    graphForMatrix.addEdge(2, 0, 80);
    graphForMatrix.addEdge(2, 5, 30);
    graphForMatrix.addEdge(2, 6, 50);
    graphForMatrix.addEdge(3, 4, 60);
    graphForMatrix.addEdge(5, 6, 50);
    graphForMatrix.addEdge(5, 1, 40);
    graphForMatrix.addEdge(6, 0, 80);
    graphForMatrix.addEdge(6, 2, 90);

    System.out.println("Graph:");
    System.out.println("------");
    graphForMatrix.printGraph();
    System.out.println();
    System.out.println("Matrix Representation of The Graph:");
    System.out.println("-----------------------------------");

    double[][] matrix = graphForMatrix.exportMatrix();   // exportMatrix function
    
    /* printing the matrix graph */
    for (int i = 0; i < matrix.length; i++) {
        System.out.print("[");
        for (int j = 0; j < matrix[i].length; j++) {

            System.out.print(matrix[i][j]);
            if(j != matrix.length-1)
                System.out.print(", ");
        }
        System.out.println("]");
    }
    System.out.println();
    System.out.println();


    MyGraph<Integer> emptyGraph = new MyGraph<Integer>(7, true);
    Vertex.count = -1; // necessary for contiguous id's
    System.out.println("Empty Graph:");
    System.out.println("------");
    emptyGraph.printGraph();
    System.out.println();
    System.out.println("Matrix Representation of The Graph:");
    System.out.println("-----------------------------------");

    double[][] matrix2 = emptyGraph.exportMatrix();   // exportMatrix function
    
    /* printing the matrix graph */
    for (int i = 0; i < matrix2.length; i++) {
        System.out.print("[");
        for (int j = 0; j < matrix2[i].length; j++) {

            System.out.print(matrix2[i][j]);
            if(j != matrix2.length-1)
                System.out.print(", ");
        }
        System.out.println("]");
    }
    System.out.println();
    System.out.println();
  

    MyGraph<Integer> graphTest = new MyGraph<Integer>(6, true);
    Vertex.count = -1; // necessary for contiguous id's

    graphTest.addVertex(graphTest.newVertex("v10", 0));
    graphTest.addVertex(graphTest.newVertex("v11", 0));
    graphTest.addVertex(graphTest.newVertex("v12", 0));
    graphTest.addVertex(graphTest.newVertex("v13", 0));
    graphTest.addVertex(graphTest.newVertex("v14", 0));
    graphTest.addVertex(graphTest.newVertex("v15", 0));

    graphTest.addEdge(0, 1, 10);
    graphTest.addEdge(0, 2, 20);
    graphTest.addEdge(1, 5, 40);
    graphTest.addEdge(1, 3, 50);
    graphTest.addEdge(2, 3, 30);
    graphTest.addEdge(2, 4, 20);


    System.out.println("BFS and DFS Traversal");
    System.out.println("---------------------");
    System.out.println("Edges:");
    System.out.println("------");
    graphTest.displayEdges();
    System.out.println();
    System.out.println(TraversalsDifference.traversalDifference(graphTest));
    System.out.println();
    System.out.println();

    System.out.println("BFS and DFS Traversal");
    System.out.println("---------------------");
    System.out.println("Edges:");
    System.out.println("------");
    graphForMatrix.displayEdges();
    System.out.println();
    System.out.println(TraversalsDifference.traversalDifference(graphForMatrix));
    System.out.println();
    System.out.println();
    
  

    MyGraph<Double> gDjikstra = new MyGraph<Double>(3, true);
    Vertex.count = -1; // necessary for contiguous id's

    Vertex<Double> g0 = gDjikstra.newVertex("v0", 5);
    Vertex<Double> g1 = gDjikstra.newVertex("v1", 10);
    Vertex<Double> g2 = gDjikstra.newVertex("v2", 20);

    gDjikstra.addVertex(g0);
    gDjikstra.addVertex(g1);
    gDjikstra.addVertex(g2);

    gDjikstra.addEdge(0, 1, 4);
    gDjikstra.addEdge(0, 2, 8);
    gDjikstra.addEdge(1, 2, 6);

    g0.setBoostVal(2.0);
    g1.setBoostVal(3.0);
    g2.setBoostVal(0.0);

    System.out.println("Edges and Vertices:");
    System.out.println("------");
    gDjikstra.displayEdges();
    gDjikstra.displayVertices();
    System.out.println();
    BoostedDijkstrasAlgorithm.dijkstrasAlgorithm(gDjikstra, g0);
    System.out.println();



    MyGraph<Double> graphDijkstra = new MyGraph<>(5, true);
    Vertex.count = -1; // necessary for contiguous id's

    Vertex<Double> gv0 = graphDijkstra.newVertex("gv0", 10);
    Vertex<Double> gv1 = graphDijkstra.newVertex("gv1", 10);
    Vertex<Double> gv2 = graphDijkstra.newVertex("gv2", 10);
    Vertex<Double> gv3 = graphDijkstra.newVertex("gv3", 10);
    Vertex<Double> gv4 = graphDijkstra.newVertex("gv4", 10);

    graphDijkstra.addVertex(gv0);
    graphDijkstra.addVertex(gv1);
    graphDijkstra.addVertex(gv2);
    graphDijkstra.addVertex(gv3);
    graphDijkstra.addVertex(gv4);

    graphDijkstra.addEdge(0, 1, 10);
    graphDijkstra.addEdge(0, 3, 30);
    graphDijkstra.addEdge(0, 4, 100);
    graphDijkstra.addEdge(1, 2, 50);
    graphDijkstra.addEdge(2, 4, 10);
    graphDijkstra.addEdge(3, 2, 20);
    graphDijkstra.addEdge(3, 4, 60);


    gv0.setBoostVal(0.0);
    gv1.setBoostVal(0.0);
    gv2.setBoostVal(0.0);
    gv3.setBoostVal(0.0);
    gv4.setBoostVal(0.0);

    System.out.println();
    System.out.println("Edges and Vertices (Boost value of vertices = 0):");
    System.out.println("------");
    graphDijkstra.displayEdges();
    graphDijkstra.displayVertices();
    System.out.println();
    BoostedDijkstrasAlgorithm.dijkstrasAlgorithm(graphDijkstra, gv0);
    System.out.println();
    System.out.println();


    gv0.setBoostVal(3.0);
    gv1.setBoostVal(20.0);
    gv2.setBoostVal(5.0);
    gv3.setBoostVal(15.0);
    gv4.setBoostVal(10.0);

    System.out.println();
    System.out.println("Edges and Vertices (Non-zero boost values):");
    System.out.println("------");
    graphDijkstra.displayEdges();
    graphDijkstra.displayVertices();
    System.out.println();
    BoostedDijkstrasAlgorithm.dijkstrasAlgorithm(graphDijkstra, gv0);
    System.out.println();
    System.out.println();


    

  
   

    }
}
