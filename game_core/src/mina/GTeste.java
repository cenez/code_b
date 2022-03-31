package mina;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Random;

import core.GFrame;
import sample.drawables.Circulo;

@SuppressWarnings("serial")
public class GTeste extends GFrame {
	private Circulo mina;
	public GTeste(int largura, int altura) {
		super(largura, altura);
	}
	@Override
	protected void inicializar() {
		int[] xy = getRandomCoord();
		mina = new Circulo(xy[0], xy[1], Color.ORANGE);
		this.sleeping(500);
	}
	@Override
	protected void loop() {
		int[] xy = getRandomCoord();
		mina.moveTO(xy[0], xy[1]);
	}
	@Override
	protected void renderizar() {
		this.tela.draw(mina);
	}
	private int[] getRandomCoord() { 
		Random r = new Random();
		int[] xy = new int[2];
		xy[0] = r.nextInt()*2%((int)tela.midW()-Circulo.SIZE*2);
		xy[1] = r.nextInt()*2%((int)tela.midH()-Circulo.SIZE*2);
		return xy;
	}

	@Override
	public void keyTyped(KeyEvent e) { }
	@Override
	public void keyPressed(KeyEvent e) { }
	@Override
	public void keyReleased(KeyEvent e) { }
}
