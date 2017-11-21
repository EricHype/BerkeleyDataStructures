package com.ericheitmuller.week2.teasers;

import java.util.Random;

public class FindTheMissingNumberInArray {

    public static void main(String[] args) {

        int[] arr = getArrayWithMissingNumber(5);

        for(int i=0; i< arr.length; i++){
            System.out.println("Value is:" + arr[i] );
        }

        int missing = findMissingNumber(arr);
        System.out.println("The missing number is: " + missing);
    }

    public static int findMissingNumber(int[] supposedlyContiguousArray){
        if(supposedlyContiguousArray[0] != 1){
            return 1;
        }

        for(int i=0; i< supposedlyContiguousArray.length; i++){

            if(i + 1 >= supposedlyContiguousArray.length){
                return -1;
            }

            if(supposedlyContiguousArray[i +1 ] != supposedlyContiguousArray[i] + 1){
                return supposedlyContiguousArray[i] + 1;
            }
        }

        return -1;
    }

    public static int[] getArrayWithMissingNumber(int max){

        int[] retVal = new int[max -1];
        Random random = new Random();
        int keyToDelete = random.nextInt(max - 1);
        if(keyToDelete == 0){
            keyToDelete = 1;
        }
        int j=0;
        for(int i=1; i<= max; i++){
            if(i == keyToDelete){
                continue;
            }
            retVal[j] = i;
            j++;
        }

        return retVal;
    }

}
