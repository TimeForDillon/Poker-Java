package Poker;
import java.util.ArrayList;
import java.util.Random;

/**
 * A deck of playing cards.
 */
public class DeckOfCards
{
	private ArrayList<Card> deck;
	private ArrayList<Card> pile;
	
	/**
	 * Constructs a DeckOfCards object filled with shuffled cards.
	 */
	public DeckOfCards()
	{
		deck = new ArrayList<Card>();
		pile = new ArrayList<Card>();
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 13; j++)
			{
				Card newCard = new Card(j,i);
				this.deck.add(newCard);
			}
		}
		
		this.shuffle();
	}
	
	/**
	 * Shuffles the deck of cards (randomizes their position within the ArrayList).
	 */
	public void shuffle()
	{
		ArrayList<Card> shuffledDeck = new ArrayList<Card>();
		Random randomizer = new Random();
		
		// Remove each card randomly and put into another deck.
		while (this.deck.size() > 0)
		{
		   int i = randomizer.nextInt(this.deck.size());
		   shuffledDeck.add(this.deck.get(i));
		   this.deck.remove(i);
		}
		
		// Remove each card randomly from the other deck and put back into the original.
		while (shuffledDeck.size() > 0)
		{
		   int i = randomizer.nextInt(shuffledDeck.size());
		   this.deck.add(shuffledDeck.get(i));
		   shuffledDeck.remove(i);
		}
	}
	
	/**
	 * Retrieves first 5 top cards in the deck. Moves these cards from the deck to a burn pile. 
	 * @return First 5 top cards in the deck. 
	 */
	public ArrayList<Card> dealHand()
	{
		ArrayList<Card> hand = new ArrayList<Card>();
		for(int i = 0; i < 5; i++)
		{
			hand.add(this.deck.get(i));
			this.pile.add(this.deck.get(i));
			this.deck.remove(i);
		}
		//System.out.print(this.deck.size() + this.pile.size());
		return hand;
	}
	
	/**
	 * Retrieves the top card in the deck. Moves the card from the deck to a burn pile.
	 * @return The top card in the deck.
	 */
	public Card dealCard()
	{
		Card newCard = this.deck.get(0);
		this.pile.add(this.deck.get(0));
		this.deck.remove(0);
		//System.out.print(this.deck.size() + this.pile.size());
		return newCard;
	}
	
	/**
	 * Retrieves the number of remaining cards in the deck.
	 * @return The number of remaining cards in the deck.
	 */
	public int cardsRemaining()
	{
		return this.deck.size();
	}
	
	/**
	 * Returns the cards in the burn pile back to the deck and shuffles it.
	 */
	public void resetDeck()
	{
		if(this.pile.size()>0)
		{
			for(int i = 0; i < this.pile.size(); i++)
			{
				this.deck.add(this.pile.get(i));
				this.pile.remove(i);
				this.shuffle();
			}
		}
		else this.shuffle();
	}
}
