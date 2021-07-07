package br.player;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import br.Game;
import br.input.Input;
import br.sons.Efeitos;
import br.sons.Sons;

@SuppressWarnings("serial")
public class Player extends Canvas {

	private static final byte
			espera_movimentacao = 7,
			espera_atack = 5,
			espera_defesa = 5,
			espera_music1 = 4,
			espera_music = 95;
	public static Rectangle player = new Rectangle(Game.WIDTH / 2 - 8*Game.ESCALA, Game.HEIGTH / 2 - 8*Game.ESCALA, 16*Game.ESCALA, 16*Game.ESCALA),
							arma = new Rectangle(-500, -500, 1, 1),
							escudo = new Rectangle(-500, -500, 1, 1);
	public static final byte velocidade = 5;
	private static byte
						delay_up = 0,
						delay_down = 0,
						delay_colet = 0,
						delay_left = 0,
						delay_rigth = 0,
						delay_atack = 0,
						anima_sprite = 0,
						atack_sprite = 0,
						defesa_sprite = 0,
						colet_sprite = 0,
						arma_n = 0,
						time_music = 0;


	public static boolean
	up = true,
	left = false,
	rigth = false,
	down = false,
	atacando = false,
	defendendo = false,
	precionando = false,
	coletando = false,
	mute = false;

	private static void movimentar(boolean ups, boolean downs, boolean rigths, boolean lefts) {
	if(!coletando) {
		if (ups) {
			if (!defendendo && !atacando) {
				up = true;
				down = left = rigth = false;
			}
			delay_up++;
			if (delay_up > espera_movimentacao && !lefts && !rigths) {
				switch (anima_sprite) {
					case 0:
						anima_sprite = 1;
						break;
					case 1:
						anima_sprite = 0;
						break;
				}
				delay_up = 0;
			}

			player.y -= velocidade;
		} else if (downs) {
			if (!defendendo && !atacando) {
				down = true;
				up = left = rigth = false;
			}
			delay_down++;
			if (delay_down > espera_movimentacao && !lefts && !rigths) {
				switch (anima_sprite) {
					case 0:
						anima_sprite = 1;
						break;
					case 1:
						anima_sprite = 0;
						break;
				}
				delay_down = 0;
			}

			player.y += velocidade;
		}

		if (rigths && !ups && !downs) {
			if (!defendendo && !atacando) {
				rigth = true;
				down = left = up = false;
			}
			delay_rigth++;
			if (delay_rigth > espera_movimentacao) {
				switch (anima_sprite) {
					case 0:
						anima_sprite = 1;
						break;
					case 1:
						anima_sprite = 0;
						break;
				}
				delay_rigth = 0;
			}

			player.x += velocidade;
		} else if (lefts && !ups && !downs) {
			if (!defendendo && !atacando) {
				left = true;
				down = up = rigth = false;
			}
			delay_left++;
			if (delay_left > espera_movimentacao) {
				switch (anima_sprite) {
					case 0:
						anima_sprite = 1;
						break;
					case 1:
						anima_sprite = 0;
						break;
				}
				delay_left = 0;
			}
			player.x -= velocidade;
		}

		if (!ups && !downs && !lefts && !rigths) {
			delay_up++;
			delay_down++;
			delay_left++;
			delay_rigth++;
			if (delay_up > espera_movimentacao && delay_down > espera_movimentacao && delay_rigth > espera_movimentacao
					&& delay_left > espera_movimentacao) {

				anima_sprite = 0;

				delay_up = 0;
				delay_down = 0;
				delay_rigth = 0;
				delay_left = 0;

			}
		}
	}
	}

	public static void update() {
		defender(Input.defend);
		atack(Input.atack);
		movimentar( Input.up, Input.down, Input.right, Input.left);
	}

	public static void animacao(Graphics g) {
		escudo.x=escudo.y=-500;
		escudo.width=escudo.height=1;
		if (!atacando && !defendendo && !coletando) {
			if (up) {
				Game.display.setIcon(Sprites.move_up[0]);
				g.drawImage(Sprites.move_up[anima_sprite], player.x, player.y, player.width, player.height, null);
			} else if (down) {
				Game.display.setIcon(Sprites.move_down[0]);
				g.drawImage(Sprites.move_down[anima_sprite], player.x, player.y, player.width, player.height, null);
			} else if (rigth) {
				Game.display.setIcon(Sprites.move_H[0]);
				g.drawImage(Sprites.move_H[anima_sprite], player.x, player.y, player.width, player.height, null);
			} else {
				Game.display.setIcon(Sprites.move_H[0]);
				g.drawImage(Sprites.move_H[anima_sprite], player.x + player.width, player.y, -player.width, player.height, null);
			}
		}
		if(!atacando && defendendo && !coletando) {

			if(up) {
				escudo.height=5;
				escudo.width=player.width;
				escudo.x=player.x;
				escudo.y=player.y-5;
				Game.display.setIcon(Sprites.move_up[0]);
				g.drawImage(Sprites.move_up[anima_sprite], player.x, player.y, player.width, player.height, null);
			}else if(down) {
				escudo.height=5;
				escudo.width=player.width;
				escudo.x=player.x;
				escudo.y=player.y+player.height;
				Game.display.setIcon(Sprites.shield_down[0]);
				g.drawImage(Sprites.shield_down[anima_sprite], player.x, player.y, player.width, player.height, null);
			}else if(rigth) {
				escudo.height=player.height;
				escudo.width=5;
				escudo.x=player.x+player.width;
				escudo.y=player.y;
				Game.display.setIcon(Sprites.shield_H[0]);
				g.drawImage(Sprites.shield_H[anima_sprite], player.x, player.y, player.width, player.height, null);
			}else {
				escudo.y=player.y;
				escudo.height=player.height;
				escudo.width=5;
				escudo.x=player.x-5;
				Game.display.setIcon(Sprites.shield_H[0]);
				g.drawImage(Sprites.shield_H[anima_sprite], player.x + player.width, player.y, -player.width, player.height, null);
			}
		}
		if (atacando && !defendendo && !coletando) {

			if (up) {
				switch (atack_sprite) {
				case 0:

					arma.x = player.x;
					arma.y = player.y;
					arma.width = player.width;
					arma.height = player.height;

					g.drawImage(Sprites.corpo_up[arma_n][0], player.x, player.y, player.width, player.height, null);
					break;
				case 1:

					arma.width = Sprites.arma_up[arma_n][0].getWidth() * Game.ESCALA;
					arma.height = Sprites.arma_up[arma_n][0].getHeight() * Game.ESCALA;
					arma.y = player.y - arma.height;
					arma.x = player.x;

					g.drawImage(Sprites.corpo_up[arma_n][1], player.x, player.y, player.width, player.height, null);
					g.drawImage(Sprites.arma_up[arma_n][0], arma.x, arma.y, arma.width, arma.height, null);
					break;
				case 2:

					arma.height = Sprites.arma_up[arma_n][1].getHeight() * Game.ESCALA;
					arma.width = Sprites.arma_up[arma_n][1].getWidth() * Game.ESCALA;
					arma.y = player.y - arma.height;
					arma.x = player.x;
					g.drawImage(Sprites.corpo_up[arma_n][2], player.x, player.y, player.width, player.height, null);
					g.drawImage(Sprites.arma_up[arma_n][1], arma.x, arma.y, arma.width, arma.height, null);
					break;
				case 3:

					arma.height = Sprites.arma_up[arma_n][2].getHeight() * Game.ESCALA;
					arma.width = Sprites.arma_up[arma_n][2].getWidth() * Game.ESCALA;
					arma.y = player.y - arma.height;
					arma.x = player.x;

					g.drawImage(Sprites.corpo_up[arma_n][3], player.x, player.y, player.width, player.height, null);
					g.drawImage(Sprites.arma_up[arma_n][2], arma.x, arma.y, arma.width, arma.height, null);
					break;
				}
			} else if (down) {
				switch (atack_sprite) {
				case 0:
					arma.x = player.x;
					arma.y = player.y;
					arma.width = player.width;
					arma.height = player.height;

					g.drawImage(Sprites.corpo_down[arma_n][0], player.x, player.y, player.width, player.height, null);
					break;
				case 1:
					arma.width = Sprites.arma_down[arma_n][0].getWidth() * Game.ESCALA;
					arma.height = Sprites.arma_down[arma_n][0].getHeight() * Game.ESCALA;
					arma.x = player.x;
					arma.y = player.y + player.height;

					g.drawImage(Sprites.corpo_down[arma_n][1], player.x, player.y, player.width, player.height, null);
					g.drawImage(Sprites.arma_down[arma_n][0], arma.x, arma.y, arma.width, arma.height, null);
					break;
				case 2:
					arma.width = Sprites.arma_down[arma_n][1].getWidth() * Game.ESCALA;
					arma.height = Sprites.arma_down[arma_n][1].getHeight() * Game.ESCALA;
					arma.x = player.x;
					arma.y = player.y + player.height;

					g.drawImage(Sprites.corpo_down[arma_n][2], player.x, player.y, player.width, player.height, null);
					g.drawImage(Sprites.arma_down[arma_n][1], arma.x, arma.y, arma.width, arma.height, null);
					break;
				case 3:
					arma.width = Sprites.arma_down[arma_n][2].getWidth() * Game.ESCALA;
					arma.height = Sprites.arma_down[arma_n][2].getHeight() * Game.ESCALA;
					arma.x = player.x;
					arma.y = player.y + player.height;

					g.drawImage(Sprites.corpo_down[arma_n][3], player.x, player.y, player.width, player.height, null);
					g.drawImage(Sprites.arma_down[arma_n][2], arma.x, arma.y, arma.width, arma.height, null);
					break;

				}
			} else if (left) {
				switch (atack_sprite) {
				case 0:
					arma.x = player.x;
					arma.y = player.y;
					arma.width = player.width;
					arma.height = player.height;

					g.drawImage(Sprites.corpo_H[arma_n][0], player.x + player.width, player.y, -player.width, player.height,
							null);
					break;
				case 1:
					arma.width = Sprites.arma_H[arma_n][0].getWidth() * Game.ESCALA;
					arma.height = Sprites.arma_H[arma_n][0].getHeight() * Game.ESCALA;
					arma.x = player.x - arma.width;
					arma.y = player.y;

					g.drawImage(Sprites.corpo_H[arma_n][1], player.x + player.width, player.y, -player.width, player.height,
							null);
					g.drawImage(Sprites.arma_H[arma_n][0], arma.x + arma.width, arma.y, -arma.width, arma.height, null);
					break;
				case 2:
					arma.width = Sprites.arma_H[arma_n][1].getWidth() * Game.ESCALA;
					arma.height = Sprites.arma_H[arma_n][1].getHeight() * Game.ESCALA;
					arma.x = player.x - arma.width;
					arma.y = player.y;

					g.drawImage(Sprites.corpo_H[arma_n][2], player.x + player.width, player.y, -player.width, player.height,
							null);
					g.drawImage(Sprites.arma_H[arma_n][1], arma.x + arma.width, arma.y, -arma.width, arma.height, null);
					break;
				case 3:
					arma.width = Sprites.arma_H[arma_n][2].getWidth() * Game.ESCALA;
					arma.height = Sprites.arma_H[arma_n][2].getHeight() * Game.ESCALA;
					arma.x = player.x - arma.width;
					arma.y = player.y;

					g.drawImage(Sprites.corpo_H[arma_n][3], player.x + player.width, player.y, -player.width, player.height,
							null);
					g.drawImage(Sprites.arma_H[arma_n][2], arma.x + arma.width, arma.y, -arma.width, arma.height, null);
					break;
				}
			} else {
				switch (atack_sprite) {
				case 0:
					arma.x = player.x;
					arma.y = player.y;
					arma.width = player.width;
					arma.height = player.height;

					g.drawImage(Sprites.corpo_H[arma_n][0], player.x, player.y, player.width, player.height, null);
					break;
				case 1:
					arma.width = Sprites.arma_H[arma_n][0].getWidth() * Game.ESCALA;
					arma.height = Sprites.arma_H[arma_n][0].getHeight() * Game.ESCALA;
					arma.x = player.x + player.width;
					arma.y = player.y;
					g.drawImage(Sprites.corpo_H[arma_n][1], player.x, player.y, player.width, player.height, null);
					g.drawImage(Sprites.arma_H[arma_n][0], arma.x, arma.y, arma.width, arma.height, null);
					break;
				case 2:
					arma.width = Sprites.arma_H[arma_n][1].getWidth() * Game.ESCALA;
					arma.height = Sprites.arma_H[arma_n][1].getHeight() * Game.ESCALA;
					arma.x = player.x + player.width;
					arma.y = player.y;
					g.drawImage(Sprites.corpo_H[arma_n][2], player.x, player.y, player.width, player.height, null);
					g.drawImage(Sprites.arma_H[arma_n][1], arma.x, arma.y, arma.width, arma.height, null);
					break;
				case 3:
					arma.width = Sprites.arma_H[arma_n][2].getWidth() * Game.ESCALA;
					arma.height = Sprites.arma_H[arma_n][2].getHeight() * Game.ESCALA;
					arma.x = player.x + player.width;
					arma.y = player.y;
					g.drawImage(Sprites.corpo_H[arma_n][3], player.x, player.y, player.width, player.height, null);
					g.drawImage(Sprites.arma_H[arma_n][2], arma.x, arma.y, arma.width, arma.height, null);
					break;
				}
			}
			delay_atack++;
			if (delay_atack > espera_atack) {
				delay_atack = 0;
				atack_sprite++;
			}
			if (atack_sprite > 3) {
				atack_sprite = 0;
				arma.x = arma.y = -500;
				arma.width = arma.height = 1;
				atacando = false;
			}

		}

		if(atacando && defendendo && !coletando) {

			if(up) {
				escudo.height=5;
				escudo.width=player.width;
				escudo.x=player.x;
				escudo.y=player.y-5;
				switch(defesa_sprite) {
				case 0:

					arma.width = Sprites.arma_up[arma_n][0].getWidth() * Game.ESCALA;
					arma.height = Sprites.arma_up[arma_n][0].getHeight() * Game.ESCALA;
					arma.y = player.y - arma.height;
					arma.x = player.x;

					g.drawImage(Sprites.corpo_up[arma_n][1], player.x, player.y, player.width, player.height, null);
					g.drawImage(Sprites.arma_up[arma_n][0], arma.x, arma.y, arma.width, arma.height, null);
					break;
				case 1:

					arma.height = Sprites.arma_up[arma_n][2].getHeight() * Game.ESCALA;
					arma.width = Sprites.arma_up[arma_n][2].getWidth() * Game.ESCALA;
					arma.y = player.y - arma.height;
					arma.x = player.x;

					g.drawImage(Sprites.corpo_up[arma_n][3], player.x, player.y, player.width, player.height, null);
					g.drawImage(Sprites.arma_up[arma_n][2], arma.x, arma.y, arma.width, arma.height, null);
					break;
				}
			}else if(down) {
				escudo.height=5;
				escudo.width=player.width;
				escudo.x=player.x;
				escudo.y=player.y+player.height;
				switch (defesa_sprite) {
				case 0:
					arma.x=player.x;
					arma.y=player.y+player.height;
					arma.height=Sprites.escudo_down[arma_n][0].getHeight() * Game.ESCALA;
					arma.width=Sprites.escudo_down[arma_n][0].getWidth() * Game.ESCALA;
					g.drawImage(Sprites.escudoC_down[arma_n][0], player.x, player.y, player.width, player.height, null);
					g.drawImage(Sprites.escudo_down[arma_n][0], arma.x, arma.y, arma.width, arma.height, null);
					break;

				case 1:
					arma.x=player.x;
					arma.y=player.y+player.height;
					arma.height=Sprites.escudo_down[arma_n][1].getHeight() * Game.ESCALA;
					arma.width=Sprites.escudo_down[arma_n][1].getWidth() * Game.ESCALA;
					g.drawImage(Sprites.escudoC_down[arma_n][1], player.x, player.y, player.width, player.height, null);
					g.drawImage(Sprites.escudo_down[arma_n][1], arma.x, arma.y, arma.width, arma.height, null);
					break;
				}
			}else if(rigth) {
				escudo.height=player.height;
				escudo.width=5;
				escudo.x=player.x+player.width;
				escudo.y=player.y;
				switch (defesa_sprite) {
				case 0:
					arma.x=player.x+player.width;
					arma.y=player.y;
					arma.width=Sprites.escudo_H[arma_n][0].getWidth() * Game.ESCALA;
					arma.height=Sprites.escudo_H[arma_n][0].getHeight() * Game.ESCALA;
					g.drawImage(Sprites.escudoC_H[arma_n][0], player.x, player.y, player.width, player.height, null);
					g.drawImage(Sprites.escudo_H[arma_n][0], arma.x, arma.y, arma.width, arma.height, null);
					break;

				case 1:
					arma.x=player.x+player.width;
					arma.y=player.y;
					arma.width=Sprites.escudo_H[arma_n][1].getWidth() * Game.ESCALA;
					arma.height=Sprites.escudo_H[arma_n][1].getHeight() * Game.ESCALA;
					g.drawImage(Sprites.escudoC_H[arma_n][1], player.x, player.y, player.width, player.height, null);
					g.drawImage(Sprites.escudo_H[arma_n][1], arma.x, arma.y, arma.width, arma.height, null);
					break;
				}
			}else {
				escudo.y=player.y;
				escudo.height=player.height;
				escudo.width=5;
				escudo.x=player.x-5;
				switch (defesa_sprite) {
				case 0:
					arma.width=Sprites.escudo_H[arma_n][0].getWidth() * Game.ESCALA;
					arma.height=Sprites.escudo_H[arma_n][0].getHeight() * Game.ESCALA;
					arma.x=player.x-arma.width;
					arma.y=player.y;
					g.drawImage(Sprites.escudoC_H[arma_n][0], player.x+player.width, player.y, -player.width, player.height, null);
					g.drawImage(Sprites.escudo_H[arma_n][0], arma.x+arma.width, arma.y, -arma.width, arma.height, null);
					break;

				case 1:
					arma.width=Sprites.escudo_H[arma_n][1].getWidth() * Game.ESCALA;
					arma.height=Sprites.escudo_H[arma_n][1].getHeight() * Game.ESCALA;
					arma.x=player.x-arma.width;
					arma.y=player.y;
					g.drawImage(Sprites.escudoC_H[arma_n][1], player.x+player.width, player.y, -player.width, player.height, null);
					g.drawImage(Sprites.escudo_H[arma_n][1], arma.x+arma.width, arma.y, -arma.width, arma.height, null);
					break;
				}
			}

			delay_atack++;
			if(delay_atack>espera_defesa) {
				delay_atack=0;
				defesa_sprite++;
			}
			if (defesa_sprite != 0 && defesa_sprite !=1) {
				defesa_sprite = 0;
				arma.x = arma.y = -500;
				arma.width = arma.height = 1;
				atacando = false;
			}
		}

		if(coletando) {
			Game.display.setIcon(Sprites.item[1]);
			g.drawImage(Sprites.item[colet_sprite], player.x, player.y, player.width, player.height, null);

			delay_colet++;
			if(delay_colet>espera_music1) {
				colet_sprite=1;
				time_music++;
			}
			if(mute) {
				if(time_music>espera_music) {
					time_music=0;
					coletando=false;
					delay_colet = colet_sprite = 0;
				}
			}
			else if(colet_sprite == 1 && !Efeitos.eTocando(Efeitos.item_recebido)) {
				time_music=0;
				coletando = false;
				delay_colet = colet_sprite = 0;

			}
		}
	}

	private static void atack(boolean atack) {
		if(atack) {
			precionando=true;
		}
		if(!atack && !atacando && precionando) {
			precionando=false;
			atacando = true;
			Efeitos.play(Efeitos.sword_atack);
		}
	}

	private static void defender(boolean shield) {
		defendendo=shield;
	}
	public static void coletItem() {
		Efeitos.play(Efeitos.item_recebido);
		mute=Sons.mute;
		coletando=true;
	}

	public static void setArma(byte armas) {
		arma_n = armas;
		if (arma_n > 3) {
			arma_n = 3;
		} else if (arma_n < 0) {
			arma_n = 0;
		}
	}
}
