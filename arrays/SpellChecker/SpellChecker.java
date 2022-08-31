package arrays.SpellChecker;

import java.util.Scanner;

public class SpellChecker {
    static Scanner reader = new Scanner(System.in);
    public static void main(String args[]) {
        Dictionary dictionary = new Dictionary("arrays\\SpellChecker\\Dictionary.txt");

        for (;;) {
            System.out.print("User Enters: ");
            dictionary.setWord(reader.nextLine());
            
            if (!dictionary.correctWord()) {
                for (;;) {
                    if (!dictionary.findCloseMatch()) {
                        System.out.println("No Words Match");
                        break;
                    }
                    if (dictionary.getCorrectness(reader))
                        break;
                }
            }
            if (!dictionary.playAgain(reader)) 
                return;
        }
    }
}