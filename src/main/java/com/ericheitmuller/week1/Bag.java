package com.ericheitmuller.week1;


/*
A. Define what is meant by Abstract Data Type.

An abstract data type designed by the programmer. 
It defines operations that can be performed on the data of the object and the data organization a representation.
Generally, it is a type than cannot be instantiated on it's own, only inherited into concrete types.

B. During Nov 2 class, we came up with a Bag data type, ie ADT Bag,
Write a Java / C++ / C / Python program to implement a Bag.
Use a Array for implementing the Bag. Pic of the white board items for Bag attached.

*/

import java.util.Arrays;

public class Bag {
    Integer[] objectsInBag;

    public Bag(int capacity){
        objectsInBag = new Integer[capacity];
    }

    public boolean isEmpty(){
        return !Arrays.stream(objectsInBag).anyMatch(a-> a != null);
    }

    public void putItem(int item){
        Integer index = findFirstEmptyIndex();
        if(index == null){
            System.out.println("Cannot put item, bag is full");
            return;
        }
        objectsInBag[index] = item;
    }

    public Integer[] getItems(){
        return objectsInBag;
    }

    public Integer getItem(int value){
        for(int i=0; i< objectsInBag.length; i++){
            if(objectsInBag[i] != null && objectsInBag[i] == value){
                int temp = objectsInBag[i];
                objectsInBag[i] = null;
                return temp;
            }
        }

        return null;
    }

    public Integer findFirstEmptyIndex(){
        for(int i=0; i< objectsInBag.length; i++){
            if(objectsInBag[i] == null){
                return i;
            }
        }

        return null;
    }

    public int getCapacity(){
        return objectsInBag.length;
    }

    public void printContents(){
        System.out.println("All objects in bag:");
        for(int i=0; i< objectsInBag.length; i++){
            System.out.println(objectsInBag[i]);
        }
    }

    public void sortTheItemsInTheBag(){
        Arrays.sort(objectsInBag); //could also use the quicksort I implemented
    }

    public void empty(){
        objectsInBag = new Integer[objectsInBag.length];
    }
}
