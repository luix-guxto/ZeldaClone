package br.input;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Controller;
import org.lwjgl.input.Controllers;


public class GamePad{
	private static boolean pluged = false, precionando;
	private static Controller cont;
	public static boolean up, left, right, down, atack, defend, start, mute;
	public static void init() {
		try {
			Controllers.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		Controllers.poll();
		cont=Controllers.getController(0);
	}
	public static void update() {
		if(Teclado.controler && !precionando) {
			precionando=true;
			if(pluged) {
				pluged=false;
				up=false;
				down=false;
				left=false;
				right=false;
				atack=false;
				defend=false;
				start=false;
				mute=false;
			}else {
				pluged=true;
			}
		}else if(!Teclado.controler){
			precionando=false;
		}
		if(pluged) {
			cont.poll();
			if(cont.getPovY()<0 ||cont.getAxisValue(0)<-0.30f) {
				up=true;
			}else {
				up=false;
			}
			if(cont.getPovY()>0 || cont.getAxisValue(0)>0.30f) {
				down=true;
			}else {
				down=false;
			}
			if(cont.getPovX()<0 || cont.getAxisValue(1)<-0.30f) {
				left=true;
			}else {
				left=false;
			}
			if(cont.getPovX()>0 || cont.getAxisValue(1)>0.30f) {
				right=true;
			}else {
				right=false;
			}
			if(cont.isButtonPressed(2)) {
				atack=true;
			}else {
				atack=false;
			}
			if(cont.isButtonPressed(4)) {
				defend=true;
			}else {
				defend=false;
			}
			if(cont.isButtonPressed(7)) {
				start=true;
			}else {
				start=false;
			}
			if(cont.isButtonPressed(6)) {
				mute=true;
			}else {
				mute=false;
			}
		}
	}
}
