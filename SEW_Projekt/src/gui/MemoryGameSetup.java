package gui;

import java.awt.BorderLayout;

import javax.swing.JComponent;

import models.GameEngine;
import models.InGameLayout;

public class MemoryGameSetup extends JComponent {

	public MemoryGameSetup() {

		MemoryCardGrid cardsPanel = new MemoryCardGrid();
		InGameLayout userPanel = new InGameLayout(cardsPanel.getCards());
		GameEngine gameEngine = new GameEngine(userPanel);

		cardsPanel.setOpaque(false);

		setLayout(new BorderLayout());
		
		add(cardsPanel, BorderLayout.CENTER);
		add(userPanel, BorderLayout.SOUTH);

		gameEngine.start();

	}

}
