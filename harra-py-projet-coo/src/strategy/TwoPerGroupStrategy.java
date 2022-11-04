package strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import competitor.Competitor;

public class TwoPerGroupStrategy implements Strategy {
	private int nbWinnersInPoule;
	private String name;
	
	/**
	 * creat the strategy
	 */
	public TwoPerGroupStrategy() {
		this.name="TwoPerGroupStrategy";
		this.nbWinnersInPoule=2;
	}
	
	/**
	 * renvoie la liste des competitors qui vont jouer le tournoi 
	 */
	@Override
	public List<Competitor> getListOfwinners(List<HashMap<Competitor, Integer>> l) {
		
		 List<Competitor> res = new ArrayList<Competitor>();
		    for (HashMap<Competitor, Integer> m : l) { 
		        Set<Competitor> keys =m.keySet();
		        Iterator<Competitor> it= keys.iterator();
		        int i=0;
		        while(it.hasNext() && i<2) {
		        	Competitor c = null;
		        	c=it.next();
		        	c.setVictoires(0);
		        	c.setRounds(0);
			        res.add(c);
			        
			        i++;
		        }
		    }
		    System.out.println("taille :  " +res.size());
		return res;
		
	}
	/** renvoie nombre de gagnant a extraire de chaque pool
	 * renvoie nombre de gagnant a extraire de chaque pool
	 */
	@Override
	public int getNbOfWinnersInPoules() {
		return this.nbWinnersInPoule;
	} 

	



}
