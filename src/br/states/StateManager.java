package br.states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StateManager implements KeyListener {

	public static final byte numberStates = 3;
	public static State[] states = new State[numberStates];
	public static byte currentState = 0;

	public static final byte TITLE = 1, MOVE = 0;
	public static void setState(byte state) {
		currentState = state;
		states[currentState].init();
	}

	public StateManager() {
		states[1]=new TitleScreen();
		states[0]=new TesteMovimentacao();
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
