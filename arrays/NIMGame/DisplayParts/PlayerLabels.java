package arrays.NIMGame.DisplayParts;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JLabel;

public class PlayerLabels extends JLabel {
    public PlayerLabels(int x, int y, int width, int height, String name) {
        this.setBounds(x + 12, y-y/2/2/2/2, width, height);
        this.setText(name);
        this.setFont(new Font("Times New Roman", Font.BOLD, 20));
        this.setForeground(new Color(255, 169, 0));
        this.setVisible(true);
    }
}
