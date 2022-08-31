package arrays.StudentGradesSortComparison;

import java.util.Arrays;
import java.util.Scanner;

import arrays.StudentGradesSortComparison.Utility.Utils;

import java.io.File;

public class Main {
    private static final int MAX = 10000;
    public static void main(String args[]) {
        try {
            File file = new File("arrays\\StudentGradesSortComparison\\Grades.txt");

            Utils.genGrades(MAX);

            Scanner read = new Scanner(file);
            Student s[] = new Student[MAX];

            for (int i = 0; read.hasNextLine() && i < MAX; i++) {
                String[] student = read.nextLine().split(" ");
                String name = student[0];
                String[] grades = Arrays.copyOfRange(student, 1, 6);
                s[i] = new Student(name, grades);
            }

            read.close();

            Student student = s[0];

            Utils.startTime();

            student.bubbleSort();
            //student.binarySort();
            student.print();

            Utils.endTime();

        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
