/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tv.sonis.lobber;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author skaviouz
 */
public class LobberCanvasIMPL extends JPanel {

    public Image image = null;

    @Override
    protected void paintComponent(Graphics gOriginal) {
        super.paintComponent(gOriginal);
        //CALL ALL THE VARIABLES...
        //TODO: move local variables from method to class level
        //TODO: give better names =D
        int maxx, maxy, maxxa, maxya;
        Graphics2D graphics2edit, imageGraphics;
        BufferedImage bfi;
        ComponentSize:
        {
            maxx = getWidth();
            maxy = getHeight();
            //means lowest values
            maxxa = 0;
            maxya = 0;
        }
        GraphicSetup:
        {
            //graphics to graphics2D to do stuff
            graphics2edit = (Graphics2D) gOriginal;
            //image.draw(stuff), then graphics.draw(image)
            //this let's us able to do screenshots =D
            bfi = new BufferedImage(maxx, maxy, BufferedImage.TYPE_INT_ARGB);
            //makes graphics2D for image
            imageGraphics = bfi.createGraphics();
            imageGraphics.setBackground(new Color(0, 0, 0, 0));
        }
        BackgroundCheck:
        {
            if (image != null) {
                imageGraphics.drawImage(image, 0, 0, null);
            }
        }
        Statistics:
        {
            //TODO: IMPL these
            imageGraphics.drawString("X:" + maxx, 33, 33);
            imageGraphics.drawString("Y:" + maxy, 33, 22);
            imageGraphics.drawString("OFFSET:" + 0, 33, 11);
        }
        //
        try {
            //this draws the image into the actual canvas
            graphics2edit.drawImage(bfi, 0, 0, null);
            //this save's the buffered image
            ImageIO.write(bfi, "png", new File("./image.png"));
        } catch (IOException ex) {
            Logger.getLogger(tv.sonis.lobber.graphics.LobberCanvas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //ui.update(scratchGraphics, this);
        } finally {
            //scratchGraphics.dispose();
        }
    }
}
