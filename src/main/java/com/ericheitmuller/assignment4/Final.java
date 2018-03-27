package com.ericheitmuller.assignment4;

public class Final {

    public static void main(String[] args) {

        System.out.println("Brute force method, O(n) runtime");
        int[] testInput = {15,16,19,20,25,1,3,4,5,7,10,14};
        System.out.println("The Index of 5 in the example data should be 8, it is:" +
                findIndexOfItemInUnsortedUniqueArray(testInput, 5));

        System.out.println("Binary search method, O(log n) runtime");
        System.out.println("The Index of 5 in the example data should be 8, it is:" +
            findIndexOfItemInRotatedArray(testInput, 5));

    }

    //Finds the index of an element in an array, returns -1 if not found
    public static int findIndexOfItemInUnsortedUniqueArray(int[] input, int whatToFind){
        //straight search of every element, O(n) time
        for(int i=0; i< input.length; i++){
            if(input[i] == whatToFind){
                return i;
            }
        }

        return  -1;
    }


    //Finds the index of an element in an array, returns -1 if not found
    public static int findIndexOfItemInRotatedArray(int[] input, int whatToFind){

        //find pivot point
        int pivot = findIndexOfPivotPoint(input, 0, input.length - 1);

        // No pivot, assume it's sorted still.
        if (pivot == -1)
            return binarySearch(input, 0, input.length-1, whatToFind);

        //did we get lucky and find it at pivot?
        if (input[pivot] == whatToFind)
            return pivot;

        //search left of pivot w/ BS
        if (input[0] <= whatToFind)
            return binarySearch(input, 0, pivot - 1, whatToFind);

        //search right of pivot w/ BS
        return binarySearch(input, pivot+1, input.length - 1, whatToFind);
    }

    //find pivot point similar to binary search
    public static int findIndexOfPivotPoint(int[] input, int low, int high){
        if (high < low)
            return -1;
        if (high == low)
            return low;

        /* low + (high - low)/2; */
        int midPoint = (low + high)/2;
        if (midPoint < high && input[midPoint] > input[midPoint + 1])
            return midPoint;
        if (midPoint > low && input[midPoint] < input[midPoint - 1])
            return (midPoint-1);
        if (input[low] >= input[midPoint])
            return findIndexOfPivotPoint(input, low, midPoint-1);
        return findIndexOfPivotPoint(input, midPoint + 1, high);
    }


    public static int binarySearch(int arr[], int low, int high, int whatToFind)
    {
        if (high < low)
            return -1;

        int mid = (low + high)/2;
        if (whatToFind == arr[mid])
            return mid;
        if (whatToFind > arr[mid])
            return binarySearch(arr, (mid + 1), high, whatToFind);
        return binarySearch(arr, low, (mid -1), whatToFind);
    }


}
