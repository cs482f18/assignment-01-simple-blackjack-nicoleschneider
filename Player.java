package com.example.nicole.simpleblackjackgame;

/**
 * Abstract class representing a Player in the blackjack Game
 * @author Nicole Schneider
 * @version 1
 */
public abstract class Player {

    /**
     * represents the hand of Cards that this Player holds
     */
    protected Hand playerHand;

    /**
     * method to give Player's Hand its first 2 Cards
     * @param c1 first Card
     * @param c2 second Card
     */
    public void createHand(Card c1, Card c2){
        playerHand = new Hand(c1, c2);
    }

    /**
     * method to represent Player hitting
     * @param d Deck from which to draw the Card
     * @return true if hit was successful, false otherwise
     */
    public boolean hit(Deck d){
        return playerHand.addCard(d.drawTopCard());
    }

    /**
     * method to check if Player has blackjack Hand
     * @return true if blackjack, false otherwise
     */
    public boolean hasBlackJack(){
        return playerHand.getValue() == Hand.BLACKJACK_VALUE && playerHand.getHandSize() == Hand.STARTING_HAND_SIZE;
    }

    /**
     * getter method to return Player's Hand
     * @return Hand of the Player
     */
    public Hand getHand(){
        return playerHand;
    }

    /**
     * method to check if Player has busted (gone over 21)
     * @return true if busted, false otherwise
     */
    public boolean isBust(){
        return playerHand.getValue() > Hand.BLACKJACK_VALUE;
    }

}