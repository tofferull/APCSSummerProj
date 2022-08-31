package arrays.TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    private static final Scanner reader = new Scanner(System.in);
    public static void main(String args[]) {
        try { 
            for (;;) {
                Game game = new Game();

                game.loop(reader);

                if (!game.findWinner()) 
                    System.out.println("It is a tie");
                
                if (!Util.continuePlaying(reader)) {
                    reader.close();
                    return;
                }
            }
        } catch (Error e) {
            e.printStackTrace();
        }   
    }

}
