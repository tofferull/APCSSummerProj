package arrays.StudentGrades;

import java.util.Arrays;
import java.util.Scanner;

import arrays.StudentGrades.Utility.Utils;

import java.io.File;

public class Main {
    private static final int MAX = 10000;
    private static final int DEFAULT = 25;
    public static void main(String args[]) {
        try {
            File file = new File("arrays\\StudentGrades\\Grades.txt");
            if (!file.createNewFile()) {
                file.delete();
                file.createNewFile();
            }

            Utils.genGrades(DEFAULT);

            Scanner read = new Scanner(file);
            Student s[] = new Student[DEFAULT];

            for (int i = 0; read.hasNextLine() && i < DEFAULT; i++) {
                String[] student = read.nextLine().split(" ");
                String name = student[0];
                String[] grades = Arrays.copyOfRange(student, 1, 6);
                s[i] = new Student(name, grades);
            }

            read.close();
            
            Student.bubbleSort();
            //Student.timSort();
            Student.print();

        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
