package observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import competitor.Competitor;
import match.Match;

public class Bookmaker implements Observer {
	private String name;
	private  HashMap<Competitor, Integer> cotes;
	public Bookmaker(String name,List<Competitor> competitors) {
		this.cotes=new HashMap<Competitor,Integer>();
		this.initCotes(competitors);
		this.name=name;
	}

	private void initCotes(List<Competitor> competitors) {
		for (Competitor c:competitors) {
			this.cotes.put(c, 1);
		}
	}
	/**
	 * @return the cotes
	 */
	public HashMap<Competitor, Integer> getCotes() {
		return cotes;
	}

	/**
	 * @param cotes the cotes to set
	 */
	public void setCotes(HashMap<Competitor, Integer> cotes) {
		this.cotes = cotes;
	}

	@Override
	public void observe(Match match) {
		Competitor win=match.getWinner();
		Competitor los=match.getLooser();
		this.addCote(win);
		this.removeOneCote(los);
		System.out.println("Cote de "+ win.getName()+ " est " + this.getCotes().get(win));
		System.out.println("Cote de "+ los.getName()+ " est " + this.getCotes().get(los));
	}
	
	public void addCote(Competitor c) {
		if (this.getCotes().get(c)>1) {
			this.cotes.put(c, this.getCotes().get(c)-1);
		}
		
	}
	public void removeOneCote(Competitor c) {
		this.cotes.put(c, this.getCotes().get(c)+1);
	}

}
