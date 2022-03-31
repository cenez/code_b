package snake.drawables;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import core.ADrawableLimited;
import sample.drawables.Circulo;

public class SnakeShape extends ADrawableLimited {
	private final Color HEAD_COLOR = Color.RED;
	private final Circulo HEAD;// = new Point(0, 0);
	private final List<Circulo> TAIL = new ArrayList<>();
	
	public int fluxoX=-Circulo.SIZE, fluxoY=0; 
	
	public SnakeShape(double xMax, double yMax) {
		super(xMax, yMax);
		HEAD = new Circulo((MAX_X-Circulo.SIZE*2), (MAX_Y-Circulo.SIZE*2), HEAD_COLOR);
		for(int i = 1; i <= 4; i++)
			TAIL.add(new Circulo(Circulo.SIZE * i, 0, Color.WHITE));
		TAIL.get(0).moveTO(HEAD.X, HEAD.Y);
		for(int i = 1; i < TAIL.size(); i++)
			TAIL.get(i).moveTO(TAIL.get(i - 1).X, TAIL.get(i - 1).Y);
	}
	public Circulo getHEAD() { return HEAD; }
	public void addToTail(Circulo p) { TAIL.add(p); }
	public void up() {
		if(fluxoY==0) {
			fluxoY = Circulo.SIZE;
			fluxoX = 0;
		} 
	}
	public void down() {
		if(fluxoY==0) {
			fluxoY = -Circulo.SIZE;
			fluxoX = 0;
		} 
	}
	public void left() {
		if(fluxoX==0) {
			fluxoY = 0;
			fluxoX = -Circulo.SIZE;
		} 
	}
	public void right() {
		if(fluxoX==0) {
			fluxoY = 0;
			fluxoX = Circulo.SIZE;
		} 
	}
	public void listenKey(KeyEvent e) { 
		int k = e.getKeyCode();
		if(k == KeyEvent.VK_UP) 		this.up();
		else if(k == KeyEvent.VK_DOWN) 	this.down();
		else if(k == KeyEvent.VK_LEFT) 	this.left();
		else if(k == KeyEvent.VK_RIGHT) this.right();
	}
	public void update() {
		updateTail();
		updateHead();
	}
	private void updateHead() { 
		HEAD.moveIncremental(fluxoX, fluxoY);
		if(HEAD.X+Circulo.SIZE*2>MAX_X) HEAD.X = -(MAX_X)+Circulo.SIZE;
		else if(HEAD.X-Circulo.SIZE<-MAX_X) HEAD.X = (MAX_X-Circulo.SIZE*2);
		else if(HEAD.Y+Circulo.SIZE*2>MAX_Y) HEAD.Y = -(MAX_Y)+Circulo.SIZE;
		else if(HEAD.Y-Circulo.SIZE<-MAX_Y) HEAD.Y = (MAX_Y-Circulo.SIZE*2);
	}
	private void updateTail() { 
		for(int i = TAIL.size() - 1; i > 0; i--)
			TAIL.get(i).moveTO(TAIL.get(i - 1).X, TAIL.get(i - 1).Y);
		TAIL.get(0).moveTO(HEAD.X, HEAD.Y);
	}
	@Override
	public void draw(Graphics2D g2d) {
		TAIL.forEach(p -> p.draw(g2d));
		Color cor = g2d.getColor();
		g2d.setColor(HEAD_COLOR);
		HEAD.draw(g2d);
		g2d.setColor(cor);
	}
}

/* Observação sobre Movimento:
 * fluxoX diz o sentido que cobra segue na coordenada X do plano cartesiano;
 * fluxoY diz o sentido que cobra segue na coordenada Y do plano cartesiano;
 * Em fluxoX==0 ou fluxoY==0 diz que esse movimento é estável, 
 * respectivamente para sentidos X e Y, não existindo movimento;
 * fluxoX ou fluxoY caminham ao passo +-Point.SIZE.
 */

