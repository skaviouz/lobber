package tv.sonis;

import java.awt.Color;

import javax.swing.*;
import javax.swing.text.*;

/*
 *
 * @author sonis
 */
public class ColorJTextPane extends JTextPane {

    public void append(Color c, String s) {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY,
                StyleConstants.Foreground, c);
        int len = getDocument().getLength();
        setCaretPosition(len);
        setCharacterAttributes(aset, false);
        replaceSelection(s);
    }

    public void appendBold(Color c, String s) {
        StyledDocument document = new DefaultStyledDocument();
        
        SimpleAttributeSet attributes = new SimpleAttributeSet();
        attributes = new SimpleAttributeSet();
        attributes.addAttribute(StyleConstants.CharacterConstants.Bold, Boolean.FALSE);
        attributes.addAttribute(StyleConstants.CharacterConstants.Italic, Boolean.FALSE);
        attributes.addAttribute(StyleConstants.CharacterConstants.Foreground, Color.LIGHT_GRAY);

        try {
            document.insertString(document.getLength(), " Bold, Italic and light gray color", attributes);
        } catch (BadLocationException badLocationException) {
            System.err.println("Bad insert");
        }
        
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY,
                StyleConstants.Foreground, c);
        int len = getDocument().getLength();
        setCaretPosition(len);
        setCharacterAttributes(aset, false);
        replaceSelection(s);
    }

    public static void main(String args[]) {
        ColorJTextPane pane = new ColorJTextPane();
        for (int i = 1; i <= 400; i++) {
            if (isPrime(i)) {
                pane.append(Color.red, String.valueOf(i) + ' ');
            } else if (isPerfectSquare(i)) {
                pane.append(Color.blue, String.valueOf(i) + ' ');
            } else {
                pane.append(Color.black, String.valueOf(i) + ' ');
            }
        }
        JFrame f = new JFrame("example color JTextPane");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(new JScrollPane(pane));
        f.setSize(600, 400);
        f.setVisible(true);
    }

    public static boolean isPrime(int i) {
        if (i < 2) {
            return false;
        }
        double max = Math.sqrt(i);
        for (int j = 2; j <= max; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPerfectSquare(int i) {
        int j = 1;
        while (j * j < i && j * j > 0) {
            j++;
        }
        return (j * j == i);
    }
}
