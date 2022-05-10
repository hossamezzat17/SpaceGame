package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.*;

public class SpaceCraft extends Rectangle {
	
	int moveDirection = 10;
	int xVelocity; //how fast when pressed,SUPERPOWER FASTER IF COLLECTED ITEM 

	SpaceCraft(int x, int y, int CRAFT_WIDTH, int CRAFT_HEIGHT){
		//howa 3ml extend le rectangle we 3ml hna super
		super(x,y,CRAFT_WIDTH,CRAFT_HEIGHT);
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==39) {
			setXDirection(moveDirection);
			move();
		}
		if(e.getKeyCode()==37) {
			setXDirection(-moveDirection);
			move();
		}
	}
	
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==39) {
			setXDirection(0);
			move();
		}
		if(e.getKeyCode()==37) {
			setXDirection(0);
			move();
		}
	}
	
	public void setXDirection(int xDirection) {
		xVelocity = xDirection;
	}
	
	public void move() {
		x = x +xVelocity;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
		
	}
}
