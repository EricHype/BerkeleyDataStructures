package com.ericheitmuller.week2.teasers;

import java.util.Random;

public class FindDuplicateInArray {

    public static void main(String[] args) {

        int[] arr = getArrayWithDuplicateNumber(5);

        for (int i=0; i< arr.length; i++){
            System.out.println("Value is: " + arr[i]);
        }

        int duplicatedValue = findDuplicatedValue(arr);

        System.out.println("Duplicated value: " + duplicatedValue);

    }

    public static int findDuplicatedValue(int[] arrayToSearch){

        //if this isn't in order, we'd need a map, or to sort it.

        for(int i=0; i< arrayToSearch.length; i++){
            if(arrayToSearch[i] == arrayToSearch[i+1]){
                return arrayToSearch[i];
            }
        }

        return -1;
    }

    public static int[] getArrayWithDuplicateNumber(int max){

        int[] retVal = new int[max + 1];
        Random random = new Random();
        int keyToDuplicate = random.nextInt(max);

        for(int i=0; i<= max; i++){
            if(i == keyToDuplicate){
                retVal[i] = i;
                retVal[i + 1] = i;
                i++;
                continue;
            }

            retVal[i] = i;

        }

        return retVal;
    }

}
