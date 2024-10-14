package LojaMeLetra;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Loja {

	public static void main(String[] args) {
		boolean isTurn = true;

		Eights loja = new Eights();
		Scanner userInput = new Scanner(System.in);
		while (loja.checkGameOver()) {
			System.out.println("Mid card is " + loja.getMidCards().getCard(loja.getMidCards().getDeck().size() - 1));
			if (isTurn) {

				IntStream.range(0, loja.getPlayer(1).getDeck().size())
						.forEach(i -> System.out.println(i + "->" + loja.getPlayer(1).getCard(i)));

				System.out.println("Player 1 put a card in the middle, type 100 to draw a card from the pile or type 200 if finished :");

				int nCard = userInput.nextInt();
				if (nCard == 100) {
					loja.getPlayer(1).addCard(loja.getCardFromPile());
				} else if (nCard == 200)
					isTurn = false;
				else {

					if (loja.isValid(loja.getPlayer(1), nCard) == false)
						System.out.println("cant do that try to draw!");
					else
						loja.putCardMiddle(loja.getPlayer(1), nCard);
				}

			} else {
				IntStream.range(0, loja.getPlayer(2).getDeck().size())
						.forEach(i -> System.out.println(i + "->" + loja.getPlayer(2).getCard(i)));
				System.out.println("Player 2 put a card in the middle, type 100 to draw a card from the pile or type 200 if finished :");

				int nCard2 = userInput.nextInt();
				if (nCard2 == 100) {
					loja.getPlayer(2).addCard(loja.getCardFromPile());
				} else if (nCard2 == 200)
					isTurn = true;
				else {

					if (loja.isValid(loja.getPlayer(2), nCard2) == false)
						System.out.println("cant do that try to draw!");
					else
						loja.putCardMiddle(loja.getPlayer(2), nCard2);
				}
			}

			loja.GameOver();
		}
	}

}
