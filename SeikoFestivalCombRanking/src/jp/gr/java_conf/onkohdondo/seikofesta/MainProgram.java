package jp.gr.java_conf.onkohdondo.seikofesta;

import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainProgram extends TimerTask{

	@SuppressWarnings("unused")
	private ArrayList<Game> games;
	private RankingFrame rankingFrame;
	
	public static void main(String[] args) {
		new Timer().schedule(new MainProgram(),300,50);
	}
	
	private MainProgram(){
		load();
		rankingFrame=new RankingFrame(this);
//		g=(Graphics2D) rankingFrame.getGraphics();
		GraphicsDevice device =
				GraphicsEnvironment.getLocalGraphicsEnvironment().
				getDefaultScreenDevice();
		device.setFullScreenWindow(rankingFrame);
	}
	
	
	private void load(){
		games=new ArrayList<Game>();
	}

	@Override
	public void run() {
		rankingFrame.repaint();
	}
	
	public void redraw(Graphics2D g){
		g.drawString(System.currentTimeMillis()+"", 0, 100);
	}
}
