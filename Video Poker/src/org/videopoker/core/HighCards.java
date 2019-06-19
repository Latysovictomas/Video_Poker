package org.videopoker.core;

public class HighCards {
	public static final int ACE = 14;
	public static final int KING = 13;
	public static final int QUEEN = 12;
	public static final int JACK = 11;
	public static final String ACE_STRING = "Ace";
	public static final String KING_STRING = "King";
	public static final String QUEEN_STRING = "Queen";
	public static final String JACK_STRING = "Jack";

	public static String replaceInts(int r) {
		String rank;
		if (r== JACK) {
			rank= JACK_STRING;
		} else if(r==QUEEN) {
			rank = QUEEN_STRING;
		} else if (r==KING) {
			rank = KING_STRING;
		} else if(r==ACE){
			rank = ACE_STRING;
		} else {
			rank=String.valueOf(r);
		}
		
		return rank;
	}
}
