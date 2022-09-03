package arrays.NIMConsole;

import java.util.Scanner;

public class NIM {
    static final int[] pile = { 3, 5, 8 };

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        boolean play = true;

        while (play) {
            Game game = new Game(pile, reader, pile.length);
            game.getTurn();

            System.out.println("Play again? (y/n): ");
            for (String str = reader.nextLine().toLowerCase();;str = reader.nextLine().toLowerCase()) {
                if (str.equals("y") || str.equals("n")) {
                    play = str.equals("y");
                    break;
                } else
                    System.out.println("Enter (y/n): ");
            }

            Pile.reset();
        }

        reader.close();
    }
}
