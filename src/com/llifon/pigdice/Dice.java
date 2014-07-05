package com.llifon.pigdice;

/**
 * Represents a game die which can be rolled for a random outcome.

 */
public interface Dice {

    /**
     * Rolls the dice to generate a random number.
     * @return The random number which was generated from the roll.
     */
    int roll();

    /**
     * Gets the maximum number of faces available
     * on the given dice.
     * @return The number of faces on the dice.
     */
    int getNumberOfFaces();
}
