package snake;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import sample.drawables.Circulo;

@SuppressWarnings("serial")
public class Main extends JFrame {
	public Main(int largura, int altura) {
		this.setTitle("Snake 2D");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new GSnake(largura, altura));
		this.setSize(largura+Circulo.SIZE*2, altura+Circulo.SIZE*2);
		this.setLocationRelativeTo(null); //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Main(800, 600).setVisible(true);
			}
		});
	}
}
