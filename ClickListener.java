import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner; 
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

/**
 * Helps determine the actions of each button
 *
 * @author Adi Venkatesh
 * @version 1.0
 */
public class ClickListener implements ActionListener {
    private PicturePanel panel;
    private java.io.File inFile;

    public ClickListener(PicturePanel panelName) {
        panel = panelName;
    }
    
    @Override
    /**
     * What happens when a button is clicked
     *
     * @param event the action event
     */
    public void actionPerformed(ActionEvent event) {
        if ("Negate".equals(event.getActionCommand())) {
            Pixel[][] pixels = panel.getPixels2D();
            for (Pixel[] rowArray : pixels)
            {
              for (Pixel pixelObj : rowArray)
              {
                pixelObj.setGreen(255 - pixelObj.getGreen());
                pixelObj.setRed(255 - pixelObj.getRed());
                pixelObj.setBlue(255 - pixelObj.getBlue());
              }
            }
            panel.redraw();
            panel.repaint();
        }
        
        else if ("Grayscale".equals(event.getActionCommand())) {
            Pixel[][] pixels = panel.getPixels2D();
            for (Pixel[] rowArray : pixels)
            {
              for (Pixel pixelObj : rowArray)
              {
                pixelObj.setGreen((pixelObj.getGreen() + pixelObj.getRed() + pixelObj.getBlue()) / 3);
                pixelObj.setRed((pixelObj.getGreen() + pixelObj.getRed() + pixelObj.getBlue()) / 3);
                pixelObj.setBlue((pixelObj.getGreen() + pixelObj.getRed() + pixelObj.getBlue()) / 3);
              }
            }
            panel.redraw();
            panel.repaint();
        }
        
        else if ("Mirror".equals(event.getActionCommand())) {
            
            Pixel[][] pixels = panel.getPixels2D();
            Pixel leftPixel = null;
            Pixel rightPixel = null;
            int width = pixels[0].length;
            for (int row = 0; row < pixels.length; row++)
            {
              for (int col = 0; col < width / 2; col++)
              {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
              }
            }
            panel.redraw();
            panel.repaint();
        }
        
        else if ("Cool".equals(event.getActionCommand())) {
            Pixel[][] pixels = panel.getPixels2D();
            for (Pixel[] rowArray : pixels)
            {
              for (Pixel pixelObj : rowArray)
              {
                pixelObj.setBlue(pixelObj.getBlue()+50);
              }
            }
            panel.redraw();
            panel.repaint();
        }
        
        else if ("Warm".equals(event.getActionCommand())) {
            Pixel[][] pixels = panel.getPixels2D();
            for (Pixel[] rowArray : pixels)
            {
              for (Pixel pixelObj : rowArray)
              {
                pixelObj.setRed(pixelObj.getRed()+50);
              }
            }
            panel.redraw();
            panel.repaint();
        }
        
        else if ("Edge Detection".equals(event.getActionCommand())) {
            Pixel leftPixel = null;
            Pixel rightPixel = null;
            Pixel[][] pixels = panel.getPixels2D();
            Color rightColor = null;
            for (int row = 0; row < pixels.length; row++)
            {
              for (int col = 0; 
                   col < pixels[0].length-1; col++)
              {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col+1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > 
                    10)
                  leftPixel.setColor(Color.BLACK);
                else
                  leftPixel.setColor(Color.WHITE);
              }
            }
            panel.redraw();
            panel.repaint();
        }
        
        else if ("Select File".equals(event.getActionCommand())) {
            JFileChooser fileChooser = new JFileChooser();
            inFile = new File("test");
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
            fileChooser.setFileFilter(filter);
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {    
              // Get the selected file≥
              inFile = fileChooser.getSelectedFile(); 
            }
            else {
              System.out.println("No file selected");
            }
            panel.setBackImage(new ImageIcon(inFile.getAbsolutePath()));
            panel.repaint();
        }
        
        else {
            if (inFile.getName().equals("test") == false) {
                panel.setBackImage(new ImageIcon(inFile.getAbsolutePath()));
                panel.repaint();
            }
        }
    }
}