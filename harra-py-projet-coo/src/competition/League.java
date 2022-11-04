package competition;

import java.util.ArrayList;
import java.util.List;

import competitor.Competitor;
import observer.Observer;

public class League extends Competition {

	/**
	 * Constructor of a league (creation instance of league)
	 * @param comp list of competitors
	 */
	public League(List <Competitor> comp,ArrayList<Observer> ob) {
		super(comp,ob);
		// TODO Auto-generated constructor stub
	}
	/**
	 * play the league
	 */
	@Override
	protected void play(List<Competitor> comp) {
		for(Competitor c1:comp) {
			for (Competitor c2:comp){
				this.playMatch(c1, c2);	
			}
		}
		this.afficheRanking(this.ranking());
	}
	
}
