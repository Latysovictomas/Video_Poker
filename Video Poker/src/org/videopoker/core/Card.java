package org.videopoker.core;

public class Card {
	
	
	public static final String ACE_STRING = "Ace";
	public static final String KING_STRING = "King";
	public static final String QUEEN_STRING = "Queen";
	public static final String JACK_STRING = "Jack";

	private final int mRank;
	private final Suit mSuit;

	public Card(Suit s, int r) {
		this.mSuit = s;

		if (r < 2 || r > 14) {
			throw new IllegalArgumentException("No such card with rank: " + r);
		}

		this.mRank = r;
	}

	public Suit getSuit() {
		return mSuit;
	}

	public int getRank() {
		return mRank;
	}
}
