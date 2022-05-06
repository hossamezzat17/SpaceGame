package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.*;

public class SpaceCraft extends Rectangle {
	
	int xVelocity; //SUPERPOWER FASTER IF COLLECTED ITEM 
	SpaceCraft(int x, int y, int CRAFT_WIDTH, int CRAFT_HEIGHT){
		//howa 3ml extend le rectangle we 3ml hna super
		super(x,y,CRAFT_WIDTH,CRAFT_HEIGHT);
	}
	
	public void keyPressed(KeyEvent e) {
		
	}
	
	public void keyReleased(KeyEvent e) {
		
	}
	
	public void setXDirection(int xDirection) {
		
	}
	
	public void move() {
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
		
	}
}
