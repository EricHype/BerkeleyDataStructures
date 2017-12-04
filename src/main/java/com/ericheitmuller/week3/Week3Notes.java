package com.ericheitmuller.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Week3Notes {

    public static String[] chars = { "", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
    "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };


    public static int[] sortedAray = { 1, 2, 3, 4, 5, 6, 7};

    public static void main(String[] args) {
	// write your code here

        
        List<String> translateEmpty = translateNumericString("", "");
        System.out.println("Empty string values: ");
        for(String s : translateEmpty){
            System.out.println(s);
        }

        List<String> singleValue = translateNumericString("2", "");
        System.out.println("Single string values: ");
        for(String s : singleValue){
            System.out.println(s);
        }

        List<String> doubleValue = translateNumericString("11", "");
        System.out.println("Double string values: ");
        for(String s : doubleValue){
            System.out.println(s);
        }

        List<String> tripleValue = translateNumericString("111", "");
        System.out.println("Triple string values: ");
        for(String s : tripleValue){
            System.out.println(s);
        }

        List<String> quad = translateNumericString("1112", "");
        System.out.println("Quad string values: ");
        for(String s : quad){
            System.out.println(s);
        }

        List<String> quint = translateNumericString("11212", "");
        System.out.println("Quint string values: ");
        for(String s : quint){
            System.out.println(s);
        }


        System.out.println("Index of 5 is:" + BinarySearch(sortedAray, 0, sortedAray.length -1, 5) );
        System.out.println("Index of 7 is:" + BinarySearch(sortedAray, 0, sortedAray.length -1, 7) );
        System.out.println("Index of 10 is:" + BinarySearch(sortedAray, 0, sortedAray.length -1, 10) );
        System.out.println("Index of 0 is:" + BinarySearch(sortedAray, 0, sortedAray.length -1, -1) );
    }




    public static List<String> translateNumericString(String input, String inputSoFar){

        if(inputSoFar == null){
            inputSoFar = "";
        }

        if(input == null || input.length() < 1)
            return Arrays.asList( new String[] { inputSoFar } );

        if(input.length() == 1){
            Integer value = Integer.parseInt(input);
            return Arrays.asList( new String[] { inputSoFar + chars[value] });
        }

        //if string is 2 or longer, grab the first two numbers and append
        String substring = input.substring(0, 2);
        List<String> retVal = new ArrayList<>();
        if (isValidCharacter(substring)) {
            Integer value = Integer.parseInt(substring);
            retVal.addAll(translateNumericString(input.substring(2), inputSoFar + chars[value] ));
        }

        //add as individual
        Integer value = Integer.parseInt(substring.substring(0, 1));
        retVal.addAll(translateNumericString(input.substring(1), inputSoFar + chars[value] ));

        return retVal;
    }



    public static boolean isValidCharacter(String substring) {

        Integer value = Integer.parseInt(substring);
        if(value < 1 || value > 26){
            return false;
        }

        return true;
    }

    public static int BinarySearch(int[] sortedArray, int left, int right, int valueToFind){


        int mid = (left + right) / 2;

        if(sortedArray.length == 0){
            return -1;
        }

        if(left + 1 == right){
            if(sortedArray[left] == valueToFind){
                return left;
            }
            if(sortedArray[right] == valueToFind){
                return right;
            }
            return -1;
        }

        if(sortedArray[mid] > valueToFind){
            return BinarySearch(sortedArray, left, mid, valueToFind);
        }

        return BinarySearch(sortedArray, mid, right, valueToFind);

    }

}
