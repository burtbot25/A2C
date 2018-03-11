package ca.bcit.comp2526.A2;

/**
 * Board3D
 *
 * @author Wilburt Herrera
 * @version 2018
 */
public class Board3D extends Board {

    String squareColour;
    
    public void newGame() {
        setSquares(24, 8);
        setWhitePieces();
        setBlackPieces();
        System.out.println("Started New Game");
    }

    /**
     * @see ca.bcit.comp2526.A2.Board#setSquares(int, int)
     * @param rows
     * @param cols
     */
    public void setSquares(int rows, int cols) {
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                // Determines colour of square
                if (x >= 0 && x <= 7) {
                    level = 1;
                    squareColour = ((x + y) % 2 == 0) ? "grey" : "light grey";
                    squareArray[x][y] = new Square(squareColour, x, y, level);
                } else if (x >= 8 && x <= 15) {
                    level = 2;
                    squareColour = ((x + y) % 2 == 0) ? "blue" : "royalblue";
                    squareArray[x][y] = new Square(squareColour, x, y, level);
                } else {
                    level = 3;
                    squareColour = ((x + y) % 2 == 0) ? "grey" : "light grey";
                    squareArray[x][y] = new Square(squareColour, x, y, level);
                }
                
                add(squareArray[x][y], x, y);
                
                // Returns coordinates of the square
                squareArray[x][y].setOnMousePressed(this::move);
                
            }
        }
    }
}
