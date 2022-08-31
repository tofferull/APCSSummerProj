package arrays.SumArray;

public class SumArray {
    
    public double findAvg(double arr[]) {
        double res = 0;
        int arrL = arr.length;

        for (int i = 0; i < arrL; i++)
            res += arr[i];

        return res / (arrL*1.0);
    }

    public void sumArray(int arr[][]) {
        int res = 0;
        int arrL = arr.length;

        for (int i = 0; i < arrL; i++) {
            int row = 0;

            for (int j = 0, l = arr[i].length; j < l; j++)
                row += arr[i][j];
            
            res += row;

            System.out.println("Row "+i+" = "+row);
        }
        System.out.println("SUM = "+res);
        System.out.println("AVG = "+res / (arrL*1.0));
    }

    public void sumArray(double arr[][]) {
        double res = 0.0;
        int arrL = arr.length;

        for (int i = 0; i < arrL; i++) {
            double row = 0.0;

            for (int j = 0, l = arr[i].length; j < l; j++)
                row += arr[i][j];
            
            res += row;

            System.out.println("Row "+i+"= "+row);
        }
        System.out.println("SUM = "+res);
        System.out.println("AVG = "+res / arrL);
    }
}