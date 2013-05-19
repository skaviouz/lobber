/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tv.sonis.lobber.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;

/**
 *
 * @author skaviouz
 */
public class LobCanvas extends JComponent {

    @Override
    public void paintComponent(Graphics g) {
        int y = getHeight();
        int x = getWidth();
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.red);
        g2d.drawString("Hello", 50, 50);
        
        g2d.setColor(Color.red);
        Rectangle2D r2d = new Rectangle2D.Double(15, 5, x-5, y-5);
        g2d.draw(r2d);
        
        g2d.dispose();
    }
}
