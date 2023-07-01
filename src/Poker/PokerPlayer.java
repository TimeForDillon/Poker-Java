package Poker;
import java.util.ArrayList;

/**
 * A poker player with tokens and a hand for cards.
 */
public class PokerPlayer
{
	 private ArrayList<Card> playerHand;
	 private int playerTokens;
	 
	 /**
	  * Constructs a PokerPlayer object with 25 tokens and an empty hand.
	  */
	 public PokerPlayer()
	 {
		 this.playerHand = new ArrayList<Card>();
		 this.playerTokens = 25;
	 }
	 
	 /**
	  * Sets the players hand to the passed in set of cards.
	  * @param hand set of cards.
	  */
	 public void setHand(ArrayList<Card> hand)
	 {
		 this.playerHand = hand;
	 }
	 
	 /**
	  * Sets a card in the players hand to a new value.
	  * @param index Spot in players hand.
	  * @param newCard New card from deck.
	  */
	 public void setCard(int index, Card newCard)
	 {
		 this.playerHand.set(index, newCard);
	 }
	 
	 /**
	  * Retrieves the poker players hand.
	  * @return The poker players hand.
	  */
	 public ArrayList<Card> getHand()
	 {
		 return this.playerHand;
	 }
	 
	 /**
	  * Clears the poker players hand.
	  */
	 public void clearHand()
	 {
		 this.playerHand.clear();
	 }
	 
	 /**
	  * Increases the players tokens by the given amount.
	  * @param amount Amount of tokens won.
	  */
	 public void setTokens(int amount)
	 {
		 this.playerTokens += amount;
	 }
	 
	 /**
	  * Retrieves the number of tokens possessed by the poker player.
	  * @return The number of tokens possessed by the poker player.
	  */
	 public int getTokens()
	 {
		 return this.playerTokens;
	 }
	 
	 /**
	  * Retrieves the text list of cards in the players hand.
	  * @return The text list of cards in the players hand.
	  */
	 public String displayHand()
	 {
		 String myHand = "";
		 for(int i = 0; i < this.playerHand.size(); i++)
		 {
			 myHand += (i+1) + ": " + this.playerHand.get(i).displayCard() + "\r";
		 }
		 return myHand;
	 }
}
