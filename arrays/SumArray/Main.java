package arrays.SumArray;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        int iArr[][] = new int[5][4];
        double dArr[][] = new double[5][4];
        SumArray sum = new SumArray();
        String stop = " or '/' if finished: ";

        Scanner reader = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("Enter a Integer"+stop);
                String read = reader.nextLine();

                if (read.equals("/")) {
                    reader.close();
                    return;
                }
                
                iArr[i][j] = Integer.parseInt(read);
            }
        }
        
        sum.sumArray(iArr);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("Enter a Double"+stop);
                String read = reader.nextLine();

                if (read.equals("/")) {
                    reader.close();
                    return;
                }
                
                dArr[i][j] = Double.parseDouble(read);
            }
        }
        sum.sumArray(dArr);

        reader.close();
    }

}
