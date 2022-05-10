
package view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	static final int GAME_WIDTH = 1024;
	static final int GAME_HEIGHT = 786;
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	static final int SPACECRAFT_WIDTH = 25;
	static final int SPACECRAFT_HEIGHT = 25;
	static final int LASERSHOT = 10;


	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	SpaceCraft spacecraft;
	SpaceCraft spacecraft2;
	LaserShot lasershot;
	Score score;
	boolean gameOver = false;

	
	GamePanel(){
		newPlayer();
		newEnemy();
		score = new Score();
		this.setFocusable(true);
		this.addKeyListener(new Action());
		this.setPreferredSize(SCREEN_SIZE);
		
		gameThread = new Thread(this);
		gameThread.start();
		
	}
	
	public void newEnemy() {
//		random = new Random();
	}
	
	public void newPlayer() {
		spacecraft = new SpaceCraft(Math.round(GAME_WIDTH/2),600,SPACECRAFT_WIDTH,SPACECRAFT_HEIGHT);
		spacecraft2 = new SpaceCraft(300,600,SPACECRAFT_WIDTH,SPACECRAFT_HEIGHT);

	}
	
	public void paint(Graphics g) {
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image,0,0,this); 
		
		if (gameOver) {
			g.setColor(Color.red);
			g.setFont(new Font("Pixel",Font.BOLD,45));
			g.drawString("GAME OVER!", 450, 600);
		}
		
	}
	
	
	public void draw(Graphics g) {
		spacecraft.draw(g);
		spacecraft2.draw(g);
		
	}
	
	public void move() {
		spacecraft.move();
	}
	
	public void checkCollision() {
		if (spacecraft.intersects(spacecraft2)) {
			gameOver = true;
			System.out.println("TEST");
		}
		
		
		
		//stops spacecraft at screen end 
		if(spacecraft.x<=0) {
			spacecraft.x = 0;
		}
		if(spacecraft.x >= (GAME_WIDTH-SPACECRAFT_WIDTH)) { 
			spacecraft.x = GAME_WIDTH-SPACECRAFT_WIDTH;
		}
	}
	
	public void run() {
/*Intent:
	A game loop runs continuously during gameplay. Each turn of the loop, it processes user input without blocking, updates the game state, and renders the game. It tracks the passage of time to control the rate of gameplay.
	This pattern decouples progression of game time from user input and processor speed.*/
		long LastTime = System.nanoTime();
		double amountofTicks = 60.0;
		double ns = 1000000000 / amountofTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now - LastTime)/ns;
			LastTime = now;
			if(delta >= 1) {
				checkCollision();
				repaint();
				delta--;
			}
		}
	}
	
	public class Action extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			spacecraft.keyPressed(e);
		
		}
		public void keyReleased(KeyEvent e) {
			spacecraft.keyPressed(e);
		}
	}
}
