package com.llifon.pigdice;

import java.util.UUID;

/**
 * Represents the behaviour of a player in the game "Pig Dice".
 */
public interface Player {

    /**
     * Retrieves the universally unique identifier ({@link UUID})
     * for the player. The value retrieved should be unique
     * for every distinct {@link Player}.
     * @return The unique player ID.
     */
    UUID getUniqueId();

    /**
     * Retrieves the display friendly name
     * of the player.
     * @return The name of the player.
     */
    String getPlayerName();

    /**
     * Retrieves the current game score
     * of the player.
     * @return The current score.
     */
    PlayerScore getCurrentScore();
}
