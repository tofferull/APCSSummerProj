package arrays.TicTacToe;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Util {
    public static boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int getNum(Scanner reader, String text) {
        System.out.print(text);
        String str = reader.nextLine();
        if (!isInt(str)) 
            return getNum(reader, "Must be a number in the range of 1-3: ");
        
        int num = Integer.parseInt(str);
        if (num < 1 || num > 3)
            return getNum(reader, "Number must be in the range of 1-3: ");

        return num - 1;
    }

    public static String changeCenter(String str, char mark) {
        char[] arr = str.toCharArray();
        int center = arr.length / 2;
        arr[center] = mark;
        return new String(arr);
    }

    public static int randomNum(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public static boolean continuePlaying(Scanner reader) {
        System.out.print("Continue playing? (y/n): ");

        String answer = reader.nextLine();

        if (answer.toUpperCase().equals("Y")) return true;
        else if (answer.toUpperCase().equals("N")) {
            System.out.println("Finished playing");
            return false;
        }

        return continuePlaying(reader);
    }

    private static boolean betterIsInt(String str) {
        if (str == null) return false;
        int len = str.length();
        if (len == 0) return false;
        
        int idx = 0;
        if (str.charAt(0) == '-') {
            if (len == 1) return false;
            idx = 1;
        }

        for (; idx < len; idx++) {
            char c = str.charAt(idx);
            if (c <'0' || c > '9') return false;
        }
        return true;
    }
}
