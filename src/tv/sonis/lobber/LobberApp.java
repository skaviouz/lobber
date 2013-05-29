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
 * new LobberApp() runs LFrame in swing thread
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
                gui = new LFrame("Swing Paint Demo");
            }
        });
    }
}
