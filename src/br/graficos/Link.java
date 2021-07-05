package br.graficos;

import java.io.IOException;

import br.sprites.ImageLoader;
import br.sprites.SpriteSheet;

public class Link {

	public static SpriteSheet ssLink;

	public static void init(){
		ImageLoader loader = new ImageLoader();
		try {
			ssLink = new SpriteSheet(loader.loadImage("/sprites/linkSprites.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
