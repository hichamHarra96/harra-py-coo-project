package competitionTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import competitor.Competitor;

class CompetitorTest {

	@Test
	void getNametest() {
		Competitor c1 = new Competitor("comp1");
		assertEquals("comp1",c1.getName());
	}
	
	@Test
	void getNbOfVictoiresTest() {
		Competitor c2 = new Competitor("comp1");
		assertSame(0,c2.getNbOfVictoires());
	}
	
	@Test
	void setNbOfVictoiresTest() {
		Competitor c3 = new Competitor("comp1");
		assertSame(0,c3.getNbOfVictoires());
		c3.addNbOfVictoires(4);
		assertSame(4,c3.getNbOfVictoires());
	}
	
	@Test
	void addNbrOfRoundsTest() {
		Competitor c1 = new Competitor("comp1");
		int nbRoundBefore = c1.getNbrOfRounds();
		c1.addNbrOfRounds();
		assertEquals(c1.getNbrOfRounds(), nbRoundBefore + 1);
	}
	
	@Test
	void setNameTest() {
		Competitor c1 = new Competitor("comp1");
		String name = "Test";
		c1.setName(name);
		assertEquals(name, "Test");
	}
}

