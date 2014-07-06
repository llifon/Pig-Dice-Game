package com.llifon.pigdice;

/**
 * The entry point into the application.
 */
public class Main {

    /**
     * Run a console version of the pig dice game.
     * @param args Not used.
     */
    public static void main(String[] args) {

        Announcer gameAnnouncer = new Announcer();
        gameAnnouncer.addAnnouncementListener(System.out::println);

        PigInput pigInputter = new PigConsoleInput();
        Dice gameDice = new SixNumberedDice();

        Player firstPlayer = new HumanPlayer("Player 1", 0);
        Player secondPlayer = new HumanPlayer("Player 2", 0);

        PigGame gameManager = new PigGame(gameDice, gameAnnouncer, pigInputter, 20);
        gameManager.addPlayer(firstPlayer);
        gameManager.addPlayer(secondPlayer);
        gameManager.runGameLoop();
    }
}
