package arrays.NIMGame.Core;

public class NIM {
    public static void main(String args[]) {
        // Init frame = new Init(1280, 720);
        int[] defaultStones = { 3, 5, 8 };

        new Init("Nim", 1024, 720, defaultStones);
    }

}
