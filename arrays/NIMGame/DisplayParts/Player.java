package arrays.NIMGame.DisplayParts;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import arrays.NIMGame.Utilities.Util;

import javax.swing.Box;
import javax.swing.BoxLayout;

public class Player extends Panels {
    private final ImageIcon stone = Util.resize("usable-stone.png", 77, 98);
    private static Player[] players = new Player[2];
    private static int pCount = 0;
    private JLabel label;

    public Player(int x, int y, int width) {
        super(x, y, width, width, Color.DARK_GRAY);

        label = new JLabel("0");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.PLAIN, 30));
        label.setIconTextGap(20);
        label.setIcon(stone); 

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(Box.createHorizontalGlue());
        this.add(label);
        this.add(Box.createHorizontalGlue());

        players[pCount] = this;
        pCount++;
    }

    public void addScore(String num) {
        label.setText(num);
    }

    public static Player[] getPlayers() {
        return players;
    }
}
