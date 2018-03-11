package ca.bcit.comp2526.A2;

/**
 * Player of the game.
 *
 * @author Wilburt Herrera
 * @version 2018
 */
public class Player {

    /**
     * Determines if Player is black or white.
     */
    private boolean isWhite;
    
    /**
     * Constructs an object of type Player.
     * @param colour a String.
     */
    public Player(String colour) {
         if (colour.equals("white")) {
             isWhite = true;
         }
    }
    
    /**
     * Checks in the player is White or Black.
     * @return a boolean.
     */
    public boolean isWhite() {
        return isWhite;
    }
}
