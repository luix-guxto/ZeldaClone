package br.states;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import br.Game;
import br.colisao.Colisao;
import br.player.Player;
import br.sons.Musicas;
import br.sprites.ImageLoader;
import br.sprites.SpriteSheet;
import org.lwjgl.Sys;

@SuppressWarnings("serial")
public class OverWorld extends Canvas implements State {
		//8x16
		private static final int 	mundoX[] = {1, 258, 515, 772, 1029, 1286, 1543, 1800, 2057, 2314, 2571, 2828, 3085, 3342, 3599, 3856},
		 							mundoY[] = {1, 178, 355, 532, 709, 886, 1063, 1240};
		
		private static int localX = 0,  localY=0, proximoX = 0, proximoY = 0;
		private static int faseX = 0, faseY = 0;
		private static final byte velocidade_mudanca = 127, mult=6;
		public static Rectangle fase = new Rectangle(0, 0);
		private SpriteSheet mundo;
		private static boolean mudando = false;


	@Override
	public void init() {
		//Player.player.x=Player.player.y=-5000;
		ImageLoader loader = new ImageLoader();
		try {
			mundo = new SpriteSheet(loader.loadImage("/sprites/overWorld.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
        Musicas.setMusic(Musicas.OVER);
	}

	@Override
	public void update() {
		mudar();
		if(!mudando) {
			localX=mundoX[faseX];
			localY=mundoY[faseY];
			Player.update();
			colisoes();
			mudanca();
		}else {
			mover();
		}
	}
	private void colisoes(){
		for(int x = 0; x<Colisao.colisaoOver.length; x++){
			//cima player
			if(Colisao.colisaoOver[x].intersects(new Rectangle(Player.player.x+Player.player.width/2-Game.ESCALA*(mult/2),Player.player.y-Player.velocidade+Game.ESCALA*3, Game.ESCALA*mult, 3))){
				Player.player.y=Colisao.colisaoOver[x].y+Colisao.colisaoOver[x].height+Player.velocidade-Game.ESCALA*3;
			}
			//baixo player
			if(Colisao.colisaoOver[x].intersects(new Rectangle(Player.player.x+Player.player.width/2-Game.ESCALA*(mult/2), Player.player.y+Player.player.height-3+Player.velocidade-Game.ESCALA, Game.ESCALA*mult, 3))){
				Player.player.y=Colisao.colisaoOver[x].y-Player.player.height-Player.velocidade+Game.ESCALA;
			}

			//esquerda player
			if(Colisao.colisaoOver[x].intersects(new Rectangle(Player.player.x-Player.velocidade+Game.ESCALA*3, Player.player.y+Player.player.height/2-Game.ESCALA*(mult/2), 3, Game.ESCALA*mult))){
				Player.player.x=Colisao.colisaoOver[x].x+Colisao.colisaoOver[x].width+Player.velocidade-Game.ESCALA*3;
			}

			//direita
			if(Colisao.colisaoOver[x].intersects(new Rectangle(Player.player.x+Player.player.width-3+Player.velocidade-Game.ESCALA*3, Player.player.y+Player.player.height/2-Game.ESCALA*(mult/2), 3, Game.ESCALA*mult))){
				Player.player.x=Colisao.colisaoOver[x].x-Player.player.width-Player.velocidade+Game.ESCALA*3;
			}
		}
	}
	@Override
	public void render(Graphics g) {
		g.drawImage(mundo.getSprite(localX, localY, 256, 176), 0 , 0, Game.WIDTH, Game.HEIGTH, this);
		if(!mudando){
			Player.animacao(g);
		}
		if(!mudando) {
			for (int x = 0; x < Colisao.colisaoOver.length; x++) {
				g.setColor(Color.MAGENTA);
				g.fillRect(Colisao.colisaoOver[x].x, Colisao.colisaoOver[x].y, Colisao.colisaoOver[x].width, Colisao.colisaoOver[x].height);
			}
		}
		g.setColor(Color.RED);
		g.fillRect(Player.player.x+Player.player.width/2-Game.ESCALA*(mult/2),Player.player.y-Player.velocidade+Game.ESCALA*3, Game.ESCALA*mult, 3);
		g.fillRect(Player.player.x+Player.player.width/2-Game.ESCALA*(mult/2), Player.player.y+Player.player.height-3+Player.velocidade-Game.ESCALA, Game.ESCALA*mult, 3);
		g.fillRect(Player.player.x-Player.velocidade+Game.ESCALA*3, Player.player.y+Player.player.height/2-Game.ESCALA*(mult/2), 3, Game.ESCALA*mult);
		g.fillRect(Player.player.x+Player.player.width-3+Player.velocidade-Game.ESCALA*3, Player.player.y+Player.player.height/2-Game.ESCALA*(mult/2), 3, Game.ESCALA*mult);
	}
	private void mudanca(){
		if(Player.player.x+Player.player.width>=Game.WIDTH){
			fase.x++;
			for(int x = 0; x<Colisao.colisaoOver.length; x++){
				Colisao.colisaoOver[x].x-=257 * Game.ESCALA;
				Player.player.x=3;
			}
		}
		if(Player.player.x<=0){
			fase.x--;
			for(int x = 0; x<Colisao.colisaoOver.length; x++){
				Colisao.colisaoOver[x].x+=257 * Game.ESCALA;
				Player.player.x=Game.WIDTH-Player.player.width-3;
			}
		}
		if(Player.player.y+Player.player.height>=Game.HEIGTH){
			fase.y++;
			for(int x = 0; x<Colisao.colisaoOver.length; x++){
				Colisao.colisaoOver[x].y-=177 * Game.ESCALA;
				Player.player.y=3;
			}
		}
		if(Player.player.y<=0){
			fase.y--;
			for(int x = 0; x<Colisao.colisaoOver.length; x++){
				Colisao.colisaoOver[x].y+=177 * Game.ESCALA;
				Player.player.y=Game.HEIGTH-Player.player.height-3;
			}
		}
	}

	@Override
	public void KeyPress(int cod) {

	}

	@Override
	public void KeyReleased(int cod) {
//		if(cod== KeyEvent.VK_RIGHT) {
//			if(fase.x==15){return;}
//			fase.x++;
//			for (int x = 0; x < Colisao.colisaoOver.length; x++) {
//				Colisao.colisaoOver[x].x -= 257 * Game.ESCALA;
//			}
//		}
//		if(cod == KeyEvent.VK_LEFT){
//			if(fase.x==0){return;}
//			fase.x--;
//			for (int x = 0; x < Colisao.colisaoOver.length; x++) {
//				Colisao.colisaoOver[x].x += 257 * Game.ESCALA;
//			}
//		}
//		if(cod==KeyEvent.VK_DOWN){
//			if(fase.y==7){return;}
//			fase.y++;
//			for(int x = 0; x<Colisao.colisaoOver.length; x++){
//				Colisao.colisaoOver[x].y-=177 * Game.ESCALA;
//			}
//		}
//		if(cod==KeyEvent.VK_UP){
//			if(fase.y==0){return;}
//			fase.y--;
//			for(int x = 0; x<Colisao.colisaoOver.length; x++){
//				Colisao.colisaoOver[x].y+=177 * Game.ESCALA;
//			}
//		}
	}
	
	private static void mudar() {
		if(faseX != fase.x || faseY != fase.y){
			mudando=true;
			proximoX=mundoX[fase.x];
			proximoY=mundoY[fase.y];
			faseX=fase.x;
			faseY=fase.y;
		}
	}
	private static void mover() {
		if(localX<proximoX-velocidade_mudanca){
			localX+=velocidade_mudanca;
		}

		else if(localX>proximoX+velocidade_mudanca){
			localX-=velocidade_mudanca;
		}

		else if(localY<proximoY-velocidade_mudanca){
			localY+=velocidade_mudanca;
		}

		else if(localY>proximoY+velocidade_mudanca){
			localY-=velocidade_mudanca;
		}else{
			localX = mundoX[faseX];
			localY = mundoY[faseY];
			mudando=false;
		}

	}

}
