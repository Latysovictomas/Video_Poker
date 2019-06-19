package org.videopoker.core;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	private ArrayList<Card> deck;
	

	public Deck() {
		deck=new ArrayList<Card>();
		initDeck();
	}

	public void initDeck() {
		//availability=true;
		for(Suit i : Suit.values()) {
			for (int j=2; j<15; j++) {
				this.deck.add(new Card(i,j));
			}
		}
		
	}
	
	public void printDeck() {

		for (Card d:deck) {
	
			System.out.println(d.getSuit()+" "+HighCards.replaceInts(d.getRank()));
		}
	}
	
	public Card getRandomCard() {
		Random rand = new Random();
		int index =rand.nextInt(deck.size());
		Card card = deck.get(index);
		//make this card unavailable
		deck.remove(index);
		return card;
	}
}
