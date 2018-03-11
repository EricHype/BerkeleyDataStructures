package com.ericheitmuller.assignment3;

public class Entry<K, T> {
    K key;
    T value;

    Entry(K key, T value){
        this.key = key;
        this.value = value;
    }
}
