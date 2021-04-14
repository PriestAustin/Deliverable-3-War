package Deliverable_3;
/*This class is specifically for our War game. It gives the player 2 decks
 * which will be used to show hands to be played and won hands.
 * @author Austin Priest, Emre Erdonmez, Jaycob Bond
*/

public class WarPlayer extends Player {

	private Deck deck;
        private Deck sideDeck;

	public WarPlayer() {
		
	}
        
        public WarPlayer(Deck newDeck) {
            this.deck = newDeck;
        }
        
        public WarPlayer(Deck newDeck, Deck sideDeck) {
            this.deck = newDeck;
            this.sideDeck = sideDeck;
        }
        
        public WarPlayer(String name) {
            this.setPlayerID(name);
        }
        
        //sets the player's main deck
        public void setDeck(Deck newDeck) {
            this.deck = newDeck;
        }
        
        //returns the player's main deck
        public Deck getDeck() {
            return this.deck;
        }
        
        //sets the player's side deck
        public void setSideDeck(Deck newDeck) {
            this.sideDeck = newDeck;
        }
        
        //returns the player's side deck
        public Deck getSideDeck() {
            return this.sideDeck;
        }


}