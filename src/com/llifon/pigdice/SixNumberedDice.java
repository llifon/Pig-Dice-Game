package com.llifon.pigdice;

import java.util.Random;

/**
 * Represents dice which has six faces / six possible outcomes.
 * The range starts at 1 and ends at 6 (inclusive).

 */
public class SixNumberedDice implements Dice{

    /**
     * The java.util random generator which will be
     * used to return a random value between 1 and 6.
     */
    private final Random randomGenerator;

    /**
     * The number of faces on the dice.
     */
    private final int numDiceFaces = 6;

    /**
     * Constructs a new SixNumberedDice which can be used to roll a dice
     * for 1 of 6 possible outcomes.
     */
    public SixNumberedDice()
    {
        this.randomGenerator = new Random();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int roll()
    {
        return this.randomGenerator.nextInt(this.getNumberOfFaces()) + 1;
    }

    /**
     * Gets the maximum number of faces available
     * on the given dice.
     *
     * @return The number of faces on the dice.
     */
    @Override
    public int getNumberOfFaces()
    {
        return this.numDiceFaces;
    }
}
