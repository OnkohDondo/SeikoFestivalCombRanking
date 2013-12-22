package jp.gr.java_conf.onkohdondo.seikofesta.server;


/**
 * 参加者を管理するクラス。SuicaID、登録名、各種ゲーム上での点数が記録される。
 * 
 * @author Onkoh Dondo
 *
 */
public class Person {
	
	/**
	 * 参加者のSuica/PasmoのID番号（IDm）。<br>
	 * コンストラクタ実行時に指定され、原則変更できない。
	 * 
	 * @see Person#getSuicaid()
	 */
	private int suicaid;
	
	/**
	 * 参加者の名前。
	 * 
	 * @see Person#getName()
	 */
	private String name;
	
	public Person(int id,String name){
		setSuicaid(id);
		setName(name);
	}
	
	/**
	 * Suica/PasmoのID番号（IDm）を取得する。
	 * 
	 * @return　Suica/PasmoのIDm
	 */
	public int getSuicaid() {
		return suicaid;
	}

	private void setSuicaid(int suicaid) {
		this.suicaid = suicaid;
	}

	/**
	 * 参加者の名前を取得する。
	 * 
	 * @return 参加者の名前
	 */
	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		return "(ID:"+suicaid+", "+name+")";
	}
}
