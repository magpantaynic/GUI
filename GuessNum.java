import javafx.application.*;
import javafx.stage.*;
import javafx.stage.FileChooser.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.effect.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.image.*;
import javafx.event.*;
import javafx.animation.*;
import javafx.geometry.*;
import java.util.*;

/**
 * HW14: Guess The number
 * Creator: Lee Stemkoski
 * Submitted by: Nicole Magpantay
 * 
 * The computer will randomly choose a secret number between 1 and 100.
 *  
 */
public class GuessNum extends Application
{
    public static void main(String[] args)
    {
        try
        {
            launch(args);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            System.exit(0);
        }
    }
    //. The player then tries to guess the number. If the guessed number is 
    // higher or lower than the actual secret number, a hint is given accordingly, 
    // such as “guess higher” or “guess lower”. The total number of guesses made by
    // the player is displayed. When the secret number is guessed exactly, a 
    // congratulations message is displayed. The player has the ability to 
    // start a new game.

    //random number holder
    int NumGuess;
    int guessCount;
    Label winner;
    Label LabelGuess;
    boolean win;
    public void start(Stage mainStage)
    {
        mainStage.setTitle("Guess The Number");
        //add some images
        mainStage.getIcons().add(new Image("icons/monitor.png"));
        BorderPane root = new BorderPane();
        MenuBar menuBar = new MenuBar();
        Menu file = new Menu("File");
        MenuItem quit = new MenuItem("Quit");
        menuBar.getMenus().add(file);
        file.getItems().add(quit);
        root.setTop(menuBar);
        VBox centerBox = new VBox();
        centerBox.setPadding(new Insets(16) );
        centerBox.setSpacing( 40 );
        centerBox.setAlignment( Pos.CENTER );
        root.setCenter(centerBox);
        Scene mainScene = new Scene(root, 600, 600);
        mainStage.setScene(mainScene);
        // add the stylesheet
        mainScene.getStylesheets().add("assets/stylesheet.css");
        
        // Make a textfield for the user to enter a number
        Label todo = new Label("Choose a number between 1-100: ");
        TextField input = new TextField();
        //create the buttons for guessing and playing again
        Button guess = new Button("Guess");
        Button again = new Button("Play Again");
        //give our buttons some colors to make lookable
        guess.getStyleClass().add("fancy-button");
        again.getStyleClass().add("fancy-button");
        winner = new Label("You guessed: ");
        LabelGuess = new Label("number of guesses: ");
        //set the random to be 1-100
        NumGuess = (int)(100 * Math.random() +1);
        //when button is clicked have the computer check to see if the user number
        //matches with the computer number
        win = false;
        guess.setOnAction((ActionEvent event) ->
            {
                if(!win)
                {
                    if(input.getText().isEmpty())
                    {
                        Alert info = new Alert(AlertType.INFORMATION);
                        info.setTitle("ERROR");
                        info.setHeaderText(null);
                        info.setContentText("Choose a number "+
                            "between 1-100");
                        info.setGraphic(
                            new ImageView( new Image("icons/cross.png",64,64,true,true)));
                        info.showAndWait();
                    }
                    else
                    {
                        try
                        {
                            //convert the text to a integer	
                            int num = Integer.parseInt(input.getText());
                            if(num < NumGuess)
                            {
                                winner.setText("Too low");
                            }
                            else if( num > NumGuess)
                            {
                                winner.setText("Too high");
                            }
                            else
                            {
                                winner.setText("Winner!");
                                win = true;
                            }                 	
                            if(num <= 0)
                            {
                                Alert info = new Alert(AlertType.INFORMATION);
                                info.setTitle("ERROR");
                                info.setHeaderText(null);
                                info.setContentText("Enter a number "+
                                    "between 1-100");
                                info.setGraphic(
                                    new ImageView( new Image("icons/cross.png",64,64,true,true)));
                                info.showAndWait();
                            }
                        }
                        catch(Exception error)
                        {
                            Alert info = new Alert(AlertType.INFORMATION);
                            info.setTitle("ERROR");
                            info.setHeaderText(null);
                            info.setContentText("Please enter a number "+
                                "in the range of 1-100");
                            info.setGraphic(
                                new ImageView( new Image("icons/cross.png",64,64,true,true)));
                            info.showAndWait();
                        }
                    }

                    //go up by one when the guess button is chosen
                    guessCount++;
                    //as the user clicks the button hae the system show them
                    //how many guesses they have made
                    guess.setText("number of guesses: " + guessCount);
                }
            }
        );
        //when clicked the first initial number should be randomized again
        again.setOnAction((ActionEvent event) ->
            {
                NumGuess = (int)(100 * Math.random() +1);
                //reset the counter to start new game
                guessCount = 0;
                guess.setText("number of guesses: " + guessCount);
                //clear the current text inside the textbar
                input.clear();
                win = false;
            }
        );
        quit.setOnAction((ActionEvent event) ->
            {
                System.exit(0);
            }	
        );  
        centerBox.getChildren().addAll(todo,input,guess,again,winner,LabelGuess);
        //show the stage
        mainStage.show();
    }
}
