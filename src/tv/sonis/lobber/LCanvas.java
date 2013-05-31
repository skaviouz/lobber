/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tv.sonis.lobber;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import tv.sonis.lobber.graphics.LobberCanvas;
import static tv.sonis.lobber.util.Constants.d2i;
import static tv.sonis.lobber.util.Constants.random;

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
        Graphics2D g2d = (Graphics2D) g;
        ImagePage:
        {
            bfi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = bfi.createGraphics();
            g2.setBackground(new Color(100, 100, 0, 100));
            g2.setColor(Color.black);
            g2.drawString("ROAWRRR", 40, 40);
        }
        try {
            g2d.drawImage(bfi, 0, 0, null);
            ImageIO.write(bfi, "png", new File("./image.png"));
        } catch (IOException ex) {
            Logger.getLogger(LobberCanvas.class.getName()).log(Level.SEVERE, null, ex);
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

    public void old_GUI_Resize(ComponentEvent evt) {
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
}
