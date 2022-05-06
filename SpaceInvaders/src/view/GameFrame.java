package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {
	GamePanel panel;

	public GameFrame() {
		panel = new GamePanel();
		this.add(panel);
		this.getContentPane().setBackground(Color.black);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Space Invaders");
		this.pack();
		this.setVisible(true); 


	}
}
