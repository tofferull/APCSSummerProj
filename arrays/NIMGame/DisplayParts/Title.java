package arrays.NIMGame.DisplayParts;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

public class Title extends JLabel {
    private static JLabel title;

    public Title(int width, int height, int screenWidth) { 
        title = this;

        this.setText("NIM Game");
        this.setFont(new Font("Times New Roman", Font.PLAIN, 70));
        this.setForeground(new Color(255, 206, 0));
        this.setBounds(screenWidth / 2 - (width / 2 / 2) - 30, 30, width, height);
        setTitleVisibility(true);
    }

    public static void setTitleVisibility(boolean visible) {
        title.setVisible(visible);
    }
}
