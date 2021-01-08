import java.awt.event.*;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;

/**
 * Creates the drawing function of the program
 *
 * @author Adi Venkatesh
 * @version 1.0
 */

public class MotionListener implements MouseMotionListener
{
    // Fields
    private PicturePanel panel;
    private JColorChooser chooser;

    /**
     * Constructor for objects of class MotionListener
     * 
     * @param panelName The name of the picture panel to paint on
     * @param chooserName The name of the color chooser to collect the color from
     */
    public MotionListener(PicturePanel panelName, JColorChooser chooserName)
    {
        panel = panelName;
        chooser = chooserName;
    }

    @Override
    /**
     * Empty method that does nothing, but required for overriding purposes
     *
     * @param  m  A mouse event m
     */
    public void mouseMoved(MouseEvent m)
    {
        
    }
    
    @Override
    /**
     * Collects the data about when mouse is clicked, held, and released
     *
     * @param  m  A mouse event
     */
    public void mouseDragged(MouseEvent m)
    {
        panel.getBufferedImage().setRGB(m.getX(), m.getY(), chooser.getColor().getRGB());
        panel.getBufferedImage().setRGB(m.getX() + 1, m.getY() + 1, chooser.getColor().getRGB());
        panel.getBufferedImage().setRGB(m.getX() - 1, m.getY() - 1, chooser.getColor().getRGB());
        panel.getBufferedImage().setRGB(m.getX() + 1, m.getY(), chooser.getColor().getRGB());
        panel.getBufferedImage().setRGB(m.getX() - 1, m.getY(), chooser.getColor().getRGB());
        panel.getBufferedImage().setRGB(m.getX(), m.getY() + 1, chooser.getColor().getRGB());
        panel.getBufferedImage().setRGB(m.getX(), m.getY() - 1, chooser.getColor().getRGB());
        panel.redraw();
        panel.repaint();
    }
}
