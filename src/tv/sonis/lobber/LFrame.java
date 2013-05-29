/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tv.sonis.lobber;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import tv.sonis.lobber.util.Constants;
import static tv.sonis.lobber.util.Constants.d2i;
import static tv.sonis.lobber.util.Constants.random;

/**
 *
 * @author skaviouz
 */
public class LFrame extends JFrame implements ComponentListener {

    public JLayeredPane jlp;
    public BufferedImage bfi;

    public LFrame(String str) {
        super(str);
        setSize(800, 600);
        settings:
        {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        setTitleBarInfo:
        {
            setTitle(Constants.getTitle());
            ImageIcon II = new ImageIcon("./resources/images/icon32_S.png");
            setIconImage(II.getImage());
            jlp = new JLayeredPane();
        }
        ImagePage:
        {
            bfi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = bfi.createGraphics();
            g2.setBackground(new Color(0, 0, 0, 0));
        }
        setScreenLocationInfo:
        {
            setLocationByPlatform(true);
            setVisible(true);
        }
    }

    public void GUI_Resize(ComponentEvent evt) {
        validate();
        Component c = (Component) evt.getSource();
        final int x = getWidth(), y = getHeight();
        insideComponents:
        {
            setContent:
            {
                for (int i = 0; i < 2; i++) {
                    final int i2 = i;
                    jlp.add(new JLabel() {
                        {
                            setVerticalAlignment(JLabel.TOP);
                            setHorizontalAlignment(JLabel.CENTER);
                            setOpaque(true);
                            setBackground(new Color(d2i(random(254)), d2i(random(254)), d2i(random(254)), 255));
                            setForeground(Color.black);
                            setBorder(BorderFactory.createLineBorder(Color.black));
                            //setBounds(33 + (i2 * 10), 33 + (i2 * 10), 140, 140);
                            setBounds(d2i(random(2, x - 144)), 22 + d2i(random(2, y - 144)), 140, 140);
                        }
                    }, i2 + 10);
                }
            }
        }
        copyright:
        {
            //Layer1 obviously... =D
            jlp.add(new JLabel() {
                {
                    setVerticalAlignment(JLabel.TOP);
                    setHorizontalAlignment(JLabel.CENTER);
                    setOpaque(true);
                    setBackground(new Color(255, 255, 255, 0));
                    setBounds(x - 99, y - 16, 98, 15);
                }

                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setColor(new Color(0, 0, 0, 50));
                    g2d.drawString("\u00a9" + " Skaviouz 2009", getWidth() - 95, getHeight() - 3);
                }
            }, 1);
        }
        screen:
        {
            setContentPane(jlp);
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }
}
