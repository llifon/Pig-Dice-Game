package com.llifon.pigdice;

/**
 * Represents a consumer of user inputs.

 */
public interface PigInput {

    /**
     * Awaits the integer input of the user for the pig game.
     * @return The input provided by the user.
     */
    Nullable<InputTextOptions> readRollOrSkipOption();

    /**
     * Awaits the string input of the user for the pig game.
     * @return The input provided by the user.
     */
    Nullable<InputTextOptions> readContinueOrHoldOption();

}
