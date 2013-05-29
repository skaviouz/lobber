/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tv.sonis.lobber;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseMotionAdapter;
import javax.swing.*;
import tv.sonis.lobber.util.Constants;
import static tv.sonis.lobber.util.Constants.random;
import static tv.sonis.lobber.util.Constants.d2f;
import static tv.sonis.lobber.util.Constants.d2i;
import static tv.sonis.lobber.util.Constants.f2i;

/**
 *
 * @author skaviouz
 */
public class LobberApp {

    public static GUI gui;
    public static boolean ShowUI = true;
    public static boolean[] tempvar = new boolean[]{
        true, true, true, true, true,
        true, true, true, true, true,
        true, true, true, true, true,
        true, true, true, true, true};

    /*
     * Program starts here
     */
    public static void main(String[] args) {
        new LobberApp();
    }

    /*
     * Program starts GUI
     */
    public LobberApp() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    /*
     * MainGUI
     */
    public void createAndShowGUI() {
        gui = new GUI("Swing Paint Demo");
    }

    public class GUI extends JFrame {

        public JLayeredPane jlp;

        public GUI(String str) {
            super(str);
            settings:
            {
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setSize(800, 600);
            }
            final int x = getWidth(), y = getHeight();
            setTitleBarInfo:
            {
                setTitle(Constants.getTitle());
                ImageIcon II = new ImageIcon("./resources/images/icon32_S.png");
                setIconImage(II.getImage());
            }
            insideComponents:
            {
                jlp = new JLayeredPane();
                jlp.setPreferredSize(new Dimension(getWidth(), getHeight()));
                jlp.setBorder(BorderFactory.createTitledBorder(
                        "Move the Mouse to Move Duke"));
                jlp.addMouseMotionListener(new MouseMotionAdapter() {
                });
                setContent:
                {
                    for (int i = 0; i < 412; i++) {
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
                        }, i2 + 5);
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
                jlp.setOpaque(true); //content panes must be opaque
                setContentPane(jlp);
                pack();
            }
            setScreenLocationInfo:
            {
                setLocationByPlatform(true);
                setVisible(true);
            }
        }
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
