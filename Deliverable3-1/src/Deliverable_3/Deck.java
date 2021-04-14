package Deliverable_3;
/* Used to fill and split the deck. They are used specifically for 
 * our game of War.
 * @author Austin Priest, Emre Erdonmez, Jaycob Bond
*/

public class Deck extends GroupOfCards {


        public Deck() {
            
        }
        
        
	public Deck(int givenSize) {
            this.setSize(givenSize);
	}

        //fills the deck in order with the specified size
	public void fillDeck() {
            WarCard card = new WarCard();
            int size = this.getSize();
            for (int i = 0; i < size; i++){  
                this.setCard(new WarCard(i % 13 + 1));
            }
	}
        
        //splits the deck in half
        public void splitDeck(Deck deck1, Deck deck2) {
            int min = Math.min(deck1.getSize(), deck2.getSize());
            for (int i = 0; i < min * 2; i++) {
                if (i % 2 == 0) {
                    deck1.setCard(this.dealCard());
                }
                else {
                    deck2.setCard(this.dealCard());
                }
            }
        }
        
        //prints the card values
	public void showCards() {
            
            int i = 0;
            
            while (i < this.getGroupOfCards().size()) {
                System.out.print(this.getGroupOfCards().get(i) + " ");
                i += 1; 
            }
            System.out.println();
	}
        
        //adds a card to the end of the deck
        public void setCard(Card value) {
            if (this.getGroupOfCards().size() < this.getSize())
                this.getGroupOfCards().add(value);
            else 
                throw new IllegalArgumentException("Deck of cards is full");
        }
        
        //adds a card to a specified index
        public void setCard(int index, Card value) {
            if (this.getSize() < this.getGroupOfCards().size())
                this.getGroupOfCards().set(index, value);
            else 
                throw new IllegalArgumentException("Deck of cards is full");
        }
        
        //gets a card at an index without removing
        public Card getCard(int index) {
            Card dealt = this.getGroupOfCards().get(index);
            return dealt;
        }
        
        //gets the first card in deck without removing
        public Card getCard() {
            Card dealt = this.getGroupOfCards().get(0);
            return dealt;
        }
        
        //deals the top card in the deck
        public Card dealCard() {
            Card dealt = this.getGroupOfCards().get(0);
            this.getGroupOfCards().remove(0);
            return dealt;
        }

}