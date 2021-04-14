/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Deliverable_3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AustinPriest
 */
public class DeckTest {
    
    public DeckTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("This is displayed before the Deck class.\n");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("This is displayed after the Deck class.\n");
    }
    
    @Before
    public void setUp() {
        System.out.println("Called before test case.\n");
    }
    
    @After
    public void tearDown() {
        System.out.println("Called after test case.\n");
    }

    /**
     * Good Test of fillDeck method, of class Deck.
     * True when deck is filled to 52.
     */
    @Test
    public void goodTestFillDeck() {
        System.out.println("fillDeck() good case\n");
        Deck instance = new Deck(52);
        instance.fillDeck();
        boolean expResult = true;
        boolean result = instance.getGroupOfCards().size() == 52;
        assertEquals(expResult, result);
        
    }
    
    /**
     * Bad Test of fillDeck method, of class Deck.
     * True because deck size is 0 and is not filled.
     */
    @Test
    public void badTestFillDeck() {
        System.out.println("fillDeck() bad case\n");
        Deck instance = new Deck(0);
        instance.fillDeck();
        boolean expResult = true;
        boolean result = instance.getGroupOfCards().size() == 0;
        assertEquals(expResult, result);
        
    }
    
    /**
     * Boundary Test of fillDeck method, of class Deck.
     * True because deck was filled.
     */
    @Test
    public void boundaryTestFillDeck() {
        System.out.println("fillDeck() boundary case\n");
        Deck instance = new Deck(1);
        instance.fillDeck();
        boolean expResult = true;
        boolean result = instance.getGroupOfCards().size() == 1;
        assertEquals(expResult, result);
        
    }

    /**
     * Test of splitDeck method, of class Deck.
     * True when deck is split evenly.
     */
    @Test
    public void goodTestSplitDeck() {
        System.out.println("splitDeck() good case\n");
        Deck deck1 = new Deck(3);
        Deck deck2 = new Deck(3);
        Deck instance = new Deck(6);
        for (int i = 0; i < instance.getSize(); i++) {
            instance.setCard(new WarCard(i + 1));
        }
        instance.splitDeck(deck1, deck2);
        System.out.println("deck 1 size: " + deck1.getGroupOfCards().size() + " deck 2 size: " + deck1.getGroupOfCards().size());
        boolean expResult = true;
        boolean result = deck1.getGroupOfCards().size() == deck2.getGroupOfCards().size();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of splitDeck method, of class Deck.
     * True because since 1 deck has a size of 0, neither can be filled.
     */
    @Test
    public void badTestSplitDeck() {
        System.out.println("splitDeck() bad case\n");
        Deck deck1 = new Deck(3);
        Deck deck2 = new Deck(0);
        Deck instance = new Deck(6);
        for (int i = 0; i < instance.getSize(); i++) {
            instance.setCard(new WarCard(i + 1));
        }
        instance.splitDeck(deck1, deck2);
        System.out.println("deck 1 size: " + deck1.getGroupOfCards().size() + " deck 2 size: " + deck1.getGroupOfCards().size());
        System.out.println("deck was not split because deck2 has size of 0.\n");
        boolean expResult = true;
        boolean result = deck1.getGroupOfCards().size() == deck2.getGroupOfCards().size();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of splitDeck method, of class Deck.
     * True despite decks being different sizes, they are filled to the smaller one.
     */
    @Test
    public void boundaryTestSplitDeck() {
        System.out.println("splitDeck() boundary case\n");
        Deck deck1 = new Deck(3);
        Deck deck2 = new Deck(2);
        Deck instance = new Deck(6);
        for (int i = 0; i < instance.getSize(); i++) {
            instance.setCard(new WarCard(i + 1));
        }
        instance.splitDeck(deck1, deck2);
        System.out.println("deck 1 size: " + deck1.getGroupOfCards().size() + " deck 2 size: " + deck1.getGroupOfCards().size());
        boolean expResult = true;
        System.out.println( deck1.getGroupOfCards().size() + "   " + deck2.getGroupOfCards().size());
        boolean result = deck1.getGroupOfCards().size() == deck2.getGroupOfCards().size();
        assertEquals(expResult, result);
    }
    
    
}
