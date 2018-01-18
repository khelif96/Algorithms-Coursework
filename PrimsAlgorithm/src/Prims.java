/**
 * Mohamed Khelif
 * Assignment 1 Prims Algorithm
 * Issues: Calculation of steps is probably wrong
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
public class Prims {

    static void prim(int[][]matrix){
        int stepper = 0; // Counter for Countin Steps taken
        int added = 0;
        int r = 0;
        int[] q = new int[matrix.length];
        boolean[] selected = new boolean[matrix.length];
        Arrays.fill(q, Integer.MAX_VALUE); // Fills the new mst array With the max int value
        Arrays.fill(selected, false);
        q[r] = 0;
        selected[r] = true;
        while (added != matrix.length - 1){
//            stepper++;
            int nodeA = -1,nodeB = -1;
            for (int i = 0; i<matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (selected[i] && !selected[j] && i != j && matrix[i][j] != Integer.MAX_VALUE) {
                        stepper++;
                        if (nodeA == -1) {
                            nodeA = i;
                            nodeB = j;
                        } else if (matrix[i][j] < matrix[nodeA][nodeB]) {
                            nodeA = i;
                            nodeB = j;
                        }
                    }
                }
            }

            if(nodeA == -1){
                return; // Quit if we get to an array out of bounds
            }
            System.out.print("(" +nodeA+"," + nodeB +
                    "),");

            selected[nodeB] = true;
            added++;
        }
        System.out.println();

        System.out.println("Steps " + stepper);
    }


    static ArrayList<int[][]> readInput(){
        int graphSize = 100;
        ArrayList<int[][]> list = new ArrayList<>(1);
        int[][] temp = new int[graphSize][graphSize];
        Random rand = new Random();
        for(int i = 0; i <graphSize; i++){
            for(int j =0; j < graphSize; j++){
                temp[i][j] = rand.nextInt((10)+1)+0; // Generate Random matrix values from 0-10

            }
        }
        list.add(temp);
        return list;
    }


    public static void main(String[] args) {
//        int matrixSize = 10;
//        int a[][] = new int[matrixSize][matrixSize];
            System.out.println("Adj matrix: ");
            prim(readInput().get(0));


    }
}
