package ca.bcit.comp2526.A2;
import javafx.scene.text.Font;

/**
 * King.
 *
 * @author Wilburt Herrera
 * @version 2018
 */
public class King extends ChessPiece {
    
    /**
     * King Serial.
     */
    private static final long serialVersionUID = 1L;

    /**
     * King Image.
     */
    private String kingImage = "\u265A";
    
    /**
     * Name.
     */
    private String name = "King";
    
    /**
     * Constructs an object of type King.
     * @param colour of King
     * @param xCor an int
     * @param yCor an int
     */
    public King(String colour, int xCor, int yCor, int zCor) {
        super(colour, xCor, yCor, zCor);
        setText(kingImage);

        // Assigns black or white icon
        setColour();
        
        setFont(new Font(ChessPiece.SIZE));
        
    }
    
    /**
     * Get Name.
     * @see ca.bcit.comp2526.A2.ChessPiece#getName()
     * @return name.
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
     * @return a boolean
     */
    @Override
    boolean validMove(Square[][] squareArray, int fromX, int fromY,
            int toX, int toY) {
        int move = (int) (Math.pow((toX - fromX), 2) 
                + Math.pow((toY - fromY), 2));
        return (move == 1 || move == 2);
    }

}
