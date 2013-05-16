/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tv.sonis.lobber.model;

/**
 *
 * @author skaviouz
 */
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.sun.jna.platform.WindowUtils;
import javax.swing.SwingUtilities;

public class TransparentFrame extends JFrame {
   public TransparentFrame() {
      setTitle("Transparent Frame");
      setSize(400,400);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JSlider slider = new JSlider(JSlider.HORIZONTAL, 30, 100, 100);

      slider.addChangeListener(new ChangeListener() {
         @Override
         public void stateChanged(ChangeEvent e) {
            JSlider slider = (JSlider) e.getSource();
            if(!slider.getValueIsAdjusting()){
               WindowUtils.setWindowAlpha(TransparentFrame.this, slider.getValue()/100f);
            }
         }
      });
      add(slider);
      setVisible(true);
   }
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
	 @Override
	 public void run() {
	    new TransparentFrame();
	 }
      });
   }
}