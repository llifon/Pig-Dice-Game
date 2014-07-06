package com.llifon.pigdice;

/**
 * Messages to be used by the game announcer.
 */
class AnnouncerConstants
{
    /**
     * The announcement message for when it is the turn of a player different to the last.
     */
    final static String YOUR_TURN_PLAYER_X = "You're up %s, your current score is %d.";

    /**
     * The announcement message asking the player to either roll the dice or to forfeit their turn.
     */
    final static String USE_TURN_OR_SKIP = "You have two options %s, |roll| the dice or |skip| your turn.";

    /**
     * The announcement message when a number between one and max is rolled.
     */
    final static String YOU_ROLLED_GREATER_THAN_ONE = "Phew! You rolled %d, not bad. |Roll| again or |hold|.";

    /**
     * The announcement message for when the user rolls a one. Not good!
     */
    final static String YOU_ROLLED_A_ONE = "Oh dear! You rolled a one. No points this turn.";

    /**
     * The announcement message for when the user rolls the highest number available.
     */
    final static String YOU_ROLLED_MAX = "Great! You rolled %d, can't do much better than that. |Roll| again or |hold|.";

    /**
     * The announcement message for when the user voluntarily ends his or her turn.
     */
    final static String RUNNING_TOTAL_SAVED = "%s, your running total of %d has been added to your score. You now have %d points.";

    /**
     * The announcement message for when a winner has been found.
     */
    final static String WE_HAVE_A_WINNER = "Hooray! Three cheers for %s, our winner with a score of %d.";
}
