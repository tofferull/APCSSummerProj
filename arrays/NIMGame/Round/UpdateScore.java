package arrays.NIMGame.Round;

import arrays.NIMGame.DisplayParts.Player;

public class UpdateScore {
    private static int turn = 0;
    private static int count = 0;

    public static int getScore() {
        return count;
    }

    public static void addCount() {
        count++;
        Player.getPlayers()[turn].addScore(Integer.toString(count));
    }

    public static int getTurn() {
        return turn;
    }
    
    public static void reset() {
        turn = turn == 0 ? 1 : 0;
        count = 0;
        for (int i = 0; i < 2; i++)
            Player.getPlayers()[i].addScore("0");
    }

    public static void resetAll() {
        turn = 0;
        count = 0;
        for (int i = 0; i < 2; i++) 
            Player.getPlayers()[i].addScore("0");
    }
}
