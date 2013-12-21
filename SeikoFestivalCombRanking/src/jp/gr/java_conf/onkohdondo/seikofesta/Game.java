package jp.gr.java_conf.onkohdondo.seikofesta;

import java.util.ArrayList;
import java.util.ListIterator;

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
	
	/**
	 * �Q�[���ɐV�����L�^��ǉ�����B
	 * �L�^�́Arecord��score�ō~���ɕ��ёւ�����B
	 * playing�͎����I��false�Ƃ����B
	 * 
	 * @param p�@�L�^�ێ���
	 * @param i�@�_��
	 */
	public void addRecord(Person p,int i){
		addRecord(p, i, true);
	}
	
	
	/**
	 * �Q�[���ɐV�����L�^��ǉ�����Bplaying�𖾎��I�Ɏw�肷��ꍇ�ɌĂяo���B
	 * �L�^�́Arecord��score�ō~���ɕ��ёւ�����B
	 * 
	 * @param p�@�L�^�ێ���
	 * @param i�@�_��
	 * @param b playing�ɐݒ肷��l
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
	 * �����l�̐l�����̃Q�[���ɂ����ďo�����L�^�̒��ŁA
	 * �ł��_���������X�R�A���擾����B
	 * 
	 * @param p �T���Ă���p�[�\���f�[�^
	 * @return �p�[�\���f�[�^�ɓK������X�R�A�f�[�^
	 * @throws IllegalArgumentException
	 * �Y�����郉���L���O�f�[�^��������Ȃ��������ɃX���[�����B<br>
	 * ���̏ꍇ�A���̐l�̓Q�[���𖢃v���C�ł���B
	 */
	public Record getHighestRecord(Person p){
		for(Record data:record)
			if(data.person.equals(p))
				return data;
		//�Y������l����������Ȃ������ꍇ�AIllegalArgumentException��
		//�X���[����B
		throw new IllegalArgumentException("Person not found");
	}
	
	/**
	 * �l��ID�ɑΉ�����Perso���C���X�^���X���������L�^�̂����A
	 * �v���C���̂��̂�Ԃ��B
	 * 
	 * @param id�@�p�[�\���f�[�^��ID
	 * @return�@�L�^�f�[�^
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
	 * ���ڂ̃C���f�b�N�X���w�肵�āA���X�g�̃X�R�A��ύX����B
	 * ���ʂ͎����I�ɕ��בւ�����B
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