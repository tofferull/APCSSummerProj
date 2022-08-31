package arrays.EZ;

public class BigEZ {
    public static void main(String args[]) {
        int amounts = 0;
        double n = 1000.0;
        for (int i = 0; i < n; i++)
            for (float num = 0.0f; num < 1; num += Math.random(), amounts++)
                ;

        System.out.println(amounts / n);
    }

}
