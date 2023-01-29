package models;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;

public class CardModel extends JButton {

	private ImageIcon icon;
	private Color color;

	private boolean isCreated;
	private boolean geklickt;

	public CardModel(int gridsize) {

		isCreated = false;
		icon = new ImageIcon(getClass().getResource("../images/logo.png"));
		setFocusPainted(false);
		setmainCard();

		setCursor(new Cursor(Cursor.HAND_CURSOR));

		addActionListener((e) -> {
			setIcon(null);
			setBackground(color);
			setEnabled(false);
			geklickt = true;
		});
	}

	public void setmainCard() {
		setIcon(icon);
		setDisabledIcon(icon);
		setBackground(Color.WHITE);
		geklickt = false;
		setEnabled(true);
	}

	public boolean isClicked() {
		return geklickt;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public boolean isCreated() {
		return isCreated;
	}

	public void setCreated(boolean addedToBoard) {
		this.isCreated = addedToBoard;
	}

}
