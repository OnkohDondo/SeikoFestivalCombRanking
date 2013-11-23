package jp.gr.java_conf.onkohdondo.seikofesta;

import java.util.ArrayList;

/**
 * �����L���O��ێ�����Q�[���̏��B
 * 
 * @author Onkoh Dondo
 *
 */
public class Game {
	
	/**
	 * ���̃Q�[���̒ʏ́B
	 * 
	 * @see Game#getGameName()
	 */
	private String gameName;
	
	/**
	 * ���̃Q�[���Ɋ܂܂�郉���L���O�f�[�^�B
	 * 
	 * @see Game#getRecord()
	 */
	private ArrayList<Record> record;
	
	/**
	 * �Q�[���N���X�̃R���X�g���N�^�B<br>
	 * �Q�[���̒ʏ̂̐ݒ�A�y�ъe��t�B�[���h�̏��������s���B<br>
	 * �Q�[���̒ʏ̂́A�R���X�g���N�^�݂̂ɂ���Đݒ肳���B
	 * 
	 * @param str�@�Q�[���̃R���X�g���N�^�B
	 */
	public Game(String str){
		setGameName(str);
		record=new ArrayList<Record>();
	}
	
	/**
	 * ���̃Q�[���̒ʏ̂��擾����B
	 * 
	 * @return ���̃Q�[���̒ʏ�
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
	 * ���̃Q�[���Ɋ܂܂�郉���L���O�f�[�^���擾����B
	 * 
	 * @return �����L���O�̃f�[�^
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
	 * ���̃Q�[���Ɋ܂܂�郉���L���O�f�[�^�̒��ŁA�ł��_���������X�R�A���擾����B
	 * 
	 * @param p �T���Ă���p�[�\���f�[�^
	 * @return �p�[�\���f�[�^�ɓK������X�R�A�f�[�^
	 * @throws IllegalArgumentException
	 * �Y�����郉���L���O�f�[�^��������Ȃ��������ɃX���[�����B<br>
	 * ���̏ꍇ�A���̐l�̓Q�[���𖢃v���C�ł���B
	 */
	public int getHighestRecord(Person p){
		for(Record data:record)
			if(data.person.equals(p))
				return data.score;
		//�Y������l����������Ȃ������ꍇ�AIllegalArgumentException��
		//�X���[����B
		throw new IllegalArgumentException("Person not found");
	}
	
	/**
	 * �Q�[���̋L�^��ێ�����N���X�B<br>
	 * �L�^�ێ��ҁA�y�т��̃X�R�A���L�^����B
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