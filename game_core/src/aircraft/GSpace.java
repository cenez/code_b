package aircraft;
import java.awt.event.KeyEvent;

import aircraft.drawables.SpaceAirCraft;
import core.GFrame;
import sample.drawables.CartesianPlane;
import sample.drawables.Star;

@SuppressWarnings("serial")
public class GSpace extends GFrame {
	private SpaceAirCraft nave;
	private CartesianPlane plano;
	private Star star;
	private boolean up=false, down=false;
	
	public GSpace(int largura, int altura) {
		super(largura, altura);
	}
	@Override
	protected void inicializar() { 
		nave = new SpaceAirCraft(this);
		plano = new CartesianPlane(tela.midW(), tela.midH());
		star = new Star(tela.midW(), tela.midH());
	}
	@Override
	public void loop() {
		this.sleeping(100);
		if(this.up)         this.up    = nave.up();
		else if(this.down)  this.down  = nave.down();
	}
	@Override
	protected void renderizar() {
		this.rainOfStars(20);
		this.tela.draw(nave);
		this.tela.draw(plano);
	}
	@Override
	public void keyTyped(KeyEvent e) { }
	@Override
	public void keyReleased(KeyEvent e) { }
	@Override
	public void keyPressed(KeyEvent e) { 
		int k = e.getKeyCode();
		this.up = this.down = false;
		
		if(k == KeyEvent.VK_UP)    { this.up = nave.up();       this.down = this.up?false:true;    }
		if(k == KeyEvent.VK_DOWN)  { this.down = nave.down();   this.up = this.down?false:true;    }
		if(k == KeyEvent.VK_LEFT)  { nave.left();   }
		if(k == KeyEvent.VK_RIGHT) { nave.right(); }
	}
	protected void rainOfStars(int qtd) {
		for(int i = 1; i <= qtd; i++) {
			star.randomize();
			this.tela.draw(star);
		}
	}
}
