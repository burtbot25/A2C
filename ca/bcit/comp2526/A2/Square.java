package ca.bcit.comp2526.A2;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



/**
 * Squares class.
 *
 * @author Wilburt Herrera
 * @version 2018
 */
public class Square extends Rectangle {

    /**
     * Square size.
     */
    public static final int SQUARE_SIZE = 50;
    
    /**
     * Color toggle.
     */
    private boolean toggle;
    
    /**
     * Colour of the square.
     */
    private String colour;
    
    /**
     * X coordinate.
     */
    private int xCor;
    
    /**
     * Y coordinate.
     */
    private int yCor;
    
    /**
     * Z coodinate.
     */
    private int zCor;
    
    /**
     * Chess piece on Square.
     */
    private ChessPiece piece;
    
    /**
     * Constructs an object of type Square.
     * @param colour of square
     * @param x location
     * @param y location
     * @param z level
     */
    public Square(String colour, int x, int y, int z) {
        
        this.colour = colour;
        this.xCor = x;
        this.yCor = y;
        this.zCor = z;
        
        setWidth(SQUARE_SIZE);
        setHeight(SQUARE_SIZE);
        
        setColour();
        
        this.setOnMouseEntered(this::hover);
        this.setOnMouseExited(this::hover);
        
    }
    
    /**
     * Highlights the borders blue when selected.
     * @param me an event.
     */
    public void hover(MouseEvent me) {
        if (!toggle) {
            setFill(Color.CYAN);
            toggle = true;
        } else {
            setColour();
            toggle = false;
        }
    }
    
    /**
     * Sets Color.
     */
    public void setColour() {
        if (colour.equals("grey")) {
            this.setFill(Color.GREY);
        } else if (colour.equals("light grey")) {
            this.setFill(Color.LIGHTGREY);
        } else if (colour.equals("blue")) {
            this.setFill(Color.BLUE);
        } else if (colour.equals("royalblue")) {
            this.setFill(Color.ROYALBLUE);
        }
    }
    
    /**
     * Returns the x for this Square.
     * @return x
     */
    public int getxCor() {
        return xCor;
    }

    /**
     * Returns the y for this Square.
     * @return y
     */
    public int getyCor() {
        return yCor;
    }

    /**
     * Returns the zCor for this Square.
     * @return zCor
     */
    public int getzCor() {
        return zCor;
    }

    /**
     * Sets the zCor for this Square.
     * @param zCor the zCor to set
     */
    public void setzCor(int zCor) {
        this.zCor = zCor;
    }

    /**
     * String representation of this Square.
     * @see java.lang.Rectangle#toString()
     * @return
     */
    @Override
    public String toString() {
        return colour + " Square" + "(" + getzCor() + ")";
    }
    
    /**
     * Gets square source.
     * @return an Object.
     */
    public Object getSource() {
        return new Square(null, 0, 0, 0);
    }

    /**
     * Returns the piece for this Square.
     * @return piece
     */
    public ChessPiece getPiece() {
        return piece;
    }
    
    /**
     * Sets the piece for this Square.
     * @param piece the piece to set
     */
    public void setPiece(ChessPiece piece) {
        this.piece = piece;
    }
}
