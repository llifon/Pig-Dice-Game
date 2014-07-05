package com.llifon.pigdice;

/**
 * The entry point into the application.

 */
public class Main {

    public static void main(String[] args) {
        Announcer gameAnnouncer = new Announcer();
        gameAnnouncer.addAnnouncementListener(e -> System.out.println(e));

        PigInput pigInputter = new PigConsoleInput();

        Dice gameDice = new SixNumberedDice();

        Player humanPlayer = new HumanPlayer("Llifon", 0);
        Player aiPlayer = new HumanPlayer("Iona", 0);

        PigGame gameManager = new PigGame(gameDice, gameAnnouncer, pigInputter, 20);
        gameManager.addPlayer(humanPlayer);
        gameManager.addPlayer(aiPlayer);
        gameManager.runGameLoop();
    }
}
