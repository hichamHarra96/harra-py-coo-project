package competitionTest;

import java.util.List;

import competition.Competition;
import competitor.Competitor;
import exception.NotPowerOfTwoException;

public class MockCompetition extends Competition {

	public MockCompetition(List<Competitor> comp) {
		super(comp);
		
	}

	@Override
	protected void play(List<Competitor> comp) throws NotPowerOfTwoException {
		// TODO Auto-generated method stub

	}
	protected void playMatch(Competitor c1, Competitor c2) {
		if (! c1.equals(c2)){
			Competitor winner=this.getMatch().getWinner(c1, c2);
			winner.addNbOfVictoires(1);
			winner.addNbrOfRounds();
			this.rank.put(winner,winner.getNbOfVictoires());
			System.out.println(c1.getName()+" vs "+c2.getName()+" --> "+winner.getName()+ " wins!");
		}
	}
	protected boolean isPowerTwo(int n) {
		return (n!=0) && ((n&(n-1))==0);
	}

}
