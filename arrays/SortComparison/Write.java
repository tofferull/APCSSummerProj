package arrays.SortComparison;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Write {
    private static final String LOCATION = "arrays\\SortComparison\\Files\\";

    public static void writeInt(int[] arr) throws IOException {
        for (int i = 0; i < arr.length; i++) {
            int rand = (int) (Math.random() * (Math.pow(2, 31) - 1));
            arr[i] = rand;
        }
    }

    public static void writeString(String[] arr) throws FileNotFoundException {
        File f = new File(LOCATION+"string.txt");
        Scanner reader = new Scanner(f);
        for (int i = 0; reader.hasNextLine(); i++)
            arr[i] = reader.nextLine();
        reader.close();
    }

    public static void writeDouble(double[] arr) throws IOException {
        for (int i = 0; i < arr.length; i++) {
            double rand = Math.random() * Math.pow(2, 10);
            arr[i] = rand;
        }
    }
}

