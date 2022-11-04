package competitionTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import competition.Competition;
import competitor.Competitor;
import match.Match;

public abstract class CompetitionTest {
	
	protected Competition myCompetition;
	protected Match match;
	protected abstract Competition createCompetition();

	@BeforeEach
	public void init() {
		 this.myCompetition = createCompetition();
	}
	
	/**@Test
	public void rankingTest() {
		int i=10;
		for(Competitor c:this.myCompetition.getCompetitors()) {
			c.addNbOfVictoires(i);
			i--;
		}
		HashMap<Competitor, Integer> rank=this.myCompetition.ranking();
		Set<Competitor> keys =rank.keySet();
	    Iterator<Competitor> it= keys.iterator();
		assertTrue(rank.get(it.next())>0);
		

	}*/
	@Test 
	public void playMatchTest() {
		List<Competitor> l= new ArrayList<Competitor>();
		Competitor c1=new Competitor("hicham");
		Competitor c2=new Competitor("alexendre");
		l.add(c2);
		l.add(c1);
		MockCompetition m=new MockCompetition(l);
		assertTrue((c1.getNbOfVictoires()==0) && (c2.getNbOfVictoires()==0));	
		m.playMatch(c1,c2);
		assertTrue(c1.getNbOfVictoires()==1 || c2.getNbOfVictoires()==1);
	
	}
	@Test
	public void powerTwoTest() {
		List<Competitor> l= new ArrayList<Competitor>();
		Competitor c1=new Competitor("hicham");
		Competitor c2=new Competitor("alexendre");
		l.add(c2);
		l.add(c1);
		MockCompetition m=new MockCompetition(l);
		assertTrue(m.isPowerTwo(4));
		assertFalse(m.isPowerTwo(6));
	}
}
