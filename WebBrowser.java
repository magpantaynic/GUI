import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.beans.property.*;
import javafx.beans.value.*;
import javafx.event.*;
import javafx.animation.*;
import javafx.geometry.*;
import java.io.*;
import java.util.*;
import javafx.scene.web.*;
/**
 * HW20 - Web Browser Improvements
 * Created by: (Lee Stemkoski)
 * Submitted by: Nicole Magpantay
 * 
 * 
 */
public class WebBrowser extends Application
{
    public static void main(String[] args)
    {
        try
        {
            launch(args);
        }
        catch (Exception error)
        {
            error.printStackTrace();
        }
        finally
        {
            System.exit(0);
        }
    }

    public void start(Stage mainStage)
    {
        mainStage.setTitle("WebView Example");
        BorderPane menuspot = new BorderPane();
        VBox root = new VBox();
        root.setSpacing(16);
        root.setStyle("-fx-font-size: 16;");
        Scene mainScene = new Scene(menuspot);
        mainStage.setScene(mainScene);
        // custom code below --------------------------------------------
        // the following line loads a stylesheet file; incorrect syntax will generate a parse warning
        mainScene.getStylesheets().add("assets/stylesheet.css");

        //get menues to show
        MenuBar bar = new MenuBar();
        Menu favorite = new Menu("Favorite");
        Menu About = new Menu("About");
        Menu quit = new Menu("Quit");
        bar.getMenus().addAll(favorite,About,quit);
        menuspot.setTop(bar);
        MenuItem Twitter = new MenuItem("Twitter");
        MenuItem Adelphi = new MenuItem("Adelphi");
        MenuItem gitHub = new MenuItem("gitHub");
        favorite.getItems().addAll(Twitter,Adelphi,gitHub);

        
        WebView browser = new WebView();
        browser.setPrefSize(800,600);
        // supresses a warning message when trying to load some websites
        //  search Server Name Indication for more details
        System.setProperty("jsse.enableSNIExtension", "false");
        String defaultURL = "www.google.com";
        WebEngine webEngine = browser.getEngine();
        webEngine.load(defaultURL);
        TextField urlText = new TextField(defaultURL);
        urlText.setOnAction((ActionEvent event) ->
            {
                if(urlText.equals("http://"))
                {
                    webEngine.load( urlText.getText() );
                }
                else
                {  
                    webEngine.load("http://"+urlText.getText() );
                    urlText.setText("http://" + urlText.getText());
                }
            }
        );
        //Go to URL button to directly go to the website
        Button urlButton = new Button("Go to URL");
        urlButton.setOnAction(
            (ActionEvent e) ->
            {
                if(urlText.equals("http://"))
                {
                    String url = urlText.getText();
                    webEngine.load( url );
                }
                else
                {  
                    webEngine.load("http://" + urlText.getText());
                    urlText.setText("http://" + urlText.getText());
                }
            }
        );
        // Goes back to web history
        // Previous webpage
        Button backButton = new Button("Back");
        backButton.setGraphic(new ImageView( new Image("icons/arrow_undo.png")));
        backButton.setOnAction(
            (ActionEvent e) ->
            {
                // this executes JavaScript code!
                webEngine.executeScript( "history.back()" );
            }
        );
        // Goes forward to web history
        // Ex: if you went to twitter, then adelphi, then back to twitter,
        // you go back to adelphi
        Button foward = new Button("foward");
        foward.setGraphic(new ImageView(new Image("icons/arrow_redo.png")));
        foward.setOnAction( (ActionEvent event) ->
            {
                webEngine.executeScript( "history.forward()" );
            }
        );
        // Sends you back to home page or default URL
        Button home = new Button("Home");
        home.setGraphic(new ImageView(new Image("icons/house.png")));
        home.setOnAction( (ActionEvent event) ->
            {
                webEngine.load(defaultURL);                           
            }
        );

        root.getChildren().addAll(urlText, urlButton, backButton,foward,home, browser);
        menuspot.setCenter(root);
        //menu functions
        quit.setOnAction((ActionEvent event)->
            {
                System.exit(0);
            }
        );
        About.setOnAction((ActionEvent event)->
            {
                Alert infoAlert = new Alert( AlertType.INFORMATION );
                infoAlert.setTitle("About");
                infoAlert.setHeaderText(null);
                infoAlert.setContentText("Enter the site to be taken to it");
                // display this window (make visible) and wait for user input
                infoAlert.showAndWait();
            }
        );
        Twitter.setOnAction((ActionEvent event)->
            {
                webEngine.load("https://www.twiiter.com/");
                //set URL text without the https:// because it will 
                // automatically put the https:// and then go to the site
                urlText.setText("www.twitter.com/");
            }
        );

        Adelphi.setOnAction((ActionEvent event)->
            {
                webEngine.load("https://www.adelphi.edu/");
                urlText.setText("www.adelphi.edu/");
            }
        );

        gitHub.setOnAction((ActionEvent event)->
            {
                webEngine.load("https://www.gitHub.com/");        
                urlText.setText("www.gitHub.com/");
            }
        );
        // custom code above --------------------------------------------
        mainStage.show();
    }
}
