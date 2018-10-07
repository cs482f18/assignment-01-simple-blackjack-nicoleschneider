package com.example.nicole.simpleblackjackgame;

/**
 * Class representing a blackjack hand of at most 5 Cards
 * @author Nicole Schneider
 * @version 1
 */
public class Hand {
    /**
     * represents the limit placed on how many Cards can be dealt to the Hand
     */
    public static final int MAX_HAND_SIZE = 5;

    /**
     * represents the number of Cards a Hand starts out with before any hitting is done
     */
    public static final int STARTING_HAND_SIZE = 2;

    /**
     * represents the highest value a Hand can have before it busts
     */
    public static final int BLACKJACK_VALUE = 21;

    /**
     * represents the series of Cards that make us a Hand
     */
    private Card [] cards = new Card[MAX_HAND_SIZE];

    /**
     * represents the number of Cards in the Hand currently
     */
    private int handSize;

    /**
     * represents the total numerical value of the Hand currently
     */
    private int handValue;

    /**
     * Parameterized constructor that takes 2 Cards to start the hand off with
     * @param c0 first Card
     * @param c1 second Card
     */
    public Hand(Card c0, Card c1){
        cards[0] = c0;
        cards[1] = c1;
        handSize = STARTING_HAND_SIZE;
        updateValue();
    }

    /**
     * method to recalculate the value of the hand after new Cards have been added
     */
    public void updateValue(){
        int temp = 0;
        for(int i=0; i<handSize; i++){
            if(cards[i].getValue()==11 && (temp + 11 > BLACKJACK_VALUE)) // if Ace and bust
                temp += 1; // make Ace soft
            else
                temp += cards[i].getValue();

        }
        this.handValue = temp;
    }

    /**
     * getter method to return hand value
     * @return value of hand
     */
    public int getValue(){
        return this.handValue;
    }

    /**
     * getter method to return array of Cards
     * @return Card array
     */
    public Card[] getCards(){
        return cards;
    }

    /**
     * getter method to return size of hand currently
     * @return integer hand size
     */
    public int getHandSize(){
        return handSize;
    }

    /**
     * method to add a Card to the hand
     * @param c Card to be added
     * @return true if successfully added Card, false otherwise
     */
    public boolean addCard(Card c){
        if (handSize < MAX_HAND_SIZE){ // there is room to add the card
            cards[handSize] = c;
            handSize++;
            updateValue();
            return true;
        }
        else
            return false;
    }

    /**
     * Overidden toString method that returns hand as a string with all the Card names
     * @return String representation of Hand
     */
    @Override
    public String toString(){
        String str = "\n";
        for(int i=0; i<handSize; i++){
            str = str + cards[i] + "\n";
        }
        return str;
    }
}
