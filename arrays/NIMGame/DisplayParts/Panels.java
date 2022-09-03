package arrays.NIMGame.DisplayParts;

import java.awt.Color;

import javax.swing.JPanel;


public abstract class Panels extends JPanel {
    private JPanel panel;
    private int width;

    public Panels (int x, int y, int width, int height, Color color) {
        this.setBackground(color);
        this.setBounds(x, y, width, height);
        this.width = width;
        panel = this;
    }

    public JPanel getPanel() {
        return panel;
    }

    public int getWidth() {
        return width;
    }
}