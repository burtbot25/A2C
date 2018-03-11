package ca.bcit.comp2526.A2;
import javafx.scene.text.Font;

/**
 * Queen.
 *
 * @author Wilburt Herrera
 * @version 2018
 */
public class Queen extends ChessPiece {
    
    /**
     * Queen Serial.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Queen Image.
     */
    private String queenImage = "\u265B";
    
    /**
     * Name.
     */
    private String name = "Queen";
    
    /**
     * Constructs an object of type Queen.
     * @param colour of Queen
     * @param xCor an int
     * @param yCor an int
     */
    public Queen(String colour, int xCor, int yCor, int zCor) {
        super(colour, xCor, yCor, zCor);
        setText(queenImage);

        // Assigns black or white icon
        setColour();
        
        setFont(new Font(ChessPiece.SIZE));
        
    }
    
    /**
     * Gets the name.
     * @see ca.bcit.comp2526.A2.ChessPiece#getName()
     * @return a name
     */
    public String getName() {
        return name;
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
    boolean validMove(Square[][] squareArray, int fromX, int fromY,
            int toX, int toY) {
        
        // Diagonal Movements
        // Up-left
        if (fromX - toX > 0 && fromX - toX == fromY - toY) {
            //return checkPath(squareArray, -1, -1, fromX, fromY, toX, toY);
        }
        
        // Up-right
        if (fromX - toX < 0 && fromX - toX == (fromY - toY) * -1) {
            //return checkPath(squareArray, 1, -1, fromX, fromY, toX, toY);
        }
        
        // Down-left
        if (fromX - toX > 0 && fromX - toX == (fromY - toY) * -1) {
            //return checkPath(squareArray, -1, 1, fromX, fromY, toX, toY);
        }
        
        // Down-right
        if (fromX - toX < 0 && fromX - toX == fromY - toY) {
            //return checkPath(squareArray, 1, 1, fromX, fromY, toX, toY);
        }
        
        // Vertical
        if (toX == fromX) {
            
//            if (fromY > toY) {
//                return checkPath(squareArray, 0, -1, fromX, fromY, toX, toY);
//            } else {
//                return checkPath(squareArray, 0, 1, fromX, fromY, toX, toY);
//            }
        } 
        // Horizontal
        if (toY == fromY) {
//            if (fromX > toX) {
//                return checkPath(squareArray, -1, 0, fromX, fromY, toX, toY);
//            } else {
//                return checkPath(squareArray, 1, 0, fromX, fromY, toX, toY);
//            }
        }
        return true;
        
    }

}
