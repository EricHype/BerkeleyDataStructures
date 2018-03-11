package com.ericheitmuller.assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EHHashMap<K, V> {
    Entry<K, V>[] entries = new Entry[1024];

    public void put(K key, V value){
        int hashCode = key.hashCode();

        //if array not big enough
        if(hashCode > entries.length){
            redimArray(hashCode);
        }

        //TODO: here we would test for hash collision and handle it
        entries[hashCode] = new Entry(key, value);

    }

    private void redimArray(int newMaxSize){
        Entry<K, V>[] newEntries = new Entry[newMaxSize];
        for(int i=0; i< entries.length; i++){
            newEntries[i] = entries[i];
        }
        entries = newEntries;
    }

    public V get(K key){
        int hashcode = key.hashCode();
        return entries[hashcode].value;
    }

    public List<K> getKeys(){
        List<K> retVal = new ArrayList<>();
        for(int i=0; i< entries.length; i++){
            if(entries[i] != null){
                retVal.add(entries[i].key);
            }
        }

        return retVal;
    }

}
