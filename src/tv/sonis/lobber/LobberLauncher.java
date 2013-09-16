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
    }

    private void initComponents() {
        mainPane = new LobberLauncherPanel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        add(mainPane);
        setSize(800, 600);
        setTitle(Constants.getTitle());
        ImageIcon II = new ImageIcon("./resources/images/icon32_S.png");
        setIconImage(II.getImage());
        setLocationByPlatform(true);
    }
}
