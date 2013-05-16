/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tv.sonis.lobber.graphics;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import tv.sonis.*;
import tv.sonis.lobber.*;
import tv.sonis.lobber.model.AzimuthData;
import tv.sonis.lobber.util.geometry;
import static tv.sonis.lobber.util.geometry.*;

/**
 *
 * @author skaviouz
 */
public class LobberCanvas extends Canvas {

    public Image image = null;
    public static AzimuthData[] azimuths = null;
    public static double[] bar = {
        0, 0, 0, 1000, 1000, 0,
        0, 0, 0, 0, 0, 0,};

    public void setValids(String[] old) {
        int count = 0;
        for (int i = 0; i < old.length; i++) {
            if (old[i] != null || !old[i].equals("")) {
                count++;
            }
        }
        AzimuthData[] newD = new AzimuthData[count];
        count = 0;
        for (int i = 0; i < old.length; i++) {
            try {
                newD[count] = new AzimuthData().setID(i).decipher(old[i]);
                count++;
            } catch (Exception e) {
            }
        }
        count = 0;
        for (int i = 0; i < newD.length; i++) {
            if (newD != null) {
                count++;
            }
        }
        azimuths = new AzimuthData[count];
        count = 0;
        for (int i = 0; i < newD.length; i++) {
            if (newD[i] != null) {
                azimuths[count] = newD[i];
                count++;
            }
        }
        repaint();
    }
    public LobberToolApplication LTA = null;

    public LobberCanvas() {
    }

    public LobberCanvas(LobberToolApplication lta) {
        LTA = lta;
        resized();
        this.setBackground(new Color(255, 255, 255));



        //g.drawLine(WIDTH, WIDTH, WIDTH, WIDTH);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g22 = (Graphics2D) g;
        BufferedImage bfi = new BufferedImage(LTA.getWidth(), LTA.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bfi.createGraphics();
        g2.setBackground(new Color(0, 0, 0, 0));
        if (image != null) {
            g2.drawImage(image, 0, 0, null);
        }

        int LTAx = LTA.getWidth();
        int LTAy = LTA.getHeight();
        int LTAxa = 0;//(int)bar[3] - 1000;
        int LTAya = 0;//(int)bar[4] - 1000;
//        int LTAy = (int) ((double)LTA.getHeight() / 1000 * bar[4]);
//        int LTAx = (int) ((double)LTA.getWidth() / 1000 * bar[3]);
        g2.setColor(new Color(0, 0, 0, 100));
        g2.drawString("X:" + Double.toString(bar[3]), 33, 33);
        g2.drawString("Y:" + Double.toString(bar[4]), 33, 22);
        g2.drawString("OFFSET:" + Double.toString(bar[5]), 33, 11);
        for (int i = 0; i < 3; i++) {
            if(bar[i]==0){
                break;
            }
            int[] p = geometry.AzimuthLineBox((int)(LTAx/2+LTAxa), (int)(LTAy/2+LTAya), 1000, 1000, bar[i]);
            switch (i % 3) {
                case 0:
                    g2.setColor(new Color(0, 0, 0, 100));
                    break;
                case 1:
                    g2.setColor(new Color(0, 255, 0, 100));
                    break;
                case 2:
                    g2.setColor(new Color(0, 0, 255, 100));
                    break;
            }
            g2.drawString(Double.toString(bar[i]), 33, 55 + i * 12);
            g2.drawLine(LTAx/2+LTAxa, LTAy/2+LTAya, (int)p[0], (int)p[1]);
        }
        if (azimuths != null) {
            for (int i = 0; i < azimuths.length; i++) {
                if (azimuths[i] == null) {
                    break;
                }
                if(azimuths[i].Thickness<1){
                    azimuths[i].Thickness=1.00;
                }
                double d_minus = azimuths[i].Value - (azimuths[i].Thickness / 2) + bar[5];
                double d_plus = azimuths[i].Value + (azimuths[i].Thickness / 2) + bar[5];
                g2.setColor(azimuths[i].LineColor);
                int[]  p2 = geometry.AzimuthLineBox(LTAx/2+LTAxa, LTAy/2+LTAya, 1000, 1000, azimuths[i].Value + bar[5]);
                g2.drawString(azimuths[i].Name,
                        (int) (p2[0] + azimuths[i].NameOffset[0]),
                        (int) (p2[1] + azimuths[i].NameOffset[1]));
                if (d_minus == d_plus) {
                    int[]  pm = geometry.AzimuthLineBox(LTAx/2+LTAxa, LTAy/2+LTAya, 1000, 1000, d_minus);
                    g2.drawLine(LTAx+LTAxa, LTAy+LTAya, pm[0], pm[1]);
                } else {
                    Polygon p = makeArea2(i, LTAx, LTAy, LTAxa, LTAya, d_minus);
                    //g2.fillPolygon(xy[0], xy[1], xy.length);
                    g2.draw(p);
                    g2.fill(p);
                }
            }
        }
        try {
            g22.drawImage(bfi, 0, 0, null);
            ImageIO.write(bfi, "png", new File("./image.png"));
        } catch (IOException ex) {
            Logger.getLogger(LobberCanvas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Polygon makeArea(double thickness, int x, int y){
                    Polygon p = new Polygon();
                    Point[] p_p = new Point[(int) (thickness + 1)];
//                    System.out.println("thickness count plus two is " + p_p.length);
                    p_p[0] = new Point(x/2, y/2);
//                    System.out.println("center of screen is :" + p_p[0].x + "," + p_p[0].y);
                    for (int ii = 1; ii <= thickness; ii++) {
                        int[] tii = geometry.AzimuthLineBox(x/2, y/2, 1000, 1000, thickness + ii);
                        p_p[ii] = new Point(tii[0], tii[1]);
                    }
                    for (int ii = 0; ii < p_p.length; ii++) {
                        p.addPoint(p_p[ii].x, p_p[ii].y);
                    }
                    return p;
    }
    
    public Polygon makeArea2(int i, int LTAx, int LTAy, int LTAxa, int LTAya, double d_minus){
                    Polygon p = new Polygon();
                    Point[] p_p = new Point[(int) (azimuths[i].Thickness + 1)];
//                    System.out.println("thickness count plus two is " + p_p.length);
                    p_p[0] = new Point(LTAx/2, LTAy/2);
//                    System.out.println("center of screen is :" + p_p[0].x + "," + p_p[0].y);
                    for (int ii = 1; ii <= azimuths[i].Thickness; ii++) {
                        int[] tii = geometry.AzimuthLineBox(LTAx/2+LTAxa, LTAy/2+LTAya, 1000, 1000, d_minus + ii);
                        p_p[ii] = new Point(tii[0], tii[1]);
                    }
                    for (int ii = 0; ii < p_p.length; ii++) {
                        p.addPoint(p_p[ii].x, p_p[ii].y);
                    }
                    return p;
    }

    public double lt(double a, double b) {
        return (a > b) ? b : a;
    }

    public double gt(double a, double b) {
        return (a > b) ? a : b;
    }

    public void getXY() {

        double angleStep = ((10.00 * Math.PI) / (360.00 / 3.00)) / 10.00;

        for (int i = 0; i < 9 * 2; i++) {
            double angle = i * angleStep;
            double radius = 0;

            double x = 0 + radius * Math.cos(angle);
            double y = 0 + radius * Math.sin(angle);

            //xy[i * 2 + 0] = (int) Math.round(x);
            //xy[i * 2 + 1] = (int) Math.round(y);
        }

        // Close polygon
        //xy[nPoints * 2 - 2] = xy[0];
        //xy[nPoints * 2 - 1] = xy[1];
    }

    public void resized() {
        
//        ((AboutDialogBox)LTA.Aboutdialog).jSlider4.setValue((int)bar[3]);
//        ((AboutDialogBox)LTA.Aboutdialog).jSlider5.setValue((int)bar[4]);
    }
}
