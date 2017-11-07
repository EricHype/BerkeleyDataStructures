package com.ericheitmuller.week1;

public class GCD {
    public static void main(String[] args) {
        //given two non negative integers, find the greatest common divisor

        System.out.println("The GCD of 77 and 11 is: " + findGCD(77, 11) );
        System.out.println("The GCD of 1204 and 888 is: " + findGCD(1024, 888) );
        System.out.println("The GCD of 53 and 55 is: " + findGCD(53, 55) );
        System.out.println("The GCD of 1000 and 100 is: " + findGCD(1000, 100) );
    }


    public static int findGCD(int first, int second){

        if(first  < 1 || second <1){
            System.out.println("No negatives allowed in GCD");
            return -1;
        }

        int greater = first;
        int lesser = second;
        if(second > first){
            greater = second;
            lesser = first;
        }

        int remainder = greater % lesser;
        if( remainder == 0 ){
            return lesser;
        }

        return findGCD(lesser, remainder);

    }
}
