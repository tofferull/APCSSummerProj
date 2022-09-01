package arrays.NIMGame.Core;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import arrays.NIMGame.DisplayParts.Pile;
import arrays.NIMGame.Round.UpdateScore;
import arrays.NIMGame.Utilities.ErrorLabel;
import arrays.NIMGame.Utilities.Util;
import arrays.NIMGame.Utilities.Util.lockPanel;

public class Entity extends JLabel {
    private final int multiple = 6;
    private final int width = 11 * multiple;
    private final int height = 14 * multiple;
    private final ImageIcon stoneH = Util.resize("highlighted-stone.png", width, height);
    private final ImageIcon stone = Util.resize("usable-stone.png", width, height);
    // 11/14 ratio estimated
    private static ArrayList<Entity> entities = new ArrayList<>();
    private JPanel panel;

    public Entity(JPanel panel) {
        this.setIcon(stone);
        this.addMouseListener(new clickEvent());
        this.panel = panel;
        entities.add(this);
        //this.addMouseMotionListener(new dragEvent());
    }

    public JLabel getLabel() {
        return this;
    }

    public static void restoreEntity() {
        for (int i = 0; i < entities.size(); i++)
            entities.get(i).setVisible(true);
    }

    private class clickEvent extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if (new lockPanel(panel).isInPanel(e)) {
                if (Pile.getAmount() == 1) {
                    ErrorLabel.showError("Cannot remove last stone, press end turn.");
                    return;
                }
                getLabel().setVisible(false);
                /* 
                    removing entities leads to performance issues as it requires to recreate the labels
                    
                    panel.remove(getLabel());
                    panel.revalidate();
                    panel.repaint();
                */
                UpdateScore.addCount();
                Pile.removeCount();
            } else
                ErrorLabel.showError("Can only select stone within the stone pile.");
        }
        public void mouseEntered(MouseEvent e) {
            getLabel().setIcon(stoneH);
        }
        public void mouseExited(MouseEvent e) {
            getLabel().setIcon(stone);
        }
    }

    // private class dragEvent extends MouseMotionAdapter {
    //     public void mouseDragged(MouseEvent e) {
    //         getLabel().setLocation(e.getLocationOnScreen().x - nX, e.getLocationOnScreen().y - nY);
    //         nX = e.getLocationOnScreen().x - getLabel().getX();
    //         nY = e.getLocationOnScreen().y - getLabel().getY();
    //     }
    // }
 


    
}
