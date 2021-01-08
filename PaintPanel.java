import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The bottom panel with the paint feature
 *
 * @author Adi Venkatesh
 * @version 1.0
 */
public class PaintPanel extends JPanel
{
    // Fields
    private JColorChooser choose;

    /**
     * Constructor for objects of class PaintPanel
     */
    public PaintPanel() {
        choose = new JColorChooser();
        addComponents();
    }

    /**
     * Adds the components to the panel
     */
    public void addComponents() {
        add(choose);
    }
    
    /**
     * Returns the color chooser
     * 
     * @return choose
     */
    public JColorChooser getChooserName() {
        return choose;
    }
}
