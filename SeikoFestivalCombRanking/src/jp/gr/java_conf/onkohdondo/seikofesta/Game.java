package jp.gr.java_conf.onkohdondo.seikofesta;

import java.util.ArrayList;

/**
 * ランキングを保持するゲームの情報。
 * 
 * @author Onkoh Dondo
 *
 */
public class Game {
	
	/**
	 * そのゲームの通称。
	 * 
	 * @see Game#getGameName()
	 */
	private String gameName;
	
	/**
	 * そのゲームに含まれるランキングデータ。
	 * 
	 * @see Game#getRecord()
	 */
	private ArrayList<Record> record;
	
	/**
	 * ゲームクラスのコンストラクタ。<br>
	 * ゲームの通称の設定、及び各種フィールドの初期化を行う。<br>
	 * ゲームの通称は、コンストラクタのみによって設定される。
	 * 
	 * @param str　ゲームのコンストラクタ。
	 */
	public Game(String str){
		setGameName(str);
		record=new ArrayList<Record>();
	}
	
	/**
	 * そのゲームの通称を取得する。
	 * 
	 * @return そのゲームの通称
	 * 
	 * @see Game#gameName
	 */
	public String getGameName() {
		return gameName;
	}
	
	
	private void setGameName(String gameName) {
		this.gameName = gameName;
	}
	
	/**
	 * そのゲームに含まれるランキングデータを取得する。
	 * 
	 * @return ランキングのデータ
	 * 
	 * @see Game#record
	 */
	public ArrayList<Record> getRecord() {
		return record;
	}

	@SuppressWarnings("unused")
	private void setRecord(ArrayList<Record> record) {
		this.record = record;
	}
	
	public void addRecord(Person p,int i){
		record.add(new Record(p,i));
	}
	
	/**
	 * このゲームに含まれるランキングデータの中で、最も点数が高いスコアを取得する。
	 * 
	 * @param p 探しているパーソンデータ
	 * @return パーソンデータに適合するスコアデータ
	 * @throws IllegalArgumentException
	 * 該当するランキングデータが見つからなかった時にスローされる。<br>
	 * この場合、その人はゲームを未プレイである。
	 */
	public int getHighestRecord(Person p){
		for(Record data:record)
			if(data.person.equals(p))
				return data.score;
		//該当する人が見当たらなかった場合、IllegalArgumentExceptionを
		//スローする。
		throw new IllegalArgumentException("Person not found");
	}
	
	/**
	 * ゲームの記録を保持するクラス。<br>
	 * 記録保持者、及びそのスコアを記録する。
	 * 
	 * @author Onkoh Dondo
	 * 
	 */
	private class Record {
		@SuppressWarnings("all")
		public Person person;
		@SuppressWarnings("all")
		public int score;
		
		public Record(Person p,int s){
			person=p;
			score=s;
		}
	}
}