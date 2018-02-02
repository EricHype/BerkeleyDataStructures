package com.ericheitmuller.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;


public class DistinctWords {

    public static void main(String[] args) {

        System.out.println("Brown Cat Brown");
        String[] arr = { "Brown", "Cat", "Brown" };
        System.out.println(getDistinctAndNonDistinctList(arr));

    }


    public static String getDistinctAndNonDistinctList(String[] input){

        HashMap<String, Boolean> wordsAndDistinct = new HashMap();

        for(String s : input){
            if(!wordsAndDistinct.keySet().contains(s)){
                wordsAndDistinct.put(s, true);
            } else {
                wordsAndDistinct.put(s, false); //non distinct
            }
        }

        List<String> distinct = new ArrayList();
        List<String> nonDistinct = new ArrayList();
        for(String key : wordsAndDistinct.keySet()){
            
            if(wordsAndDistinct.get(key)){
                distinct.add(key);
            } else {
                nonDistinct.add(key);
            }
        }

        return "Distinct words: " + String.join(",", distinct) + "\nNon Distinct: " + String.join(",", nonDistinct );
    }


}