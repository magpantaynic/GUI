import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
// add the layout classes: VBox, HBox, GridPane, BorderPane
import javafx.scene.layout.*;
// add margins around edges of application
import javafx.geometry.Insets;
// specify alignment of layout contents
import javafx.geometry.Pos;
//packages from WebBrowser
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import java.io.*;
import java.util.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.event.*;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.event.EventHandler;
import javafx.scene.web.*;
/**
 *   FINAL PROJECT: Full CalcDesign
 *   Author: Lee Stemkoski
 *   Submitted by: Nicole Magpantay
 *   
 *   Using the Calculator Design from HW04 and HW13, 
 *   this application will not only have a stylesheet file, that improves 
 *   on the designs of the buttons but it will also fully function as a calculator
 *   
 */
public class FinalCalcDesign extends Application
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

    public void start(Stage mainStage)
    {
        mainStage.setTitle("Calc Design");      

        // change layout container
        VBox root = new VBox();
        List<Node> rootList = root.getChildren();
        Scene mainScene = new Scene( root, 500, 400 );
        mainStage.setScene( mainScene );

        // add new code below

        // These buttons aren't needed but gonna leave them here for reference
        //Button b1 = new Button("Hello!");
        //Button b2 = new Button("Goodbye.");
        //Button b3 = new Button("\u00F7");        

        //Reference from HW03, this part of the code is suppose to let the user 
        // enter numbers
        Label numerator = new Label(" ");
        rootList.add( numerator );
        numerator.setLayoutX( 20 );
        numerator.setLayoutY( 80 );

        TextField first = new TextField();
        rootList.add( first );
        first.setLayoutX( 20 );
        first.setLayoutY( 100 );
        //Change how wide big you want the textbox to be horizontally
        first.setMaxWidth(200);
        //Disables the manual text entry in text field
        first.setEditable(false);

        // add spacing between elements (measured in pixels)
        root.setSpacing( 20 );
        // add spacing around elements (measured in pixels)
        root.setPadding( new Insets(16) );
        // set font size for all attached objects
        root.setStyle( "-fx-font-size: 20;" );
        // change default alignment of contents
        //root.setAlignment( Pos.CENTER );

        // Goal: 
        //        b1  b2   <-- row
        //          b3
        HBox row = new HBox();
        row.setSpacing( 20 );
        row.setAlignment( Pos.CENTER );

        // style sheet
        mainScene.getStylesheets().add("assets/stylesheet.css");

        // GridPane -- aligns contents in a grid pattern; specify row and column.
        GridPane grid = new GridPane();
        Button plus = new Button("+");
        //minus, times, division, and delete keys must be in unicode 
        Button minus = new Button("\u2212"); //minus
        Button times = new Button("\u00D7"); //times
        Button divide = new Button("\u00F7"); //divide
        Button equals = new Button("=");
        Button decimal = new Button(" . ");

        //Clear and All Clear keys abbreviated for the buttons to be smaller
        Button clear = new Button("C");
        // All clear button can be deleted just for this project
        //Button allClear = new Button("A");
        Button delete = new Button("\u2421"); // unicode for delete

        //Number buttons
        Button zero = new Button("0");
        Button one = new Button("1");
        Button two = new Button("2");
        Button three = new Button("3");
        Button four = new Button("4");
        Button five = new Button("5");
        Button six = new Button("6");
        Button seven = new Button("7");
        Button eight = new Button("8");
        Button nine = new Button("9");

        // add to grid, specify Node, row #, column #
        // put operator keys on the edges
        grid.add(plus, 3, 4);
        grid.add(minus, 3, 3);
        grid.add(times, 3, 2);
        grid.add(divide, 3, 1);
        grid.add(equals, 3, 5);
        grid.add(decimal, 2, 5);
        grid.add(clear, 1, 1);
        //grid.add(allClear, 0, 1);
        grid.add(delete, 2, 1);
        //put numbers inside
        grid.add(zero, 0, 5);
        grid.add(one, 0, 4);
        grid.add(two, 1, 4);
        grid.add(three, 2, 4);
        grid.add(four, 0, 3);
        grid.add(five, 1, 3);
        grid.add(six, 2, 3);
        grid.add(seven, 0, 2);
        grid.add(eight, 1, 2);
        grid.add(nine, 2, 2);

        // add to root node when done!
        root.getChildren().add( grid );

        //Number buttons
        zero.getStyleClass().add("fancy-button");
        one.getStyleClass().add("fancy-button");
        two.getStyleClass().add("fancy-button");
        three.getStyleClass().add("fancy-button");
        four.getStyleClass().add("fancy-button");
        five.getStyleClass().add("fancy-button");
        six.getStyleClass().add("fancy-button");
        seven.getStyleClass().add("fancy-button");
        eight.getStyleClass().add("fancy-button");
        nine.getStyleClass().add("fancy-button");

        //Operand buttons
        plus.getStyleClass().add("fancy-button");
        minus.getStyleClass().add("fancy-button");
        times.getStyleClass().add("fancy-button");
        divide.getStyleClass().add("fancy-button");
        equals.getStyleClass().add("fancy-button");
        decimal.getStyleClass().add("fancy-button");        
        clear.getStyleClass().add("fancy-button");
        //allClear.getStyleClass().add("fancy-button");
        delete.getStyleClass().add("fancy-button");

        //  make the stage visible
        mainStage.show();

        // Use setOnAction for the data of buttons
        // to show onto the textbox
        //WebEngine already doing the functions of the operators
        WebView Button = new WebView();
        WebEngine webEngine = Button.getEngine();
        //Make an array for the number buttons so a setOnAction method can be made
        Button[] numButtons = new Button[]{zero, one, two, three, 
                four, five, six, seven, eight, nine};
        // Loop needs to run many times 
        // setText and getText methods are needed for data of each button to appear
        // in the text box
        for(Button button : numButtons)
        {            
            // button to represent the array numButtons for this method
            // this for loop is to work for all buttons in the array
            button.setOnAction((ActionEvent event) ->
                {
                    //name of text field to show data from the button pressed
                    first.setText(first.getText() + button.getText());
                }
            );
        }
        
        decimal.setOnAction((ActionEvent event) ->
            {
                first.setText(first.getText() + ".");
            }
        );
        plus.setOnAction((ActionEvent event) ->
            {
                first.setText(first.getText() + "+");
            }
        );
        minus.setOnAction((ActionEvent event) ->
            {
                first.setText(first.getText() + "-");
            }
        );
        times.setOnAction((ActionEvent event) ->
            {
                first.setText(first.getText() + "*");
            }
        );
        divide.setOnAction((ActionEvent event) ->
            {
                first.setText(first.getText() + "/");
            }
        );        
        clear.setOnAction((ActionEvent event) ->
            {
                first.clear();  
            }
        );
        delete.setOnAction((ActionEvent event) ->
            {
                //From index 1 to whatever the length of the string is - 1
                // getText method accepts the beginning of the character in the text box
                //inside parameter is the beginning and the last character that was just entered
                String text = first.getText(0, first.getText().length()-1);  
                first.setText(text);
            }
        );
        equals.setOnAction((ActionEvent event) ->
            {
                //If user enters operators but no numbers to calculate, 
                // error message will pop up
                // e.g. +- or */
                try
                {
                    if(!first.getText().isEmpty())
                    {
                        Object result = webEngine.executeScript(first.getText());
                        first.setText(result.toString());
                    }
                }
                catch(Exception e)
                {
                    Alert info = new Alert(AlertType.ERROR);
                    info.setTitle("Syntax Error");
                    info.setContentText("Please enter properly the numbers you want to calculate");
                    info.setHeaderText(null);
                    info.showAndWait();
                }
            }
        );
    }
} 
