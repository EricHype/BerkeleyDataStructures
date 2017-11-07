package com.ericheitmuller.week1;

public class CharacterCounter {

    public static void main(String[] args) {

        String countedChars = countCharacters("abrabbc255");
        System.out.println("End Result is: " + countedChars.toString());
    }


    public static String countCharacters(String whatToCount) {

        if(whatToCount == null){
            return null;
        }

        if(whatToCount.length() == 0){
            return whatToCount;
        }

        char[] whatToTotal = whatToCount.toCharArray();

        Character currentChar = whatToTotal[0];
        int currentAmountSeen =1;

        StringBuilder result = new StringBuilder();

        for(int i=1; i< whatToTotal.length; i++ ){

            if(whatToTotal[i] != currentChar){
                result.append(currentChar);
                result.append(currentAmountSeen);
                currentChar = whatToTotal[i];
                currentAmountSeen = 1;
                continue;
            }

            currentAmountSeen++;
        }

        result.append(currentChar);
        result.append(currentAmountSeen);

        return result.toString();
    }
}
