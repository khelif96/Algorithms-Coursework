import java.util.Random;

/**
 * Created by mohamed on 6/26/17.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {0,2,1,3,5,4,7,9,6};
        Random rand = new Random();
//        array = {0,2,1,3,5,4,7,9,6};
        for(int i = 0; i<array.length; i++){
            System.out.print(array[i] + ",");
        }
        System.out.println();

        quickSort(array, 1 , array.length-1);
        System.out.println();
        for(int i = 0; i<array.length; i++){
            System.out.print(array[i] + ",");
        }
    }

    public static void quickSort(int[] array, int p, int r){
        if(p < r){
            int q = Partition(array, p, r);
            quickSort(array,p,q-1);
            quickSort(array,q+1,r);
        }
    }

    public static int Partition(int[] array, int p, int r){
        int x = array[r];
        int i = p;
        for(int j = p; j< r-1; j++){
            if(array[j] <= x){
                i = i+1;
                swap(array, i, j);
            }
        }
        swap(array, i+1, r);
        return i+1;
    }

    public static void swap(int[] array, int i, int j){
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
        for(int it = 0; i<array.length; it++){
            System.out.println(array[it]);
        }
    }
}
