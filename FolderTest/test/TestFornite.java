package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import icesi.model.Fornite;
import icesi.model.Player;

public class TestFornite {
	
	private Fornite fornite;
	private void stage1() {
		fornite = new Fornite();
	}
	
	@Test
	public void testFillLeves() {
		stage1();
		int amountExpected = 100;
		fornite.getServer().fillServer(100);
		fornite.analyzeServerPlayers();
		int exLevel = fornite.getExpertLevelPlayers().size();
		int meLevel = fornite.getMediumLevelPlayers().size();
		int roLevel = fornite.getRookieLevelPlayers().size();
		int result = exLevel+meLevel+roLevel;
		
		assertTrue(amountExpected == result);
	}

	@Test
	public void testTypePing() {
		stage1();

		Player a = new Player();
		a.setRanking(1999);
		a.setPing(600);
		Player b = new Player();
		b.setRanking(1999);
		b.setPing(300);
		Player c = new Player();
		c.setRanking(1999);
		c.setPing(150);
		fornite.fillLevels(a);
		fornite.fillLevels(b);
		fornite.fillLevels(c);
		int amountGoodping = fornite.getPings()[6].size();
		int amountMediumping = fornite.getPings()[7].size();
		int amountBadping = fornite.getPings()[8].size();
		int amountExpected = 1;
		assertTrue(amountExpected == amountBadping);
		assertTrue(amountExpected == amountGoodping);
		assertTrue(amountExpected == amountMediumping);
		
	}
	
}
