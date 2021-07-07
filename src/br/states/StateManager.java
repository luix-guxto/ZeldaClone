package br.states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StateManager implements KeyListener {

	public static final byte numberStates = 3;
	public static State[] states = new State[numberStates];
	public static byte currentState = 0;

	public static final byte OVERWORLD = 2, TESOUROS = 1, TITLE = 0;
	public static void setState(byte state) {
		currentState = state;
		states[currentState].init();
	}

	public StateManager() {
		states[2]=new OverWorld();
		states[1]=new Tesouros();
		states[0]=new TitleScreen();
	}

	public void update() {
		states[currentState].update();
	}

	public void render(Graphics g) {
		states[currentState].render(g);
	}
	public static State getState() {
		return states[currentState];
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		states[currentState].KeyPress(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		states[currentState].KeyReleased(e.getKeyCode());

	}
}
