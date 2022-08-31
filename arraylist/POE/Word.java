package arraylist.POE;

import java.util.ArrayList;

public class Word {
    private static ArrayList<Word> words = new ArrayList<>();
    private static int totalWords = 0;
    private static Word mostOccurence = null;

    private int occurence;
    private String str;
    public Word(String word) {
        occurence = 1;
        str = word;
        words.add(this);
    }

    public int getOccurence() {
        return occurence;
    }

    public String getString() {
        return str;
    }

    public static Word getMostOccurred() {
        return mostOccurence;
    }

    public static int getTotalWords() {
        return totalWords;
    }

    public static ArrayList<Word> getWords() {
        return words;
    }

    public static void findWord(String str) {
        long startTime = System.nanoTime();
        for (int i = 0, len = words.size(); i < len; i++) {
            Word w = words.get(i);
            if (w.str.equals(str)) {
                System.out.println(w.str+" WORD FOUND and occured "+w.occurence+" time"+(w.occurence == 1 ? "" : "s"));
                long endTime = System.nanoTime();
                System.out.println("Start time is: "+startTime+" ns");
                System.out.println("End time is: "+endTime+" ns");
                System.out.println("Elasped time is: "+(endTime - startTime)+" ns");
                return;
            }
        }
        System.out.println("WORD NOT IN BOOK");

        long endTime = System.nanoTime();
        System.out.println("Start time is: "+startTime+" ns");
        System.out.println("End time is: "+endTime+" ns");
        System.out.println("Elasped time is: "+(endTime - startTime)+ " ns");
    }
    
    public static boolean addWord(String str) {
        totalWords++; //counts the total amount of words
        for (Word word : words) {
            if (mostOccurence == null)
                mostOccurence = word; //the first word becomes the most occured

            if (word.str.equals(str)) {
                word.occurence++;
                if (word.occurence > mostOccurence.occurence)
                    mostOccurence = word; //finds the most occured word

                return true; //finds the word, so adds the occurence
            }
        }

        new Word(str); //did not find the word so creates a new one
        return true;
    }

    public static void wordsToString() {
        for (Word word : words) {
            if (word != mostOccurence)
                System.out.println(word.str + " occured "+word.occurence+" time"+(word.occurence == 1 ? "" : "s"));
        }
    }
}
