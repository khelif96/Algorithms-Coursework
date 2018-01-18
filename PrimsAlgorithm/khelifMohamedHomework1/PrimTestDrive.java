/**
 * Mohamed Khelif
 * Assignment 1 Prims Algorithm
 * Issues: Calculation of steps is probably wrong
 * Observations: Run Time is considerably improved if prims algorithm implementation only returns a minimum spanning tree instead of printing one
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class PrimTestDrive {
    static void prim(int[][]matrix){
        System.out.println("Minimum Spanning Tree");
        long startTime = System.currentTimeMillis(); // Count run time
        long stepper = 0; // Counter for Counting Steps taken
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
            System.out.print("(" +nodeA+"," + nodeB + "),");

            selected[nodeB] = true;
            added++;
        }
        long endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("Steps " + stepper);
        long totalTime = endTime - startTime;
        System.out.println("Runtime " + totalTime);
    }


    static int[][] readInput(){
//        Generate random Matrix
        System.out.println("Enter your matrix size");
        Scanner Sc = new Scanner(System.in);
        int matrixSize = Sc.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        System.out.println("Enter your matrix");
        for(int i = 0; i<matrixSize; i++){
            for(int j = 0; j<matrixSize; j++){
                matrix[i][j] = Sc.nextInt();
            }

        }
        return matrix;
    }

    static int[][] generateMatrix(int graphSize){
        //        Generate random Matrix
//        int graphSize = 100;
        ArrayList<int[][]> list = new ArrayList<>(1);
        int[][] temp = new int[graphSize][graphSize];
        Random rand = new Random();
        for(int i = 0; i <graphSize; i++){
            for(int j =0; j < graphSize; j++){
                temp[i][j] = rand.nextInt((9)+1)+0; // Generate Random matrix values from 0-10

            }
        }
        System.out.println("Generated Matrix");
        // Print matrix
        for(int i = 0; i<graphSize; i++){
            for(int j =0; j<graphSize; j++){
//                System.out.print(" ");
                System.out.print(temp[i][j]+" ");
//                if(temp[i][j] < 10){System.out.print(" ");}

            }
            System.out.println();
        }
        return temp;
    }


    public static void main(String[] args) {
        int matrixSize = 10;
        prim(generateMatrix(matrixSize)); // This Randomly Generates a matrix
//        prim(readInput());  // This reads the users input for the Adjancey Matrix input

    }
}
