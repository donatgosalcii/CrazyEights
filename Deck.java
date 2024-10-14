package LojaMeLetra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

	private ArrayList<Card> deck;

	public Deck(ArrayList<Card> deck) {
		this.deck = deck;
	}

	public Deck(int player) {
		deck = new ArrayList<Card>();
	}

	public Deck() {
		List<String> suits = Card.getValidSuits();

		List<String> faceNames = Card.getValidFaceNames();

		deck = new ArrayList<>();

		for (String suit : suits) {
			for (String faceName : faceNames)
				if (faceName == "jack" || faceName == "queen" || faceName == "king" || faceName == "10")
					deck.add(new Card(faceName, suit, 10));
				else if (faceName == "ace")
					deck.add(new Card(faceName, suit, 1));
				else if (faceName == "8")
					deck.add(new Card(faceName, suit, 50));
				else
					deck.add(new Card(faceName, suit, Integer.parseInt(faceName)));

		}
	}

	/* na jep deck te letrave */
	public ArrayList<Card> getDeck() {
		return deck;
	}

	public String toString() {
		String CardListOut = "";

		for (Card aCard : deck) {
			CardListOut += "\n " + aCard.toString();
		}

		return CardListOut;
	}

	public void shuffle() {
		ArrayList<Card> tempDeck = new ArrayList<Card>();
		Random random = new Random();
		int randomCardIndex = 0;
		int originalSize = this.deck.size();
		for (int i = 0; i < originalSize; i++) {
			randomCardIndex = random.nextInt((this.deck.size() - 1 - 0) + 1) + 0;
			tempDeck.add(this.deck.get(randomCardIndex));
			this.deck.remove(randomCardIndex);
		}
		this.deck = tempDeck;

	}

	public void removeCard(int i) {
		this.deck.remove(i);
	}

	public Card getCard(int i) {
		return this.deck.get(i);
	}

	public void addCard(Card addCard) {
		this.deck.add(addCard);
	}

	public void draw(Deck comingFrom) {
		this.deck.add(comingFrom.getCard(0));
		comingFrom.removeCard(0);
	}

}


