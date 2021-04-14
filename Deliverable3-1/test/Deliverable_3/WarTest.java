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
public class WarTest {
    
    public WarTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("This is displayed before the War test\n");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("This is displayed after the War test\n");
    }
    
    @Before
    public void setUp() {
        System.out.println("This is displayed before a test case\n");
    }
    
    @After
    public void tearDown() {
        System.out.println("This is displayed after a test case\n");
    }

    /**
     * Test of declareWinner method, of class War.
     */
    @Test
    public void goodTestDeclareWinner() {
        WarPlayer player1 = new WarPlayer("a");
        WarPlayer player2 = new WarPlayer("b");
        War instance = new War();
        instance.setPlayers(player1, player2);
        instance.createDecks();
        player1.getSideDeck().setCard(new WarCard(1));
        instance.declareWinner();
    }
    
    /**
     * Test of declareWinner method, of class War.
     */
    @Test
    public void badTestDeclareWinner() {
        WarPlayer player1 = new WarPlayer("a");
        WarPlayer player2 = new WarPlayer("b");
        War instance = new War();
        instance.setPlayers(player1, player2);
        instance.createDecks();
        player2.getSideDeck().setCard(new WarCard(1));
        instance.declareWinner();
    }
    
    /**
     * Test of declareWinner method, of class War.
     */
    @Test
    public void boundaryTestDeclareWinner() {
        WarPlayer player1 = new WarPlayer("a");
        WarPlayer player2 = new WarPlayer("b");
        War instance = new War();
        instance.setPlayers(player1, player2);
        instance.createDecks();
        instance.declareWinner();
    }
    
}
