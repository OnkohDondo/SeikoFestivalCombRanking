package jp.gr.java_conf.onkohdondo.seikofesta;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.plaf.SliderUI;

import processing.core.PApplet;

public class MainProgram extends PApplet{
	private static final long serialVersionUID = 
			5172172264712487071L;
	public static final int RECORD_HEIGHT=60;
	private ArrayList<Game> games;
	
	private int mode;
	private int step;
	
	private static final int STEP_MAX=256;
	private static final int LEFT_SPACE=40;
	private static final int RIGHT_SPACE=LEFT_SPACE;
	
	public static void main(String[] passedArgs) {
		String[] appletArgs = new String[] 
			{ "jp.gr.java_conf.onkohdondo.seikofesta.MainProgram"
//				,ARGS_FULL_SCREEN
				};
		if (passedArgs != null) {
			PApplet.main(concat(appletArgs, passedArgs));
		} else {
			PApplet.main(appletArgs);
		}
	}
	
	public void setup(){
		//フレームをいじる
//		frame.setResizable(true);
		frame.setAlwaysOnTop(true);
		
		//ゲームデータ読み込み
		loadGameData();
		
		//変数の初期化
		mode=0;
		step=0;
		
		//アプレット系をいじる
		size(displayWidth,displayHeight);
		background(255);
	}

	public void draw(){
		Game game=games.get(mode);
		
		//アニメーションステップの加算
		if(mode<games.size()){
			Game g=games.get(mode);
			for(Record r:g.getRecord())
				if(r.isPlaying())
					r.move();
		}
		step++;
		if(step>=STEP_MAX){
			step=0;
			mode++;
			if(mode>=games.size()) mode=0;
		}
			
		//背景
		background(255);
		
		//ゲームタイトル
		fill(0);
		textFont(createFont("ＭＳ　明朝", 60));
		textAlign(CENTER);
		text(game.getGameName(), width/2, 100);
		
		//各ランキングデータ表示
		noStroke();
		for(int i=0; i<game.getRecord().size();i++){
			Record r=game.getRecord().get(i);
			int drawY=120+(int)(r.isPlaying()?
						r.displayedRank:i)*(RECORD_HEIGHT+10);
			fill(208);
			rect(LEFT_SPACE,drawY, width-LEFT_SPACE-RIGHT_SPACE,
					RECORD_HEIGHT);
			fill(0);
			textSize(30);
			textAlign(LEFT,CENTER);
			text(i+1+"", 40,drawY+RECORD_HEIGHT/2);
			text(r.person.getName(),120,drawY+RECORD_HEIGHT/2);
			text(r.isPlaying()?r.displayedScore:r.getScore(),
					600, drawY+RECORD_HEIGHT/2);
			System.out.println(r.getScore());
			
			stroke(255,0,0);
			line(40,drawY+RECORD_HEIGHT/2,
					width-40,drawY+RECORD_HEIGHT/2);
			noStroke();
		}
		
		//エフェクト
		if(step<=64){
			fill(255,256-step*4);
			rect(0,0,width,height);
		}
		if(step>=STEP_MAX-64){
			fill(255,256-(STEP_MAX-step)*4);
			rect(0,0,width,height);
		}
		
		//step表示
//		text(step,0,height);
	}

	private void loadGameData(){
		games=new ArrayList<Game>();
		games.add(new Game("おもしろゲーム１"));
//		games.add(new Game("おもしろゲーム２"));
		Game g=games.get(0);
		Person p=new Person(0, "TAMESHI");
		g.addRecord(p,1000,false);
		g.addRecord(p, 500,false);
		g.addRecord(p, 200,false);
		g.addRecord(p, 100,false);
//		g=games.get(1);
//		g.addRecord(p,1000);
//		g.addRecord(p, 500);
//		g.addRecord(p, 200);
//		g.addRecord(p, 100);

		g.addRecord(new Person(1,"強者"), 0);
		new Timer().schedule(new AddData(),12000);
		new Timer().schedule(new AddData2(),16000);
	}
	public class AddData extends TimerTask{
		public void run(){
			games.get(0).getPlayingRecordByPerson(1).setScore(10000);
		}
	}
	public class AddData2 extends TimerTask{
		public void run(){
			games.get(0).getPlayingRecordByPerson(1).setScore(15000);
		}
	}
}