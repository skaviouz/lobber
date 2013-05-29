/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tv.sonis.lobber;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

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
