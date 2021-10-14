

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Starting code for a Rock-Paper-Scissors game!
 *
 * @author Michael Buescher for APCS-A @ HB
 * @version 1.0
 */
public class RPS2 extends Application
{
    // The Rock-Paper-Scissors Match
    private RPSMatch rpsMatch;
    
    // Labels for displaying the win counts
    private Label lblPlayerWins =       new Label("Human Wins");
    private Label lblComputerWins =     new Label("Computer Wins");
    private Label lblTies =             new Label("Ties");
    private Label lblStatus1 =          new Label("Choose Rock, Paper, or Scissors");
    private Label lblStatus2 =          new Label("");
    private Label lblStatus3 =          new Label("");
    private Label lblHeader =           new Label("Results:");
    private Label lblPlayerWinCount =   new Label("0");
    private Label lblComputerWinCount = new Label("0");
    private Label lblTieCount =         new Label("0");
    private Label lblBlank =            new Label("");

    @Override
    public void start(Stage stage) throws Exception
    {
        // Start the match
        rpsMatch = new RPSMatch();
        
        // Create a Button or any control item
        Button btnChooseRock =     new Button("Rock");
        Button btnChoosePaper =    new Button("Paper");
        Button btnChooseScissors = new Button("Scissors");
        btnChooseRock.setPrefWidth(80.0);
        btnChoosePaper.setPrefWidth(80.0);
        btnChooseScissors.setPrefWidth(80.0);
        
        
        //btnChooseRock.setMaxSize (Double.MAX_VALUE, Double.MAX_VALUE);

        // Buttons on the TilePane
        // Tips at https://docs.oracle.com/javafx/2/layout/size_align.htm
        HBox chooseButtons = new HBox();
        chooseButtons.setSpacing(10.0);
        chooseButtons.getChildren().addAll(btnChooseRock, btnChoosePaper, btnChooseScissors);
        
        // Labels for game status
        VBox gameResult = new VBox();
        gameResult.setSpacing(10.0);
        gameResult.getChildren().addAll(lblStatus1, lblStatus2, lblStatus3);
        
        
        // Labels for match status
        VBox matchStatusLabels = new VBox();
        matchStatusLabels.setSpacing(10.0);
        lblHeader.setStyle("-fx-font-weight: bold");
        matchStatusLabels.getChildren().addAll(lblHeader, lblPlayerWins, lblComputerWins, lblTies);
       
        // Labels for match status
        VBox matchStatus = new VBox();
        matchStatus.setSpacing(10.0);
        lblPlayerWinCount.setStyle("-fx-font-weight: bold");
        lblComputerWinCount.setStyle("-fx-font-weight: bold");
        lblTieCount.setStyle("-fx-font-weight: bold");
        matchStatus.getChildren().addAll(lblBlank, lblPlayerWinCount, lblComputerWinCount, lblTieCount);
        
        
        
        // Create a new grid pane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setMinSize(500, 500);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(chooseButtons, 1, 0, 2, 1);
        grid.add(gameResult, 1, 1);
        grid.add(matchStatusLabels, 1, 2);
        grid.add(matchStatus, 2, 2);

       
        //set an action on the button using method reference
        btnChooseRock.setOnAction(this::rockClick);
        btnChoosePaper.setOnAction(this::paperClick);
        btnChooseScissors.setOnAction(this::scissorsClick);


        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(grid, 300,250);
        stage.setTitle("JavaFX Example");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();
    }

    /**
     * This will be executed when the player clicks the "Rock" button
     * **false denotes that the game is cheating
     */
    private void rockClick(ActionEvent event)
    {
        rpsMatch.setHumanPlay("Rock");
        lblStatus1.setText ("You have chosen Rock      ");
        
        lblStatus2.setText ("I choose " + rpsMatch.getComputerPlay(false));
        
        lblStatus3.setText (rpsMatch.getResult());
        updateScores();
    }
    
    /**
     * This will be executed when the player clicks the "Paper" button
     * **false denotes that the game is cheating
     */
    private void paperClick(ActionEvent event)
    {
        rpsMatch.setHumanPlay("Paper");
        lblStatus1.setText ("You have chosen Paper     ");
               
        lblStatus2.setText ("I choose " + rpsMatch.getComputerPlay(true));
        
        lblStatus3.setText (rpsMatch.getResult());
        updateScores();

    }

    /**
     * This will be executed when the player clicks the "Scissors" button
     * **false denotes that the game is cheating
     */
    private void scissorsClick(ActionEvent event)
    {
        rpsMatch.setHumanPlay("Scissors");
        lblStatus1.setText ("You have chosen Scissors  ");
               
        lblStatus2.setText ("I choose " + rpsMatch.getComputerPlay(false));
        
        lblStatus3.setText (rpsMatch.getResult());
        updateScores();

    }


    //updates the scores of each variable (human, computer, tie) to match the new number 
    //^after each round thats played
    private void updateScores()
    {
        lblPlayerWinCount.setText("" + rpsMatch.getHumanWins());
        lblComputerWinCount.setText("" + rpsMatch.getComputerWins());
        lblTieCount.setText("" + rpsMatch.getTies());

    }
    
}