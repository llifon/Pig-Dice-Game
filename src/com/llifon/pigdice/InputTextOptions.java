package com.llifon.pigdice;

/**
 * Enumerations of possible user input selections. The key words
 * which translate into these options are left to the implementation;
 * but these are the values used to control the logic flow.
 */
public enum InputTextOptions {

    /**
     * An unknown input flag. Used when the user's input cannot be interpreted to mean
     * any of the other options.
     */
    UNKNOWN,

    /**
     * The option which indicates the user wants to roll the dice.
     */
    ROLL_DICE,

    /**
     * The option which indicates the user does not want to roll, but rather skip their turn
     * all together.
     */
    SKIP_TURN,

    /**
     * The option which indicates the user would like to continue with their turn, admittedly
     * risking their accumulated score.
     */
    CONTINUE_TURN,

    /**
     * The option which indicates the user would like to end their turn now, but would like to
     * save their accumulated score.
     */
    KEEP_SCORE
}
