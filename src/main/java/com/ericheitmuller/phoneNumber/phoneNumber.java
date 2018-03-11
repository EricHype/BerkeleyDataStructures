package com.ericheitmuller.phoneNumber;

import java.util.HashMap;
import java.util.Map;

public class phoneNumber {

    // hashTable[i] stores all characters that correspond to digit i in phone
    //const char hashTable = {"", "", "abc", "def", "ghi", "jkl",
    //        "mno", "pqrs", "tuv", "wxyz"};

    private static final Map<Integer, String> hashTable;
    static
    {
        hashTable = new HashMap<Integer, String>();
        hashTable.put(0, "");
        hashTable.put(1, "");
        hashTable.put(2, "abc");
        hashTable.put(3, "def");
        hashTable.put(4, "ghi");
        hashTable.put(5, "jkl");
        hashTable.put(6, "mno");
        hashTable.put(7, "pqrs");
        hashTable.put(8, "tuv");
        hashTable.put(9, "wxyz");
    }


    public static void main(String[] args) {
        int number[] = {2, 3, 4};
        int n = number.length;
        printWords(number, n);
    }


    // A wrapper over printWordsUtil().  It creates an output array and
    // calls printWordsUtil()
    static void printWords(int number[], int n)
    {
        char[] result = new char[n+1];
        result[n] =',';
        printWordsUtil(number, 0, result, n);
    }



    // A recursive function to print all possible words that can be obtained
// by input number[] of size n.  The output words are one by one stored
// in output[]
    static void  printWordsUtil(int number[], int curr_digit, char output[], int n)
    {
        // Base case, if current output word is prepared
        int i;
        if (curr_digit == n)
        {
            System.out.print(output);
            return ;
        }

        // Try all 3 possible characters for current digir in number[]
        // and recur for remaining digits
        int length = hashTable.get(number[curr_digit]).length();
        for (i=0; i< length; i++)
        {
            output[curr_digit] = hashTable.get(number[curr_digit]).charAt(i);
            printWordsUtil(number, curr_digit+1, output, n);
            if (number[curr_digit] == 0 || number[curr_digit] == 1)
                return;
        }
    }
}
