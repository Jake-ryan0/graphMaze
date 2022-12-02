import edu.princeton.cs.algs4.*;

import java.util.ArrayList;

public class Square {

    private double x, y, halfLength;
    private static ArrayList<Square> squareList = new ArrayList<>();

    public Square(double x,double y, double halfLength){
        this.x = x;
        this.y = y;
        this.halfLength = halfLength;
        StdDraw.square(x,y,halfLength);
        squareList.add(this);
    }

    public void drawFilledSquare(){
        StdDraw.filledSquare(this.x, this.y, this.halfLength);
    }

    public boolean contains(double mouseX, double mouseY){
        if (mouseX > this.x-halfLength && mouseX < this.x+halfLength && mouseY > this.y-halfLength && mouseY < this.y+halfLength)
            return true;
        return false;
    }

    public static ArrayList<Square> getSquares(){
        return squareList;
    }
}
