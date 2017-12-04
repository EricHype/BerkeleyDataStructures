package com.ericheitmuller.assignment2;

import java.util.Arrays;

public class AssignmentTwo {

    public static void main(String[] args) {

        //Step 1
        System.out.println("Is bob a palindrome? " + isPalin("bob"));
        System.out.println("Is tree a palindrome? " + isPalin("tree"));
        System.out.println("Is tacocat a palindrome? " + isPalin("tacocat"));

        //2. Write a method/function using recursion to convert int M in decimal to radix N.
        System.out.println("8 is base 2 is: " + convertToRadix(8, 2));
        System.out.println("256 is base 16 is: " + convertToRadix(256, 16));
        System.out.println("256 is base 2 is: " + convertToRadix(256, 2));

        //3. Study Sorting algorithm QuickSort. What is its time complexity ? Explain
        /*
        The best case scenario is: O(n log n), when each pivot divides into roughly equal pieces
        Average case (between 25th and 75th percentile) comes out to: O(n log n)
        Worst case is O(n^2) as a single quicksort call involves O(n) work plus two recursive calls on lists of size 0 and n−1
        */

        //4. Given a array of nine digits determine whether they are  1 2 3 4 5 6 7 8 9 . Feel free to use API if needed.
        //The problem statement is unclear if we'll get a sorted array, I'll assume we're just looking in order
        System.out.println("Is [1,2] equal to 1-9? " + isOneThroughNine(new int[] { 1, 2 }));
        System.out.println("Is [1,2,3,4,6,5,7,8,9] equal to 1-9? " + isOneThroughNine(new int[] { 1,2,3,4,6,5,7,8,9 }));
        System.out.println("Is [1,2,3,4,5,6,7,8,9] equal to 1-9? " + isOneThroughNine(new int[] { 1,2,3,4,5,6,7,8,9 }));
    }

    public static boolean isPalin(String string) {

        if(string == null || string.length() < 1){
            return false;
        }

        int i=0;
        int j= string.length() - 1;
        char[] characters = string.toCharArray();

        while(i < j){
            if(characters[i] != characters[j]){
                return false;
            }

            i++;
            j--;
        }

        return true;

    }

    public static String convertToRadix(int decimalNumber, int radix){

        if(decimalNumber < radix){
            return Integer.toString(decimalNumber, radix);
        }

        return Integer.toString(decimalNumber / radix, radix) + convertToRadix( decimalNumber % radix, radix);
    }


    public static boolean isOneThroughNine(int[] arrayToTest){
        if(arrayToTest.length  != 9){
            return false;
        }

        for(int i=0; i< arrayToTest.length; i++){
            if(arrayToTest[i] != (i + 1)){
                return false;
            }
        }

        return true;
    }
}
