package arrays.NIMGame.Utilities;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.Timer;

public class ErrorLabel extends JTextArea {
    private static JTextArea error;
    
    public ErrorLabel(int x, int y, int width, int height) {
        error = this;
        this.setWrapStyleWord(true);
        this.setLineWrap(true);
        this.setEditable(false);
        this.setFocusable(false);
        this.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        this.setOpaque(true);
        this.setForeground(new Color(255, 0, 0));
        this.setBackground(new Color(255, 204, 204));
        this.setBounds(x, y, width, height);
        this.setVisible(false);
    }

    public static void showError(String errorMsg) {
        error.setText("Error: " + errorMsg);
        error.setVisible(true);
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                error.setVisible(false);
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
}
