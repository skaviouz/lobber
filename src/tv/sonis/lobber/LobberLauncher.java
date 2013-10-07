/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tv.sonis.lobber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.*;
import javax.swing.*;
import tv.sonis.lobber.util.Constants;
import tv.sonis.lobber.util.lobberstatics;

/**
 *
 * @author skaviouz
 */
public class LobberLauncher extends JFrame {

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LobberLauncher().setVisible(true);
            }
        });
    }
    public LobberLauncherPanel mainPane;

    public LobberLauncher() {
        initSelf:
        {
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setSize(800, 600);
            setTitle(Constants.getTitle());
            ImageIcon:
            {
                String file = "resources/images/icon32_L.png";
                InputStream is;
                ImageInJar:
                try {
                    is = Thread.currentThread().getContextClassLoader().getResourceAsStream(file);
                    byte[] buffer = new byte[100000];
                    is.read(buffer, 0, 100000);
                    ImageIcon placeHolder = new ImageIcon(buffer);
                    setIconImage(placeHolder.getImage());
                } catch (IOException ex) {
                    Logger.getLogger(LobberLauncher.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            setLocationByPlatform(true);
        }
        initComponents:
        {
            mainPane = new LobberLauncherPanel();
            add(mainPane);
            AboutDialogBox Aboutdialog = new AboutDialogBox(this, true);
            Aboutdialog.setVisible(true);
        }
    }
}
