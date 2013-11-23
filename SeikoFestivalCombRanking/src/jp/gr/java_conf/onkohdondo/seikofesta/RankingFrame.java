package jp.gr.java_conf.onkohdondo.seikofesta;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class RankingFrame extends JFrame{
	private static final long serialVersionUID = 
			-6867407503791065348L;

//	public Graphics2D graphics;
	private MainProgram main;
	
	public RankingFrame(MainProgram m){
		setUndecorated(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(600,600);
		setVisible(true);
		main=m;
	}
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D graphics = (Graphics2D)g;
		main.redraw(graphics);
	}
}
