package Deliverable_3;
import java.util.Scanner;
/* Contains all methods used for running the game. Has 2 players
 * which contain the decks used throughout the game. The two decks
 * belong to no one but are needed temporarily throughout.
 * @author Austin Priest, Emre Erdonmez, Jaycob Bond
*/

public class War extends Game {
    
        private WarPlayer player1, player2;
        private Deck tiedDeck, mainDeck;

        //runs the 26 rounds of comparison
	public void compareCards() {
            Card p1Draw = new WarCard();
            Card p2Draw = new WarCard();
            
            for (int i = 0; i < 26; i++) {
                System.out.println("Round " + (i + 1));
                p1Draw = player1.getDeck().dealCard();
                p2Draw = player2.getDeck().dealCard();
                
                checkCards(p1Draw, p2Draw);
            }
	}
        
        public void setPlayers(WarPlayer player1, WarPlayer player2) {
            this.player1 = player1;
            this.player2 = player2;
        }
        
        //checks the cards and places into the correct sidedeck
	public void checkCards(Card p1Draw, Card p2Draw) {
            
            Card currentTiedCard = new WarCard();
                
                if (p1Draw.getRank() > p2Draw.getRank()) {
                    System.out.println(player1.getPlayerID() + " wins the following cards: ");
                    player1.getSideDeck().setCard(p1Draw);
                    player1.getSideDeck().setCard(p2Draw);
                    System.out.print(p1Draw + " " + p2Draw + " ");
                    while (tiedDeck.getGroupOfCards().size() > 0) {
                        currentTiedCard = tiedDeck.dealCard();
                        player1.getSideDeck().setCard(currentTiedCard);
                        System.out.print(currentTiedCard + " ");
                    }
                    System.out.println();
                } else if (p1Draw.getRank() < p2Draw.getRank()) {
                    System.out.println(player2.getPlayerID() + " wins the following cards: ");
                    player2.getSideDeck().setCard(p1Draw);
                    player2.getSideDeck().setCard(p2Draw);
                    System.out.print(p1Draw + " " + p2Draw + " ");
                    while (tiedDeck.getGroupOfCards().size() > 0) {
                        currentTiedCard = tiedDeck.dealCard();
                        player2.getSideDeck().setCard(currentTiedCard);
                        System.out.print(currentTiedCard + " ");
                    }
                    System.out.println();
                } else {
                    System.out.println("Round was tied.");
                    tiedDeck.setCard(p1Draw);
                    tiedDeck.setCard(p2Draw);
                }
                System.out.println();
	}

	public War() {
            this.setGameName("War");
	}
        
        //asks the players for their names and sets them
        public void getNames() {
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter the name for player 1: ");
            String name = input.nextLine();
            player1 = new WarPlayer(name);
            
            System.out.println("Please enter the name for player 2: ");
            name = input.nextLine();
            player2 = new WarPlayer(name);
        }
        
        //creates all necessary decks
        public void createDecks() {
            mainDeck = new Deck(53);
            player1.setDeck(new Deck(26));
            player2.setDeck(new Deck(26));
            player1.setSideDeck(new Deck(52));
            player2.setSideDeck(new Deck(52));
            
            tiedDeck = new Deck(52);
            
                    
            mainDeck.fillDeck();
            mainDeck.shuffle();
            
            mainDeck.splitDeck(player1.getDeck(), player2.getDeck());
        }

        //the method used to run the game
	public void play() {
            getNames();
            
            System.out.println("Hello to " + player1.getPlayerID() + " and " 
                    + player2.getPlayerID() + " and welcome to our game to our "
                            + "game of " + this.getGameName() + "!!!");
            
            createDecks();
            
            System.out.println();
            System.out.println("First we will split up the decks. ");
            System.out.println("This is your deck, " + player1.getPlayerID() + "\n");
            player1.getDeck().showCards();
            System.out.println();
            
            System.out.println("And this is your deck, " + player2.getPlayerID() + "\n");
            player2.getDeck().showCards();
            System.out.println();
            
            compareCards();
            
            
            System.out.println("Here are the cards that " + player1.getPlayerID() + " has won: ");
            player1.getSideDeck().showCards();
            System.out.println();
            System.out.println("And here are the cards that " + player2.getPlayerID() + " has won: ");
            player2.getSideDeck().showCards(); 
            System.out.println();  
            declareWinner();
            
            
            playAgain();
            
	}

        //determines winner based on who has more cards
	public void declareWinner() {
            System.out.println(player1.getSideDeck().getGroupOfCards().size() + "    " + player2.getSideDeck().getGroupOfCards().size());
            if (player1.getSideDeck().getGroupOfCards().size() != player2.getSideDeck().getGroupOfCards().size()) {
                System.out.print("Our final count shows that ");
                if (player1.getSideDeck().getGroupOfCards().size() > player2.getSideDeck().getGroupOfCards().size())
                    System.out.println(player1.getPlayerID() + " has won with a score of " + 
                        player1.getSideDeck().getGroupOfCards().size() + " to " 
                            + player2.getSideDeck().getGroupOfCards().size());
                else if (player1.getSideDeck().getGroupOfCards().size() < player2.getSideDeck().getGroupOfCards().size())
                    System.out.println(player2.getPlayerID() + " has won with a score of " + 
                        player2.getSideDeck().getGroupOfCards().size() + " to " 
                            + player1.getSideDeck().getGroupOfCards().size());
            } else {
                System.out.println("Looks like we have a tie! ");
            }
	}
        
        //asks the user if they would like to play again
        public void playAgain() {
            System.out.println("Would you like to play again? (y/n) ");
            Scanner input = new Scanner(System.in);
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes"))
                play();
            else 
                System.out.println("Thank you for playing! ");
        }

}