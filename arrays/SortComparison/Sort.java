package arrays.SortComparison;

import java.io.IOException;
import java.util.Arrays;

public class Sort {
    static final int MAX = 10000;
    static int[] a = new int[MAX];
    static String[] b = new String[MAX];
    static double[] c = new double[MAX];
    public static void main(String[] args) throws IOException {
        Write.writeInt(a);
        Write.writeString(b);
        Write.writeDouble(c);

        intTime();
        stringTime();
        doubleTime();
    }

    public static void intTime() {
        int[] x = a.clone();
        Timer t1 = new Timer();
        Arrays.sort(a);
        long l1 = t1.endTimer("TimSort");

        Timer t2 = new Timer();
        bubbleSort.sort(x);
        long l2 = t2.endTimer("BubbleSort");

        System.out.println((l1 < l2 ? "TimSort" : "BubbleSort") + " is faster");
    }

    public static void stringTime() {
        String[] y = b.clone();

        Timer t1 = new Timer();
        Arrays.sort(b);
        long l1 = t1.endTimer("TimSort");

        Timer t2 = new Timer();
        bubbleSort.sort(y);
        long l2 = t2.endTimer("BubbleSort");

        System.out.println((l1 < l2 ? "TimSort" : "BubbleSort") + " is faster");
    }

    public static void doubleTime() {
        double[] z = c.clone();

        Timer t1 = new Timer();
        Arrays.sort(c);
        long l1 = t1.endTimer("TimSort");

        Timer t2 = new Timer();
        bubbleSort.sort(z);
        long l2 = t2.endTimer("BubbleSort");

        System.out.println((l1 < l2 ? "TimSort" : "BubbleSort") + " is faster");
    }

}
