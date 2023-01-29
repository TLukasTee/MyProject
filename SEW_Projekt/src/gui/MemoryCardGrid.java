package gui;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.CardColor;
import models.CardModel;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class MemoryCardGrid extends JPanel {
	
	
	private List<CardModel> cards;
	private int howManyCards = 16;
	public static MemoryCardGrid gui = new MemoryCardGrid();
	 
	public MemoryCardGrid() {
		cards = new ArrayList<>();
        createBoardLayout();
        createCards();
        addCards();
	}
	
	public void createBoardLayout() {
	       
	       setLayout(new GridLayout(4, 4, 80, 80));
	       setBorder(new EmptyBorder(70, 205, 70, 205));
	              
	    
	}
	   
	public void createCards() {
	        for (int i = 0; i < howManyCards; i++) {
	            CardModel card = new CardModel(howManyCards);
	            cards.add(card);
	        }

	        //Add color to cards
	        int indexOfColor = 0;

	        for (int i = 0; i < howManyCards; i += 2) {
	            cards.get(i).setColor(CardColor.getColorCard(indexOfColor));
	            cards.get(i + 1).setColor(CardColor.getColorCard(indexOfColor));
	            indexOfColor++;
	        }
	    }

	    /**
	     * Random adding cards to board
	     */
	    public void addCards() {
	        int counter = 0;
	        Random random = new Random();
	        int i;

	        while (counter < howManyCards) {
	            i = random.nextInt(howManyCards);

	            if (!cards.get(i).isCreated()) {
	                add(cards.get(i));
	                cards.get(i).setCreated(true);
	                counter++;
	            }
	        }
	    }

	    public List<CardModel> getCards() {
	        return cards;
	    }

}
