package arrays.StudentGrades;

import java.util.Arrays;

import arrays.StudentGrades.Utility.Info;
import arrays.StudentGrades.Utility.Utils;

public class Student {
    private static Info[] info = new Info[10000];
    private static Info[] recreated;
    private static int studentCount = 0;

    private double totalGrade = 0;

    public Student(String name, String[] grades) {
        for (int i = 0; i < 5; i++)
            totalGrade += Double.parseDouble(grades[i]);

        info[studentCount] = new Info(totalGrade / 5, name);
        studentCount++;
    }

    public static void timSort() {
        recreated = Arrays.copyOfRange(info, 0, studentCount);
        Arrays.sort(recreated);
    }

    public static void bubbleSort() {
        recreated = Arrays.copyOfRange(info, 0, studentCount);
        Utils.bubbleSort(recreated);
    }

    public static void print() {
        for (int i = 0; i < studentCount; i++) {
            Info d = recreated[i];
            System.out.println(d.getName() + ": " + d.getNum());
        }
    }
}
