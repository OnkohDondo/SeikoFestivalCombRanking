package jp.gr.java_conf.onkohdondo.seikofesta;

import java.util.ArrayList;
import java.util.ListIterator;

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
	
	/**
	 * ゲームに新しい記録を追加する。
	 * 記録は、recordのscoreで降順に並び替えられる。
	 * playingは自動的にfalseとされる。
	 * 
	 * @param p　記録保持者
	 * @param i　点数
	 */
	public void addRecord(Person p,int i){
		addRecord(p, i, true);
	}
	
	
	/**
	 * ゲームに新しい記録を追加する。playingを明示的に指定する場合に呼び出す。
	 * 記録は、recordのscoreで降順に並び替えられる。
	 * 
	 * @param p　記録保持者
	 * @param i　点数
	 * @param b playingに設定する値
	 */
	public void addRecord(Person p, int i, boolean b){
		if(record.isEmpty()){
			record.add(new Record(0,p,i,b));
			return;
		}
		ListIterator<Record> li=record.listIterator();
		do{
			if(li.next().getScore()<i){
				li.previous();
				li.add(new Record(li.previousIndex()+1,p,i,b));
				return;
			}
		}while(li.hasNext());
		li.add(new Record(li.previousIndex()+1,p,i,b));
	}
	
	/**
	 * ある一人の人がこのゲームにおいて出した記録の中で、
	 * 最も点数が高いスコアを取得する。
	 * 
	 * @param p 探しているパーソンデータ
	 * @return パーソンデータに適合するスコアデータ
	 * @throws IllegalArgumentException
	 * 該当するランキングデータが見つからなかった時にスローされる。<br>
	 * この場合、その人はゲームを未プレイである。
	 */
	public Record getHighestRecord(Person p){
		for(Record data:record)
			if(data.person.equals(p))
				return data;
		//該当する人が見当たらなかった場合、IllegalArgumentExceptionを
		//スローする。
		throw new IllegalArgumentException("Person not found");
	}
	
	/**
	 * 人のIDに対応するPersoｎインスタンスを持った記録のうち、
	 * プレイ中のものを返す。
	 * 
	 * @param id　パーソンデータのID
	 * @return　記録データ
	 */
	public Record getPlayingRecordByPerson(int id){
		for(Record data:record){
			if(data.person.getSuicaid()==id){
				if(data.isPlaying()){
					return data;
				}
			}
		}
		return null;
	}
	
	/**
	 * 項目のインデックスを指定して、リストのスコアを変更する。
	 * 順位は自動的に並べ替えられる。
	 */
	public void setScore(int index, int score){
		record.get(index).setScore(score);
		ListIterator<Record> li=record.listIterator();
		Record r=null;
		while(li.nextIndex()!=index)
			r=li.next();
		r=li.next();
		li.remove();
		addRecord(r.person, r.getScore());
		getPlayingRecordByPerson(r.person.getSuicaid()).
				displayedRank=r.getIndex();
//		System.out.println(record);
		for(int i=0;i<record.size();i++){
			record.get(i).setIndex(i);
//			System.out.print(record.get(i)+" ");
//			System.out.println(record.get(i).getIndex());
		}
	}
}