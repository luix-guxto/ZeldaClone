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
	private Display display;
	public static final int WIDTH = 896, HEIGTH = 640, FPS = 60, ESCALA = 8;
	public static final double TPS = 1000000000 / FPS;

	public Game() {
		sm = new StateManager();
		display = new Display("THE LEGENDS OF JAVA", WIDTH, HEIGTH);
		km = new Teclado();
		display.setKeyListener(sm);
		display.setKeyListener(km);
	}

	@Override
	public void run() {
		init();
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
		StateManager.setState(StateManager.TITLE);
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

	public synchronized void stop() throws InterruptedException{
		if(thread == null) { return; }
		thread.join();
	}
}
