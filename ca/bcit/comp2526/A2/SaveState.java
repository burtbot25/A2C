package ca.bcit.comp2526.A2;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * SaveState.
 *
 * @author Wilburt Herrera
 * @version 2018
 */
public class SaveState implements Serializable {

    /**
     * Serial Number.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Holds all the pieces to be saved.
     */
    protected ArrayList<ChessPiece> pieceArray = new ArrayList<ChessPiece>();
    
    /**
     * Method to save pieces into this object.
     * @param piece a ChessPiece
     */
    public void savePiece(ChessPiece piece) {
        pieceArray.add(piece);
    }
    
    /**
     * Returns the squareArray for this SaveState.
     * @return squareArray
     */
    public ArrayList<ChessPiece> getPieceArray() {
        return pieceArray;
    }

        
}
