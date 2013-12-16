package jp.gr.java_conf.onkohdondo.visualFrame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class VisualFrame extends JFrame {
	
	private static final long serialVersionUID = 
			-5710970358529875400L;
	
	public final int FRAME_ID;
	private static int nextID;
	
	Drawable drawable;
	boolean setupped;
	public BufferStrategy bst;
	
	public VisualFrame(Drawable d) throws HeadlessException {
		super();
		FRAME_ID=nextID;
		setup(d);
	}

	public VisualFrame(GraphicsConfiguration arg0,Drawable d) {
		super(arg0);
		FRAME_ID=nextID;
		setup(d);
	}

	public VisualFrame(String arg0,Drawable d) 
			throws HeadlessException {
		super(arg0);
		FRAME_ID=nextID;
		setup(d);
	}

	public VisualFrame(String arg0, GraphicsConfiguration arg1,
			Drawable d) {
		super(arg0, arg1);
		FRAME_ID=nextID;
		setup(d);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D graphics=(Graphics2D) g;
		if(!setupped){
			drawable.setup(graphics,FRAME_ID);
			setupped=true;
		}
		drawable.draw(graphics, FRAME_ID);
	}
	
	private void setup(Drawable d){
		nextID++;
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		drawable=d;
	}

}
