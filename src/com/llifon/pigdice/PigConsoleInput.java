package com.llifon.pigdice;

import java.util.Scanner;

/**
 * Represents a user input prompter for a console based implementation
 * of the game.
 */
public class PigConsoleInput implements PigInput{

    /**
     * The scanner which consumes console based inputs.
     */
    private final Scanner console;

    /**
     * Constructs a new PigConsoleInput object. This class can be used
     * to prompt users for inputs in a console based application.
     */
    public PigConsoleInput()
    {
        this.console = new Scanner(System.in);
    }

    /**
     * Awaits the input of the user for the pig game.
     *
     * @return The integer input provided by the user.
     */
    @Override
    public Nullable<InputTextOptions> readRollOrSkipOption()
    {
        Nullable<InputTextOptions> defaultOption = new Nullable<>(InputTextOptions.UNKNOWN, false);

        try
        {
            String value = this.console.nextLine().trim().toLowerCase();

            if (value.contains("roll"))
            {
                return new Nullable<>(InputTextOptions.ROLL_DICE, true);
            }
            else if (value.contains("skip"))
            {
                return new Nullable<>(InputTextOptions.SKIP_TURN, true);
            }
        }
        catch(Exception ex)
        {
        }

        return defaultOption;
    }

    /**
     * Awaits the string input of the user for the pig game.
     *
     * @return The input provided by the user.
     */
    @Override
    public Nullable<InputTextOptions> readContinueOrHoldOption()
    {
        Nullable<InputTextOptions> defaultOption = new Nullable<>(InputTextOptions.UNKNOWN, false);

        try
        {
            String value = this.console.nextLine().trim().toLowerCase();

            if (value.contains("continue") || value.contains("roll"))
            {
                return new Nullable<>(InputTextOptions.CONTINUE_TURN, true);
            }
            else if (value.contains("hold"))
            {
                return new Nullable<>(InputTextOptions.KEEP_SCORE, true);
            }

        }
        catch(Exception ex)
        {
        }

        return defaultOption;
    }
}
