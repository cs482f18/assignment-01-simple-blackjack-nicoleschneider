package com.example.nicole.simpleblackjackgame;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Class to be the controller and run the Game and update the View that takes user input
 * @author Nicole Schneider
 * @version 1
 */
public class MainActivity extends AppCompatActivity {

    /**
     * represents the game being controlled by this class
     */
    private Game game;

    /**
     * Overridden method to outline behavior of app when it is opened
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View v = findViewById(R.id.blackjackapp);
        newGame(v);
    }

    /**
     * method to update the UI view of all the User Cards
     */
    public void updateUserHandViews(){
        int [] cardIDs = {R.id.card0, R.id.card1, R.id.card2, R.id.card3, R.id.card4};

        for(int i=0; i < game.getUserHand().getHandSize(); i++){
            TextView card = findViewById(cardIDs[i]);
            card.setText(game.getUserHand().getCards()[i].toString());
            card.setBackgroundColor(Color.WHITE);
        }
    }

    /**
     * method to update the UI view of all the Dealer Cards
     */
    public void updateDealerHandViews(){
        int [] cardIDs = {R.id.dealercard0, R.id.dealercard1, R.id.dealercard2, R.id.dealercard3, R.id.dealercard4};

        for(int i=0; i < game.getDealerHand().getHandSize(); i++){
            TextView card = findViewById(cardIDs[i]);
            card.setText(game.getDealerHand().getCards()[i].toString());
            card.setBackgroundColor(Color.WHITE);
        }
    }

    /**
     * method to show the user who has won the Game
     */
    public void displayWinner(){
        TextView winnerView = findViewById(R.id.winnerdisplay);
        winnerView.setBackgroundColor(Color.WHITE);

        if(game.getWinner() == null)
            winnerView.setText("           Tie!");
        else
            winnerView.setText("   " + game.getWinner().toString() + " Won!");

        disableButtons();
    }

    /**
     * method to clear out Cards from past Game so a new Game can be played
     */
    public void clearViews(){
        int [] cardIDs = {R.id.card0, R.id.card1, R.id.card2, R.id.card3, R.id.card4};
        int [] dealercardIDs = {R.id.dealercard0, R.id.dealercard1, R.id.dealercard2, R.id.dealercard3, R.id.dealercard4};

        for(int i=0; i < Hand.MAX_HAND_SIZE; i++){
            TextView dealercard = findViewById(dealercardIDs[i]);
            dealercard.setBackgroundColor(Color.BLACK);
            dealercard.setText("");
        }
        for(int i=0; i < Hand.MAX_HAND_SIZE; i++){
            TextView card = findViewById(cardIDs[i]);
            card.setBackgroundColor(Color.BLACK);
            card.setText("");
        }

        TextView winnerView = findViewById(R.id.winnerdisplay);
        winnerView.setBackgroundColor(Color.BLACK);
        winnerView.setText("");
    }

    /**
     * helper method to disable hit and stand buttons so user cannot click them
     */
    public void disableButtons(){
        android.view.View hitbutton = findViewById(R.id.hit_button);
        hitbutton.setEnabled(false);
        android.view.View standbutton = findViewById(R.id.stand_button);
        standbutton.setEnabled(false);
    }

    /**
     * method to be called when user clicks Hit button
     * @param v
     */
    public void userHit(android.view.View v){
        game.executeHitTurn();

        if (game.getWinner() != null) // game over
            displayWinner();

        updateUserHandViews();
    }

    /**
     * method to be called when user clicks Stand button
     * @param v
     */
    public void userStand(android.view.View v){
        game.executeStandTurn();
        android.view.View button = findViewById(R.id.stand_button);
        button.setEnabled(false);

        game.dealerMove();
        updateDealerHandViews();

        displayWinner();
    }

    /**
     * method to be called when user clicks New button
     * @param v
     */
    public void newGame(android.view.View v){
        game = new Game();
        clearViews();

        updateUserHandViews();
        updateDealerHandViews();

        android.view.View button = findViewById(R.id.hit_button);
        button.setEnabled(true);
        button = findViewById(R.id.stand_button);
        button.setEnabled(true);
    }
}