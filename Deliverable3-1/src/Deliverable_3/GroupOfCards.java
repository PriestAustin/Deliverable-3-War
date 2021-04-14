package Deliverable_3;

import java.util.*;
import java.util.Random;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author dancye
 */
public class GroupOfCards {

	private int size;
	/**
	 * The group of cards, stored in an ArrayList
	 */
	private ArrayList<Card> cards = new ArrayList<Card>();

        //gets the maximum size of the group of cards
	public int getSize() {
		return this.size;
	}

        //sets the max size of the group of cards
	public void setSize(int size) {
		this.size = size;
	}
        
        public GroupOfCards() {
            
        }
        
	/**
	 * the size of the grouping
	 * @param givenSize
	 */
	public GroupOfCards(int givenSize) {
            this.setSize(givenSize);
	}

	
        
        //gets the arraylist object
        public ArrayList<Card> getGroupOfCards() {
            return this.cards;
        }

        //shuffles the cards
	public void shuffle() {
            Collections.shuffle(cards);
	}

}