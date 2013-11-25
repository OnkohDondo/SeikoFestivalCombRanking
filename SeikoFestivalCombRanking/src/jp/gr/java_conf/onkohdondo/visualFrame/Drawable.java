package jp.gr.java_conf.onkohdondo.visualFrame;

import java.awt.Graphics2D;

public interface Drawable {
	void setup(Graphics2D g,int id);
	void draw(Graphics2D g,int id);
}
