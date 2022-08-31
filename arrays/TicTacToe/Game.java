package arrays.TicTacToe;

import java.util.Scanner;

import javax.swing.SpinnerDateModel;

public class Game {
    private static final String[] results = {"Player", "Computer"};
    private Board board;
    private Computer computer;
    private int winner;
    public Game() {
        board = new Board();
        computer = new Computer(board);
    }

    public void loop(Scanner reader) {
        for (int i = 0; i < 9; i++) {
            boolean turn = board.isPlayerTurn();
            System.out.println((turn ? "Player" : "Computer") + "'s Turn: ");

            if (turn) {
                int x = Util.getNum(reader, "Enter row (1-3): ");
                int y = Util.getNum(reader, "Enter column (1-3): ");
            
                if (!getMoves(x, y))
                    System.out.println("Location: ("+(x+1)+", "+(y+1)+") already occupied.");
            } else
                computerMove();

            if (findWinner()) {
                System.out.println(results[winner - 1]+" is the winner!");
                return;
            }
        }
    }

    public boolean getMoves(int x, int y) {
        if (board.enterMove(x, y)) {
            board.printBoard();
            return true;
        }
        return false;
    }

    public void displayRules() {
        System.out.println("===========================================");
        System.out.println("|                 RULES:                  |");
        System.out.println("| Place marker three time in a row to win |");
        System.out.println("| Tie happens when all moves are completed|");
        System.out.println("| are no winner are found                 |");
        System.out.println("===========================================");
    }

    public void computerMove() {
        computer.move(Util.randomNum(0, 3), Util.randomNum(0, 3));
    }

    public boolean findWinner() {
        int[][] b = board.getBoard();
        for (int i = 0; i < b.length; i++) { //horizontal win
            int hRes = Checker.hLine(b[i]);
            int vRes = Checker.vLine(b, i);
            int lRes = Checker.dLeftLine(b);
            int rRes = Checker.dRightLine(b);
            if (hRes + vRes + lRes + rRes > -4) {
                winner = hRes > 0 ? hRes : vRes > 0 ? vRes : lRes > 0 ? lRes : rRes; //finds the winner
                return true;
            }
        }
        return false;
    }
}
