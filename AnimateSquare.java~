import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.JFrame;

class RepeatedPatternWithCirclePainterComponent extends JComponent {
    int width;
    int height;
    final int RECT_HEIGHT = 8;
    final int RECT_WIDTH  = 21;
    final int RECT_SPACER = 34;
    int fib_count = 3;
    int fib_counter = 0;
    int counter = 0;
    int _counter = 3;
    final int counter_tile = 3;
    
    public RepeatedPatternWithCirclePainterComponent(int width, int height) {
	this.width  = width;
	this.height = height;
    }
    
    public Dimension getPreferredSize() {
	return new Dimension(width, height);
    }

    // thank you to Kenneth H. Rosen, for this brilliant Fibonacci Equation
    // featured in his Textbook... I'm not entirely sure he created but it
    // was in his Discrete Mathematics textbook.
    public int fib(int n) {
	double a1 =  1./Math.sqrt(5.);		
	double a2 = -1./Math.sqrt(5.);
	double r1 = ((1.+Math.sqrt(5.))/2.);
	double r2 = ((1.-Math.sqrt(5.))/2.);

	return (int) (a1 * Math.pow(r1, n) + a2 * Math.pow(r2, n));
    }
    
    public boolean isInFunctionPlacer(int i) {
	// if (fib_counter++ < fib_count)
	//     return i % fib(fib_count) == 0;
	// else {
	//     fib_counter = 0;
	//     return i % fib(fib_count++) == 0;
	// }
	if (_counter++ < counter)
	    return i % counter == 0;
	else {
	    _counter = 0;
	    counter += counter_tile;
	    return i % counter == 0;
	}
    }

    public void paint(Graphics g) {
	for(int i = 0; i < width; i++) {
	    for(int j = 0; j < height; j++) {
		if (i % RECT_SPACER == 0 &&
		    j % RECT_SPACER == 0 &&
		    !isInFunctionPlacer(i)) {
		    g.setColor(new Color(i%255,
					 j%255,
					 (int)((i+j*0.618)%255)));
		    g.drawRect(i, j, RECT_WIDTH, RECT_WIDTH);
		} else if (i % RECT_SPACER == 0 &&
			   j % RECT_SPACER == 0 &&
			   isInFunctionPlacer(i)) {
		    g.setColor(new Color(i%255,
					 j%255,
					 (int)((i+j*0.618)%255)));
		    g.drawOval(i, j, RECT_WIDTH, RECT_WIDTH);
		} else if (i % RECT_SPACER == 0 &&
			   j % RECT_SPACER == 0){
		    g.setColor(new Color(i%255,
					 j%255,
					 (int)((i+j*0.618)%255)));
		    g.drawRect(i, j, RECT_WIDTH, RECT_WIDTH);
		}	       
	    }
	}
    }
}

class RepeatedPatternPainterComponent extends JComponent {
    int width;
    int height;
    final int RECT_HEIGHT = 8;
    final int RECT_WIDTH  = 21;
    final int RECT_SPACER = 34;
    public RepeatedPatternPainterComponent(int width, int height) {
	this.width  = width;
	this.height = height;
    }
    
    public Dimension getPreferredSize() {
	return new Dimension(width, height);
    }

    public void paint(Graphics g) {
	for(int i = 0; i < width; i++) {
	    for(int j = 0; j < height; j++) {
		if (i % RECT_SPACER == 0 &&
		    j % RECT_SPACER == 0 ) {
		   
		    g.setColor(new Color(i%255,
					 j%255,
					 (int)((i+j*0.618)%255)));
		    g.drawRect(i, j, RECT_WIDTH, RECT_WIDTH);
		} 
	    }
	}
    }
}

public class RepeatPatternColored {
    private static JFrame thisFrame;
        
    public static void main(String... args) {
	try {
	    final int WIDTH  = 610;
	    final int HEIGHT = 377;
	    thisFrame = new JFrame();
	    // thank you to R.Knott from the Math Department at surrey.ac.uk
	    // for the fibonacci numbers calculated and factored
	    thisFrame.setSize(new Dimension(WIDTH, HEIGHT));
	    RepeatedPatternWithCirclePainterComponent rpwcpc =
		new RepeatedPatternWithCirclePainterComponent(WIDTH, HEIGHT);
	    
	    thisFrame.add("Center", rpwcpc);
	    thisFrame.pack();
	    thisFrame.setVisible(true);
	    thisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} catch(Exception e) {
	    System.err.println(":(");
	}	
    }
}
