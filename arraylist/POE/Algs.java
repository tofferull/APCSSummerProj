package arraylist.POE;

import java.util.Arrays;

public class Algs {
    public static String[] bubbleSort(String[] words) {
        long startTime = System.nanoTime();
        for (int i = 0, len = words.length; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                String current = words[j];
                String next = words[j + 1];
                if (current.compareTo(next) > 0) {
                    words[j] = next;
                    words[j + 1] = current;
                }
            }
        }
        long endTime = System.nanoTime();
        System.out.println("BubbleSort elasped: "+(endTime - startTime)+ " ns");
        return words;
    }
    public static String[] timSort(String[] words) { //too fast that ms can't see it
        long startTime = System.nanoTime();
        Arrays.sort(words);
        long endTime = System.nanoTime();
        System.out.println("TimSort elasped: "+(endTime - startTime)+ " ns");
        return words;
    }

    public static int binarySearch(String[] words, String str, int min, int max) {
        //ASSUMED A SORTED ARRAY 
        if (min > max) return -1;
        
        int center = min + (max - min) / 2;
        
        String word = words[center];
        if (word.equals(str))
            return center;

        if (word.compareTo(str) > 0)
            return binarySearch(words, str, min, center - 1);

        return binarySearch(words, str, center + 1, max);
    }

    public static int linearSearch(String[] words, String str) {
        long start = System.nanoTime();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(str)) {
                System.out.println("Linear Search elasped: "+(System.nanoTime() - start)+" ns");
                return i;
            }
        }
        System.out.println("Linear Search elasped: "+(System.currentTimeMillis() - start)+" ns");
        return -1;
    }
}
