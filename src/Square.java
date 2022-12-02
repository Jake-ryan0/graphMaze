import edu.princeton.cs.algs4.*;

public class Square {

    private double x, y, halfLength;

    public Square(double x,double y, double halfLength){
        this.x = x;
        this.y = y;
        this.halfLength = halfLength;

        StdDraw.setPenRadius(0.1);
        StdDraw.square(x,y,halfLength);
    }

    public static void drawFilledSquare(){

    }
}
