package br.states;

import java.awt.Canvas;
import java.awt.Graphics;

import br.Game;
import br.graficos.TitleSprites;
import br.input.Input;
import br.sons.Musicas;

@SuppressWarnings("serial")
public class TitleScreen extends Canvas implements State {
	private byte anima = 0, time=0;
	@Override
	public void init() {
		TitleSprites.init();
		Musicas.setMusic(Musicas.INTRO);
	}

	@Override
	public void update() {
		time++;
		if(Input.start) {
			StateManager.setState(StateManager.MOVE);
		}
		if(time>=10) {
			anima++;
			if(anima>=6) {anima = 0;}
			time=0;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(TitleSprites.titleScreen[anima], 0, 0, Game.WIDTH, Game.HEIGTH, this);

	}

	@Override
	public void KeyPress(int cod) {
		// TODO Auto-generated method stub

	}

	@Override
	public void KeyReleased(int cod) {

	}

}
