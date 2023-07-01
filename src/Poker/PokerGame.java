package Poker;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A utility class for scoring a poker game.
 */
public final class PokerGame
{
	/**
	 * Constructs a PokerGame object.
	 */
	private PokerGame() {}
	
	/**
	 * Scores a PokerPlayer's hand of cards for video poker.
	 * @param hand PokerPlayer's hand of cards.
	 * @return The score of the PokerPlayer's hand.
	 */
	public static int scoreHand(ArrayList<Card> hand)
	{
		int suitCount=1; //counts number of same suits.
		int straightCount=1; //counts consecutive numbers
		int straightSum=0; //sums ranks
		
		//sorts rank values in order
		ArrayList<Integer> cardRankValues = new ArrayList<Integer>();
		for(int i = 0; i<hand.size(); i++)
		{
			cardRankValues.add(hand.get(i).getRank());
		}
		
		//static method from the util collections class to sort my list for me in descending order
		Collections.sort(cardRankValues);
		//static method as well that reverses the order to ascending order
		Collections.reverse(cardRankValues);
		
		int[] runs = new int[] {1,1,1,1};

		//test pair, trips, quads, and fullhouse
		for(int i=0; i<cardRankValues.size()-1; i++)
		{
			for(int j=i+1; j<cardRankValues.size(); j++)
			{
				if(cardRankValues.get(i) == cardRankValues.get(j))
				{
					runs[i]++;
				}
				else 
				{
					i+=(runs[i]-1);
					break;
				}
			}
			if(runs[i]==cardRankValues.size()-i)
			{
				i+=(runs[i]-1);
			}
		}
		
		int pairs=0;
		int trips=0;
		int quads=0;
		
		for(int i=0; i<runs.length; i++)
		{
			if(runs[i]==2) pairs++;
			if(runs[i]==3) trips++;
			if(runs[i]==4) quads++;
		}
		
		if(pairs>0 && trips>0) return 6;
		if(pairs>0 && trips==00) return pairs;
		if(trips>0 && pairs==0) return 3;
		if(quads>0) return 25;
		
		//test straight
		int x=0;
		while(x<hand.size()-1)
		{

			straightSum += cardRankValues.get(x);
			if(cardRankValues.get(x) == (cardRankValues.get(x+1))+1)
			{
				straightCount++;
			}
			x++;
			if(x==hand.size()-1)
				straightSum += cardRankValues.get(x);
		}
		
		//royal case
		if(straightCount == 4 && straightSum == 42) straightCount+=1;
		
		//test flush
		for(int i = 0; i<hand.size()-1; i++)
		{
			if(hand.get(i).getSuit() == hand.get(i+1).getSuit())
			{
				suitCount++;
			}
		}
		
		if(suitCount == 5 && straightCount == 5 && straightSum == 42)
		{
			return 250;
		}
		else if(suitCount == 5 && straightCount == 5)
		{
			return 50;
		}
		else if(suitCount == 5)
		{
			return 5;
		}
		else if(straightCount == 5)
		{
			return 4;
		}
		return 0;
	}
}
