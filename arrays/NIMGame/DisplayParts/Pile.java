package arrays.NIMGame.DisplayParts;

import java.awt.Color;

import arrays.NIMGame.Core.Entity;

public class Pile extends Panels {
    private static int originalAmt;
    private static int amount;

    public Pile(int amount, int x, int y, int width, int height) {
        super(x, y, width, height, Color.LIGHT_GRAY);
        
        originalAmt += amount;
        Pile.amount += amount;
        
        for (int i = 0; i < amount; i++) 
            this.add(new Entity(this));
    }
    public static void removeCount() {
        amount--;
    }

    public static int getAmount() {
        return amount;
    }

    public static void resetAmt() {
        amount = originalAmt;
    }
}
