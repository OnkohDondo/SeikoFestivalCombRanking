package jp.gr.java_conf.onkohdondo.seikofesta;

import java.util.ArrayList;

public class MainProgram {

	private ArrayList<Game> games;
	
	public static void main(String[] args) {
		new MainProgram();
	}
	
	private MainProgram(){
		load();
	}
	
	
	private void load(){
		games=new ArrayList<Game>();
	}
}
