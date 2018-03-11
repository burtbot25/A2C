package ca.bcit.comp2526.A2;
import javafx.scene.text.Font;

/**
 * Bishop.
 *
 * @author Wilburt Herrera
 * @version 2018
 */
public class Bishop extends ChessPiece {

    /**
     * Bishop Serial.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Bishop Image.
     */
    private String bishopImage = "\u265D";
    
    /**
     * Name.
     */
    private String name = "Bishop";
    
    /**
     * Constructs an object of type Bishop.
     * @param colour of Bishop
     * @param xCor an int
     * @param yCor an int
     */
    public Bishop(String colour, int xCor, int yCor, int zCor) {
        super(colour, xCor, yCor, zCor);
        setText(bishopImage);

        // Assigns black or white icon
        setColour();
        
        setFont(new Font(ChessPiece.SIZE));
        
    }

    /**
     * Gets the name.
     * @see ca.bcit.comp2526.A2.ChessPiece#getName()
     * @return a name;
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
        
        // Up-left
        if (fromX - toX > 0 && fromX - toX == fromY - toY) {
            System.out.println("upleft");
            return checkPath(squareArray, -1, -1, fromX, fromY, toX, toY);
        }
        
        // Up-right
        if (fromX - toX < 0 && fromX - toX == (fromY - toY) * -1) {
            System.out.println("upright");
            return checkPath(squareArray, 1, -1, fromX, fromY, toX, toY);
        }
        
        // Down-left
        if (fromX - toX > 0 && fromX - toX == (fromY - toY) * -1) {
            System.out.println("downleft");
            return checkPath(squareArray, -1, 1, fromX, fromY, toX, toY);
        }
        
        // Down-right
        if (fromX - toX < 0 && fromX - toX == fromY - toY) {
            System.out.println("downright");
            return checkPath(squareArray, 1, 1, fromX, fromY, toX, toY);
        }
        
        
        return false;
    }

}
