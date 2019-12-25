package com.java.samples.enumeration;

//It is not type-safe. You can assign any int value (e.g., 88) into the int variable suit.
//No namespace: You must prefix the constants by the class name CardSuit.
//Brittleness: new constants will break the existing codes.
//Printed values are uninformative: printed value of 0, 1, 2 and 3 are not very meaningful.

import java.util.*;

// TODO: demo
interface ISuit {
	public String shape();
}

enum Suit implements ISuit {
	SPADE, DIAMOND, CLUB, HEART;

	@Override
	public String shape() {
		return this.name();
	}
}

enum Rank {
	ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
}

class Card { // A card
	private Suit suit;
	private Rank rank;

	Card(Suit suit, Rank rank) { // constructor
		this.suit = suit;
		this.rank = rank;
	}

	Rank getRank() {
		return rank;
	}

	Suit getSuit() {
		return suit;
	}

	public String toString() {
		return "This card is " + rank + " of " + suit;
	}
}

class CardDeck { // A deck of card
	List<Card> deck;

	CardDeck() { // constructor
		deck = new ArrayList<Card>();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deck.add(new Card(suit, rank));
			}
		}
	}

	public void print() {
		for (Card card : deck)
			System.out.println(card); // print all cards
	}

	public void shuffle() {
		Collections.shuffle(deck); // use java.util.Collections' static method
									// to shuffle the List
	}
}

public class CardTest {
	public static void main(String[] args) {
		Suit s = Suit.SPADE;
		System.out.println(s.toString());
		System.out.println(Suit.values());
		for (Suit suit : Suit.values()) {
			System.out.println(suit);
		}

		CardDeck deck = new CardDeck();
		deck.print();
		deck.shuffle();
		deck.print();
	}
}
