package arrays.StudentGradesSortComparison.Utility;

import java.io.FileWriter;
import java.io.IOException;
import java.math.*;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {

    private static long start = 0, end = 0, diff = 0;

    public static void startTime() {
        start = System.currentTimeMillis();
    }

    public static void endTime() {
        end = System.currentTimeMillis();
        diff = end - start;
        System.out.println("Time taken: "+diff+" ms");
    }

    public static void genGrades(int size) {
        try {
            //write file
            FileWriter writer = new FileWriter("arrays\\StudentGrades\\Grades.txt");

            for (int i = 1; i <= size; i++) {
                String student = "Student"+i;
                for (int j = 0; j < 5; j++) 
                {
                    if (i % 5 != 0) 
                    {
                        double rand = ThreadLocalRandom.current().nextDouble(60, 100);
                        BigDecimal b = BigDecimal.valueOf(rand);
                        b = b.setScale(2, RoundingMode.HALF_UP);
                        student += " "+b.doubleValue();
                    }
                    else
                    {
                        int rand = ThreadLocalRandom.current().nextInt(60, 100);
                        student += " "+rand;
                    }

                }
                writer.write(student+"\n");
            }

            writer.close();

        } catch (IOException e) {}
    }

    public static void bubbleSort(Info arr[]) {
        int count = arr.length;
        for (int i = 0; i < count; i++) {
            boolean swapped = false;
            for (int j = i + 1; j < count; j++) {
                double c1 = arr[i].getNum();
                double c2 = arr[j].getNum();
                if (c1 > c2) {
                    double temp = c1;
                    arr[i].setNum(c2);
                    arr[j].setNum(temp);
                    
                    String tempN = arr[i].getName();
                    arr[i].setName(arr[j].getName());
                    arr[j].setName(tempN);

                    swapped = true;
                }
            }
            if (!swapped) return;
            swapped = false;
        }
    }
}
