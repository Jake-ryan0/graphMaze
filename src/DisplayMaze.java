
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import java.awt.*;

public class DisplayMaze {
    private static boolean settingStart = true;
    private static boolean settingDetours = false;
    private static boolean settingEnd = false;
    private static boolean drawingBarriers = false;
    private static boolean playing = false;

    public static void drawGraph(GraphMaze gm) throws InterruptedException {
        StdDraw.setCanvasSize(1200,1200);// this resets canvas, so must be first
        Graph graph = gm.getGraph();
        StdDraw.setXscale(0, Math.sqrt(graph.V()));
        StdDraw.setYscale(0, Math.sqrt(graph.V()));
        StdDraw.enableDoubleBuffering(); // must call show() //TODO where to put this?
        drawGrid(graph);
        StdDraw.show();
//        StdDraw.disableDoubleBuffering();//TODO figure out how this shit works

        while (settingStart) {
            if (StdDraw.isMousePressed()){
                StdDraw.setPenColor(StdDraw.BOOK_BLUE);
                //TODO maybe text? START
               Square clicked = Square.getContaining(StdDraw.mouseX(), StdDraw.mouseY());
               StdDraw.filledCircle(clicked.getX(), clicked.getY(), clicked.getHalfLength());
               StdDraw.show();
               gm.setStart(clicked.getVertex());
               TimeUnit.MILLISECONDS.sleep(500);

                settingStart = false;
               settingDetours = true;
            }
            while (settingDetours) {
                if (StdDraw.isMousePressed()) {
                    StdDraw.setPenColor(StdDraw.YELLOW);
                    //TODO maybe text? DETOUR 1, 2, 3 etc
                    Square clicked = Square.getContaining(StdDraw.mouseX(), StdDraw.mouseY());
                    StdDraw.filledCircle(clicked.getX(), clicked.getY(), clicked.getHalfLength());
                    StdDraw.show();
                    gm.addDetour(clicked.getVertex());
                    TimeUnit.MILLISECONDS.sleep(500);

                    //TODO go through all detours?
                    settingDetours = false;
                    settingEnd = true;
                }
            }
            while (settingEnd){
                if (StdDraw.isMousePressed()) {
                    StdDraw.setPenColor(StdDraw.GREEN);
                    //TODO maybe text? END
                    Square clicked = Square.getContaining(StdDraw.mouseX(), StdDraw.mouseY());
                    StdDraw.filledCircle(clicked.getX(), clicked.getY(), clicked.getHalfLength());
                    StdDraw.show();
                    gm.setEnd(clicked.getVertex());
                    TimeUnit.MILLISECONDS.sleep(500);

                    settingEnd = false;
                    drawingBarriers = true;
                }
            }
            while (drawingBarriers){
                if (StdDraw.isMousePressed()) {
                    StdDraw.setPenColor(StdDraw.RED);
                    //TODO maybe make this look like rocks or water?
                    //TODO maybe make clear paths look like grass or road?
                    Square clicked = Square.getContaining(StdDraw.mouseX(), StdDraw.mouseY());
                    StdDraw.filledSquare(clicked.getX(), clicked.getY(), clicked.getHalfLength());
                    StdDraw.show();
                    TimeUnit.MILLISECONDS.sleep(500);

                    drawingBarriers = false;
                    playing = true;
                    //TODO redraw edges of graph, without any vertices in 'black-list'
                    //TODO create blacklist array of vertices that can't have edges
                }
            }
            while (playing){
                //TODO somehow set up a delay, and draw lines between x,y coordinates of vertices
//                for (Iterable i : gm.getPath()){
//                    Square s1 = Square.getSquare(i);
//                    Square s2 = Square.getSquare(i.);
//                    StdDraw.line(s1.getX(),s1.getY(), s2.getX(),s2.getY());
//                }
                System.out.println(gm.getPath());
                playing = false;

            }
        }
//        boolean done = false;
//        while(!done){
//            if (StdDraw.isMousePressed()){
//                StdDraw.setPenColor(Color.RED);
//                for (int i = 0; i < Square.getSquares().size(); i++){
//                    if (Square.getSquares().get(i).contains(StdDraw.mouseX(),StdDraw.mouseY())){
//                        System.out.println(Square.getSquares().get(i).getVertex());
//                        Square.getSquares().get(i).drawFilledSquare();
//                                            StdDraw.show();
//
//
//                    }
//                }
//                // TimeUnit.MILLISECONDS.sleep(500);
//            }
//        }

    }

    private static void drawGrid(Graph graph){
        double x,y;
        int scale = (int) Math.sqrt(1.0 * graph.V());
        for (double row = 0; row < scale; row++){
            for (double col = 0; col < scale; col++){
                new Square(row + 0.5, col + 0.5, 0.5);

            }

        }
    }
}
