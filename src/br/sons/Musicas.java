package br.sons;

import br.audio.AudioPlayer;

public class Musicas {

	public static final byte MUSICAS = 5;
	private static AudioPlayer music[] = new AudioPlayer[MUSICAS];
	private static byte currentMusic = -1;
	public static final byte INTRO = 0, LABIRITO = 1, OVER = 2, DEATH = 3, END = 4;

	public static void init() {
		music[0] = new AudioPlayer("/audios/musics/intro.mp3");
		music[1] = new AudioPlayer("/audios/musics/labyrinth.mp3");
		music[2] = new AudioPlayer("/audios/musics/overworld.mp3");
		music[3] = new AudioPlayer("/audios/musics/death-mountain.mp3");
		music[4] = new AudioPlayer("/audios/musics/ending.mp3");
	}

	public static void update() {
		if(currentMusic != -1) {
			if(Sons.mute) {
				music[currentMusic].pause();
			}else if(!music[currentMusic].taTocando()) {
				music[currentMusic].play();
			}
		}else {
			for(byte x = 0; x<music.length; x++) {
				music[x].pause();
			}
		}

	}

	public static void setMusic(byte musics) {
		for(byte x = 0; x<music.length; x++) {
			music[x].pause();
		}
		currentMusic=musics;
	}

}
