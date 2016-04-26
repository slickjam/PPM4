import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

/**
 * Created by SlickJam on 4/25/2016.
 */
public class ImageLoader implements IImageLoader {

    private byte[] convertImageToBytes(BufferedImage image){

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try
        {
            ImageIO.write(image, "jpg", outputStream);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return outputStream.toByteArray();
    }

    public byte[] loadImage(String imageLocation) {

        BufferedImage image = null;
        try
        {
            // Load the image from the given file location
            image  = ImageIO.read(new File(imageLocation));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return convertImageToBytes(image);
    }
}
