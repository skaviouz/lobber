/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tv.sonis.lobber;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author skaviouz
 */
public class LobberLauncherPanel extends JPanel implements MouseListener, MouseMotionListener {

    private Graphics2D g2d;
    private String state = "";
    private int x, y;
    public boolean ViewGraph = true;
    public JTabbedPane MainTab = new JTabbedPane();
    public JPanel About, How, Version, Values, Ref;

    public LobberLauncherPanel() {
        super(new GridBagLayout(), true);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        addMouseMotionListener(this);
        addMouseListener(this);
        MainTab.add("asdfasdf", new JPanel());
        setVisible(true);
    }

    //@Override
    public void paintComponent(Graphics g) {
        if (ViewGraph) {
            super.paintComponent(g);
            return;
        }
        g2d = (Graphics2D) g;

        int y = getHeight();
        int x = getWidth();

        Graphics2D g2d = (Graphics2D) g.create();
        LobberGraphics:
        {
            Shape cirzzz;
            //cirzzz = Ellipse2D.Double(x/2, y/2, 60, 120);
            g2d.setColor(Color.red);
            g2d.drawOval(x / 2, y / 2, 40, 60);
        }
        testString:
        {
            g2d.setColor(Color.red);
            g2d.drawString("Hello", 50, 50);
        }
        box:
        {
            g2d.setColor(Color.red);
            Rectangle2D r2d = new Rectangle2D.Double(15, 5, x - 25, y - 25);
            g2d.draw(r2d);
        }
        copyrigbht:
        {
            g2d.setColor(new Color(0, 0, 0, 90));
            g2d.drawRect(x - 96, y - 21, 93, 12);
            g2d.drawString("\u00a9" + " Skaviouz 2009", x - 95, y - 10);
            if (!state.equals("")) {
                g2d.drawString("STATE: " + state, 5, 25);
            }
        }

        g2d.dispose();
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setX(int x) {
        this.x = x;
        repaint();
    }

    public void setY(int y) {
        this.y = y;
        repaint();
    }

    //MouseMotionListener
        /*
     * M/C + M MOVE
     */
    @Override
    public void mouseDragged(MouseEvent e) {
    }

    /*
     * M MOVE
     */
    @Override
    public void mouseMoved(MouseEvent e) {
    }

    //MouseListener
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
