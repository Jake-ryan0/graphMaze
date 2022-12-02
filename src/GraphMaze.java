
import edu.princeton.cs.algs4.*;

//TODO figure out SymbolGraph
//TODO generate txt file for SymbolGraph
//TODO figure out how to draw points associated with Vertices

/**
 GraphMaze represents a graph, and the necessary tools to solve a maze
 */
public class GraphMaze {
    private Graph graph;
    private int start;
    private int end;
    private static Queue<Integer> detours = new Queue<>();
    private static Queue<Iterable> totalPath = new Queue<>();


    /**
     * Gets the start value for the maze.
     *
     * @return the starting value
     */
    public int getStart() {
        return start;
    }

    /**
     * Sets the starting value for the maze.
     *
     * @param start the starting value
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * Sets end.
     *
     * @param end the end
     */
    public void setEnd(int end) {
        this.end = end;
    }

    /**
     * Gets end.
     *
     * @return the end
     */
    public int getEnd() {
        return end;
    }

    /**
     * Instantiates a new Graph maze.
     *
     * @param size the size of the maze.  must be a perfect square currently (e.g. 9, 25, 100)
     */
    public GraphMaze(int size){
        graph = new Graph(size);
        generateEdges();
    }

    /**
     * Get graph graph.
     *
     * @return the graph
     */
    public Graph getGraph(){
        return graph;
    }

    /**
     * Gets the path from start to end, including all detours
     *
     * @return the queue containing all points along the path to end
     */
    public Queue<Iterable>getPath(){
        return getPath(start, end);
    }

    private Queue<Iterable>getPath(Integer current, Integer next) {
        BreadthFirstPaths bfs = new BreadthFirstPaths(graph, current);
        if (detours.isEmpty()){     // base case
            totalPath.enqueue(bfs.pathTo(next));
        }
        else {
            int temp = detours.dequeue();
            totalPath.enqueue(bfs.pathTo(temp));
            return getPath(temp, next);
        }
        return totalPath;
    }

    /**
     * Add detour.
     *
     * @param d vertice of the detour
     */
    public static void addDetour(Integer d){
        detours.enqueue(d);
    }



    private void generateEdges() {
        int root = (int) Math.sqrt(1.0 * graph.V());
        for (int i = 0; i < graph.V(); i++) {
            if (i % root != root - 1) { // right side should not add right neighbor
                graph.addEdge(i, i + 1);
            }
            if (i < graph.V() - root) { // bottom row should only add right neighbor
                graph.addEdge(i, i + root);
            }
        }
        /*
         0 1 2
         3 4 5
         6 7 8

         0   1   2   3   4   5   6   7   8   9
        10  11  12  13  14  15  16  17  18  19
        20  21  22  23  24  25  26  27  28  29
        */
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {


    }
}
