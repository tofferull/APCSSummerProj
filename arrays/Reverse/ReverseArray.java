

import java.util.Scanner;
import java.util.ArrayList;

public class ReverseArray {
    private static final String sentinel = "/";

    public static void main(String args[]) {
        try {
            Scanner reader = new Scanner(System.in);
            ArrayList<String> arr = new ArrayList<>();

            while (true) {
                System.out.print("Enter a number (/ to stop): ");
                String input = reader.nextLine();

                if (input.equals(sentinel)) 
                    break;

                arr.add(input);
            }

            reader.close();

            int size = arr.size();
            for (int i = 0; i < size; i++)
            {
                String val = arr.get(i);
                if (size == 1)
                {   
                    System.out.println(val);
                    break;
                }
                if (i == size - 2) 
                {
                    System.out.println(val + " and " + arr.get(size - 1));
                    break;
                }
                System.out.print(val + ", ");
            }

            reverse(arr);
        } 
        catch (Error e) {
            System.out.println("Input error");
        }
    }
    public static void reverse(ArrayList<String> arr) {
        for (int i = arr.size() - 1; i > 0; i--)
        {
            String val = arr.get(i);
            if (arr.size() == 1)
            {
                System.out.println(val);
            }
            if (i == 1)
            {
                System.out.println(val + " and " + arr.get(0));
                break;
            }
            System.out.print(val + ", ");
        }
    }
}
