package ca.bcit.comp2526.A2;
import javafx.scene.text.Font;

/**
 * Rook.
 *
 * @author Wilburt Herrera
 * @version 2018
 */
public class Rook extends ChessPiece {
    
    /**
     * Rook Serial.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Rook Image.
     */
    private String rookImage = "\u265C";
    
    /**
     * Name.
     */
    private String name = "Rook";
    
    /**
     * Constructs an object of type Rook.
     * @param colour of Rook
     * @param xCor an int
     * @param yCor an int
     */
    public Rook(String colour, int xCor, int yCor, int zCor) {
        super(colour, xCor, yCor, zCor);
        setText(rookImage);

        // Assigns black or white icon
        setColour();
        setFont(new Font(ChessPiece.SIZE));
    }
    
    /**
     * Gets the name.
     * @see ca.bcit.comp2526.A2.ChessPiece#getName()
     * @return name.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Checks if valid move.
     * @see ca.bcit.comp2526.A2.ChessPiece#validMove(int, int, int, int)
     * @param fromX
     * @param fromY
     * @param toX
     * @param toY
     * @return boolean
     */
    @Override
    public boolean validMove(Square[][] squareArray, int fromX, int fromY,
            int toX, int toY) {
        
        // Vertical
        if (toX == fromX) {
            
            if (fromY > toY) {
                return checkPath(squareArray, 0, -1, fromX, fromY, toX, toY);
            } else {
                return checkPath(squareArray, 0, 1, fromX, fromY, toX, toY);
            }
        } 
        // Horizontal
        if (toY == fromY) {
            if (fromX > toX) {
                return checkPath(squareArray, -1, 0, fromX, fromY, toX, toY);
            } else {
                return checkPath(squareArray, 1, 0, fromX, fromY, toX, toY);
            }
        }
        return false;
    }

    /**
     * Text to string.
     * @see java.lang.Text#toString()
     * @return a string
     */
    @Override
    public String toString() {
        return (getColour() + " " + name + "(" + (getzCor() + 1) + ")");
    }

}
