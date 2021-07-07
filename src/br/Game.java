package br;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import br.display.Display;
import br.graficos.Loader;
import br.input.Input;
import br.input.Teclado;
import br.sons.Sons;
import br.states.StateManager;

public class Game implements Runnable {

	private Teclado km;

	private Thread thread;
	private boolean running = false;

	private StateManager sm;
	public static Display display;
	public static byte ESCALA = 3;
	public static int WIDTH = 256 * ESCALA, HEIGTH = 176 * ESCALA, FPS = 60;
	public static final double TPS = 1000000000 / FPS;

	public Game() {
		sm = new StateManager();
		km = new Teclado();
		init();
		display = new Display("THE LEGENDS OF JAVA", WIDTH, HEIGTH, "/sprites/icone.png");
		Launch.carregado();
		display.setKeyListener(sm);
		display.setKeyListener(km);
	}

	@Override
	public void run() {
		double tick = 0;
		long now, lastTime = System.nanoTime();

		while(running) {
			now = System.nanoTime();
			tick+=(now-lastTime)/TPS;
			lastTime = now;

			if(tick >= 1) {

				update();
				render();
				tick--;
			}
		}
	}

	private void init() {
		Loader.load();
		Sons.init();
		Input.init();
		StateManager.setState(StateManager.OVERWORLD);
	}

	private void update() {
		Sons.update();
		sm.update();
		Input.update();
	}

	private void render() {
		BufferStrategy bs = display.getBufferStrategy();
		if(bs == null) {
			display.createBufferStrategy();
			bs = display.getBufferStrategy();
		}
		Graphics g = bs.getDrawGraphics();
		g.clearRect(0, 0, WIDTH, HEIGTH);

		 if(StateManager.getState() != null){ sm.render(g); }

		g.dispose();
		bs.show();
	}

	public synchronized void start() {
		if(thread != null ) { return; }
		thread = new Thread(this);
		thread.start();
		running = true;
	}

}
