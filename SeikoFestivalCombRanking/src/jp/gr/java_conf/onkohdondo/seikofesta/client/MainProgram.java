package jp.gr.java_conf.onkohdondo.seikofesta.client;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainProgram extends TimerTask {
	
	private File input_output_file;

	private MainFrame mainFrame;
	protected static final String SETTING_PASSWORD=
			"setting skgFestibal";
	
	private String playerName;
	
	public static void main(String[] args) {
		new Timer().schedule(new MainProgram(), 0, 50);
	}
	
	private MainProgram(){
		mainFrame=new MainFrame(this);
		input_output_file=new File("C:\\Users\\user\\Documents\\input.txt");
	}
	
	public void run() {
		//ÉtÉ@ÉCÉãÇÃì«Ç›çûÇ›
		String str="";
		try {
			FileReader reader=new FileReader(input_output_file);
			int ch;
			while((ch=reader.read())!=-1) str+=(char)ch;
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(str.indexOf("name")!=-1){
			if(!mainFrame.isVisible()) mainFrame.setVisible(true);
		}
	}
	
	protected void openSettings(){
	}

	protected String getName() {
		return playerName;
	}

	protected void setName(String playerName) {
		this.playerName = playerName;
	}
}
