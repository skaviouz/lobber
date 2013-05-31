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
import javax.swing.JPanel;
import tv.sonis.lobber.util.Constants;
import static tv.sonis.lobber.util.Constants.d2i;
import static tv.sonis.lobber.util.Constants.random;

/**
 * LobberJFrame
 *
 * @author skaviouz
 */
public class LFrame extends JFrame implements ComponentListener {

    public LCanvas jlp;

    public LFrame(String str) {
        super(str);
        settings:
        {
            setSize(800, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //Titlebar
            setTitle(Constants.getTitle());
            setIconImage(new ImageIcon("./resources/images/icon32_S.png").getImage());
        }
        Content:
        {
            jlp = new LCanvas();
            setContentPane(jlp);
        }
        setScreenLocationInfo:
        {
            setLocationByPlatform(true);
            setVisible(true);
        }
    }

    /*
     * called when the window is resized
     * redirects to : 
     */
    @Override
    public void componentResized(ComponentEvent e) {
        jlp.Resized();
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
