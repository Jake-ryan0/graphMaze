
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import java.awt.*;

public class DisplayMaze {

    public static void drawGraph(Graph graph) throws InterruptedException {
        StdDraw.setPenRadius();
        StdDraw.setXscale(0, Math.sqrt(graph.V()));
        StdDraw.setYscale(0, Math.sqrt(graph.V()));

        // to speed up performance, defer displaying points
        //    StdDraw.enableDoubleBuffering();

        StdDraw.setCanvasSize(700,700);

        //  StdDraw.filledSquare(0,0,0.1);
        drawGrid(graph);
        boolean done = false;
        while(!done){
            if (StdDraw.isMousePressed()){
                StdDraw.setPenColor(Color.RED);
                for (int i = 0; i < Square.getSquares().size(); i++){
                    if (Square.getSquares().get(i).contains(StdDraw.mouseX(),StdDraw.mouseY()))
                        Square.getSquares().get(i).drawFilledSquare();
                }
                // TimeUnit.MILLISECONDS.sleep(500);
            }
        }

        // plot points, one at a time
//        while () { //TODO make this work
//            double x = StdIn.readDouble();
//            double y = StdIn.readDouble();
//            StdDraw.point(x, y);
    }

    private static void drawGrid(Graph graph){
        double x,y;
        int scale = (int) Math.sqrt(1.0 * graph.V());
        for (double row = 0; row < scale; row++){
            for (double col = 0; col < scale; col++){
                new Square(row/10+0.05,col/10+0.05,0.05);
            }
        }
    }

    // display all of the points now
//        StdDraw.show();

}
