package com.llifon.pigdice;

/**
 * Created with IntelliJ IDEA.

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
    KEEP_SCORE;
}
