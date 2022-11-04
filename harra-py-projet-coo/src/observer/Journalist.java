package observer;

import competitor.Competitor;
import match.Match;


public class Journalist implements Observer {
	private String name;
	
	public Journalist(String name) {
		this.name= name;
		
	}

	@Override
	public void observe(Match match) {
		System.out.println(this.name + " :"+ match.getCompetitor1().getName()+ " vs "+ match.getCompetitor2().getName()+
				" -> "+match.getWinner().getName() + " wins! "+ "losser est "+match.getLooser().getName());
		
	}




}
