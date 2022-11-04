package match;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import competitor.Competitor;
import observer.Observer;

public abstract class Match {

	protected Competitor competitor1;
	protected Competitor competitor2;
	
	protected Competitor winner;
	protected Competitor looser;
	public Match(Competitor c1,Competitor c2 ) {
		this.competitor1=c1;
		this.competitor2=c2;
		this.derouleMatch(this.getCompetitor1(), this.getCompetitor2());
		
	}
	/**
	 * @return the winner
	 */
	public void derouleMatch(Competitor c1,Competitor c2) {
		Random random =new Random();
		int r=random.nextInt(2);
		if (r==0) {
			this.winner=c1;
			this.looser=c2;
		}
		
		else {
			this.winner=c2;
			this.looser=c1;
		}
	}
	
	/**
	 * @return the winner
	 */
	public Competitor getWinner() {
		return this.winner;
	}
	/**
	 * @return the looser
	 */
	public Competitor getLooser() {
		return this.looser;
	}
	
	
	/**
	 * @return the competitor1
	 */
	public Competitor getCompetitor1() {
		return this.competitor1;
	}
	/**
	 * @return the competitor2
	 */
	public Competitor getCompetitor2() {
		return this.competitor2;
	}
}
