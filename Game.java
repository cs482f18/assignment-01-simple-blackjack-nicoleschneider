package com.example.nicole.simpleblackjackgame;

/**
 * Class to represent a game of blackjack
 * @author Nicole Schneider
 * @version 1 Date
 */
public class Game {

    /** javadoc description of instanc evariable */
    private User user;
    private Dealer dealer;
    private Deck deck;

    /**
     * represents the Player whose turn it is currently in the Game
     */
    private Player playerUp;

    /**
     * represents the Player (Dealer or User) who won or null if no one has won yet
     */
    private Player winner;


    /**
     * constructor to create a Game with a Deck and 2 Players
     */
    public Game(){
        deck = new Deck();
        deck.shuffle();

        user = new User();
        user.createHand(deck.drawTopCard(), deck.drawTopCard());

        dealer = new Dealer();
        dealer.createHand(deck.drawTopCard(), deck.drawTopCard());

        playerUp = user;
    }

    /**
     * helper method to switch the Player whose turn it is in the Game
     */
    public void switchPlayers(){
        if (playerUp == dealer)
            playerUp = user;
        else
            playerUp = dealer;
    }

    /**
     * method to represent a hit taking place
     * @return true of hit was successful, false otherwise
     */
    public boolean executeHitTurn(){
        boolean turnSucceeded = playerUp.hit(deck);

        if(playerUp.isBust()){
            if(playerUp == user)
                this.winner = dealer;
            else
                this.winner = user;
        }
        return turnSucceeded;
    }

    /**
     * method to represent a stand taking place
     */
    public void executeStandTurn(){
        if(playerUp == user)
            switchPlayers(); // now its dealer's turn
        else
            pickWinner(); // dealer stood, game is done
    }

    /**
     * getter method to return winner of game
     * @return User, Dealer, or null Player of no one has won yet
     */
    public Player getWinner(){
        return this.winner;
    }

    /**
     * method to compare Dealer and Player Hands and check who won
     */
    public void pickWinner(){
        int userValue = user.getHand().getValue();
        int dealerValue = dealer.getHand().getValue();

        if(user.hasBlackJack() && dealer.hasBlackJack())
            this.winner = null; // tie
        else if(userValue == dealerValue)
            this.winner = null;
        else if(user.hasBlackJack())
            this.winner = user;
        else if(dealer.hasBlackJack())
            this.winner = dealer;
        else if(user.isBust())
            this.winner = dealer;
        else if(dealer.isBust())
            this.winner = user;
        else if(userValue > dealerValue)
            this.winner = user;
        else
            this.winner = dealer;
    }

    /**
     * getter method to return User Hand
     * @return Hand of User
     */
    public Hand getUserHand(){
        return user.getHand();
    }

    /**
     * getter method to return Dealer Hand
     * @return Hand of Dealer
     */
    public Hand getDealerHand(){
        return dealer.getHand();
    }

    /**
     * method to represent Dealer making moves automatically
     */
    public void dealerMove(){
        while(dealer.getHand().getValue() < Dealer.THRESHOLD){
            boolean success = dealer.hit(deck);
            if(!success) // dealer exceeded MAX_HAND_SIZE
                break;
        }
        pickWinner();
    }
}
