import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.*;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.util.Scanner; 
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

/**
 * Combines the different panels onto a Frame and displays it on a window
 *
 * @author Adi Venkatesh
 * @version 1.0
 */
public class PictureTester
{
    public static void main (String[] args) throws Exception {
        BorderLayout layout1 = new BorderLayout();
        JFrame scene = new JFrame();
        PaintPanel southPanel = new PaintPanel();
        JColorChooser chooserName = southPanel.getChooserName();
        PicturePanel middlePanel = new PicturePanel();
        MouseMotionListener listener = new MotionListener(middlePanel, chooserName);
        middlePanel.addMouseMotionListener(listener);
        JPanel northPanel = new PicFilterPanel(middlePanel, scene);
        
        scene.setLayout(layout1);

        scene.setSize(900, 900);
        scene.add(northPanel, BorderLayout.NORTH);
        scene.add(southPanel, BorderLayout.SOUTH);
        scene.add(middlePanel, BorderLayout.CENTER);
        scene.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scene.setVisible(true);
        scene.setTitle("Photo Editor");
    }
}
