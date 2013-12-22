package jp.gr.java_conf.onkohdondo.seikofesta.server;


/**
 * �Q���҂��Ǘ�����N���X�BSuicaID�A�o�^���A�e��Q�[����ł̓_�����L�^�����B
 * 
 * @author Onkoh Dondo
 *
 */
public class Person {
	
	/**
	 * �Q���҂�Suica/Pasmo��ID�ԍ��iIDm�j�B<br>
	 * �R���X�g���N�^���s���Ɏw�肳��A�����ύX�ł��Ȃ��B
	 * 
	 * @see Person#getSuicaid()
	 */
	private int suicaid;
	
	/**
	 * �Q���҂̖��O�B
	 * 
	 * @see Person#getName()
	 */
	private String name;
	
	public Person(int id,String name){
		setSuicaid(id);
		setName(name);
	}
	
	/**
	 * Suica/Pasmo��ID�ԍ��iIDm�j���擾����B
	 * 
	 * @return�@Suica/Pasmo��IDm
	 */
	public int getSuicaid() {
		return suicaid;
	}

	private void setSuicaid(int suicaid) {
		this.suicaid = suicaid;
	}

	/**
	 * �Q���҂̖��O���擾����B
	 * 
	 * @return �Q���҂̖��O
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
