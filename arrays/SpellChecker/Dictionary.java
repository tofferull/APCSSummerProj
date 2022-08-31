package arrays.SpellChecker;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dictionary {
    private static Word[] dictionary = new Word[20];
    private static String userWord;
    private static int idx;

    public Dictionary(String filePath) {
        try {
            idx = 0;
            Scanner reader = new Scanner(new File(filePath));
            
            System.out.println("Words are:");
            for (int i = 0; i < 20; i++) {
                String word = reader.nextLine();
                System.out.println("    "+word);
                dictionary[i] = new Word(word);
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }

    public void setWord(String word) {
        userWord = word;
    }

    public boolean findCloseMatch() {
        for (int i = 0; i < 20; i++) {
            Word word = dictionary[i];
            String w = word.getWord();
            for (int j = 0; j < userWord.length(); j++) {
                Pattern pattern = Pattern.compile(userWord, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(w);
                if (matcher.find()) word.addStrength(userWord.length());
                for (int g = 0; g < w.length(); g++) {
                    if (userWord.toLowerCase().charAt(j) == w.toLowerCase().charAt(g)) {
                        word.increaseStrength();
                        break;
                    }
                }
            }
        }
        Arrays.sort(dictionary);
        String word = dictionary[idx].getWord();
        idx++;
        if (idx == 20) return false;

        System.out.println("Do you mean?");
        System.out.println("    "+word);
        return true;
    }

    public boolean playAgain(Scanner reader) {
        System.out.print("Play again? (y/n): ");
        String ans = reader.nextLine().toLowerCase();
        if (ans.equals("y"))
            return true;
        else if (ans.equals("n"))
            return false;
        else 
            return playAgain(reader);
    }

    public boolean getCorrectness(Scanner reader) {
        System.out.print("Is the reply correct? (y/n): ");
        String c = reader.nextLine().toLowerCase();
        if (c.equals("y"))
            return true;
        else if (c.equals("n"))            
            return false;
        else 
            return getCorrectness(reader);
    }

    public boolean correctWord() {
        for (int i = 0; i < 20; i++) {
            String word = dictionary[i].getWord();
            if (word.equals(userWord)) {
                System.out.println("Word is spelt correctly");
                return true;
            }
        }
        return false;
    }
}
