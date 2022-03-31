package core;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.VolatileImage;

public class Canvas {
	public static int W, H;	
	private Graphics2D paint;
	private VolatileImage imageBuf; 
	private Component gframe;
	
	public Canvas(GFrame _gframe) {
		gframe = _gframe;
		gframe.addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent componentEvent) {
		    	imageBuf = gframe.createVolatileImage(width(), height());
		    	paint = imageBuf.createGraphics();
		    	adaptCartesianCoordinates(getPaint());
				clear();
				System.out.println(W+":"+H);
		    }
		});
	}
	private void adaptCartesianCoordinates(Graphics2D g2d) {
		double xTrans = ((double)gframe.getWidth())/2.0;
		double yTrans = ((double)gframe.getHeight())/2.0;
		g2d.translate(xTrans, yTrans);
		g2d.scale(1, -1);
	}
	public void clear() {
		paint.setColor(Color.BLACK);
		paint.clearRect(-1*((int)midW()), -1*((int)midH()), width(), height());
		paint.fill(new Rectangle2D.Double(-1*midW(),  -1*midH(),  width(),  height()));
		paint.setColor(Color.WHITE);
	}
	public void plot() { 
		Graphics g = gframe.getGraphics();
		g.drawImage(imageBuf, 0, 0, null); //g.dispose(); //memory free
	}
	public int width()            { return W = gframe.getWidth(); }
	public int height()           { return H = gframe.getHeight(); }
	public double midW()     { return gframe.getWidth()/2.0; }
	public double midH()    { return gframe.getHeight()/2.0; }
	public Graphics2D getPaint() { return paint; }
	public void draw(IDrawable obj) { obj.draw(paint); }
}
