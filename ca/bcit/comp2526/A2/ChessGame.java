package ca.bcit.comp2526.A2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * ChessGame.
 *
 * @author Wilburt Herrera
 * @version 2018
 */
public class ChessGame extends Application {
    
    /**
     * Board width.
     */
    public static final int WIDTH = 1200;
    
    /**
     * Board height.
     */
    public static final int HEIGHT = 425;
    
    /**
     * Menu offset.
     */
    public static final int OFFSET = 25;
    
    /**
     * Dimensions.
     */
    public static final int DIMENSIONS = 8;
    
    /**
     * Chessboard.
     */
    protected Board3D chessboard;
    
    
    /**
     * File.
     */
    private File file;
    
    /**
     * Filechooser.
     */
    private FileChooser fileChooser = new FileChooser();
    
    /**
     * Launches the Chess game.
     * @see javafx.application.Application#start(javafx.stage.Stage)
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        chessboard = new Board3D();
        chessboard.newGame();
        
        Scene scene;
        Group root = new Group();

        MenuBar menuBar = new MenuBar();

        Menu menu1 = new Menu("Menu");

        MenuItem newGame = new MenuItem("New Game");
        newGame.setOnAction(new EventHandler<ActionEvent>() {
        
            public void handle(ActionEvent e) {
                chessboard.newGame();
            }
        });

        MenuItem saveGame = new MenuItem("Save");
        saveGame.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                saveFile(e);
            }
        });

        MenuItem loadGame = new MenuItem("Load");
        loadGame.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                openFile(e);
            }
        });

        menu1.getItems().add(newGame);
        menu1.getItems().add(saveGame);
        menu1.getItems().add(loadGame);
        menuBar.getMenus().add(menu1);

        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        root.getChildren().add(chessboard);
        root.getChildren().add(menuBar);
        chessboard.setLayoutY(OFFSET);
        
        scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setTitle("Chess Game");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    /**
     * Opens file.
     * @param click event.
     */
    private void openFile(ActionEvent click) {
        try {
            
        fileChooser.setTitle("Open Saved Game");
        file = fileChooser.showOpenDialog(null);
        FileInputStream fileLoad = new FileInputStream(file);
        ObjectInputStream load = new ObjectInputStream(fileLoad);
        SaveState saveState = (SaveState) load.readObject();
        
        
        System.out.println(file);
        
        chessboard.getChildren().clear();
        chessboard.setSquares(WIDTH, HEIGHT);
        
//        chessboard.setNewGame();
        //setSaveLoad();
        
        System.out.println("Piece Loaded");
        
        ArrayList<ChessPiece> pieceArray = saveState.getPieceArray();
        for (ChessPiece piece : pieceArray) {
            chessboard.makePiece(piece.getName(), piece.getColour(),
                    piece.getxCor(), piece.getyCor(), 0);
        }
        
        load.close();
        fileLoad.close();
        } catch (FileNotFoundException e) {
            System.out.println("No File selected");
        } catch (IOException e) {
            System.out.println("IO Exception");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFound Exception");
        } catch (NullPointerException e) {
            System.out.println("No File Selected");
        }
        
    }
    
    /**
     * Serializes the file.
     * @param click an event
     */
    private void saveFile(ActionEvent click) {
        
        SaveState saveState = new SaveState();
        for (int i = 0; i < DIMENSIONS; i++) {
            for (int j = 0; j < DIMENSIONS; j++) {
                if (chessboard.squareArray[i][j].getPiece() != null) {
                    saveState.savePiece(
                            chessboard.squareArray[i][j].getPiece());
                }
            }
        }

        FileChooser.ExtensionFilter extFilter = 
                new FileChooser.ExtensionFilter("TXT files (*.txt)",
                        "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        file = fileChooser.showSaveDialog(null);
        if (file != null) {
            try {
                FileOutputStream fileSave = new FileOutputStream(file);
                ObjectOutputStream save = new ObjectOutputStream(fileSave);
                
                save.writeObject(saveState);
                save.flush();
                save.close();
                fileSave.close();
            System.out.println("File Saved");
            } catch (FileNotFoundException e) {
                System.out.println("File Not Found");
            } catch (IOException e) {
                System.out.println("IO Exception Save");
                System.out.println(e.getMessage());
            }
        }
    }
    
    
    /**
     * Instantiates and runs the game.
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
