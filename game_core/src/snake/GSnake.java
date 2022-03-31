package snake;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Random;

import core.GFrame;
import sample.drawables.Circulo;
import sample.drawables.Retangulo;
import snake.drawables.SnakeShape;

@SuppressWarnings("serial")
public class GSnake extends GFrame {
	private SnakeShape cobra;
	private Retangulo borda;
	private Retangulo obstaculo;
	private Circulo comida;//comida não pode surgir sobre a cobra
	private KeyEvent e = null;
	public GSnake(int largura, int altura) {
		super(((int)largura/Circulo.SIZE)*Circulo.SIZE, ((int)altura/Circulo.SIZE)*Circulo.SIZE);
	}
	@Override
	protected void inicializar() { 
		cobra = new SnakeShape(tela.midW(), tela.midH());
		borda = new Retangulo(tela.midW(), tela.midH());
		obstaculo = new Retangulo(-30, 50, 20, 100, Color.RED, true);
		int[] xy = getRandomCoord();
		comida = new Circulo(xy[0], xy[1], Color.ORANGE);
	}
	@Override
	public void loop() {
		this.sleeping(100);
		
		if(comida.equals(cobra.getHEAD())) {
			cobra.addToTail(new Circulo(comida.X, comida.Y, Color.WHITE));
			int[] xy = getRandomCoord();
			comida.moveTO(xy[0], xy[1]);
		}
		if(e!=null) cobra.listenKey(e);
		cobra.update();
		if(obstaculo.intersects(cobra.getHEAD().CIRCULO)) {
			System.out.println("Intersects....");
		}
	}
	@Override
	protected void renderizar() {
		this.tela.draw(borda);
		this.tela.draw(cobra);
		this.tela.draw(comida);
		this.tela.draw(obstaculo);
	}
	@Override
	public void keyPressed(KeyEvent e) { 
		this.e = e;
	}
	@Override
	public void keyTyped(KeyEvent e) { }
	@Override
	public void keyReleased(KeyEvent e) { }
	
	private int[] getRandomCoord() { 
		Random r = new Random();
		int[] xy = new int[2];
		xy[0] = r.nextInt()*2%((int)tela.midW()-Circulo.SIZE*2);
		xy[1] = r.nextInt()*2%((int)tela.midH()-Circulo.SIZE*2);
		return xy;
	}
}
