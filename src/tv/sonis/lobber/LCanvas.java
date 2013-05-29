/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tv.sonis.lobber;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;

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
    }

    @Override
    protected void paintComponent(Graphics g) {
        setBackground(Color.white);
        super.paintComponent(g);
    }
}
