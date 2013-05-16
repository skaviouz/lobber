package tv.sonis.lobber;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import tv.sonis.lobber.graphics.LobberCanvas;

/**
 * Simple Application (JFrame)
 * @author skaviouz
 */
public class LobberToolApplication extends javax.swing.JFrame {

    public LobberToolApplication() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackgroundPanel = new javax.swing.JPanel();
        canvas2 = new LobberCanvas(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        canvas2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                canvas2MouseClicked(evt);
            }
        });
        canvas2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                canvas2ComponentResized(evt);
            }
        });

        //BackgroundPanel.add(getCanvas());

        javax.swing.GroupLayout BackgroundPanelLayout = new javax.swing.GroupLayout(BackgroundPanel);
        BackgroundPanel.setLayout(BackgroundPanelLayout);
        BackgroundPanelLayout.setHorizontalGroup(
            BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
            .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(canvas2, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE))
        );
        BackgroundPanelLayout.setVerticalGroup(
            BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
            .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(canvas2, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public AboutDialogBox Aboutdialog = new AboutDialogBox(this, true) {
        {
            setVisible(true);
        }
    };
    private void canvas2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvas2MouseClicked
        if (evt.getButton() == 3) {
            Aboutdialog.setVisible(true);
        }
        canvas2.repaint();
    }//GEN-LAST:event_canvas2MouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        canvas2.repaint();
    }//GEN-LAST:event_formKeyPressed

    private void canvas2ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_canvas2ComponentResized
        ((LobberCanvas) canvas2).resized();
    }//GEN-LAST:event_canvas2ComponentResized

    private void AboutJMenuItemActionPerformed2(java.awt.event.ActionEvent evt) {
        AboutDialogBox Aboutdialog = new AboutDialogBox(this, true);
        Aboutdialog.setVisible(true);

    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LobberToolApplication().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackgroundPanel;
    public java.awt.Canvas canvas2;
    // End of variables declaration//GEN-END:variables
}
