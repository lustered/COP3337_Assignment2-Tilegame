/*
Carlos Luis
U08
TileGameTester.java
I affirm that this program is entirely my own work and none of it
is the work of any other person.
*/

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JOptionPane ; 

/**
 * A test class for the NumberTile Game
 */
public class TileGameTester {

    /**
     *@param args args to pass on runtime
     */
    public static void main(String[] args) {
        
        // Options for JOptionPane
        Object[] menu = { "No", "Yes" } ; 
        int playAgain ; 
        int timesPlayed = 1 ; 

        do {
            System.out.println("\n\n::Game #: " + timesPlayed + "::\n") ; 

            // Create 2 hands instances
            Hand hand1 = new Hand() ; 
            Hand hand2 = new Hand() ; 

            // Create a game instance
            TileGame game1 = new TileGame(hand1, hand2) ; 

            // Print initial hands
            System.out.println("\t::Hand 1::" + hand1.toString()) ; 
            System.out.println("\n\t::Hand 2::" + hand2.toString()) ; 

            // Run the game
            game1.play() ; 

            // Print the results
            System.out.println(game1.getResults()) ; 

            // Ask user if they want to play the game again
            playAgain = JOptionPane.showOptionDialog(null, "Play again?", "Tile Game", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE, null, menu, menu[0]) ; 

            timesPlayed++ ; 

        } while (playAgain == 1) ; 

        // String to concatenate outputs
        String gameResults = " ";
        // collect three outputs in a String
        for(int i = 0 ; i < 3 ; i++){

            gameResults += "\n\n::Game #: " + ++i + "::\n" ; 
            Hand h1 = new Hand() ;
            Hand h2 = new Hand() ; 

            TileGame g1 = new TileGame(h1, h2) ; 
            
            // Get initial hands
            gameResults += "\t::Hand 1::" + h1.toString() ; 
            gameResults += "\n\t::Hand 2::" + h2.toString() ; 

            // Run the game
            g1.play() ; 

            // Get the game results
            gameResults += g1.getResults() ; 

        }
        // Writing to file 
        try
        {
        PrintWriter output = new PrintWriter("output.txt");
        output.write(gameResults);
        output.flush();
        output.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }

        



    }

}


