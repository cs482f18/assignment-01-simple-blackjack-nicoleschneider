package com.example.nicole.simpleblackjackgame;

/**
 * enumerated type to represnt all the possible suits a Card can be
 */
enum Suit{
    H, D, C, S
}

/**
 * Class representing one card
 * @author Nicole Schneider
 * @version 1 10/05/2018  // don't forget to add date
 */
public class Card {
    
    /** Write javadoc comments to describe your instance variables such as value*/
    private int value;
    /** Write javadoc comments to describe your instance variables such as name */
    private String name;
    private Suit suit;

    /**
     * Parameterized constructor method for a card
     * @param cardValue
     * @param cardName
     * @param cardSuit
     */
    public Card(int cardValue, String cardName, Suit cardSuit){
        this.value = cardValue;
        this.name = cardName;
        this.suit = cardSuit;
    }

    /**
     * Overridden toString method to represent card object as a string
     * @return String representation of a card
     */
    @Override
    public String toString(){
        String suitString;
        if(this.suit == Suit.H)
            suitString = "♥";
        else if(this.suit == Suit.S)
            suitString = "♠";
        else if(this.suit == Suit.C)
            suitString = "♣";
        else
            suitString = "\t♦";

        return this.name + " " + suitString;
    }

    /**
     * Getter method to access numerical value of card
     * @return integer value of card
     */
    public int getValue(){
        return value;
    }

    /**
     * Setter method for value
     * SHOULD ONLY BE USED TO MAKE ACE VALUE 'SOFT' TO 1 IS HAND IS BUST
     * @param newValue new value for card to take on
     */
    public void setValue(int newValue){
        this.value = newValue;
    }

    /**
     * Getter method to access name/type of card (King, 10, 3, etc)
     * @return string representation of card name
     */
    public String getName(){
        return name;
    }

}
