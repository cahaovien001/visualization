import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JComponent;
import javax.swing.JFrame;

class ImageDrawingComponent extends JComponent {
    private int width;
    private int height;
    private BufferedImage bImg;
    private Graphics g;
    
    public ImageDrawingComponent(String filename) {
	try {
	    BufferedImage bImg = ImageIO.read(new File(filename));
	    int width  = bImg.getWidth (null);
	    int height = bImg.getHeight(null);

	    BufferedImage bImgRGB =
		new BufferedImage(width,
				  height,
				  BufferedImage.TYPE_INT_RGB);
	    
	    Graphics g = bImgRGB.getGraphics();
	    g.drawImage(bImg, 0, 0, null);
	    bImg = bImgRGB;

	    this.width = width;
	    this.height = height;
	    this.bImg = bImg;
	    this.g = g;
	} catch(Exception e) {
	    System.err.println(":(");
	}
    }

    public Dimension getPreferredSize() {
	return new Dimension(width, height);
    }

    public void paint(Graphics g) {
	Graphics2D gg = (Graphics2D) g;

	int minX = bImg.getMinX();
	int minY = bImg.getMinY();
	int maxX = bImg.getWidth();
	int maxY = bImg.getHeight();

	int widthScale =  1;
	int heightScale = 1; 

	for (int i = minY; i<maxY; i++) {
	    for (int j = minX; j<maxX; j++) {
		if (j % widthScale == 0 &&
		    i % heightScale == 0) {
		    Color color = new Color(bImg.getRGB(j, i));
		    int red   = color.getRed();
		    int green = color.getGreen();
		    int blue  = color.getBlue();
		    int letter;

		    gg.setColor(new Color(red,
					  144,
					  144));
		    gg.drawOval(j, i, 1, 1);
		    gg.fillOval(j, i, 1, 1);
		}
	    }
	}

	widthScale =  (int)((double)(maxX - minX) /233.);
	heightScale = (int)((double)(maxY - minY) /233.);
	
	
	for(int i = minY; i<maxY; i++) {
	    for (int j = minX; j<maxX; j++) {
		if (j % widthScale == 0 &&
		    i % heightScale == 0) {
		    Color color = new Color(bImg.getRGB(j, i));
		    int red   = color.getRed();
		    int green = color.getGreen();
		    int blue  = color.getBlue();
		    int letter;

		    if (green > 13) {
			gg.setColor(new Color((int) (1.618*(double)red)%255,
					      (int) (0.618*(double)green),
					      (int) (0.618*(double)blue)));
			gg.drawOval(j, i, red%13, red%13);
			gg.fillOval(j, i, red%13, red%13);
		    }
		}
	    }
	}

	
	widthScale =  (int)((double)(maxX - minX) /144.);
	heightScale = (int)((double)(maxY - minY) /144.);
	    
	for (int i = minY; i<maxY; i++) {
	    for (int j = minX; j<maxX; j++) {
		if (j % widthScale == 0 &&
		    i % heightScale == 0) {
		    Color color = new Color(bImg.getRGB(j, i));
		    int red   = color.getRed();
		    int green = color.getGreen();
		    int blue  = color.getBlue();
		    int letter;

		    gg.setColor(new Color(red,
					  89,
					  89));
		    gg.drawRect(j, i, 1, 1);
		    gg.fillRect(j, i, 1, 1);
		
		}
	    }
	}

	widthScale =  (int)((double)(maxX - minX) /55.);
	heightScale = (int)((double)(maxY - minY) /55.);
	
	for (int i = minY; i<maxY; i++) {
	    for (int j = minX; j<maxX; j++) {
		if (j % widthScale == 0 &&
		    i % heightScale == 0) {
		    Color color = new Color(bImg.getRGB(j, i));
		    int red   = color.getRed();
		    int green = color.getGreen();
		    int blue  = color.getBlue();
		    int letter;

		    if (red > 13) {
			gg.setColor(new Color(red,
					      144,
					      144));
			gg.drawOval(j, i, blue%8, blue%8);
			gg.fillOval(j, i, blue%8, blue%8);
		    }
		}
	    }
	}
    }
}
	

public class VisualizeToCirclesGradient {
    
    
    public static void main(String... args) {
	try {
	    String filename = args[0];

	    JFrame frame = new JFrame("ImageGradient");
	    ImageDrawingComponent idc = new ImageDrawingComponent(filename);

	    frame.add("Center", idc);
	    frame.pack();
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} catch(Exception e) {
	    System.err.println(":(");

	}
    }
}
