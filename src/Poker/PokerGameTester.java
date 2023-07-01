package Poker;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Tests a video poker game simulation.
 */
public class PokerGameTester
{
	public static void main(String[] args)
	{
		ArrayList<Integer> cardNumbers = new ArrayList<Integer>();
		PokerPlayer player = new PokerPlayer();
		DeckOfCards myDeck = new DeckOfCards();
		Scanner in = new Scanner(System.in);
		String inputAsText;
		int input;

		do
		{
			player.setHand(myDeck.dealHand());
			
			System.out.println("\rYou enter a token...");
			player.setTokens(-1);
			System.out.println("You now have " + player.getTokens() + " token(s).\rGood luck!\r");
			
			System.out.println(player.displayHand());
	
			System.out.println("What would you like to do?");
			System.out.println("\r(1)KEEP HAND\r(2)DISCARD CARD(S)\r(3)NEW HAND");
			
			do
			{
				System.out.print("\rEnter your selection: ");
				inputAsText = in.next();
				if(inputAsText.contains("[a-zA-Z]+") == false)
				{
					try {
						   input = Integer.parseInt(inputAsText);
						   if(input != 1 && input != 2 && input != 3)
								System.out.println("Invalid entry.");
						}
						catch (NumberFormatException e)
						{
							System.out.println("Invalid entry.");
							input = 0;
						}
				}
				else 
				{
					input = 0;
				}
			}while(input != 1 && input != 2 && input != 3);
			
			if(input == 2)
			{
				do
				{
					do
					{
						System.out.print("Which cards do you want to discard? (x to stop)");
						inputAsText = in.next();
						if(inputAsText.contains("[a-zA-Z]+") == false)
						{
							try {
								   input = Integer.parseInt(inputAsText);
								   if(input != 1 && input != 2 && input != 3 && input != 4 && input != 5)
										System.out.println("Invalid entry.");
								   else if(cardNumbers.contains(input))
									   System.out.println("You already selected this card.");
								   else if(!cardNumbers.contains(input))
								   {
									   cardNumbers.add(input);
									   System.out.println(cardNumbers);
								   }
								}
								catch (NumberFormatException e)
								{
									if(!inputAsText.toUpperCase().equals("X"))
									{
										System.out.println("Invalid entry.");
										input = 0;
									}
									else
									{
										break;
									}
								}
						}
						else 
						{
							input = 0;
						}
					}while(input != 1 && input != 2 && input != 3 && input != 4 && input != 5);
					if(cardNumbers.size()>=5) break;
				}while(!inputAsText.toUpperCase().equals("X"));
				
				for(int i = 0; i < cardNumbers.size(); i++)
				{
					player.setCard(cardNumbers.get(i) - 1, myDeck.dealCard());
				}
				System.out.println("\r" + player.displayHand());
			}
			else if(input == 3)
			{
				player.setHand(myDeck.dealHand());
				System.out.println("\r" + player.displayHand());
			}
			else System.out.println("\r" + player.displayHand());
			
			cardNumbers.clear();
			int handScore = PokerGame.scoreHand(player.getHand());
			
			if(handScore==0) System.out.println("Better luck next time.");
			else if(handScore==1) System.out.println("One pair! You earned " + handScore + " token.");
			else if(handScore==2) System.out.println("Two pairs! You earned " + handScore + " tokens.");
			else if(handScore==3) System.out.println("Three of a kind! You earned " + handScore + " tokens.");
			else if(handScore==4) System.out.println("Straight! You earned " + handScore + " tokens.");
			else if(handScore==5) System.out.println("Flush! You earned " + handScore + " tokens.");
			else if(handScore==6) System.out.println("Full House! You earned " + handScore + " tokens.");
			else if(handScore==25) System.out.println("Four of a kind! You earned " + handScore + " tokens.");
			else if(handScore==50) System.out.println("Straight Flush! You earned " + handScore + " tokens.");
			else if(handScore==250) System.out.println("Royal Flush! You earned " + handScore + " tokens.");
			player.setTokens(handScore);
			System.out.println("You now have " + player.getTokens() + " token(s).");
			player.clearHand();
			myDeck.resetDeck();
			
			do
			{
				System.out.print("Play again? (Y/N): ");
				inputAsText = in.next();
			}while(!inputAsText.toUpperCase().equals("Y") && !inputAsText.toUpperCase().equals("N") && player.getTokens()>0);
			
		}while(inputAsText.toUpperCase().equals("Y") && player.getTokens()>0);
		
		System.out.println("Thanks for playing!\rYou finished with " + player.getTokens() + " token(s)."); 
		in.close();
	}

}
