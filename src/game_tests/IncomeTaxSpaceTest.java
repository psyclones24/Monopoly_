package game_tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import game_code.*;

import org.junit.Before;
import org.junit.Test;

public class IncomeTaxSpaceTest {
	MonopolyGame testGame;
	ArrayList<Player> listOfPlayers;
	
	@Before
	public void setUp() throws Exception {
		testGame = new MonopolyGame(2, new LoadedDie(4));
		listOfPlayers = testGame.getListOfPlayers();
	}

	@Test
	public void testMonopolyGameIncomeTaxSpaceInBoard() { 
		Space testSpace = listOfPlayers.get(0).getCurrentPosition();
		
		for(int i=0; i<28; i++) {
			testSpace = testSpace.getNextSpace();
		}
		
		assertTrue(testSpace instanceof game_code.IncomeTaxSpace);
	}
	
	@Test
	public void testIncomeTaxRemoveFromPlayersMoneyTenPercent() { 	
		Space testSpace = listOfPlayers.get(0).getCurrentPosition();
		
		for(int i=0; i<40; i++) {
			if (i == 28) testSpace.interactWithLandAction(listOfPlayers.get(0));
			testSpace = testSpace.getNextSpace();
		}
		
		assertEquals(1350, listOfPlayers.get(0).getMyMoney());
	}
	
	@Test
	public void testIncomeTaxRemoveFromPlayersMoneyTwoHundred() { 
		Space testSpace = listOfPlayers.get(0).getCurrentPosition();
		listOfPlayers.get(0).changeMyMoney(800);
		
		for(int i=0; i<40; i++) {
			if (i == 28) testSpace.interactWithLandAction(listOfPlayers.get(0));
			testSpace = testSpace.getNextSpace();
		}
		
		assertEquals(2100, listOfPlayers.get(0).getMyMoney());		
	}
}
