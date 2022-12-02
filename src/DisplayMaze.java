import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdDraw;

public class DisplayMaze {

    private static void drawGraph(Graph graph){
        StdDraw.setPenRadius(0.005);
        StdDraw.setXscale(0, Math.sqrt(graph.V()));
        StdDraw.setYscale(0, Math.sqrt(graph.V()));

        // to speed up performance, defer displaying points
        StdDraw.enableDoubleBuffering();

        // plot points, one at a time
//        while () { //TODO make this work
//            double x = StdIn.readDouble();
//            double y = StdIn.readDouble();
//            StdDraw.point(x, y);
        }

        // display all of the points now
//        StdDraw.show();

    }

