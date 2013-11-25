package jp.gr.java_conf.onkohdondo.seikofesta;

import static java.awt.Color.*;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import jp.gr.java_conf.onkohdondo.visualFrame.Drawable;
import jp.gr.java_conf.onkohdondo.visualFrame.VisualFrame;

public class MainProgram extends TimerTask implements Drawable{

	private ArrayList<Game> games;
	private VisualFrame rankingFrame;
	
	@SuppressWarnings("unused")
	private int displayed;
	
	public static void main(String[] args) {
		new Timer().schedule(new MainProgram(),300,50);
	}
	
	private MainProgram(){
		load();
		rankingFrame=new VisualFrame(this);
		rankingFrame.setUndecorated(true);
		GraphicsDevice device =
				GraphicsEnvironment.getLocalGraphicsEnvironment().
				getDefaultScreenDevice();
		device.setFullScreenWindow(rankingFrame);
		rankingFrame.setVisible(true);
	}
	
	
	private void load(){
		games=new ArrayList<Game>();
		games.add(new Game("Ç®Ç‡ÇµÇÎÉQÅ[ÉÄ"));
		Game g=games.get(0);
		Person p=new Person(0, "TAMESHI");
		g.addRecord(p, 100);
	}

	@Override
	public void run() {
		rankingFrame.repaint();
	}

	@Override
	public void setup(Graphics2D g, int id) {
		if(id==rankingFrame.FRAME_ID){
			g.setColor(BLACK);
		}
	}

	@Override
	public void draw(Graphics2D g, int id) {
		if(id==rankingFrame.FRAME_ID){
			g.drawString(System.currentTimeMillis()+"", 0, 100);
		}
	}
}
