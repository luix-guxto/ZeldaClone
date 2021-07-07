package br.display;

import br.sprites.ImageLoader;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Display {

	private JFrame jframe;

	private Canvas canvas;

	public Display(String title, int width, int height, String path){

		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));

		jframe = new JFrame(title);
		ImageLoader loader = new ImageLoader();
		canvas.setFocusable(false);
		jframe.add(canvas);
		jframe.pack();

		try{
			jframe.setIconImage(loader.loadImage(path));
		}catch (IOException e){
			e.printStackTrace();
		}
		jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jframe.setResizable(false);
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);

	}
	public void fechar(){
		jframe.dispose();
	}
	public BufferStrategy getBufferStrategy() {
		return canvas.getBufferStrategy();
	}
	public void createBufferStrategy() {
		canvas.createBufferStrategy(3);
	}

	public void setKeyListener(KeyListener kl) {
		jframe.addKeyListener(kl);
	}
	public void setIcon(BufferedImage a){
		jframe.setIconImage(a);
	}
}
