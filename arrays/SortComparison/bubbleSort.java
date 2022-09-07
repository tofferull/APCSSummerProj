package arrays.SortComparison;

public class bubbleSort {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                int x = arr[j - 1], y = arr[j];
                if (x > y) {
                    int temp = x;
                    arr[j - 1] = y;
                    arr[j] = temp;
                }
            }
        }
    }

    public static void sort(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                String x = arr[j - 1], y = arr[j];
                if (x.compareTo(y) > 0) {
                    String temp = x;
                    arr[j - 1] = y;
                    arr[j] = temp;
                }
            }
        }
    }

    public static void sort(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                double x = arr[j - 1], y = arr[j];
                if (x > y) {
                    double temp = x;
                    arr[j - 1] = y;
                    arr[j] = temp;
                }
            }
        }
    }
}
