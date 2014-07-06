package com.llifon.pigdice;

/**
 * Represents a human player in the game of pig.
 */
public class HumanPlayer extends AbstractPlayer{

    /**
     * Constructs a new HumanPlayer to be used as a playable
     * entity in the game of pig.
     * @param playerName The display friendly name of this player.
     * @param startingScore The initial score the player starts with.
     */
    public HumanPlayer(String playerName, int startingScore) {
        super(playerName, startingScore);
    }
}
