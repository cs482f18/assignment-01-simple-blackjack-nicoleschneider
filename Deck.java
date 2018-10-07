package com.example.nicole.simpleblackjackgame;

import java.util.Collections;
import java.util.Stack;

/**
 * Class to represent a Deck of 52 Cards
 * @author Nicole Schneider
 * @version 1
 */
public class Deck {

    /**
     * represents the stack of Cards in a Deck
     */
    private Stack<Card> cardStack;

    /**
     * constructor to create the Deck stack according to conventional values and suits
     */
    public Deck() {
        String nameArr[] = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        int valueCount = 2;
        cardStack = new Stack<>();
        for (String n : nameArr) {
            if(n.equals("A"))
                valueCount = 11; // special case for Ace card
            for (Suit s : Suit.values())
                cardStack.add(new Card(valueCount, n, s)); //populate cardStack

        valueCount++;
        if (valueCount > 10)
            valueCount = 10; // max point value for regular (non Ace) cards
        }
    }

    /**
     * Overridden toString to return a string representation of all the Cards in the Deck in order
     * @return ordered list of Cards in String format
     */
    @Override
    public String toString(){
        String str = "";
        for (Card c : cardStack){
            str = str + c + "\n";
        }
        return str;
    }

    /**
     * method to shuffle Deck's Card order randomly
     */
    public void shuffle(){
        Collections.shuffle(cardStack);
    }

    /**
     * method to remove the top Card from the Deck
     * @return top Card
     */
    public Card drawTopCard(){
        if(!cardStack.isEmpty()){
            return cardStack.pop();
        }
        else{
            return null;
        }
    }
}