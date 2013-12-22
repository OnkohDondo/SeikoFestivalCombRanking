package jp.gr.java_conf.onkohdondo.seikofesta.client;

import static jp.gr.java_conf.onkohdondo.seikofesta.client.MainProgram.SETTING_PASSWORD;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MainFrame extends JFrame{
	
	private static final long serialVersionUID =
			2216126776867899524L;
	
	private JLabel label;
	private JTextField textField;
	private JButton button;
	
	private MainProgram mainProgram;
	
	protected MainFrame(MainProgram m){
		mainProgram=m;
		
		//フレーム初期設定
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setUndecorated(true);
		setSize(240,120);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(3,1));
		setAlwaysOnTop(true);
		
		//フレームのコンポネート設定
		label=new JLabel("あなたの名前を入力してください。");
		add(label);
		
		textField=new JTextField(60);
		textField.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				if(textField.getText().equals(SETTING_PASSWORD)){
					mainProgram.openSettings();
				};
			}
			public void keyReleased(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
		add(textField);
		
		button=new JButton("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = textField.getText();
				if(text.length()==0) 
					JOptionPane.showMessageDialog
					(MainFrame.this, "名前を入力してください");
				else if(text.length()>15)
					JOptionPane.showMessageDialog
					(MainFrame.this, "名前は、１５文字以内にしてください");
				else
					mainProgram.setName(text);
			}
		});
		add(button);
	}
	
	public void readStrings(){
		
	}
}
