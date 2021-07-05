package br.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {

	private static boolean[] keys = new boolean[256];
	public static boolean controler, left, up, down, right, atack, defend, start, mute;
	public static void update() {
		left = keys[KeyEvent.VK_LEFT];
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		right = keys[KeyEvent.VK_RIGHT];
		atack = keys[KeyEvent.VK_A];
		defend = keys[KeyEvent.VK_D];
		mute = keys[KeyEvent.VK_M];
		start = keys[KeyEvent.VK_ENTER];
		controler = keys[KeyEvent.VK_G];
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() > 255) { return; }
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() > 255) { return; }
		keys[e.getKeyCode()] = false;
	}


}
