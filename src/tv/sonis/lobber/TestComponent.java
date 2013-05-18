/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tv.sonis.lobber;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 *
 * @author skaviouz
 */
public class TestComponent extends JComponent {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.red);
        g2d.drawString("Hello", 50, 50);
        g2d.dispose();
    }
}
