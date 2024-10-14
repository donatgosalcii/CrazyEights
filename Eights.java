package LojaMeLetra;

import java.util.Scanner;

public class Eights {

	private Deck player1Deck;
	private Deck player2Deck;
	private Deck midCards;
	private Deck pile;

	public Eights() {
		StartGame();
	}

	private void StartGame() {
		System.out.println("Welcome to Crazy Eights");
		Deck playingDeck = new Deck();
		playingDeck.getDeck();

		playingDeck.shuffle();
		while (playingDeck.getCard(0).getFaceName().equals("8")) {
			playingDeck.shuffle();
		}
		// create a deck for player 1
		player1Deck = new Deck(1);
		player2Deck = new Deck(2);
		pile = playingDeck;
		midCards = new Deck(3);
		midCards.addCard(pile.getCard(0));
		pile.removeCard(0);

		for (int i = 0; i < playingDeck.getDeck().size(); i++) {

			if (i % 2 == 0 && player1Deck.getDeck().size() < 5) {
				player1Deck.addCard(playingDeck.getCard(i));
				pile.removeCard(i);
			} else if (i % 2 != 0 && player2Deck.getDeck().size() < 5) {
				player2Deck.addCard(playingDeck.getCard(i));
				pile.removeCard(i);

			}

		}

	}

	public Deck getMidCards() {
		return midCards;
	}

	public Deck getPlayer(int i) {
		if (i == 1) {
			return player1Deck;
		}
		return player2Deck;
	}

	public boolean isValid(Deck currentPlayerDeck, int i) {
		if (currentPlayerDeck.getCard(i).getFaceName() == midCards.getCard(midCards.getDeck().size() - 1).getFaceName()
				|| currentPlayerDeck.getCard(i).getSuit() == midCards.getCard(midCards.getDeck().size() - 1)
						.getSuit()) {
			return true;
		}
		return false;
	}

	public void putCardMiddle(Deck currentPlayerDeck, int i) {

		midCards.addCard(currentPlayerDeck.getCard(i));
		currentPlayerDeck.removeCard(i);

	}

	public Card getCardFromPile() {

		Card card = pile.getCard(0);
		pile.removeCard(0);
		return card;
	}

	public boolean checkGameOver() {

		if (player1Deck.getDeck().size() == 0 || player2Deck.getDeck().size() == 0 || player1Deck.getDeck().size() == 0
				|| pile.getDeck().size() == 0)
			return false;
		return true;

	}

	public static int checkPoints(Deck currDeck) {
		int sum = 0;
		for (int i = 0; i < currDeck.getDeck().size(); i++) {
			sum += currDeck.getCard(i).getValue();
		}
		return sum;
	}

	public void GameOver() {
		if (player1Deck.getDeck().size() == 0) {
			System.out.println("player 1 winner");
		} else if (player2Deck.getDeck().size() == 0) {
			System.out.println("player 2 winner");
		} else if (pile.getDeck().size() == 0) {
			if (checkPoints(player1Deck) < checkPoints(player2Deck)) {

				System.out.println("player 1 winner");
			} else
				System.out.println("player 2 winner");
		}

	}

}
