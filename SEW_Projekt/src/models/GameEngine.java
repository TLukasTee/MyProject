package models;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import gui.MemoryGameSetup;

public class GameEngine extends Thread {

	private static boolean currentstate;
	private static int tries;
	private int successpair;
	private InGameLayout cardLayout;

	public GameEngine(InGameLayout userPanel) {
		this.cardLayout = userPanel;
		tries = 0;
		successpair = 0;
		currentstate = true;
	}

	public void run() {

		List<CardModel> cardmodel = cardLayout.getCards();
		
		while (true) {
			int firstCard = -1;
			int secondCard = -1;
			int cardClicked = 0;

			for (int i = 0; i < cardmodel.size() && cardClicked < 2; i++) {
				if (cardmodel.get(i).isClicked()) {
					if (firstCard == -1)
						firstCard = i;
					else
						secondCard = i;

					cardClicked++;
				}
			}

			if (cardClicked == 2) {
				System.out.println(successpair);
				for (CardModel card : cardmodel)
					card.setEnabled(false);

				try {
					Thread.sleep(2000);
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (cardmodel.get(firstCard).getColor().equals(cardmodel.get(secondCard).getColor())) {
					successpair++;
					cardmodel.get(firstCard).setVisible(false);
					cardmodel.get(secondCard).setVisible(false);
				}

				if (currentstate) {
					tries++;
					cardLayout.setAttemptsLabelText(String.format("%03d", tries));

					for (CardModel card : cardmodel)
						card.setmainCard();
				}
			}

			if (successpair == 16 / 2) {
				InGameLayout.getTimer().setTimeRunning(false);
				currentstate = false;
				gameWin();
				successpair = 0;
			}
		}
	}

	public static void setPlaying(boolean playing) {
		GameEngine.currentstate = playing;
	}

	public static int getAttempts() {
		return tries;

	}

	public void gameWin() {
		
		
	
		JOptionPane.showMessageDialog(null, "Glückwunsch! Du hast gewonnen!");

	}
}
