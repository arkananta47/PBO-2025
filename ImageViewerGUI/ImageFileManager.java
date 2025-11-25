
/**
 * Write a description of class ImageFileManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
/**
 * ImageFileManager is a small utility class with static methods to load
 * and save images.
 *
 * @author Michael Kolling and David J Barnes
 * @version 2.0
 */
public class ImageFileManager {
    // A constant for the image format that this writer uses for writing.
    // Available formats are "jpg" and "png".
    private static final String IMAGE_FORMAT = "jpg";
    /**
     * Read an image file from disk and return it as an image.
     * @param imageFile The image file to be loaded.
     * @return The image object or null is it could not be read.
     */
    public static OFImage loadImage(File imageFile) {
        try {
            BufferedImage image = ImageIO.read(imageFile);
            // Handle case where ImageIO.read returns null or an invalid image
            if(image == null || (image.getWidth(null) < 0)) {
                return null;
            }
            return new OFImage(image);
        }
        catch(IOException exc) {
            return null;
        }
    }
    /**
     * Write an image file to disk.
     *
     * Note: The original document only showed the method signature. 
     * A complete implementation would use ImageIO.write().
     * * @param image The image to be saved.
     * @param file The file to save to.
     */
    public static void saveImage(OFImage image, File file) {
        try {
            ImageIO.write(image, IMAGE_FORMAT, file);
        } catch (IOException e) {
            // Silently ignore errors as per original document's implied intent
        }
    }
}