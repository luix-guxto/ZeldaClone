package br.input;

public class Input {
	public static boolean up, down, left, right, atack, defend, start, mute;
	public static void update() {
		Teclado.update();
		GamePad.update();
		
		if(Teclado.up || GamePad.up) {
			up=true;
		}else {
			up=false;
		}
		if(Teclado.down || GamePad.down) {
			down=true;
		}else {
			down=false;
		}
		if(Teclado.left || GamePad.left) {
			left=true;
		}else {
			left=false;
		}
		if(Teclado.right || GamePad.right) {
			right=true;
		}else {
			right=false;
		}
		if(Teclado.atack || GamePad.atack) {
			atack=true;
		}else {
			atack=false;
		}
		if(Teclado.defend || GamePad.defend) {
			defend=true;
		}else {
			defend=false;
		}
		if(Teclado.start || GamePad.start) {
			start=true;
		}else {
			start=false;
		}if(Teclado.mute || GamePad.mute) {
			mute=true;
		}else {
			mute=false;
		}
	}
	public static void init() {
		GamePad.init();
	}
}
