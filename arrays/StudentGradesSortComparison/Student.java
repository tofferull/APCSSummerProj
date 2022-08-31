package arrays.StudentGradesSortComparison;

import java.util.Arrays;

import arrays.StudentGradesSortComparison.Utility.Info;
import arrays.StudentGradesSortComparison.Utility.Utils;

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

    public void binarySort() {
        recreated = Arrays.copyOfRange(info, 0, studentCount);
        Arrays.sort(recreated);
    }

    public void bubbleSort() {
        recreated = Arrays.copyOfRange(info, 0, studentCount);
        Utils.bubbleSort(recreated);
    }

    public void print() {
        for (int i = 0; i < studentCount; i++) {
            Info d = recreated[i];
            System.out.println(d.getName() + ": " + d.getNum());
        }
    }
}
