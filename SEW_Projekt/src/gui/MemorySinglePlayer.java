package gui;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class MemorySinglePlayer extends JFrame {

	
	private static MemorySinglePlayer frame;

	private MemorySinglePlayer() {
		
		setTitle("Memory Spiel | Einzelspieler");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("../images/logo.png")).getImage());
		setSize(new Dimension(1280, 1024));
		setLocationRelativeTo(null);
		setVisible(true);
		setIconImage(new ImageIcon(getClass().getResource("../images/logo.png")).getImage());
		add(new MemoryGameSetup());

	}
	
	
	
	public static MemorySinglePlayer getInstanceOf() {
		if (frame == null)
			frame = new MemorySinglePlayer();

		return frame;
	}
}
