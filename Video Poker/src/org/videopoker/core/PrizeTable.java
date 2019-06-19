package org.videopoker.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrizeTable {
	private final int ROYAL_FLUSH_PRIZE = 800;
	private final int STRAIGHT_FLUSH_PRIZE = 50;
	private final int FOUR_OF_A_KIND_PRIZE = 25;
	private final int FULL_HOUSE_PRIZE = 9;
	private final int FLUSH_PRIZE = 6;
	private final int STRAIGHT_PRIZE = 4;
	private final int THREE_OF_A_KIND_PRIZE = 3;
	private final int TWO_PAIR_PRIZE = 2;
	private final int JACKS_OR_BETTER_PRIZE = 1;
	private final int ALL_OTHER_PRIZE = 0;

	private final String ROYAL_FLUSH = "Royal Flush";
	private final String STRAIGHT_FLUSH = "Straight Flush";
	private final String FOUR_OF_A_KIND = "Four of a kind";
	private final String FULL_HOUSE = "Full House";
	private final String FLUSH = "Flush";
	private final String STRAIGHT = "Straight";
	private final String THREE_OF_A_KIND = "Three of a kind";
	private final String TWO_PAIR = "Two Pair";
	private final String JACKS_OR_BETTER = "Jacks or Better";
	private final String ALL_OTHER = "All other";

	private final String HAND = "Hand";
	private final String PRIZE = "Prize";

	private int credits;

	public PrizeTable() {
		this.credits = 0;
		printTable();
		System.out.println();
		System.out.println("Your credits: " + credits);
	}

	public void printTable() {
		System.out.printf("%-15s %-15s\n", this.HAND, this.PRIZE);
		System.out.printf("%-15s %-15s\n", this.ROYAL_FLUSH, this.ROYAL_FLUSH_PRIZE);
		System.out.printf("%-15s %-15s\n", this.STRAIGHT_FLUSH, this.STRAIGHT_FLUSH_PRIZE);
		System.out.printf("%-15s %-15s\n", this.FOUR_OF_A_KIND, this.FOUR_OF_A_KIND_PRIZE);
		System.out.printf("%-15s %-15s\n", this.FULL_HOUSE, this.FULL_HOUSE_PRIZE);
		System.out.printf("%-15s %-15s\n", this.FLUSH, this.FLUSH_PRIZE);
		System.out.printf("%-15s %-15s\n", this.STRAIGHT, this.STRAIGHT_PRIZE);
		System.out.printf("%-15s %-15s\n", this.THREE_OF_A_KIND, this.THREE_OF_A_KIND_PRIZE);
		System.out.printf("%-15s %-15s\n", this.TWO_PAIR, this.TWO_PAIR_PRIZE);
		System.out.printf("%-15s %-15s\n", this.JACKS_OR_BETTER, this.JACKS_OR_BETTER_PRIZE);
		System.out.printf("%-15s %-15s\n", this.ALL_OTHER, this.ALL_OTHER_PRIZE);
	}


	public int getArrayIndex(Card[] arr, Card value) {

		int k = 0;
		for (int i = 0; i < arr.length; i++) {

			if (value.equals(arr[i])) {
				k = i;
				break;
			}
		}
		return k;
	}



	public List<Card> sortedCopy(Card[] hand) {
		List<Card> sortedHand = new ArrayList<Card>(Arrays.asList(hand));
//		//
//		sortedHand.clear();
//		sortedHand.add(new Card(Suit.Clubs,11));
//		sortedHand.add(new Card(Suit.Hearts,11));
//		sortedHand.add(new Card(Suit.Diamonds,11));
//		sortedHand.add(new Card(Suit.Spades,11));
//		sortedHand.add(new Card(Suit.Clubs,6));
//		//

		//asc, not desc
		Collections.sort(sortedHand, new Comparator<Card>() {
			@Override
			public int compare(Card card1, Card card2) {
				int rank1 = card1.getRank();
				int rank2 = card2.getRank();

				if (rank1 > rank2)
					return 1;

				if (rank1 < rank2)
					return -1;

				return 0;

			}
		});


		return sortedHand;
	}
	public void evaluateHand(List<Card> hand) {
		int prize=0;
	    for (PokerHand potential : PokerHand.values()) {
	        if (potential.matches(hand)) {
	        	if(potential.toString()==ROYAL_FLUSH) {
	        	prize = ROYAL_FLUSH_PRIZE;
	        	credits=credits+prize;
	        	} 
	        	else if (potential.toString()==STRAIGHT_FLUSH) {
	        		prize = STRAIGHT_FLUSH_PRIZE;
		        	credits=credits+prize;
	        	}
	        	else if (potential.toString()==FOUR_OF_A_KIND) {
	        		prize = FOUR_OF_A_KIND_PRIZE;
		        	credits=credits+prize;
	        	}
	        	else if (potential.toString()==FULL_HOUSE) {
	        		prize = FULL_HOUSE_PRIZE;
		        	credits=credits+prize;
	        	}
	        	else if (potential.toString()==FLUSH) {
	        		prize = FLUSH_PRIZE;
		        	credits=credits+prize;
	        	}
	        	else if (potential.toString()==STRAIGHT) {
	        		prize = STRAIGHT_PRIZE;
		        	credits=credits+prize;
	        	}
	        	else if (potential.toString()==THREE_OF_A_KIND) {
	        		prize = THREE_OF_A_KIND_PRIZE;
		        	credits=credits+prize;
	        	}else if (potential.toString()==TWO_PAIR) {
	        		prize = TWO_PAIR_PRIZE;
		        	credits=credits+prize;
	        	}
	        	else if (potential.toString()==JACKS_OR_BETTER) {
	        		prize = JACKS_OR_BETTER_PRIZE;
		        	credits=credits+prize;
	        	}
	        	else if (potential.toString()==ALL_OTHER) {
	        		prize = ALL_OTHER_PRIZE;
		        	credits=credits+prize;
	        	}

	    }	
	        	
	           // return potential;
	    }

	    
	}
	public int getCredits() {
		return credits;
	}
	
}
