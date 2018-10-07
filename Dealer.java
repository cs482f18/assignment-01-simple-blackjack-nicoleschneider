package com.example.nicole.simpleblackjackgame;

/**
 * Class representing game Dealer
 * Subclass of abstract Player class
 * @author Nicole Schneider
 * @version 1
 */
public class Dealer extends Player {

    /**
     * represents the threshold at which the Dealer will no longer choose to hit
     */
    public static final int THRESHOLD = 17;

    /**
     * Overridden toString to describe this Player as Dealer
     * @return string "Dealer"
     */
    @Override
    public String toString(){
        return "Dealer";
    }

}
