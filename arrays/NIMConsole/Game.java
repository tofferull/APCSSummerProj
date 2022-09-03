package arrays.NIMConsole;

import java.util.Scanner;

import arrays.TicTacToe.Util;

public class Game {
    private static final String[] players = {"Player 1", "Player 2"};
    private Pile[] piles;
    private int turn = 0;
    private boolean gameState = true;
    private Scanner reader;

    public Game(int[] stones, Scanner reader, int length) {
        this.reader = reader;

        piles = new Pile[3];
        for (int i = 0; i < stones.length; i++)
            piles[i] = new Pile(stones[i]);

        displayPiles();
    }

    public void checkForWinner() {
        if (Pile.getTotalStone() > 1) return;

        gameState = false;
        System.out.println("Winner: "+players[turn]);
    }

    public void getTurn() {
        if (!gameState) return;
        System.out.println(players[turn]+"'s turn: ");
        getChoice();
        checkForWinner();
        turn = turn == 0 ? 1 : 0;

        getTurn();
    }

    public void getChoice() {

        System.out.print("Select the pile: ");
        String str = reader.nextLine();
        if (!Util.isInt(str)) getChoice();
        int choice = Integer.parseInt(str) - 1;
        if (choice < 0 || choice > 2) getChoice();

        for (;;) {
            System.out.print("How many to remove: ");
            str = reader.nextLine();
            if (!Util.isInt(str)) continue;

            int removeAmount = Integer.parseInt(str);
            int amt = piles[choice].getStone();
            if (removeAmount <= amt) {
                if (Pile.getTotalStone() - removeAmount < 1) {
                    System.out.println("Number is too large");
                    continue;
                }
                if (removeAmount <= 0) {
                    System.out.println("Number can't be 0 or below 0");
                    continue;
                }
                piles[choice].removeStone(removeAmount);
                break;
            } else
                System.out.println("Number is greater than the pile stone count");
        }
        displayPiles();
    }
    
    private void displayPiles() {
        for (int i = 0, len = piles.length; i < len; i++)
            piles[i].displayStones(i + 1);
    }
}
