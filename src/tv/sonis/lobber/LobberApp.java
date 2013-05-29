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
import java.awt.event.ComponentListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
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

    public static LFrame gui;

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
        gui = new LFrame("Swing Paint Demo");
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
