/*
Carlos Luis
U08
TileGame.java
I affirm that this program is entirely my own work and none of it
is the work of any other person.
*/

/**
 * Implements a domino-like game where two players, both of whom are the
 * computer, take turns inserting NumberTiles into a Board
 */
public class TileGame
{
    // instance vars
    private Board board ; // the game board
    private Hand hand1 ; // Player 1 hand
    private Hand hand2 ; // Player 2 hand
    private String winner ; // the winner - player1, player2, or a tie game

    /**
     * Creates a new TileGame with two initial hands and a board.
     */
    public TileGame(Hand firstHand, Hand secondHand) 
    {
        // Initialize instance variables
        board = new Board() ; 
        hand1 = firstHand ; 
        hand2 = secondHand ; 
    }

    /**
     * Players take turn moving until one or both hand are empty
     */
    public void play() 
    {
        // boolean to stop the while loop once we find empty hands 
        boolean gameOver = false ; 

        while (!gameOver) 
        {
            // Each player makes a move per round 
            makeMove(hand1) ; 
            makeMove(hand2) ; 

            if (hand1.isEmpty() || hand2.isEmpty()) 
            {
                // Once there is an empty hand, after both players' turn
                // assign the winner, stop the loop.
                gameOver = true ; 

                // Assign the winner  
                if (hand1.isEmpty() && hand2.isEmpty()) 
                    winner = "\n\t[::It is a tie!::]" ; 
                else if (hand1.isEmpty()) 
                    winner = "\n\t[::Player 1 Wins!::]" ; 
                 else if (hand2.isEmpty()) 
                    winner = "\n\t[::Player 2 Wins!::]" ; 
                
            }
        }
    }

    /*
     * Utility method called by method makeMove. Returns the index at which a new
     * tile will be inserted into the board, or -1 if the tile cannot be inserted.
     * The new tile may be inserted either (1) between two existing tiles, (2) as
     * the new first tile, or (3) as the new last tile.
     */
    private int getIndexForFit(NumberTile tile) 
    {
        // Check for the new first tile.
        if (board.getTile(0).getLeft() == tile.getRight()) 
            return 0 ; 

        // Index of last tile on the board.
        int lastTileIndex = board.getSize() - 1 ; 

        // Check for new last tile.
        if (board.getTile(lastTileIndex).getRight() == tile.getLeft()) 
            return board.getSize() ; 
        

        /*
         *  The only way to place a tile between other 2 is if the tile has
         *  the same value for LEFT and RIGHT and match the RIGHT value of the 
         *  tile on the board.
         *
         *                       
         *     Tile on the board:      *********** 
         *                             *    6    *
         *                             * 5     7 *
         *                             *    4    *
         *    Tile from the hand:      ***********
         *                             *    4    *
         *                             * 7     7 *
         *                             *    3    *
         *  Next tile on the board:    ***********
         *                             *    9    *
         *                             * 7     3 *
         *                             *    6    *
         *                             ***********
         */ 
        
        // Check if left  and right elements are equal. Otherwise don't bother. 
        if (tile.getLeft() == tile.getRight()) 
        {

            // Iterate over the board from the first until second to last element
            for (int i = 0 ; i < board.getSize() - 1 ; i++) 
            {
                // right value of the tile on the board
                int rightTileValue = board.getTile(i).getRight() ; 

                // Doesn't matter which side of the tile we check, they
                // need to be equal. No need to check for i+1.
                // If the condition is met, return position after it.
                // Which would be between 2 already matching tiles.
                if (tile.getRight() == rightTileValue)
                    return i + 1 ; 

            }
        }

        // Tile does not fit in any position of the board
        return -1 ; 
    }

    /*
     * Utility method to decide where to place a tile from the Hand to the Board.
     * If the hand does not contain a tile to place on the board, a new random tile
     * will be added to the hand.
     */
    private void makeMove(Hand hand) 
    {
        // For each tile in the hand
        for (int i = 0 ; i < hand.getSize() ; i++) 
        {
            
            // Extract each tile
            NumberTile tile = hand.get(i) ; 

            // Check tile for match up to 3 rotations
            for (int j = 0 ; j < 3 ; j++) 
            {
                // Use helper method to check if the tile fits on the board
                int checkFitIndex = getIndexForFit(tile) ; 

                // getIndexForFit() returns -1 if no match found
                if (checkFitIndex == -1) 
                    // Rotate tile.
                    tile.rotate() ; 

                 else 
                 {
                     // If the tile fits on the board, place it at the index.
                    board.addTile(checkFitIndex, tile) ; 
                    // Remove the tile from the Hand.
                    hand.removeTile(i) ; 
                    // No need to keep iterating, break out of method
                    return ; 
                }

            }

        }
        
        // If after iterating over the entire hand no match was found
        // Then add a tile to the hand
        hand.addTile() ; 
    }

    /**
     * Return results of the game as a String containing the final board,
     * both players final hands, and the winner.
     * 
     * @return A single String containing the final state of the board,
     * both players final hands and the winner.
     */
    public String getResults() 
    {
        // String with 40 '*' characters to divide sections
        String divider = new String(new char[40]).replace("\0", "*") ; 

        return "\n\n\t::Results::\n" + divider + board.toString() + "\n\n\t::Final Hands::\n" + divider
                + "\n\n\t::Player 1 Final Hand::\n" + hand1.toString() + "\n\n\t::Player 2 Final Hand::\n"
                + hand2.toString() + "\n" + winner ; 

    }
}
