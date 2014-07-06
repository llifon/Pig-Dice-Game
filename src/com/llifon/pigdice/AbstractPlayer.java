package com.llifon.pigdice;

import java.util.UUID;

/**
 * An abstract representation of a Player in the game of Pig.
 */
public abstract class AbstractPlayer implements Player {

    /**
     * The unique ID for this player.
     */
    private final UUID playerId;

    /**
     * The display friendly name for this player.
     */
    private final String playerName;

    /**
     * The score tally associated with this player.
     */
    private final PlayerScore playerScore;

    /**
     * This is an abstract class that cannot be instantiated directly.
     * @param playerName The user friendly name for the player.
     * @param startingScore The score count the user starts with.
     */
    protected AbstractPlayer(String playerName, int startingScore)
    {
        this.playerId = UUID.randomUUID();
        this.playerName = playerName;
        this.playerScore = new PlayerScore(startingScore);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UUID getUniqueId() {
        return this.playerId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPlayerName() {
        return this.playerName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlayerScore getCurrentScore() {
        return this.playerScore;
    }
}
