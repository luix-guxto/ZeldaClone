package br.graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import br.sprites.ImageLoader;
import br.sprites.SpriteSheet;

public class TitleSprites {

	private static BufferedImage sprite;
	public static BufferedImage titleScreen[] = new BufferedImage[6];
	public static void init() {
		ImageLoader loader = new ImageLoader();
		try {
			sprite = loader.loadImage("/sprites/titleScreen.png");
		} catch (IOException e) {
			e.printStackTrace();
		}

		SpriteSheet ssTitle = new SpriteSheet(sprite);
		titleScreen[0] = ssTitle.getSprite(8, 		8, 		636, 578);
		titleScreen[1] = ssTitle.getSprite(706, 	8, 		636, 578);
		titleScreen[2] = ssTitle.getSprite(1387, 	8, 		636, 578);
		titleScreen[3] = ssTitle.getSprite(8, 		632, 	636, 578);
		titleScreen[4] = ssTitle.getSprite(706, 	632, 	636, 578);
		titleScreen[5] = ssTitle.getSprite(1387, 	632, 	636, 578);
	}
}
