package arrays.NIMGame.Round;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import arrays.NIMGame.DisplayParts.Pile;
import arrays.NIMGame.DisplayParts.Winner;
import arrays.NIMGame.Utilities.Util.lockPanel;
import arrays.NIMGame.Utilities.ErrorLabel;

public class Rounds extends JButton {
    private static final int width = 100, height = 50;
    private static JButton[] btns = new JButton[2];
    private static int btnCount = 0;
    private static boolean turn = false;

    public Rounds(int x, int y, Color color, boolean enabled) {
        this.setText("End Turn");
        this.setBounds(x, y, width, height);
        this.setFocusable(false);
        this.setBackground(color);
        this.addActionListener(e -> endTurn(e));
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setEnabled(enabled);

        btns[btnCount] = this;
        btnCount++;
    }

    public void endTurn(ActionEvent e) {
        if (e.getSource() == this) {
            if (UpdateScore.getScore() == 0) {
                ErrorLabel.showError("Can not end turn without removing any stones");
                return;
            }
            if (Pile.getAmount() == 1) {
                System.out.println("WINNER FOUND");
                Winner.showWinner(UpdateScore.getTurn());
                return;
            }
            changeTurn();
        }
    }

    public static void reset() {
        btns[0].setBackground(Color.WHITE);
        btns[1].setBackground(Color.BLACK);
        btns[0].setEnabled(true);
        btns[1].setEnabled(false);
    }

    public static void changeTurn() {
        switchSide();
        lockPanel.reset();
        UpdateScore.reset();
    }

    private static void switchSide() {
        Color temp = btns[0].getBackground();
        btns[0].setBackground(btns[1].getBackground());
        btns[1].setBackground(temp);

        btns[0].setEnabled(!btns[0].isEnabled());
        btns[1].setEnabled(!btns[1].isEnabled());
    }

    public static boolean getTurn() {
        return turn;
    }

}
