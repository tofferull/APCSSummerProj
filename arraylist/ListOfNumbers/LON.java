package arraylist.ListOfNumbers;

import java.util.ArrayList;
import java.util.Scanner;

import arrays.TicTacToe.Util;

public class LON {
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        
        //low + high
        Scanner reader = new Scanner(System.in);
        System.out.print("How many times to repeat: ");
        int nums = reader.nextInt();

        int lowestNum, highestNum, randNumber = Util.randomNum(1, 21);
        lowestNum = highestNum = randNumber;
        System.out.println(randNumber);
        list.add(randNumber);

        for (int i = 1; i < nums; i++) {
            int rand = Util.randomNum(1, 21);
            System.out.println(rand);
            list.add(rand);
            if (rand < lowestNum) lowestNum = rand;
            else if (rand > highestNum) highestNum = rand;
        }
        System.out.println("Lowest is: "+lowestNum);
        System.out.println("Highest is: "+highestNum);

        //common occurence
        int occurence = 0;
        int mostOcc = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            int occ = 0;
            int num = list.get(i);
            for (int j = 1; j < list.size(); j++) {
                if (list.get(j) == num) occ++;
            }

            if (occ > occurence) {
                mostOcc = num;
                occurence = occ;
            }
        }
        System.out.println("Most Frequent is "+mostOcc+" and it occurs "+occurence+" times");

        reader.close();
    }
}
