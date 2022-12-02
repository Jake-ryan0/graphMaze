import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        int size = 100; //test

        GraphMaze gm = new GraphMaze(size);
//        System.out.println(gm.getGraph().toString());
//        System.out.println("Enter start point");
//        gm.setStart(input.nextInt());
//        System.out.println("Enter end point");
//        gm.setEnd(input.nextInt());
//
//        System.out.println("Enter total # of detours");
//        int detours = input.nextInt();
//        for (int i = 0 ; i < detours; i++){
//            System.out.println("Enter detour point");
//            GraphMaze.addDetour(input.nextInt());
//        }
//
//        System.out.println(gm.getPath());

        DisplayMaze.drawGraph(gm.getGraph());



//        new Out(gm.getGraph().toString());
//        SymbolGraph sg = new SymbolGraph(); //TODO generate txt file for sg input
    }
}