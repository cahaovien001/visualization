import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;

public class VisualizeImageToCharacterSet {
    public static void main(String... args) {
	try {
	    String filename = args[0];
	    
	    BufferedImage bufferedImage = ImageIO.read(new File(filename));

	    int minX = bufferedImage.getMinX();
	    int minY = bufferedImage.getMinY();
	    int maxX = bufferedImage.getWidth();
	    int maxY = bufferedImage.getHeight();

	    int widthScale = (maxX - minX) / 79;
	    int heightScale = (int) ((maxY - minY) / 46);
	    
	    for (int i = minY; i<maxY; i++) {
		if(i % heightScale == 0) {
		    for (int j = minX; j<maxX; j++) {
			if (j % widthScale == 0) {
			    Color color = new Color(bufferedImage.getRGB(j, i));
			    int red   = color.getRed();
			    int green = color.getGreen();
			    int blue  = color.getBlue();
			    int letter;
			    
			    letter = (int) Math.floor((0.618*red+green+0.382*blue)/93.);
			    System.out.print((char)(letter + 33));
			}
		    }
		    System.out.println();
		}
	    }
	} catch(Exception e) {
	    System.err.println(":(");

	}
    }
}
