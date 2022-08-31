package arraylist.POE;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Poe {
    public static void main(String args[]) throws FileNotFoundException {
        /*
         * first part of project word POE
         * make a class that stores repetitions
         * ignores casing. etc
         */
        Scanner reader = new Scanner(new File("arraylist\\POE\\poe.txt"));

        while (reader.hasNext() && Word.addWord(reader.next().toLowerCase())); // loop

        System.out.println("The total number of Words in poe.txt is: " + Word.getTotalWords());
        System.out.println("The number of Unique words is: " + Word.getWords().size());

        Word mOW = Word.getMostOccurred(); // mOW = most occured word
        System.out.println(
                mOW.getString() + " is the most Frequent word and it occures " + mOW.getOccurence() + " times");

        Word.wordsToString(); // outputs the rest of the words

        // findWord();

        reader.close();

        /*
         * Second part of Project, sort comparison in POE
         */
        ArrayList<Word> w = Word.getWords();
        String[] words = new String[w.size()];
        for (int i = 0; i < w.size(); i++)
            words[i] = w.get(i).getString();

        String[] bSort = Algs.bubbleSort(words); // ï»¿the
        String[] tSort = Algs.timSort(words);

        // binary search
        String wordToFind = "eleventh";

        long start = System.nanoTime();
        int idx = Algs.binarySearch(tSort, wordToFind, 0, tSort.length - 1); // sorted array
        System.out.println("Binary Search elasped: " + (System.nanoTime() - start) + " ns"); // unsorted
        if (idx == -1)
            System.out.println("Not Found");

        if (Algs.linearSearch(words, wordToFind) == -1)
            System.out.println("Not Found");

    }

    public static void findWord() {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter a word to search: ");
        Word.findWord(reader.nextLine());
        reader.close();
    }
}
