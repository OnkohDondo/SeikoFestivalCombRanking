package jp.gr.java_conf.onkohdondo.seikofesta;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;

import processing.core.PApplet;

public class MainProgram extends PApplet{
	private static final long serialVersionUID = 
			5172172264712487071L;
	public static final int RECORD_HEIGHT=60;
	private ArrayList<Game> games;
	
	private int mode;
	private int step;
	
	public static void main(String[] passedArgs) {
		String[] appletArgs = new String[] 
			{ "jp.gr.java_conf.onkohdondo.seikofesta.MainProgram" };
		if (passedArgs != null) {
			PApplet.main(concat(appletArgs, passedArgs));
		} else {
			PApplet.main(appletArgs);
		}
	}
	
	public void setup(){
		load();
		frame.setUndecorated(true);
		GraphicsDevice device =
				GraphicsEnvironment.getLocalGraphicsEnvironment().
				getDefaultScreenDevice();
		device.setFullScreenWindow(frame);
		frame.setVisible(true);
		mode=0;
		step=0;
		
		size(400,400);
		color(0);
		background(255);
	}	
	

	private void load(){
		games=new ArrayList<Game>();
		games.add(new Game("Ç®Ç‡ÇµÇÎÉQÅ[ÉÄÇP"));
		games.add(new Game("Ç®Ç‡ÇµÇÎÉQÅ[ÉÄÇQ"));
		Game g=games.get(0);
		Person p=new Person(0, "TAMESHI");
		g.addRecord(p,1000);
		g.addRecord(p, 500);
		g.addRecord(p, 200);
		g.addRecord(p, 100);
		g=games.get(1);
		g.addRecord(p,1000);
		g.addRecord(p, 500);
		g.addRecord(p, 200);
		g.addRecord(p, 100);
	}

	public void draw(){
//		Dimension size = rankingFrame.getSize();
//		Image back = rankingFrame.
//				createImage(size.width, size.height);
//		Graphics2D g = (Graphics2D)back.getGraphics();
		Game game=games.get(mode);
			
			//îwåi
			rect(0, 0, width,height);
			
			//ÉQÅ[ÉÄÉ^ÉCÉgÉã
			textFont(createFont("ÇlÇrÅ@ñæí©", 60));
			text(game.getGameName(), 
					width/2-textWidth(game.getGameName())/2, 100);
			
			//äeÉâÉìÉLÉìÉOÉfÅ[É^ï\é¶
			
			{
				int i;
				Game.Record r;
				for(i=0,r=game.getRecord().get(i);
						i<game.getRecord().size();i++){
					int drawY=
						120+(r.playing?r.displayedX:i*RECORD_HEIGHT);
					color(128);
					rect(30,drawY, width-60, 50);
					color(0);
					textSize(30);
//					g.drawString(i+1+"", 40,drawY+RECORD_HEIGHT-30);
			}}	
//			graphics.drawImage(back,0,0,rankingFrame);
	}
/*
	@Override
	public void run() {
		rankingFrame.repaint();
		if(mode<games.size()){
			Game g=games.get(mode);
			for(Game.Record r:g.getRecord())
				if(r.playing)
					r.move();
		}
		step++;
		if(step>=100){
			step=0;
			mode++;
			if(mode>=games.size()) mode=0;
		}
	}
*/
/*

	@Override
	public void draw(Graphics2D graphics, int id) {
	}
*/

/*
	public MainProgram(){
//		rankingFrame.setIgnoreRepaint(true);
//		rankingFrame.createBufferStrategy(2);
//		rankingFrame.bst=rankingFrame.getBufferStrategy();

	}
*/
}
