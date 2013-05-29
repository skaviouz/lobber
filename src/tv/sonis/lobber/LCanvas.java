/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tv.sonis.lobber;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author skaviouz
 */
public class LCanvas extends JLayeredPane {

    public BufferedImage bfi;

    public LCanvas() {
        super();
        setBorder(BorderFactory.createTitledBorder(
                "Move the Mouse to Move Duke"));
        addMouseMotionListener(new MouseMotionAdapter() {
        });
        setOpaque(true);
        setBackground(new Color(10, 240, 240, 0));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImagePage:
        {
            bfi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = bfi.createGraphics();
            g2.setBackground(new Color(0, 0, 0, 0));
        }
    }

    static void resizeEvent(ComponentEvent evt) {
    }

    class MyLobberPane extends JPanel {

        public MyLobberPane() {
            setBorder(BorderFactory.createLineBorder(Color.black));
            add(new JButton("TEST TEST TEST"));
        }

        public Dimension getPreferredSize() {
            return new Dimension(250, 200);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString("aaaaaaaaaaaaaaaaal!", 30, 100);

            // Draw Text
            g.drawString("This is my custom Panel!", 10, 20);
        }
    }
}
