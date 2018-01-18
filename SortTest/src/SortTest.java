/**
 * Created by mohamed on 6/7/17.
 */

public class SortTest {
    public static void main(String[] args){
        int[] array = new int[20000];
        for (int i = 0; i < 20000; i++) {
            array[i] = (int)(Math.random() * 3000000);
        }

        int[] arrayCopy = array;
        insertionSort(arrayCopy);
        System.out.println();

    }

    public static void insertionSort(int[] array){
        for(int i =0; i<array.length-1; i++){
            int j = findMinAfter(i,array);
            swap(j,i, array);
        }
    }

    public static void swap(int j, int i, int[] array){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int findMinAfter(int i, int[] array){
        int min = i;
        for(int j = min; j<array.length; j++){
            if(array[j]< array[min]){
                min = j;
            }
        }
        return min;
    }
}
