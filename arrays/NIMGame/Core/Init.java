package arrays.NIMGame.Core;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import arrays.NIMGame.DisplayParts.*;
import arrays.NIMGame.Round.Rounds;
import arrays.NIMGame.Utilities.*;

import java.awt.Color;
import java.lang.Math;

public class Init extends JFrame {
    private static final String loc = "arrays\\NIMGame\\res\\";
    private static final ImageIcon frameIcon = new ImageIcon(loc + "arrays\\NIMGame\\res\\stone.png");

    private int screenWidth, screenHeight;
    private int[] stoneAmounts;
    private int width;
    private int height;
    private int y;

    public Init(String title, int screenWidth, int screenHeight, int[] stoneAmounts) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.stoneAmounts = stoneAmounts;
        width = (screenWidth - 40) / (stoneAmounts.length + 2);
        height = calcHeight();
        y = screenHeight - 550;
        
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(screenWidth, screenHeight);
        this.setLocationRelativeTo(null);

        createPlayers();
        createPile();
        createWinnerPanel();
        createErrorLabel();
        
        this.add(new Title(500, 100, screenWidth));
        this.getContentPane().setBackground(new Color(21, 71, 52));
        this.setIconImage(frameIcon.getImage());
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        
    }
    private void createErrorLabel() {
        int width = 200;
        int height = 80;
        this.add(new ErrorLabel(screenWidth - width - 5, screenHeight - 120, width, height));
    }

    private void createWinnerPanel() {
        int pWidth = 500;
        this.add(new Winner(screenWidth / 2 - pWidth / 2 - 12, 30, pWidth, 150, Color.LIGHT_GRAY));
    }

    private void createPlayers() {
        int btnY = y * 2 + 30;
        int center = width/2/2 - 5;
        int x2 = screenWidth - width - 12;
        this.add(new PlayerLabels(center, y, 100, 50, "Player 1"));
        this.add(new Player(0, y, width));
        this.add(new Rounds(center, btnY, Color.WHITE, true));

        this.add(new PlayerLabels(x2 + center, y, 100, 50, "Player 2"));
        this.add(new Player(x2, y, width));
        this.add(new Rounds(x2 + center, btnY, Color.BLACK, false));
    }

    public void createPile() {
        int len = stoneAmounts.length;
        for (int i = 0; i < len; i++) {
            int x = screenWidth / (len + 2) * (i + 1);
            this.add(new Pile(stoneAmounts[i], x, y, width, height));
        }
    }
    
    //horrible height formula
    private int calcHeight() {
        int largestNum = Util.largestNum(stoneAmounts);
        int stoneHeight = 14 * 6;
        int half = (int) Math.round(largestNum / 2.0);
        return half * stoneHeight + ((half - 1) * 10);
    }
}