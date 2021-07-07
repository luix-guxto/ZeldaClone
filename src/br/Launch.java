package br;

import br.display.Display;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Launch {
	private static Display teste;
	public static void main(String[] args) {
		teste = new Display("Carregando", 650,100, "/sprites/icone.png");
		for(int x = 0; x<2;x++) {
			BufferStrategy buff = teste.getBufferStrategy();
			if (buff == null) {
				teste.createBufferStrategy();
				buff = teste.getBufferStrategy();
			}
			Graphics g = buff.getDrawGraphics();
			g.create();
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 800, 200);
			g.setFont(new Font(Font.DIALOG, Font.BOLD, 100));
			g.setColor(Color.WHITE);
			g.drawString("Carregando...", 0, 75);
			g.dispose();
			buff.show();
		}
		Game game = new Game();
		game.start();
	}
	public static void carregado(){
		teste.fechar();
	}
}
