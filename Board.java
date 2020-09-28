/*
Carlos Luis
U08
Board.java
I affirm that this program is entirely my own work and none of it
is the work of any other person.
*/

/**
 * The board for the NumberTile game
 */
public class Board 
{
    private NumberTile[] board ; // the board for the game
    private int boardSize ; // current number of tiles on the board
    private static final int MAX_BOARD = 100 ; // maximum number of tiles

    /**
     * Creates a new Board that can hold up to MAX_BOARD tiles that contains a
     * single NumberTile.
     */
    public Board() 
    {
        // Initialize board to MAX_BOARD size
        board = new NumberTile[MAX_BOARD] ; 
        // Add a single NumberTile at index 0 then increase board size
        board[boardSize++] = new NumberTile() ; 
    }

    /**
     * Return the NumberTile at the specified index on this Board.
     * 
     * @param index index pointing to NumberTile on the board.
     * @return NumberTile object at the index.
     */
    public NumberTile getTile(int index) 
    {
        return board[index] ; 
    }

    /**
     * Return the current number of tiles on this Board
     *
     * @return Number of tiles on the Board
     */
    public int getSize() 
    {
        return boardSize ; 
    }

    /**
     * Insert a new tile into this Board at the specified index.
     * 
     * @param index index at which to insert a tile.
     * @param tile  NumberTile object to insert on the Board.
     */
    public void addTile(int index, NumberTile tile) 
    {

        /*
         * General Concept:
         * .Start at the first possible empty slot 
         * .Until i > index which is a slot before the index where we are inserting 
         * a tile and assign i to i - 1. This way we shift all elements up and
         * make space for the new tile to be placed. Eg:
         *
         * Before: arr = { 1, 2, 3, 4,..., MAX_BOARD = null}
         * After:  arr = { 1, 2, 2, 3, 4,..., MAX_BOARD = null}
         *
         * Then we replace our specified index with the new tile and increase board
         * counter.
         */

        for (int i = boardSize ; i > index ; i--)
            board[i] = board[i - 1] ; 

        board[index] = tile ; 
        boardSize++ ; 

    }

    /**
     * Return a multiline string containing all the tiles on this Board
     * 
     * @return String with the current tiles/state of the Board.
     */
    public String toString() 
    {
        // Empty string to concatenate tiles on the board 
        String tiles = " " ; 
        for (int i = 0 ; i < boardSize ; i++) {
            tiles += "\n" + board[i] ; 
        }

        return tiles ; 
    }
}
