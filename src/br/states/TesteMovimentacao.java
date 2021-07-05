package br.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import br.Game;
import br.input.*;
import br.player.Player;

public class TesteMovimentacao implements State {

	private Rectangle teste = new Rectangle(64, 64, 64, 64);
	private boolean testando = true;


	@Override
	public void init() {

	}

	@Override
	public void update() {
		Player.atack(Input.atack);
		if(Player.arma.intersects(teste)) {
			testando = false;
		}
		Player.defender(Input.defend);

		Player.movimentar(Input.up, Input.down, Input.right, Input.left);

		Player.update();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.black);
	g.fillRect(0,0, Game.WIDTH, Game.HEIGTH);
		//g.setColor(Color.RED);
		//g.fillRect(Player.player.x, Player.player.y, Player.player.width, Player.player.height);
		if(testando) {g.fillRect(teste.x, teste.y, teste.width, teste.height);}
		//g.setColor(Color.BLUE);
		//g.fillRect(Player.arma.x, Player.arma.y, Player.arma.width, Player.arma.height);
		//g.setColor(Color.YELLOW);
		//g.fillRect(Player.escudo.x, Player.escudo.y, Player.escudo.width, Player.escudo.height);
		Player.animacao(g);
	}

	@Override
	public void KeyPress(int cod) {


	}

	@Override
	public void KeyReleased(int cod) {
		if(cod == KeyEvent.VK_NUMPAD0) {
			Player.setArma((byte)0);
		}
		if(cod == KeyEvent.VK_NUMPAD1) {
			Player.setArma((byte)1);
		}
		if(cod == KeyEvent.VK_NUMPAD2) {
			Player.setArma((byte)2);
		}
		if(cod == KeyEvent.VK_NUMPAD3) {
			Player.setArma((byte)3);
		}
		if(cod == KeyEvent.VK_0) {
			testando=true;
		}
		if(cod == KeyEvent.VK_H) {
			Player.coletItem();
		}
		if(cod == KeyEvent.VK_F) {
			StateManager.setState(StateManager.TITLE);
		}

	}

}
