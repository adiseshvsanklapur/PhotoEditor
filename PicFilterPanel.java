import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Contains the premade image filter buttons
 *
 * @author Adi Venkatesh
 * @version 1.0
 */
public class PicFilterPanel extends JPanel
{
    // Fields
    private JButton negate;
    private JButton grayscale;
    private JButton mirror;
    private JButton cool;
    private JButton warm;
    private JButton edgeD;
    private JButton selFile;
    private JButton reset;
    private JFrame frame;

    /**
     * Constructor for objects of class PicFilterPanel
     */
    public PicFilterPanel(PicturePanel panel, JFrame frameName)
    {
        reset = new JButton("Reset");
        negate = new JButton("Negate");
        grayscale = new JButton("Grayscale");
        mirror = new JButton("Mirror");
        cool = new JButton("Cool");
        warm = new JButton("Warm");
        edgeD = new JButton("Edge Detection");
        selFile = new JButton("Select File");
        frame = frameName;
        addButtons();
        addListener(panel);
    }

    /**
     * Adds the buttons to the panel
     */
    private void addButtons()
    {
        add(selFile);
        add(negate);
        add(grayscale);
        add(mirror);
        add(cool);
        add(warm);
        add(edgeD);
        add(reset);
    }
    
    /**
     * Adds the listeners to the button
     *
     * @param panel The panel to reset after each addition
     */
    private void addListener(PicturePanel panel)
    {
        ActionListener listener = new ClickListener(panel);
        selFile.addActionListener(listener);
        negate.addActionListener(listener);
        grayscale.addActionListener(listener);
        mirror.addActionListener(listener);
        cool.addActionListener(listener);
        warm.addActionListener(listener);
        edgeD.addActionListener(listener);
        reset.addActionListener(listener);
    }
}
