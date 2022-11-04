package competitionTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import competition.Competition;
import competition.League;
import competitor.Competitor;
import exception.NotPowerOfTwoException;

class LeagueTest extends CompetitionTest {


	@Override
	protected Competition createCompetition() {
		
		List<Competitor> l= new ArrayList<Competitor>();
		Competitor c1=new Competitor("hicham");
		Competitor c2=new Competitor("alexendre");
		Competitor c3=new Competitor("ilyes");
		Competitor c4=new Competitor("nadine");
		l.add(c2);
		l.add(c1);
		l.add(c3);
		l.add(c4);
		return new League(l);
	}
	@Test
	public void playTest() throws NotPowerOfTwoException {
		this.myCompetition.play();
		List<Competitor>l=this.myCompetition.getCompetitors();
		for(Competitor c:l) {
			assertTrue(c.getNbrOfRounds()>0);
		}
	}

	
}
 