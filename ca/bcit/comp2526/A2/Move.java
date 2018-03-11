package ca.bcit.comp2526.A2;

import javafx.scene.input.MouseEvent;

/**
 * Move.
 *
 * @author Wilburt Herrera
 * @version 2018
 */
public interface Move {

    /**
     * Moves piece.
     * @param e Mouse event
     * @return a boolean
     */
    boolean move(MouseEvent e);
    
    /**
     * Toggles selected piece.
     * @param e Mouse event
     */
    void togglePiece(MouseEvent e);
    
}
