
/**
 * Write a description of class ImagePanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.awt.*;
import javax.swing.*;
/**
 * An ImagePanel is a Swing component that can display an OFImage.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 1.0
 */
public class ImagePanel extends JComponent {
    // The current width and height of this panel
    private int width, height;
    // An internal image buffer that is used for painting.
    private OFImage panelImage;
    /**
     * Create a new, empty ImagePanel.
     */
    public ImagePanel() {
        width = 360; // arbitrary size for empty panel
        height = 240;
        panelImage = null;
    }
    /**
     * Set the image that this panel should show.
     *
     * @param image The image to be displayed.
     */
    public void setImage(OFImage image) {
        if(image != null) {
            width = image.getWidth();
            height = image.getHeight();
            panelImage = image;
            repaint();
        }
    }
    /**
     * Clear the image on this panel.
     */
    public void clearImage() {
        // This is a common way to "clear" an image for display purposes
        // by filling the underlying buffer with a default color.
        if (panelImage != null) {
            Graphics imageGraphics = panelImage.getGraphics();
            imageGraphics.setColor(Color.LIGHT_GRAY);
            imageGraphics.fillRect(0, 0, width, height);
            repaint();
        }
        
    }
    // The following methods are redefinitions of methods
    // inherited from superclasses.
    /**
     * Tell the layout manager how big we would like to be.
     *
     * @return The preferred dimension for this component.
     */
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }
    /**
     * This component needs to be redisplayed. Copy the internal image
     * to screen.
     *
     * @param g The graphics context that can be used to draw on this component.
     */
    public void paintComponent(Graphics g) {
        Dimension size = getSize();
        g.clearRect(0, 0, size.width, size.height);
        if(panelImage != null) {
            // Draw the buffered image at position (0, 0)
            g.drawImage(panelImage, 0, 0, null);
        }
    }
}