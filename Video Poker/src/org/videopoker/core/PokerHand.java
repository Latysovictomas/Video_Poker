package org.videopoker.core;

import java.util.List;

public enum PokerHand {
	STRAIGHT_FLUSH {
		@Override
		boolean matches(List<Card> hand) {
//			if(hand.get(4).getRank()!=11&&hand.get(4).getRank()!=12&&
//					hand.get(4).getRank()!=13&&hand.get(4).getRank()!=14)
//				return false;
			int count=0;
			Suit s=null;
			Suit suit=null;
			
			
			for (int i = 1; i < hand.size(); i++) {
				if (hand.get(i).getRank() != hand.get(i - 1).getRank() + 1) {
					return false;
				}
				// suit match
				if (count == 0) {
					s = hand.get(i-1).getSuit();
					count++;
				} else {
					suit = hand.get(i-1).getSuit();
					if (s != suit)
						return false;
				}
			}
			

			return true;
		}
	},
	STRAIGHT {
		@Override
		boolean matches(List<Card> hand) {
//			if(hand.get(4).getRank()==11||hand.get(4).getRank()==12||
//					hand.get(4).getRank()==13||hand.get(4).getRank()==14)
//				return false;
			int count=0;
			Suit s=null;
			Suit suit=null;
			
			for (int i = 1; i < hand.size(); i++) {
				if (hand.get(i).getRank() != hand.get(i - 1).getRank() + 1) {
					return false;
				}
				if (count == 0) {
					s = hand.get(i-1).getSuit();
					count++;
				} else {
					suit = hand.get(i-1).getSuit();
					if (s == suit)
						return false;
				}
			
			}

			return true;
		}
	},
	
	
	FOUR_OF_A_KIND {
		@Override
		boolean matches(List<Card> hand) {

			int[] rankCount = new int[14];

			/* count up the ranks in the hand */
			for (Card card : hand) {
				rankCount[card.getRank()]++;
			}

			boolean foundHasOne = false;
			boolean foundHasFour = false;

			/*
			 * now evaluate exclusively there must be only a 1 count and a 4 count
			 */
			for (int i = 1; i < rankCount.length; i++) {

				if (rankCount[i] == 1) {
					if (!foundHasOne) {
						foundHasOne = true;
					} else {
						return false;
					}

				} else if (rankCount[i] == 4) {
					if (!foundHasFour) {
						foundHasFour = true;
					} else {
						return false;
					}

				} else if (rankCount[i] != 0) {
					return false;
				}
			}

			return true;
		}
	},
	ROYAL_FLUSH {
		final int[] rfRanks = { 10, 11, 12, 13, 14 };

		@Override
		boolean matches(List<Card> hand) {
			Suit s = null;
			Suit suit = null;
			int count = 0;
			for (int i = 0; i < rfRanks.length; i++) {
				// rank match
				if (rfRanks[i] != hand.get(i).getRank()) {
					return false;
				}
				// suit match
				if (count == 0) {
					s = hand.get(i).getSuit();
					count++;
				} else {
					suit = hand.get(i).getSuit();
					if (s != suit)
						return false;
				}

			}

			return true;
		}
	};

	abstract boolean matches(List<Card> hand);

	public String toString() {
		switch (this) {
		case ROYAL_FLUSH:
			return "Royal Flush";
		case STRAIGHT:
			return "Straight";
		case FOUR_OF_A_KIND:
			return "Four of a kind";
		case STRAIGHT_FLUSH:
			return "Straight Flush";
//		case THREE_OF_A_KIND:
//			return "Three of a kind";
		}
		return null;
	}



}
