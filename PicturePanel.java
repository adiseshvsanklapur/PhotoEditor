import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

 /**
  * The middle panel that contains the editable picture
  *
  * @author Adi Venkatesh
  * @version 1.0
  */
 public class PicturePanel extends JPanel
 {
    // Fields
    private ImageIcon backImage;
    private BufferedImage image;

    /**
     * Constructor for objects of class PicturePanel
     */
    public PicturePanel() {
        
    }
    
    /**
     * Another constructor for objects of class PicturePanel
     * 
     * @param fileName The name of the image file
     */
    public PicturePanel(String fileName)
    {
        backImage = new ImageIcon(fileName);
    }

    private BufferedImage getScaledImage() {
        image = new BufferedImage(getWidth(),getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = (Graphics2D) image.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
        if (backImage != null) {
            g2d.drawImage(backImage.getImage(), 0, 0,getWidth(),getHeight(), null);
        }
        return image;
    }
    
    /**
    * Returns the buffered image
    * 
    * @return image
    */
    public BufferedImage getBufferedImage() {
        return image;
    }
    
    @Override
    /**
    * Overrides the paint component method to draw a buffered image
    * 
    * @param g A graphics object
    */
    public void paintComponent(Graphics g) {
        BufferedImage scaledImage = getScaledImage();
        g.drawImage(scaledImage, 0, 0, getWidth(), getHeight(), this);
    }
    
    /**
    * Method to get a two-dimensional array of Pixels for this simple picture
    * @return a two-dimensional array of Pixel objects in row-major order.
    */
    public Pixel[][] getPixels2D() {
     int width = getWidth();
     int height = getHeight();
     Pixel[][] pixelArray = new Pixel[height][width];
     
     // loop through height rows from top to bottom
     for (int row = 0; row < height; row++) 
       for (int col = 0; col < width; col++) 
         pixelArray[row][col] = new Pixel(image,col,row);
      
     return pixelArray;
    }
    
    /**
    * Method to clear the screen and redraw the picture
    */
    public void redraw() {
        backImage.setImage(image);
    }
    
    /**
    * Method to set the image to a different image
    * 
    * @param image The new image to be used
    */
    public void setBackImage(ImageIcon image) {
        backImage = image;
    }
    
    /**
    * Method to return the current image
    * 
    * @return backImage
    */
    public ImageIcon getBackImage() {
        return backImage;
    }
 }