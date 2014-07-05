package com.llifon.pigdice;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the Pig Game manager.
 * User: Llifon Osian Jones.
 */
public class PigGame {

    /**
     * The dice used in the game.
     */
    private final Dice gameDice;

    /**
     * The state announcer used to inform players of
     * the results and / or state.
     */
    private final Announcer stateAnnouncer;

    /**
     * The input manager which is used to prompt the users
     * for a value.
     */
    private final PigInput pigInputter;

    /**
     * The players actively involved in the game of pig.
     */
    private final List<Player> players;

    /**
     * The score to aim for, the first person to reach this score wins.
     */
    private final int winningScore;

    /**
     * Constructs a new PigGame manager which uses a the specified dice and announcer
     * to conduct the game-play.
     *
     * @param gameDice The dice used to generate the outcomes.
     * @param stateAnnouncer The state announcer used to inform players of changes.
     * @param winningScore The score to aim for, the first person to reach this score wins.
     */
    public PigGame(Dice gameDice, Announcer stateAnnouncer, PigInput pigInputter, int winningScore)
    {
        this.gameDice = gameDice;
        this.stateAnnouncer = stateAnnouncer;
        this.pigInputter = pigInputter;
        this.winningScore = winningScore;
        this.players = new ArrayList<>();
    }

    /**
     * Adds a new player to the game.
     * @param player The player to add.
     */
    public void addPlayer(Player player)
    {
        this.players.add(player);
    }

    /**
     * Run the main game loop. This loop will run until a winner is found.
     * Once a winner is found, a winner will be announced and the method will exit.
     */
    public void runGameLoop()
    {
        while (!this.hasAnyPlayerWon())
        {
            this.players.forEach(player -> runPlayerLoop(player));
        }

        announceWinner();
    }

    /**
     * Runs the per-individual-player game logic. This
     * method runs for the duration of a player's entire turn.
     * @param player
     */
    private void runPlayerLoop(Player player)
    {
        if (this.hasAnyPlayerWon())
        {
            return;
        }

        String name = player.getPlayerName();
        PlayerScore score = player.getCurrentScore();

        this.stateAnnouncer.announce(AnnouncerConstants.YOUR_TURN_PLAYER_X, name, score.getCurrentScore());
        this.stateAnnouncer.announce(AnnouncerConstants.USE_TURN_OR_SKIP, name);
        InputTextOptions rollOrSkip = this.pauseUntilUserSelectsRollOrSkip();

        if(rollOrSkip == InputTextOptions.SKIP_TURN)
        {
            this.stateAnnouncer.announce(System.lineSeparator());
            return;
        }

        this.runRequestLoop(name, score);
        this.stateAnnouncer.announce(System.lineSeparator());
    }

    /**
     * Runs the roll/continue/hold/lose application loop.
     * @param name The name of the player being actively processed.
     * @param score The score reference of the player being actively processed.
     */
    private void runRequestLoop(String name, PlayerScore score)
    {
        boolean releasePlayersTurn  = false;
        int runningTotal = 0;

        while (!releasePlayersTurn)
        {
            int rollOutcome = this.gameDice.roll();

            if (rollOutcome == 1)
            {
                this.onPlayerRolledExactlyOne();
                releasePlayersTurn = true;
            }
            else
            {
                runningTotal += rollOutcome;
                releasePlayersTurn = !this.onPlayerRolledOverOne(rollOutcome);

                if (releasePlayersTurn)
                {
                    score.increaseScore(runningTotal);
                    this.stateAnnouncer.announce(AnnouncerConstants.RUNNING_TOTAL_SAVED, name, runningTotal, score.getCurrentScore());
                }
            }
        }
    }

    /**
     * The behaviour to execute when the outcome of a roll
     * is 1. This is significant as 1 is the losing value
     * in the game of pig.
     */
    private void onPlayerRolledExactlyOne()
    {
        this.stateAnnouncer.announce(AnnouncerConstants.YOU_ROLLED_A_ONE);
    }

    /**
     * The continuous behaviour of the pig game when the result of
     * a dice throw isn't equal to one.
     * @param amountRolled The value the dice landed on.
     * @return true if the user wishes to risk their accumulated
     * points and continue; otherwise false.
     */
    private boolean onPlayerRolledOverOne(int amountRolled)
    {
        String announcement = (amountRolled == this.gameDice.getNumberOfFaces()) ?
                AnnouncerConstants.YOU_ROLLED_MAX : AnnouncerConstants.YOU_ROLLED_GREATER_THAN_ONE;
        this.stateAnnouncer.announce(announcement, amountRolled);

        Nullable<InputTextOptions> continueResponse;

        do
        {
            continueResponse = this.pigInputter.readContinueOrHoldOption();
        } while(!continueResponse.hasValue());

        InputTextOptions response = continueResponse.value();
        return response == InputTextOptions.CONTINUE_TURN;
    }

    /**
     * Gets a value indicating whether or not any player involved with the game has got
     * a winning score.
     * @return true if a player has a winning score; otherwise false.
     */
    private boolean hasAnyPlayerWon()
    {
        return this.players.parallelStream().anyMatch(p -> this.hasPlayerWon(p));
    }

    /**
     * Gets a value indicating whether the specified player has a winning score.
     * @param player The player whose score is to be checked.
     * @return true if the player has a winning score; otherwise false.
     */
    private boolean hasPlayerWon(Player player)
    {
        return player.getCurrentScore().getCurrentScore() >= this.winningScore;
    }

    /**
     * Pauses the program at this spot until the user inputs one of two correct options.
     * If the input indicates that the user wishes to roll the dice or skip their turn,
     * the program may continue.
     * @return The option selected by the user.
     */
    private InputTextOptions pauseUntilUserSelectsRollOrSkip()
    {
        Nullable<InputTextOptions> response;
        do
        {
            response = this.pigInputter.readRollOrSkipOption();
        } while (!response.hasValue());

        return response.value();
    }

    /**
     * Locates the winner based on their score and announces the
     * victory.
     */
    private void announceWinner()
    {
        Player winner = this.players.stream()
                .filter(p -> p.getCurrentScore().getCurrentScore() >= this.winningScore)
                .findFirst().get();

        this.stateAnnouncer.announce(
                AnnouncerConstants.WE_HAVE_A_WINNER,
                winner.getPlayerName(),
                winner.getCurrentScore().getCurrentScore());
    }
}
