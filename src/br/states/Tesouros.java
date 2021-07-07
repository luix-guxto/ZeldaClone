package br.states;

import java.awt.Canvas;
import java.awt.Graphics;
import java.io.IOException;

import br.Game;
import br.input.Input;
import br.sons.Musicas;
import br.sprites.ImageLoader;
import br.sprites.SpriteSheet;

@SuppressWarnings("serial")
public class Tesouros extends Canvas implements State{
	private int y = 0, wid, heig, timeout=0;
	private boolean subindo = true;
	private SpriteSheet foto;
	@Override
	public void init() {
		Musicas.setMusic((byte) -1);
		ImageLoader load = new ImageLoader();
		try {
			foto = new SpriteSheet(load.loadImage("/sprites/allTeasures.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		wid=Game.WIDTH;
		heig=1632*(Game.WIDTH/256);
	}

	@Override
	public void update() {
		timeout++;
		if(y-Game.HEIGTH>-heig-3 && subindo) {
			y-=3;
		}else {
			y=-heig+Game.HEIGTH;
			subindo = false;
		}
		if(Input.start && timeout>20) {
			StateManager.setState(StateManager.OVERWORLD);
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(foto.getSprite(0, 0, 256, 1632), 0, y, wid, heig, this);
	}

	@Override
	public void KeyPress(int cod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void KeyReleased(int cod) {
		// TODO Auto-generated method stub
		
	}

}
