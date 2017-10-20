
import java.util.ArrayList;

/**
 * Exercise 5 of ThinkAPJava Chapter 15
 * The PokerHand class finds probabilities for the different poker hands.
 */
public class PokerHand extends Deck {
	
	Card[] hand;
	static int cardNum;

	public PokerHand(int n) {
		cardNum = n;	//specifies whether it's a hand of five or a hand of seven
		hand = dealCards();
	}

	/**
	 * Creates a poker hand
	 */
	public PokerHand(Card[] hand) {
		this.hand = hand;
	}

	/**
	 * Creates an array of Cards with no repeats
	 */
	public Card[] dealCards() {
		Deck deck = new Deck();
		Card[] hand = new Card[cardNum];
		int i = 0;
		
		while (i < cardNum) {	//creates new deck following size limitation
			deck.shuffle();
			Card newDeck = deck.cards[0];
			boolean equal = false;
			
			for (int j = 0; j < i; j++) {	//checks for duplicates of cards
				if (newDeck.equals(hand[j])) {
					equal = true;
				}
			}
			
			if (!equal) {
				hand[i] = newDeck;
				i++;
			}
		}
		
		return hand;
	}

	/**
	 * Creates a poker hand of non-repeating, randomly chosen cards
	 */
	public PokerHand deal() {
		return new PokerHand(dealCards());
	}

	/**
	 * Prints cards in a hand
	 */
	public void print() {
		for (int i = 0; i < hand.length; i++) {
			hand[i].print();
		}
	}

	/**
	 * Finds whether or not a specified hand has a flush (five cards same suit)
	 */
	public boolean hasFlush() {
		int suit = hand[0].suit;
		
		for (int i = 0; i < hand.length; i++) {	//checks hand for flush
			if (hand[i].suit != suit) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * Finds whether or not a specified hand has three of a kind (three cards same rank)
	 */
	public boolean hasThreeKind() {
		int[] counter = new int[cardNum];	//counter
		int[] rank = new int[cardNum];	//ranks of the cards

		for (int i = 0; i < hand.length; i++) {	//fills the array for rank
			rank[i] = hand[i].rank;
		}
		
		for (int i = 0; i < hand.length; i++) {	//checks for three of a kind
			for (int j = 0; j < hand.length; j++) {
				if (i != j && rank[i] == rank[j]) {
					counter[i]++;
					if (counter[i] >= 3)
						return true;
				}
			}
		}

		return false;
	}

	/**
	 * Finds whether or not a specified hand has a two pair (two pairs of two cards of same rank)
	 */
	public boolean hasTwoPair() {
		int[] counter = new int[cardNum];	//counter
		int[] rank = new int[cardNum];	//ranks of the cards
		
		int[][] has = {{-1, -1}, {-1, -1}}; //represents if the first or second pair is found, -1 representing false and 1 representing true

		for (int i = 0; i < hand.length; i++) {	//fills the rank array
			rank[i] = hand[i].rank;
		}
		
		for (int i = 0; i < hand.length; i++) {	//checks if there are pairs
			for (int j = 0; j < hand.length; j++) {
				if (i != j && rank[i] == rank[j]) {
					counter[i]++;
					if (counter[i] >= 2) {
						if (has[0][0] != 1) {
							has[0][0] = 1;
							has[0][1] = rank[i];
						} else if (has[0][0] == 1 && has[0][1] != rank[i]) {
							has[1][0] = 1;
							has[1][1] = rank[i];
						}
					}
				}
			}
		}

		if (has[0][0] == 1 && has[1][0] == 1) {	//checks truth values
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Finds whether or not a specified hand has four of a kind (four of same rank)
	 */
	public boolean hasFourKind() {
		int[] counter = new int[cardNum];	//counter
		int[] rank = new int[cardNum];	//stores ranks of the cards

		for (int i = 0; i < hand.length; i++) {	//fills the rank array
			rank[i] = hand[i].rank;
		}
		
		for (int i = 0; i < hand.length; i++) {	//checks for four of a kind
			for (int j = 0; j < hand.length; j++) {
				if (i != j && rank[i] == rank[j]) {
					counter[i]++;
					if (counter[i] >= 4)
						return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		
		cardNum = 5;	//can be changed
		
		ArrayList<PokerHand> hands = new ArrayList<PokerHand>();	//create four new PokerHands
		for (int i = 0; i < 4; i++) {
			hands.add(new PokerHand(cardNum));
		}
		
		for (int i = 0; i < hands.size(); i++) {
			hands.get(i).print();
		}
		
		ArrayList<PokerHand> hands2 = new ArrayList<PokerHand>();
		int numberHands = 10000;
		
		for (int i = 0; i < numberHands; i++) {
			hands2.add(new PokerHand(cardNum));
		}
		
		int countFlush = 0;
		int countThree = 0;
		
		for (int i = 0; i < numberHands; i++) {
			if (hands2.get(i).hasFlush()) {
				countFlush++;
			}
			if (hands2.get(i).hasThreeKind()) {
				countThree++;
			}
		}
		System.out.println("Flushes: " + countFlush + "\nThree of a kinds: " + countThree
				+ "\nin " + numberHands);
	}
}