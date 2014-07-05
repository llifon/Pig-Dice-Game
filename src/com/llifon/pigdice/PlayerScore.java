package com.llifon.pigdice;

/**
 * The {@link PlayerScore} class is used to keep track of the state of a player's score.
 * The score can be increased or decreased by a specified amount, and the current value is always available.

 */
public class PlayerScore {

    /**
     * The current value of the score.
     */
    private int currentScore;

    /**
     * Initializes a new instance of the {@link PlayerScore}.
     * @param startingScore The starting score for the player.
     */
    public PlayerScore(int startingScore)
    {
        this.currentScore = startingScore;
    }

    /**
     * Increases the current score amount by
     * the amount specified.
     * @param amount The amount to add to the current score.
     */
    public void increaseScore(int amount)
    {
        this.currentScore += amount;
    }

    /**
     * Decreases the current score amount by
     * the amount specified.
     * @param amount The amount to subtract from the current score.
     */
    public void decreaseScore(int amount)
    {
        this.currentScore -= amount;
    }

    /**
     * Retrieves the current value of this score.
     * @return
     */
    public int getCurrentScore()
    {
        return this.currentScore;
    }
}
