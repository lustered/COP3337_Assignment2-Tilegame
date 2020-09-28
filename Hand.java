/*
Carlos Luis
U08
Hand.java
I affirm that this program is entirely my own work and none of it
is the work of any other person.
*/
import java.util.Arrays ; 

/**
 * Models a hand with the game.
 */
public class Hand 
{
    private NumberTile[] hand; // a player's hand of tiles
    private int handSize; // current number of tiles in the hand
    private static final int MAX_TILES = 50; // maximum hand size
    private static final int INITIAL_SIZE = 5; // starting hand size

    /**
     * Creates a new hand containing INITIAL_SIZE NumberTiles, but with a capacity
     * of MAX_TILES.
     */
    public Hand() 
    {
        // initialize array hand with fixed max size
        hand = new NumberTile[MAX_TILES] ; 

        // Insert NumberTile objects in the first INITIAL_SIZE indexes and 
        // increase the handSize counter after each iteration.
        for (; handSize < INITIAL_SIZE; handSize++)
            hand[handSize] = new NumberTile() ; 

    }

    /**
     * Get the NumberTile at the specified index in this Hand.
     * 
     * @param index to get the specified tile.
     * @return returns the tile at the specified index.
     */
    public NumberTile get(int index) 
    {

        return hand[index] ; 
    }

    /**
     * Get the number of tiles in this Hand
     * 
     * @return the size of this hand.
     */
    public int getSize() 
    {
        return handSize ; 
    }

    /**
     * Add a new random NumberTile to this Hand
     */
    public void addTile() 
    {
        
        /* 
        * ************************************************************
        * EDGE CASE - WILL PROBABLY NEVER HAPPEN when MAX_TILES >= 50*
        * ************************************************************
        * If the hand is full, then we make room for one more tile 
        */ 
        if(handSize == MAX_TILES)
            hand = Arrays.copyOf(hand, handSize + 1) ; 

        // Place the tile at the last position, then increase handSize 
        hand[handSize++] = new NumberTile() ; 
    }

    /**
     * Remove the NumberTile at the specified index from this Hand
     * 
     * @param index at which to remove the object
     */
    public void removeTile(int index) 
    {

        /*
         * [General Concept]
         *
         * .Iterate from the index we are removing until we reach the last filled
         * element of the array.
         *
         *********************************************
         * EDGE CASE - Will most likely never happen.* 
         *********************************************
         * .We check if the index being removed is the very last tile that can 
         * fit into the array at MAX_TILES-1 or hand[49]. This is needed because the 
         * for loop will try to access index+1 and hit IndexOutOfBound. 
         */

        if (index == (MAX_TILES - 1))
            hand[index] = null ; 
        else
            for ( ; index < handSize; index++)
                hand[index] = hand[index + 1] ; 

        handSize-- ; 
    }

    /**
     * Returns if the hand is empty or not.
     *
     * @return true if empty, else false
     */
    public boolean isEmpty() 
    {

        if (handSize == 0)
            return true ; 
        else
            return false ; 
    }

    /**
     * Returns this Hand as a multiline String, if it is empty returns a message
     * saying so.
     *
     * @return String containing all the NumberTiles in this hand.
     */
    public String toString() 
    {
        // String to concatenate all the tiles in hand
        String handPrint = " " ; 

        if (isEmpty())
            return "\n\n\t::[ HAND EMPTY ]::" ; 
        else
            for (int i = 0; i < handSize; i++)
                // Put each tile in a new line
                handPrint += "\n" + hand[i] ; 

        return handPrint ; 

    }
}
