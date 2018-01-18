import com.sun.scenario.effect.Merge;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by mohamed on 7/5/17.
 */
public class Sort {
//    public static void mergeInsertionSort(int[] array, int low, int high, double size){
//        insertionSort iSort = new insertionSort();
//        mergeSort mSort = new mergeSort();
//        int partition = low + (int) Math.floor(array.length*size);
//        if(partition > high){
//            iSort.Sort(array,low,high);
//            return;
//        }
//        int mid = (int)Math.floor((low+high)/2);
//        mergeInsertionSort(array,low,mid,size);
//        mergeInsertionSort(array,(mid+1),high,size);
//        merge(array,low,mid,high)
//    }
//    private static void merge(int[] array, int[] temp, int low, int high, int mid) {
//        int i = low;
//        int j = high + 1;
//        for (int k = low; k <= mid; k++) {
//            temp[k] = array[k];
//        }
//        for (int k = low; k <= mid; k++) {
//            if (i > high) {
//                array[k] = temp[j];
//                j++;
//            } else if (j > mid) {
//                array[k] = temp[i];
//                i++;
//            } else if (temp[j] < temp[i]) {
//                array[k] = temp[j];
//                j++;
//            } else {
//                array[k] = temp[i];
//                i++;
//            }
//        }
////    ONE_THI
//    public static class insertionSort {
//        public static void Sort(int[] array) {
//            int key;
//            int i;
//            for (int j = 1; j < array.length; j++) {
//                key = array[j];
//                i = j - 1;
//                while((i >= 0) && (array[i] > key)) {
//                    array[i + 1] = array[i];
//                    i--;
//                }
//                array[i + 1] = key;
//            }
//        }
//    public static void Sort(int[] array, int low, int high) {
//        int key;
//        int i;
//        for (int j = low + 1; j <= high; j++) {
//            key = array[j];
//            i = j - 1;
//            while((i >= low) && (array[i] > key)) {
//                array[i + 1] = array[i];
//                i--;
//            }
//            array[i + 1] = key;
//        }
//    }
//    }
//    public static class mergeSort {
//        public static void Sort(int a[], int point, int end) {
//            int q;
//            if (point < end) {
//                int m = (point + end) / 2;
//
//                Sort(a, 1, m);
//                Sort(a, m + 1, end);
//                merge(a, 1, m, end);
//            }
//        }
//
//        public static void merge(int a[], int point, int m, int end) {
//            int s1 = m - point + 1;
//            int s2 = end - m;
//
//            int L[] = new int[s1];
//            int R[] = new int[s2];
//
//            for (int i = 0; i < s1; ++i) {
//                L[i] = a[point + i];
//            }
//            for (int j = 0; j < s2; ++j) {
//                R[j] = a[point + 1 + j];
//            }
//
//            int i = 0, j = 0;
//
//            int k = 1;
//            while (i < s1 && j < s2) {
//                if (L[i] <= R[j]) {
//                    a[k] = L[i];
//                    i++;
//                } else {
//                    a[k] = R[j];
//                    j++;
//                }
//                System.out.println("ak = " + a[k]);
//                k++;
//            }
//            while (i < s1) {
//                a[k] = L[i];
//                i++;
//                k++;
//            }
//            while (j < s2) {
//                a[k] = R[j];
//                j++;
//                k++;
//            }
//
//        }
//    }



        public static void mergeSort(int[] array, int[] temp, int low, int high) {
            if (low < high) {
                int mid = (int) Math.floor((low + high) / 2);
                mergeSort(array, temp, low, mid);
                mergeSort(array, temp, (mid + 1), high);
                merge(array, temp, low, mid, high);
            }
        }

        private static void merge(int[] array, int[] temp, int low, int high, int mid) {
            int i = low;
            int j = high + 1;
            for (int k = low; k <= mid; k++) {
                temp[k] = array[k];
            }
            for (int k = low; k <= mid; k++) {
                if (i > high) {
                    array[k] = temp[j];
                    j++;
                } else if (j > mid) {
                    array[k] = temp[i];
                    i++;
                } else if (temp[j] < temp[i]) {
                    array[k] = temp[j];
                    j++;
                } else {
                    array[k] = temp[i];
                    i++;
                }
            }
        }



        public static void insertionSort(int[] array) {
            int key;
            int i;
            for (int j = 1; j < array.length; j++) {
                key = array[j];
                i = j - 1;
                while ((i >= 0) && (array[i] > key)) {
                    array[i + 1] = array[i];
                    i--;
                }
                array[i + 1] = key;
            }
        }


        public static void insertionSort(int[] array, int low, int high) {
            int key;
            int i;
            for (int j = low + 1; j <= high; j++) {
                key = array[j];
                i = j - 1;
                while ((i >= low) && (array[i] > key)) {
                    array[i + 1] = array[i];
                    i--;
                }
                array[i + 1] = key;
            }
        }


    public static void mergeInsertionSort(int[] arr, int[] temp, int low, int high, double size){
        int partition = low + (int) Math.floor(arr.length * size);
        if (partition > high) {
            insertionSort(arr, low, high);
            return;
        }
        int mid = (int) Math.floor((low + high) / 2);
        mergeInsertionSort(arr, temp, low, mid, size);
        mergeInsertionSort(arr, temp, (mid + 1), high, size);
        merge(arr, temp, low, mid, high);
    }
    public static void main(String[] args) {
        int[] arr  = {10, 4 ,5 ,6, 7,2,9, 3, 1,8};
        int[] arr2  = {10, 4 ,5 ,6, 7,2,9, 3, 1,8};
        int[] arr3  = {10, 4 ,5 ,6, 7,2,9, 3, 1,8};
        int[] temp = new int[arr2.length];
        long timerStart, timerEnd;
//        InsertionSort iSort = new InsertionSort();


        timerStart = System.currentTimeMillis();
        insertionSort(arr);
        timerEnd = System.currentTimeMillis();
        System.out.print("Insertion Sort Run time:  " + (timerEnd-timerStart));
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i] + ",");
        }
        System.out.println();

//        MergeSort mSort = new MergeSort();
        timerStart = System.currentTimeMillis();
        mergeSort(arr2, temp,0 ,arr2.length-1);
        timerEnd = System.currentTimeMillis();
        System.out.print("Merge Sort Run time :  " + (timerEnd-timerStart));
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr2[i] + ",");
        }

        timerStart = System.currentTimeMillis();
        mergeInsertionSort(arr3,temp,0,arr3.length-1,1);
        timerEnd = System.currentTimeMillis();
        System.out.println();
        System.out.println("Merge Insertion Sort Run Time :  " + (timerEnd-timerStart));
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr3[i] + ",");
        }

        System.out.println();
        SortingTest();
    }

    public static void SortingTest(){
        int n = 100;
        long startTime, endTime;
        Random rand = new Random();
        ArrayList<int[]> matrices = new ArrayList<int[]>();
        for (int i = 0; i < 10 ; i++) {
            int[] testArr = new int[n];
            for (int j = 0; j < n; j++) {
                testArr[j] = rand.nextInt(n)+1;
            }
            matrices.add(testArr);
            n+=100;
        }

        for (int i = 0; i < matrices.size(); i++) {
            System.out.print("Size " + matrices.get(i).length + " ");
            int[] temp = new int[matrices.get(i).length] ;
            int[] mergeTempArr = matrices.get(i);
            int[] insertionTempArr = matrices.get(i);
            int[] mergeInsertionTempArr = matrices.get(i);
            startTime = System.currentTimeMillis();
            mergeSort(mergeTempArr,temp,0,temp.length-1);
            endTime = System.currentTimeMillis();
            long mergeTime = (endTime-startTime);

            startTime = System.currentTimeMillis();
            insertionSort(insertionTempArr);
            endTime = System.currentTimeMillis();
            long insertionTime = (endTime-startTime);

            startTime = System.currentTimeMillis();
            mergeInsertionSort(mergeInsertionTempArr,temp,0,mergeInsertionTempArr.length-1,1);
            endTime = System.currentTimeMillis();
            long mergeInsertionTime = (endTime-startTime);
            System.out.println("mergeTime | insertionTime | mergeInsertionTime" );
            System.out.println(mergeTime+ "|" + insertionTime+"|" + mergeInsertionTime);
        }

        System.out.println("mergeSort");

    }
}
