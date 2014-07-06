package com.llifon.pigdice;

/**
 * Represents an AI player in the game of pig (TO-DO).
 */
public class ArtificialPlayer extends AbstractPlayer {

    /**
     * Constructs a new ArtificialPlayer which is used to represent
     * a non-human entity involved in the game of pig.
     * @param startingScore The initial score the player starts with.
     */
    public ArtificialPlayer(int startingScore) {
        super("AI", startingScore);
    }
}