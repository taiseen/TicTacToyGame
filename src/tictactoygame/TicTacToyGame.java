/* 
    Created on : 13-Dec-2017, 14:01:54
    Author     : zoo
*/

package tictactoygame;

import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToyGame extends Application {
    
    String msg = null ;
    int winner = -1 ;
    int activePlayer = 1 ;
    
    // Layout For Display
    GridPane grid = new GridPane();
    
    // For temporary save, Players cell_id for checking winner! 
    ArrayList<Integer> player1 = new ArrayList<Integer>();
    ArrayList<Integer> player2 = new ArrayList<Integer>();
    
    Button b1 = new Button(); Button b2 = new Button(); Button b3 = new Button();
    Button b4 = new Button(); Button b5 = new Button(); Button b6 = new Button();
    Button b7 = new Button(); Button b8 = new Button(); Button b9 = new Button();
    
    @Override
    public void start(Stage primaryStage) {
        
        b1.setText(" ");
        b1.setOnAction( event -> {
            PlayGame( 1 , b1 );
        });
        
        b2.setText(" ");
        b2.setOnAction( event -> {
            PlayGame( 2 , b2 );
        });
        
        b3.setText(" ");
        b3.setOnAction( event -> {
            PlayGame( 3 , b3 );
        });
        
        b4.setText(" ");
        b4.setOnAction( event -> {
            PlayGame( 4 , b4 );
        });
        
        b5.setText(" ");
        b5.setOnAction( event -> {
            PlayGame( 5 , b5 );
        });
        
        b6.setText(" ");
        b6.setOnAction( event -> {
            PlayGame( 6 , b6 );
        });
        
        b7.setText(" ");
        b7.setOnAction( event -> {
            PlayGame( 7 , b7 );
        });
        
        b8.setText(" ");
        b8.setOnAction( event -> {
            PlayGame( 8 , b8 );
        });
        
        b9.setText(" ");
        b9.setOnAction( event -> {
            PlayGame( 9 , b9 );
        });        
        
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding( new Insets(25,25,25,25) );
        
        grid.add(b1 , 0 , 0);
        grid.add(b2 , 1 , 0);
        grid.add(b3 , 2 , 0);
        grid.add(b4 , 0 , 1);
        grid.add(b5 , 1 , 1);
        grid.add(b6 , 2 , 1);
        grid.add(b7 , 0 , 2);
        grid.add(b8 , 1 , 2);
        grid.add(b9 , 2 , 2);
        
        // Main GridLayout & Screen Size for H: V: set here
        Scene scene = new Scene(grid, 350, 350);
        
        // Extar adding this source code for CSS Style!
        scene.getStylesheets().add(TicTacToyGame.class.getResource("style.css").toExternalForm());
        // For Icon Change 
        Image img = new Image("/icons/o.png");
        primaryStage.getIcons().add(img);
        
        primaryStage.setTitle("Tic-Tac Game! :) ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    void PlayGame(int cell_id , Button selectedBtn ) {
        
        System.out.println("cell_id : " + cell_id);
        
        if( activePlayer == 1 ) {
            // Draw this chracter upon the button screen 
            selectedBtn.setText("X");

            // Temporary Save tracking info in Array List crosponding to player 
            player1.add( cell_id );
            // controll transfer to 2nd player
            activePlayer = 2 ;                        
            // start play with computer
            //autoPlayer();
        } else if( activePlayer == 2 ) {
            // Draw this chracter upon the button screen 
            selectedBtn.setText("O");
            // Temporary Save tracking info in Array List crosponding to player 
            player2.add( cell_id );
            // controll transfer to 2nd player
            activePlayer = 1 ; 
        }
        
        // No one click the button again
        selectedBtn.setDisable(true);
        
        // every time checking, who win the game
        checking_winner();
    }
    
    void rulles_for_win(){
        
        // ==========================================================================
        // Left Diagonal Checking For each player side by side 
        // ==========================================================================
        if( player1.contains(1) && player1.contains(5) && player1.contains(9) ){
            winner = 1 ;
        }
        if( player2.contains(1) && player2.contains(5) && player2.contains(9) ){
            winner = 2 ;
        }                

        // ==========================================================================
        // Right Diagonal Checking For each player side by side 
        // ==========================================================================
        if( player1.contains(3) && player1.contains(5) && player1.contains(7) ){
            winner = 1 ;
        }
        if( player2.contains(3) && player2.contains(5) && player2.contains(7) ){
            winner = 2 ;
        }                
        
        // ==========================================================================
        // Row Checking For each player side by side 
        // ==========================================================================
        // For 1st Row 
        if( player1.contains(1) && player1.contains(2) && player1.contains(3) ){
            winner = 1 ;
        }
        if( player2.contains(1) && player2.contains(2) && player2.contains(3) ){
            winner = 2 ;
        }        
        // For 2ndt Row 
        if( player1.contains(4) && player1.contains(5) && player1.contains(6) ){
            winner = 1 ;
        }
        if( player2.contains(4) && player2.contains(5) && player2.contains(6) ){
            winner = 2 ;
        }        
        // For 3rd Row 
        if( player1.contains(7) && player1.contains(8) && player1.contains(9) ){
            winner = 1 ;
        }
        if( player2.contains(7) && player2.contains(8) && player2.contains(9) ){
            winner = 2 ;
        }
        
        // ==========================================================================
        // Column Checking For each player side by side 
        // ==========================================================================
        // For 1st Colunm 
        if( player1.contains(1) && player1.contains(4) && player1.contains(7) ){
            winner = 1 ;
        }
        if( player2.contains(1) && player2.contains(4) && player2.contains(7) ){
            winner = 2 ;
        }        
        // For 2ndt Colunm
        if( player1.contains(2) && player1.contains(5) && player1.contains(8) ){
            winner = 1 ;
        }
        if( player2.contains(2) && player2.contains(5) && player2.contains(8) ){
            winner = 2 ;
        }        
        // For 3rd Colunm
        if( player1.contains(3) && player1.contains(6) && player1.contains(9) ){
            winner = 1 ;
        }
        if( player2.contains(3) && player2.contains(6) && player2.contains(9) ){
            winner = 2 ;
        }
    }
    
    void autoPlayer(){
        ArrayList<Integer> empty_cells = new ArrayList<Integer>();
        
       /*
        * need to scan all the item & check for empty cells
        * then according to empty cells he will select random location to put that element there 
        */
        // find all un-used location or cell 
        for(int cell = 1 ; cell < 10 ; cell++ )
        {
            if( !( player1.contains( cell ) || player2.contains( cell ) ) )
            {    
                // these location or cell are not used
                empty_cells.add( cell );
            }
        }
        
        // allways return random value for any un-selected cells
        Random r = new Random();
        int random_index = r.nextInt(empty_cells.size() - 0) + 0 ; // ( max - min ) + min ;
        int cell_number  = empty_cells.get( random_index );
        
        Button selectedBtn ;
        
        switch( cell_number ) {
            case 1:
                selectedBtn = b1 ;
                break;
            case 2:
                selectedBtn = b2 ;
                break;
            case 3:
                selectedBtn = b3 ;
                break;
            case 4:
                selectedBtn = b4 ;
                break;
            case 5:
                selectedBtn = b5 ;
                break;
            case 6:
                selectedBtn = b6 ;
                break;
            case 7:
                selectedBtn = b7 ;
                break;
            case 8:
                selectedBtn = b8 ;
                break;
            case 9:
                selectedBtn = b9 ;
                break;             
            default :
                selectedBtn = b1 ;
                break;                
        }
        
        PlayGame( cell_number , selectedBtn );
    }
    
    void checking_winner() {    
        
        // without this method calling here, winner checking can't possible
        rulles_for_win();
        
        // show winner message | it's mean have winner 
        if( winner != -1 )
        {            
            if( winner == 1 ) {
                msg = "Player 1 => is the winner! :) " ;
                // Stop Playing, by Disable Layout 
                grid.setDisable(true);
                
            } else {
                msg = "Player 2 => is the winner! :) " ; 
                // Stop Playing, by Disable Layout 
                grid.setDisable(true);
            }
            // show result info
            alertBox();
        }
    }
    
    void alertBox() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Info!");
        alert.setContentText( msg);
        alert.setHeaderText("Player Winning Info!");
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
