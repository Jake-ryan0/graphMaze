import edu.princeton.cs.algs4.*;

import java.util.ArrayList;

public class Square {

    private double x;
    private double y;
    private static double halfLength;
    private int vertex;
    private static ArrayList<Square> squareList = new ArrayList<>();
    private String grassImage = "https://preview.redd.it/icko709zs5c41.png?auto=webp&s=07fea1d0310e9ea5acf49f4903dd187a1ecd23a7";


    public Square(double x,double y, double halfLength){
        this.x = x;
        this.y = y;
        this.halfLength = halfLength;
        StdDraw.picture(x,y,grassImage,1,1);
        vertex = squareList.size();
        squareList.add(this);
    }


    public void drawFilledSquare(){
        StdDraw.filledSquare(this.x, this.y, this.halfLength);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean contains(double mouseX, double mouseY){
        if (mouseX > this.x-halfLength && mouseX < this.x+halfLength && mouseY > this.y-halfLength && mouseY < this.y+halfLength)
            return true;
        return false;
    }

    public static ArrayList<Square> getSquares(){
        return squareList;
    }

    public int getVertex(){
        return vertex;
    }

    public double getHalfLength() {
        return halfLength;
    }

    public static Square getContaining(double mouseX, double mouseY){
        for (Square s: squareList){
            if (s.contains(mouseX, mouseY)){
                return s;
            }
        }
        return null;
    }

    public static Square getSquare(int vertex){
        for (Square s : squareList){
            if (s.getVertex() == vertex){
                return s;
            }
        }
        return null;
    }
}
