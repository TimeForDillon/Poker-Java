package Poker;
/**
 * A playing card from a deck of cards with suit and rank.
 */
public class Card
{
	private int rank;
	private int suit;
	
	/**
	 * Constructs a Card object with the given rank and suit.
	 * @param rank Rank of the playing card.
	 * @param suit Suit of the playing card.
	 */
	public Card(int rank, int suit)
	{
		this.rank = rank;
		this.suit = suit;
	}
	
	/**
	 * Retrieves the rank of the card.
	 * @return The rank of the card.
	 */
	public int getRank()
	{
		return this.rank;
	}
	
	/**
	 * Retrieves the suit of the card.
	 * @return The suit of the card.
	 */
	public int getSuit()
	{
		return this.suit;
	}
	
	/**
	 * Retrieves the rank and suit of card in text format.
	 * @return The rank and suit of card in text format.
	 */	
	public String displayCard()
	{
		String cardName = "";
		
		if(this.rank==0) cardName += "Ace";
		else if(this.rank==10) cardName += "Jack";
		else if(this.rank==11) cardName += "Queen";
		else if(this.rank==12) cardName += "King";
		else cardName += (this.rank+1);
		
		if(this.suit==0) cardName += " of Clubs";
		else if(this.suit==1) cardName += " of Diamonds";
		else if(this.suit==2) cardName += " of Hearts";
		else if(this.suit==3) cardName += " of Spades";
		
		return cardName;
	}
}
