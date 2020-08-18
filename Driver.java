/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC331SortingMethod;
//Implement all the different sorting techniques

import java.util.Arrays;

public class Driver {

    /**
     *
     * @author Hector Felix
     * @param array
     */
//insertion sort
    public static void insertionSort(int[] array) {
        System.out.println("\n[ INSERTION SORT ]");
        int n = array.length;
        for (int i = 1; i < n; i++) {
            // Need counters for indices
            int j = i - 1; // This is the first element to compare with
            int temp = array[i]; // Store it because shifting might override it
            while (j >= 0 && array[j] > temp) {
                // Index is valid, and larger value before
                array[j + 1] = array[j];  // Shift right
                j--;        // Go to previous index
            }
            // this is the proper place for the dat
            array[j + 1] = temp; // We checked one too many before, so increment
            System.out.println(printArray(array));
        }
    }

public static void secondInsertionSort(int[] array) {
    int n = array.length;
    for (int i = 1; i < n; i++) {
        int j = i-1;
        int temp = array[i];
        
        while(j>=0 && array[j] > temp) {
            array[j+1] = array[j];
            j--;
        }
        array[j+1] = temp;
        System.out.println(printArray(array));
    }
}

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1 - i; i++) {
            int index = i;                          // index under consideration
            int minimum = i + 1;                      // Assume this is min to start
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minimum]) {
                    //Found a new minimum
                    minimum = j;
                }
            }
            if (array[minimum] < array[index]) {
                //We found a lower value in the array that needs to come before
                //So, we will swap the values
                array[minimum] = array[index] ^ array[minimum];
                array[index] = array[index] ^ array[minimum];
                array[minimum] = array[index] ^ array[minimum];

            }
        }
    }

    private static void bubbleSort(int[] array) {
        int n = array.length;
        boolean isSwapping = true;
        for (int i = 0; i < n && isSwapping; i++) {
            isSwapping = false; //Assume here checking will not result in false

            for (int j = 0; j < n - 1; j++) {
                if (array[j] > array[j + 1]) {

                    array[j] = array[j] ^ array[j + 1];
                    array[j + 1] = array[j] ^ array[j + 1];
                    array[j] = array[j] ^ array[j + 1];
                    isSwapping = true;

                    // swap arr[j+1] and arr[i] 
//                    int temp = array[j]; 
//                    array[j] = array[j+1]; 
//                    array[j+1] = temp; 
                }
            }
        }
    }
    
    public static void quickSort(int[] arr, int low, int high) {
        // Let's check the error conditions first
        if(arr == null || arr.length == 0)
            return;
        
        if(low >= high)
            return;
        
        // Pick the Pivot
        int middle = (low + high)/2;
        int pivot = arr[middle];
        
        // Make the left side less than the pivot, and right side more than the pivot
        int i = low, j = high;
        while(i <= j) {
            while(arr[i] < pivot)       // Checking on the left side
                i++;                    // Go to the next eleemnt
            
            while(arr[j] > pivot)
                j--;
            
            if(i <= j) {
                // Swap the values at i and j
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        
        System.out.println(printArray(arr));
        
       // At this point the pivot is in its place
       // Recursively sort the subarrays
       if(low < j)      // Sort left part if any
           quickSort(arr,low,j);
       if(high > i)     // Sort right part if any
           quickSort(arr,i,high);
    }
    
    public static void quickSort(int[] arr) {       // This is the wrapper methof for Quicksort
        int low = 0;
        int high = arr.length-1;
        quickSort(arr,low,high);
    }

    public static void main(String[] args) {
        //int[] array = {3, 11, 2, 4, 9, 3, 6, 8};
        int[] array = {3,7,1,2,9};
        System.out.println("Original:\n " + Arrays.toString(array));
//insertionSort(array);
//selectionSort(array);
//bubbleSort(array);
//quickSort(array);
secondInsertionSort(array);

        System.out.println("Sorted:\n " + Arrays.toString(array));
//System.out.println(printArray(array));

    }

    private static String printArray(int[] a) {
        String s = "| ";
        for (int i = 0; i < a.length; i++) {
            s += a[i] + " | ";
        }
        return s;
    }
}
