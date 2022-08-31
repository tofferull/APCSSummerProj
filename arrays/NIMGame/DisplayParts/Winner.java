package arrays.NIMGame.DisplayParts;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import arrays.NIMGame.Core.Entity;
import arrays.NIMGame.Round.Rounds;
import arrays.NIMGame.Round.UpdateScore;
import arrays.NIMGame.Utilities.Util.lockPanel;

public class Winner extends Panels {
    private static final String[] playerName = {"Player 1", "Player 2"};
    private static JLabel text = new JLabel();
    private static JButton button = new JButton("Reset?");
    private static JPanel panel;

    public Winner(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
        panel = this;
        this.setLayout(new BorderLayout(20, 10));
        this.setOpaque(false);

        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        createText();
        createBtn();

        leftPanel.setPreferredSize(new Dimension(60, 50));
        leftPanel.setOpaque(false);
        rightPanel.setPreferredSize(new Dimension(60, 50));
        rightPanel.setOpaque(false);
        centerPanel.add(button);
        centerPanel.setOpaque(false);

        this.add(text, BorderLayout.NORTH);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.EAST);
        this.add(centerPanel, BorderLayout.CENTER);
        this.setVisible(false);
    }

    public static void showWinner(int turn) {
        text.setText("Winnner: " + playerName[turn]);
        Title.setTitleVisibility(false);
        panel.setVisible(true);
    }

    public static void removeWinner() {
        panel.setVisible(false);
        Title.setTitleVisibility(true);
    }

    private void createBtn() {
        button.addActionListener(e -> reset());
        button.setFocusable(false);
        button.setFont(new Font("Times New Roman", Font.BOLD, 20));
        button.setBackground(new Color(184, 171, 27));
        button.setBorder(BorderFactory.createEmptyBorder());
    }

    private void createText() {
        text.setFont(new Font("Times New Roman", Font.PLAIN, 60));
        text.setForeground(new Color(255, 206, 0));
        text.setHorizontalAlignment(JLabel.CENTER);
    }

    private void reset() {
        Entity.restoreEntity(); // make all stone visible
        Rounds.reset(); // revert to original end turn state
        lockPanel.reset(); // remove any locked panel
        UpdateScore.resetAll(); // remove all score saved
        Pile.resetAmt(); //Reset all the stones
        /*
         * removing and creating piles creates performance issues
         */
        removeWinner();
    }

}
