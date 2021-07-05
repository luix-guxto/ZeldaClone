package br.sons;

import br.input.Input;

public class Sons {
	public static boolean mute = false, precionando = false;
	public static void init() {
		Musicas.init();
		Efeitos.init();
	}
	public static void update() {
		if(Input.mute && !precionando) {
			setMute();
			precionando=true;
		}else if(!Input.mute){
			precionando=false;
		}
		Musicas.update();
	}
	private static void setMute() {
		if(mute) {
			mute=false;
		}else {
			mute=true;
		}
	}
}
