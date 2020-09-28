/*
Carlos Luis
U08
NumberTile.java
I affirm that this program is entirely my own work and none of it
is the work of any other person.
*/

import java.util.ArrayList ; 
import java.util.Random ; 

/**
 * A NumberTile is a square tile with a number from 1 to 9 on each side
 */
public class NumberTile 
{
    private int[] tile ; // the 4-sided tile

    /**
     * Create a NumberTile object with 4 random ints in the range 1 to 9
     */
    public NumberTile() 
    {
        Random gen = new Random() ; // DO NOT ERASE THIS DECLARATION

        // Initialize tile array
        tile = new int[4] ; 
        
        // Insert 4 random integers from 1-9 inclusive
        for (int i = 0 ; i < tile.length ; ++i)
            tile[i] = (gen.nextInt(9) + 1) ; 
    }

    /**
     * Rotate this NumberTile 90 degrees
     */
    public void rotate() 
    {
        // create temporary array to hold values and pos
        int[] tmp = new int[tile.length] ; 
        for (int i = 0 ; i < tile.length ; i++)
            tmp[i] = tile[i] ; 

        tile[0] = tmp[3] ; 
        tile[1] = tmp[0] ; 
        tile[2] = tmp[1] ; 
        tile[3] = tmp[2] ; 

    }

    /**
     * Return the number on the left side of this NumberTile
     *
     * @return left element of the tile as int.
     */
    public int getLeft() 
    {
        // Do NOT modify this method
        return tile[0] ; 
    }

    /**
     * Return the number on the right side of this NumberTile
     *
     * @return right element of the tile as int.
     */
    public int getRight() 
    {
        // Do NOT modify this method
        return tile[2] ; 
    }

    /**
     * Return this NumberTile as a multiline string in a diamond shape.
     *
     * @return NumberTile string in a diamond shape.
     */
    public String toString() 
    {
        return "\n\t\t" + tile[1] + "\n\t" + getLeft() + "\t\t" + getRight() + "\n\t\t" + tile[3] ; 
    }
} // end of NumberTile class
