package arrays.NIMConsole;

public class Pile {
    private static final char SYMBOL = '|';
    private static int totalStone = 0;
    private int stones;

    public Pile(int stones) {
        this.stones = stones;
        totalStone += stones;
    }

    public void displayStones(int idx) {
        System.out.print(idx + ": ");
        for (int i = 0; i < stones; i++) {
            System.out.print(SYMBOL + " ");
        }
        System.out.print("("+stones+")");
        System.out.println();
    }

    public void removeStone(int cnt) {
        stones -= cnt;
        totalStone -= cnt;
    }
    
    public int getStone() {
        return stones;
    }

    public static int getTotalStone() {
        return totalStone;
    }

    public static void reset() {
        totalStone = 0;
    }
}   
