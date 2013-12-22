package jp.gr.java_conf.onkohdondo.seikofesta.server;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import processing.core.PApplet;

public class MainProgram extends PApplet{
	private static final long serialVersionUID = 
			5172172264712487071L;
	public static final int RECORD_HEIGHT=60;
	private ArrayList<Game> games;
	
	private int mode;
	private int step;
	
	private static final int STEP_MAX=512;
	private static final int LEFT_SPACE=40;
	private static final int RIGHT_SPACE=LEFT_SPACE;
	
	public static void main(String[] passedArgs) {
		String[] appletArgs = new String[] 
			{ "jp.gr.java_conf.onkohdondo.seikofesta.server."
					+ "MainProgram"
//				,ARGS_FULL_SCREEN
				};
		if (passedArgs != null) {
			PApplet.main(concat(appletArgs, passedArgs));
		} else {
			PApplet.main(appletArgs);
		}
	}
	
	public void setup(){
		//�t���[����������
//		frame.setResizable(true);
		frame.setAlwaysOnTop(true);
		
		//�Q�[���f�[�^�ǂݍ���
		loadGameData();
		
		//�ϐ��̏�����
		mode=0;
		step=0;
		
		//�A�v���b�g�n��������
		size(displayWidth,displayHeight);
		background(255);
	}

	public void draw(){
		Game game=games.get(mode);
		
		//�A�j���[�V�����X�e�b�v�̉��Z
		boolean b=false;//�����L���O�ϓ����P�ȏ゠�邩�ǂ���
		if(mode<games.size()){//�����L���O�\�����̂ݍs���B�i�\���O��������G���[�j
			Game g=games.get(mode);
			if(32<step && step<STEP_MAX-32)
			for(Record r:g.getRecord()){
				r.move();
				if(r.getScore()!=r.displayedScore) b=true;
			}
		}
		if(!b) step++; else step=STEP_MAX/2;
		if(step>=STEP_MAX){
			step=0;
			mode++;
			if(mode>=games.size()) mode=0;
			//�\�����[�h���ς�������AdisplayedScore��S��0�ɂ���I
			for(Record r:games.get(mode).getRecord()){
				r.displayedScore=0;
			}
		}
			
		//�w�i
		background(255);
		
		//�Q�[���^�C�g��
		fill(0);
		textFont(createFont("�l�r�@����", 60));
		textAlign(CENTER);
		text(game.getGameName(), width/2, 100);
		
		//�e�����L���O�f�[�^�\��
		noStroke();
		for(int i=game.getRecord().size()-1; i>=0;i--){
			Record r=game.getRecord().get(i);
//			System.out.println(i+": "+r.getIndex()+"(Displayed: "
//					+r.displayedRank+")		");
			int drawY=120+(int)(r.displayedRank*(RECORD_HEIGHT+10));
			fill(208);
			rect(LEFT_SPACE,drawY, width-LEFT_SPACE-RIGHT_SPACE,
					RECORD_HEIGHT);
			fill(0);
			textSize(30);
			textAlign(LEFT,CENTER);
			text((int)r.displayedRank+1+"",
					40,drawY+RECORD_HEIGHT/2);
			text(r.person.getName(),120,drawY+RECORD_HEIGHT/2);
			text(nf(r.displayedScore,game.dight),
					600, drawY+RECORD_HEIGHT/2);
//			System.out.println(r.getScore());
			
//			stroke(255,0,0);
//			line(40,drawY+RECORD_HEIGHT/2,
//					width-40,drawY+RECORD_HEIGHT/2);
//			noStroke();
		}
		
		//�G�t�F�N�g
		if(step<=64){
			fill(255,256-step*4);
			rect(0,0,width,height);
		}
		if(step>=STEP_MAX-64){
			fill(255,256-(STEP_MAX-step)*4);
			rect(0,0,width,height);
		}
		
		//step�\��
//		text(step,0,height);
	}

	private void loadGameData(){
		games=new ArrayList<Game>();
		games.add(new Game("��������Q�[���P"));
		games.add(new Game("��������Q�[���Q"));
		Game g=games.get(0);
		Person p=new Person(0, "TAMESHI");
		g.addRecord(p,1000);
		g.addRecord(p, 500);
		g.addRecord(p, 200);
		g.addRecord(p, 100);
		g.addRecord(new Person(1,"����"), 0);
		new Timer().schedule(new AddData(),12000);
		new Timer().schedule(new AddData2(),25000);
		g=games.get(1);
		g.addRecord(p,1000);
		g.addRecord(p, 500);
		g.addRecord(p, 200);
		g.addRecord(p, 100);
	}
	public class AddData extends TimerTask{
		public void run(){
			Game g=games.get(0);
			g.setScore(g.getPlayingRecordByPerson(1).getIndex(),
					700);
		}
	}
	public class AddData2 extends TimerTask{
		public void run(){
			Game g=games.get(0);
//			System.out.println(g.getPlayingRecordByPerson(1).
//					getIndex());
			g.setScore(g.getPlayingRecordByPerson(1).getIndex(),
					1500);
		}
	}
}