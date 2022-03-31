package core;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public abstract class GFrame extends JPanel implements Runnable, KeyListener {
	protected final Canvas tela;
	private final JProgressBar progressBar = new JProgressBar(0, 100);
	private int sleeper = 0;
	
	public GFrame(int largura, int altura) {
		super();
		this.setSize(largura, altura);
		this.tela = new Canvas(this);
		this.setFocusable(true);
		this.addKeyListener(this);
	}
	@Override
	public final void addNotify() {
		super.addNotify();
		new Thread(this).start();
	}
	@Override /* loop() roda constantemente. O tempo de espera é dado por sleeping(tempo) no filho! */
	public final void run() {
		this.load();
		inicializar();
		while(true) {
			this.loop();
			this.tela.clear();
			this.renderizar();
			this.tela.plot();
			try { Thread.sleep(Math.abs(this.sleeper)); } catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
	protected final void sleeping(int _sleeper) { this.sleeper = _sleeper; }
	private final void load() { /*Inicializacao/carga */
		this.add(progressBar); for(int i = 0; i<100;i++) {
			try { Thread.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
			progressBar.setValue(i);
		} this.remove(progressBar);
	}
	protected abstract void inicializar();
	protected abstract void loop();
	protected abstract void renderizar();
}
