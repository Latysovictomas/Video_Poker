package org.videopoker.core;


public class GameMain {
	PrizeTable prizeTable;
	Deck deck;
	Player player;

	public GameMain() {
		prizeTable = new PrizeTable();
		System.out.println();

		deck = new Deck();

		player = new Player();
		// add five cards
		for (int i = 0; i < 5; i++) {
			Card card = deck.getRandomCard();
			player.addCard(card, i);
		}
		// set discard indexes
		System.out.println("Your cards: ");
		player.showHand();
		System.out.println();

		player.playerMove();
		// replace cards
		for (int i = 0; i < player.getDiscardSize(); i++) {
			Card card = deck.getRandomCard();
			player.replaceCard(card, i);
		}

		player.showHand();
		// evaluate hand
		prizeTable.evaluateHand(prizeTable.sortedCopy(player.getHand()));
		System.out.println("Your credits: " + prizeTable.getCredits());

	}

	public static void main(String[] args) {
		new GameMain();

	}

}
