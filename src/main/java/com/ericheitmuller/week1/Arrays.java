package com.ericheitmuller.week1;

import java.util.Random;

public class Arrays {

    public static int[] testArray = {0, 1, 7, 4, 2, 6, 99, 100, 56, 74, 33, 26, 12};

    public static int[] testSorted1 = {0, 1, 2, 3, 4};
    public static int[] testSorted2 = {2, 4, 6, 8, 10, 12, 14, 16};

    public static void main(String[] args) {

        System.out.println("Print all Array Elements: ");
        printAllArrayElements(testArray);
        System.out.println("Print all Array Elements in reverse: ");
        printAllArrayElementsInReverse(testArray);
        System.out.println("Array Elements shifted to the right: ");
        printAllArrayElements(shiftArrayToTheRightOnePosition(testArray.clone()));
        System.out.println("Array Elements shifted to the left: ");
        printAllArrayElements(shiftArrayToTheLeftOnePosition(testArray.clone()));
        System.out.println("Remove an element: ");
        printAllArrayElements(removeElementFromArray(testArray.clone(), 99));
        System.out.println("Shuffle array:");
        printAllArrayElements(shuffleArray(testArray.clone()));
        System.out.println("duplicate array:");
        printAllArrayElements(duplicateArray(testArray.clone()));
        System.out.println("Duplicating references:");
        twoReferencesToSameArray(testArray.clone());
        System.out.println("Finding largest element");
        System.out.println("Largest element: " + findLargestElementInArray(testArray));
        System.out.println("Finding smallest element");
        System.out.println("Smallest element: " + findSmallestElementInArray(testArray));
        System.out.println("Reversing array inefficiently");
        printAllArrayElements(reverseElementsInArrayInefficiently(testArray.clone()));
        System.out.println("Reversing array efficiently");
        printAllArrayElements(reverseElementsInArrayEfficiently(testArray.clone()));

        System.out.println("Sorting arrays");
        printAllArrayElements(sortArray(testArray.clone()));

        System.out.println("Merging two sorted arrays");
        printAllArrayElements(mergeTwoSortedArrays(testSorted1, testSorted2));

        System.out.println("Find the 5 largest elements");
        printAllArrayElements(findSoManyLargestElements(testArray.clone(), 5));

        System.out.println("Find the 5 smallest elements");
        printAllArrayElements(findSoManySmallestElements(testArray.clone(), 5));

    }

    public static void printAllArrayElements(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("\n");
    }

    public static void printAllArrayElementsInReverse(int[] array) {

        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.print("\n");
    }

    public static int[] shiftArrayToTheRightOnePosition(int[] array) {

        if(array.length == 0){
            return array;
        }

        int lastElement = array[array.length - 1];

        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = lastElement;
        return array;
    }

    public static int[] shiftArrayToTheLeftOnePosition(int[] array) {

        if(array.length == 0){
            return array;
        }

        int firstElement = array[0];

        for (int i = 1; i < array.length; i++) {
            array[i - 1] = array[i];
        }
        array[array.length - 1] = firstElement;
        return array;
    }

    public static int[] removeElementFromArray(int[] array, int elementToRemove) {

        if(array.length == 0){
            return array;
        }

        int[] retVal = new int[array.length - 1];
        boolean found = false;
        int newArrayIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == elementToRemove && !found) {
                found = true;
                continue;
            }

            retVal[newArrayIndex] = array[i];

            if (newArrayIndex >= retVal.length) {
                return array;
            }
            newArrayIndex++;
        }

        return retVal;
    }

    public static int[] shuffleArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int indexToSwapWith = random.nextInt(array.length - 1);
            int temp = array[i];
            array[i] = array[indexToSwapWith];
            array[indexToSwapWith] = temp;
        }

        return array;
    }

    public static int[] duplicateArray(int[] array) {
        int[] retVal = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            retVal[i] = array[i];
        }
        return retVal;
    }

    public static void twoReferencesToSameArray(int[] array) {
        int[] ref1 = array;
        int[] ref2 = array;

        System.out.println("Ref 1 hashcode: " + ref1.hashCode());
        System.out.println("Ref 2 hashcode: " + ref2.hashCode());
    }

    private static int findLargestElementInArray(int[] array) {
        Integer largestSeen = null;
        for (int i = 0; i < array.length; i++) {
            if (largestSeen == null || array[i] > largestSeen) {
                largestSeen = array[i];
            }
        }
        return largestSeen;
    }

    private static int findSmallestElementInArray(int[] array) {
        Integer smallestSeen = null;
        for (int i = 0; i < array.length; i++) {
            if (smallestSeen == null || array[i] < smallestSeen) {
                smallestSeen = array[i];
            }
        }
        return smallestSeen;
    }

    private static int[] reverseElementsInArrayInefficiently(int[] array) {
        int[] retVal = new int[array.length];
        int forwardIndex = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            retVal[forwardIndex] = array[i];
            forwardIndex++;
        }

        return retVal;
    }

    private static int[] reverseElementsInArrayEfficiently(int[] array) {

        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int temp;
        while (rightIndex > leftIndex) {
            temp = array[leftIndex];
            array[leftIndex] = array[rightIndex];
            array[rightIndex] = temp;

            rightIndex--;
            leftIndex++;
        }


        return array;
    }

    private static int[] mergeTwoSortedArrays(int[] sortedArray1, int[] sortedArray2) {
        int[] retVal = new int[sortedArray1.length + sortedArray2.length];

        int leftArrayCounter = 0;
        int rightArrayCounter = 0;

        for (int i = 0; i < retVal.length; i++) {
            if (leftArrayCounter == sortedArray1.length
                    || sortedArray1[leftArrayCounter] >= sortedArray2[rightArrayCounter]) {
                //take right element
                retVal[i] = sortedArray2[rightArrayCounter];
                rightArrayCounter++;
                continue;
            }
            if (rightArrayCounter == sortedArray2.length
                    || sortedArray1[leftArrayCounter] <= sortedArray2[rightArrayCounter]) {
                //take left element
                retVal[i] = sortedArray1[leftArrayCounter];
                leftArrayCounter++;
                continue;
            }
        }


        return retVal;
    }

    public static int[] sortArray(int[] array) {
        quicksort(array, 0, array.length - 1);
        return array;
    }

    private static void quicksort(int[] array, int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = array[low + (high-low)/2];

        // Divide into two lists
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quicksort(array, low, j);
        if (i < high)
            quicksort(array, i, high);
    }





    public static int[] findSoManyLargestElements(int[] array, int howManyElementsToFind){
        int[] retVal = new int[howManyElementsToFind];

        if(howManyElementsToFind >= array.length){
            return array;
        }

        int[] sorted = sortArray(array);
        int retValIndex = 0;
        for(int i=sorted.length -1; i > sorted.length - (howManyElementsToFind + 1); i--){
            retVal[retValIndex] = sorted[i];
            retValIndex++;
        }

        return retVal;
    }

    public static int[] findSoManySmallestElements(int[] array, int howManyElementsToFind){
        int[] retVal = new int[howManyElementsToFind];

        if(howManyElementsToFind >= array.length){
            return array;
        }
        int[] sorted = sortArray(array);
        for(int i=0; i < howManyElementsToFind; i++){
            retVal[i] = sorted[i];
        }

        return retVal;
    }

}
