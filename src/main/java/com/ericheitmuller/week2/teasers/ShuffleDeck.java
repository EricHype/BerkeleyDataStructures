package com.ericheitmuller.week2.teasers;


//1. Given a deck of cards, shuffle the cards and print 4 of the shuffled cards.


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShuffleDeck {

    public static void main(String[] args) {
        List<Card> shuffledDeck = getDefaultDeck();
        shuffle(shuffledDeck);

        for(int i=0; i<4; i++){
            Card c = shuffledDeck.get(i);
            System.out.println("Card is:" + c.value + " " + c.suit.name());
        }
    }


    public static void shuffle(List<Card> deck){
        Random r = new Random();

        for(int i=0; i< deck.size(); i++){
            int random = r.nextInt(deck.size());
            Card c1 = deck.get(i);
            Card c2 = deck.get(random);

            deck.set(i, c2);
            deck.set(random, c1);
        }
    }


    public static List<Card> getDefaultDeck(){
        List<Card> retVal = new ArrayList<>();

        for(SuitType suit : SuitType.values()){
            for(int i=1; i<=13; i++){

                switch (i){
                    case 13:
                        retVal.add(new Card("K", suit));
                        break;
                    case 12:
                        retVal.add(new Card("Q", suit));
                        break;
                    case 11:
                        retVal.add(new Card("J", suit));
                        break;
                    case 1:
                        retVal.add(new Card("A", suit));
                        break;
                    default:
                        retVal.add(new Card(Integer.toString(i), suit));
                        break;
                }

            }
        }

        return retVal;
    }




}

enum SuitType{
    Spade,
    Club,
    Heart,
    Diamond
}

class Card{
    String value;
    SuitType suit;

    public Card(String value, SuitType suit) {
        this.value = value;
        this.suit = suit;
    }
}