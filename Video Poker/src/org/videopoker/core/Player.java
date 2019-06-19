package org.videopoker.core;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

	private Card[] hand;
	private static Scanner in;
	private ArrayList<Integer> discard;

	public Player() {

		hand = new Card[5];
	}

	public void addCard(Card c, int pos) {
		this.hand[pos] = c;

	}

	public void showHand() {
		for (int i = 0; i < hand.length; i++) {
			Card h = hand[i];
			System.out.println((i + 1) + ". " + h.getSuit() + " " + HighCards.replaceInts(h.getRank()));

		}
	}

	public Card[] getHand() {
		return hand;
	}

	public void replaceCard(Card c, int index) {

		int val = discard.get(index);
		hand[val] = c;

	}

	public int getDiscardSize() {
		return discard.size();
	}

	public void playerMove() {
		System.out.println("Please, type which card(s) to discard [1-5] and/or type 'draw' to evaluate your cards: ");
		discard = new ArrayList<Integer>();

		int count = 0;

		try {
			in = new Scanner(System.in);
			while (in.hasNext()) {
				if (in.hasNextInt()) {
					int dis = in.nextInt() - 1;
					if (count != 5 && !discard.contains(dis)) {

						discard.add(dis);
						count++;

					} ////////////
					else {
						if (count >= 5) {
							System.out.println("You have already seleted 5 cards.");
						} else if (discard.contains(dis)) {
							System.out.println("Your card has already been selected: " + (dis + 1));
						}
					}

				} else {
					String input = in.next();
					if (input.equalsIgnoreCase("DRAW")) {
						// System.out.println("Exiting");
						break;
					} else {
						System.out.println("Not valid. Enter[1-5] or 'draw'."); // same card twice?
					}
				}

			}
		} catch (Exception e) {
			System.out.println("Exiting program.");
		}

	}

}
