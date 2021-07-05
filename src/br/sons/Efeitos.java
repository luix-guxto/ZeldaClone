package br.sons;

import br.audio.AudioPlayer;

public class Efeitos {
	private static final byte EFEITOS = 2;
	public static final byte item_obtido = 0, item_recebido = 1;
	private static AudioPlayer efeitos[] = new AudioPlayer[EFEITOS];
	public static void init() {
		efeitos[0] = new AudioPlayer("/audios/efects/itemObtained.mp3");
		efeitos[1] = new AudioPlayer("/audios/efects/itemReceived.mp3");
	}
	public static void play(byte efeito) {
		if(!Sons.mute) {
			efeitos[efeito].play();
		}
	}
	public static boolean tocando() {
		boolean a = false;
		for(byte x = 0; x<efeitos.length; x++) {
			if(efeitos[x].taTocando()) {
				a = true;
			}
		}
		return a;
	}
	public static boolean eTocando(byte efeito) {
		return efeitos[efeito].taTocando();
	}
}
