package jp.gr.java_conf.onkohdondo.seikofesta;
/**
 * ゲームの記録を保持するクラス。<br>
 * 記録保持者、及びそのスコアを記録する。
 * ランキングアニメーションのため、表示されている情報なども記録される。
 * 
 * @author Onkoh Dondo
 * 
 */
public class Record {
	/**
	 * 記録を持っている人のPersonクラス。
	 */
	public Person person;
	
	/**
	 * 記録に含まれるスコア。
	 * スコアの変更はplayingがtrueであるときのみ許される。
	 * 
	 * @see Record#getScore()
	 * @see Record#setScore(int)
	 */
	private int score;
	
	private int index;
	/**
	 * 記録が、プレイ中の経過記録に対するものであるかどうか。<br>
	 * trueのものはfalseにできるが、falseのものをtrueにすることはできない。
	 * 
	 * @see Record#isPlaying()
	 * @see Record#endPlaying() 
	 */
	private boolean playing;
	public int displayedScore;
	public float displayedRank;
	@Deprecated
	public int speed;

	
	/**
	 * 新しい記録を作るメソッド。
	 * 通常はプレイ中に作られるので、playingには自動的にtrueが代入される。
	 * 
	 * @deprecated　呼び出される可能性がありません。
	 * @param p　プレイヤー
	 * @param s　初期スコア
	 */
	protected Record(int r,Person p,int s){
		this(r,p,s,true);
	}
	
	/**
	 * 新しい記録を作るメソッド。<br>
	 * プレイ中に作られず、playingにfalseを設定したい場合などに、
	 * playingを明示的に設定できる。
	 * 
	 * @param p　プレイヤー
	 * @param s　初期スコア
	 * @param b　playing
	 */
	protected Record(int r, Person p, int s, boolean b){
		index=r;
		displayedRank=r;
		playing=b;
		person=p;
		score=s;
	}
	
	private static final int SCORE_PLUS_RATE=7;
	private static final float MOVE_RATE=0.02f;
	
	/**
	 * playingがtrueであるとき、アニメーションを動かすために使用される。
	 * 
	 */
	public void move(){
		if(displayedRank<getIndex()){
//			System.out.println(getIndex()+": moved down");
			if(getIndex()-displayedRank<MOVE_RATE)
				displayedRank=getIndex();
			else
				displayedRank+=MOVE_RATE;
		}else if(displayedRank>getIndex()){
//			System.out.println(getIndex()+": moved up");
			if(displayedRank-getIndex()<MOVE_RATE)
				displayedRank=getIndex();
			else
				displayedRank-=MOVE_RATE;
		}else if(displayedScore<getScore()){
			if(getScore()-displayedScore<SCORE_PLUS_RATE)
				displayedScore=getScore();
			else
				displayedScore+=SCORE_PLUS_RATE;
		}
	}
	
	/**
	 * 文字列を返す。
	 */
	public String toString(){
		return person.getName()+": "+getScore();
	}
	
	/**
	 * スコアのゲッタ。
	 * @return　スコア
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * スコアのセッタ。スコアの変更はplayingがtrueであるときのみ許される。
	 * 
	 * @param score　スコアの値
	 */
	public void setScore(int score) {
		if(!isPlaying()) return;
		this.score = score;
	}
	
	/**
	 * playingのゲッタ。
	 * 
	 * @return　playing
	 */
	public boolean isPlaying() {
		return playing;
	}
	
	/**
	 * playingをfalseにする。<br>
	 * このメソッドが実行されると、scoreの訂正は許されなくなる。
	 */
	public void endPlaying() {
		if(playing) this.playing =false;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int rank) {
		this.index = rank;
	}
}
