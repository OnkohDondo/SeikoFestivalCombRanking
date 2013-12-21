package jp.gr.java_conf.onkohdondo.seikofesta;
/**
 * �Q�[���̋L�^��ێ�����N���X�B<br>
 * �L�^�ێ��ҁA�y�т��̃X�R�A���L�^����B
 * �����L���O�A�j���[�V�����̂��߁A�\������Ă�����Ȃǂ��L�^�����B
 * 
 * @author Onkoh Dondo
 * 
 */
public class Record {
	/**
	 * �L�^�������Ă���l��Person�N���X�B
	 */
	public Person person;
	
	/**
	 * �L�^�Ɋ܂܂��X�R�A�B
	 * �X�R�A�̕ύX��playing��true�ł���Ƃ��̂݋������B
	 * 
	 * @see Record#getScore()
	 * @see Record#setScore(int)
	 */
	private int score;
	
	private int rank;
	/**
	 * �L�^���A�v���C���̌o�ߋL�^�ɑ΂�����̂ł��邩�ǂ����B<br>
	 * true�̂��̂�false�ɂł��邪�Afalse�̂��̂�true�ɂ��邱�Ƃ͂ł��Ȃ��B
	 * 
	 * @see Record#isPlaying()
	 * @see Record#endPlaying() 
	 */
	private boolean playing;
	public int displayedScore;
	public float displayedRank;
	public int speed;

	
	/**
	 * �V�����L�^����郁�\�b�h�B
	 * �ʏ�̓v���C���ɍ����̂ŁAplaying�ɂ͎����I��true����������B
	 * 
	 * @deprecated�@�Ăяo�����\��������܂���B
	 * @param p�@�v���C���[
	 * @param s�@�����X�R�A
	 */
	protected Record(int r,Person p,int s){
		this(r,p,s,true);
	}
	
	/**
	 * �V�����L�^����郁�\�b�h�B<br>
	 * �v���C���ɍ��ꂸ�Aplaying��false��ݒ肵�����ꍇ�ȂǂɁA
	 * playing�𖾎��I�ɐݒ�ł���B
	 * 
	 * @param p�@�v���C���[
	 * @param s�@�����X�R�A
	 * @param b�@playing
	 */
	protected Record(int r, Person p, int s, boolean b){
		rank=r;
		if(b) displayedRank=r;
		playing=b;
		person=p;
		score=s;
	}
	
	/**
	 * playing��true�ł���Ƃ��A�A�j���[�V�����𓮂������߂Ɏg�p�����B
	 * 
	 */
	public void move(){
		if(displayedScore<getScore()){
			if(getScore()-displayedScore<77)
				displayedScore=getScore();
			else
				displayedScore+=77;
		}
	}
	
	/**
	 * �������Ԃ��B
	 */
	public String toString(){
		return person.getName()+": "+getScore();
	}
	
	/**
	 * �X�R�A�̃Q�b�^�B
	 * @return�@�X�R�A
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * �X�R�A�̃Z�b�^�B�X�R�A�̕ύX��playing��true�ł���Ƃ��̂݋������B
	 * 
	 * @param score�@�X�R�A�̒l
	 */
	public void setScore(int score) {
		if(!isPlaying()) return;
		this.score = score;
	}
	
	/**
	 * playing�̃Q�b�^�B
	 * 
	 * @return�@playing
	 */
	public boolean isPlaying() {
		return playing;
	}
	
	/**
	 * playing��false�ɂ���B<br>
	 * ���̃��\�b�h�����s�����ƁAscore�̒����͋�����Ȃ��Ȃ�B
	 */
	public void endPlaying() {
		if(playing) this.playing =false;
	}
	
	public int getRank() {
		return rank;
	}
	
	private void setRank(int rank) {
		this.rank = rank;
	}
}
