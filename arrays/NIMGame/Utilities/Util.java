package arrays.NIMGame.Utilities;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import javax.imageio.ImageIO;
import java.io.File;

public class Util {


    public static int largestNum(int[] arr) {
        int num = -1;
        for (int i = 0; i < arr.length; i++) 
            num = arr[i] > num ? arr[i] : num;
        return num;
    }

    public static ImageIcon resize(String path, int width, int height) {
        try {
            return new ImageIcon(ImageIO.read(new File("arrays\\NIMGame\\Res\\"+path)).getScaledInstance(width, height, Image.SCALE_SMOOTH));
        } catch (Exception e) {
            return null;
        }
    }

    public static class lockPanel {
        private static boolean click = true;
        private static int pX;
        private static int width;
        private static JPanel panel;
        public lockPanel(JPanel panel) {
            if (click) {
                lockPanel.panel = panel;
                pX = panel.getLocationOnScreen().x;
                width = panel.getWidth();
                panel.setBackground(Color.GRAY);
                panel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                click = !click;
            }
        }

        public boolean isInPanel(MouseEvent e) {
            int x = e.getLocationOnScreen().x;

            if (x > pX && x < pX + width)
                return true;

            return false;
        }

        public static void reset() {
            click = true;
            panel.setBackground(Color.LIGHT_GRAY);
            panel.setBorder(BorderFactory.createEmptyBorder());
        }

    }
}
