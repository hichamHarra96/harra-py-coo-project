package competition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;


import competitor.Competitor;
import exception.NotPowerOfTwoException;
import match.Match;
import match.MatchNotify;
import match.OrdinaryMatch;
import observer.Observer;
import util.MapUtil;

public abstract class Competition {
	private MatchNotify matchNotify;
	protected ArrayList<Observer> observers;
	private final List <Competitor> competitors;
	protected HashMap<Competitor, Integer> rank;
	
	/**
	 * creat instance of the competition
	 * @param comp list of competitors
	 */
	public Competition (List <Competitor> comp,ArrayList<Observer> ob) {
		this.matchNotify=new MatchNotify();
		this.observers=ob;
		this.competitors= comp;
		this.rank=new HashMap<Competitor,Integer>();
		for(Competitor c:competitors) {
			this.rank.put(c, 0);
		}
		this.addObservers();
	}
	void addObservers() {
		for(Observer ob:this.getObservers()) {
			this.getMatchNotify().addObserver(ob);
		}
	}
	
	
	/**
	 * @return the observers
	 */
	public ArrayList<Observer> getObservers() {
		return this.observers;
	}
	/**
	 * Return the the lis of competitors in this competition
	 * @return the lis of competitors in this competition
	 */
	public List<Competitor> getCompetitors() {
		return this.competitors;
	}
	

	/** renvoie la map triee des joeurs 
	 * @return the rank
	 */
	public Map<Competitor, Integer> getRank() {
		return this.rank;
	}
	
	/**
	 * play the competition
	 * @throws NotPowerOfTwoException 
	 */
	public void play() throws NotPowerOfTwoException {
		this.play(this.competitors);
	}
	
	protected abstract void  play(List <Competitor> comp) throws NotPowerOfTwoException;
	/**
	 * jouer un match entre deux competitors
	 * @param c1 premier competitor
	 * @param c2 deuxieme competitor
	 */
	protected void playMatch(Competitor c1, Competitor c2) {
		 Match m=new OrdinaryMatch(c1,c2);
		if (! c1.equals(c2)){
			Competitor winner=m.getWinner();
			winner.addNbOfVictoires(1);
			winner.addNbrOfRounds();
			this.rank.put(winner,winner.getNbOfVictoires());
			System.out.println(c1.getName()+" vs "+c2.getName()+" --> "+winner.getName()+ " wins!");
			this.matchNotify.notifies(m);
		}
	}
	

	
	/**
	 * Return the rank
	 * @return
	 */
	public HashMap<Competitor, Integer> ranking(){
		return (HashMap<Competitor, Integer>) MapUtil.sortByDescendingValue(this.rank);
	}

	/**
	 * Display the rank
	 * @param affiche le ranking sur la sortie standard
	 */
	public void afficheRanking(Map<Competitor, Integer> r) {
		Set<Competitor> keys=r.keySet();
		Iterator<Competitor> it =keys.iterator();
		System.out.println( " \n     *** ranking *** ");
		while(it.hasNext()) {
			Competitor c= it.next();
			System.out.println(c.getName()+" - "+c.getNbOfVictoires());
		}
	}
	/**
	 * verifie si l'entier passer en param est une puissance de deux
	 * @param n  entier a verifier
	 * @return true si il est une puissance de deux
	 */
	protected boolean isPowerTwo(int n) {
		return (n!=0) && ((n&(n-1))==0);
	}

	/**
	 * @return the matchNotify
	 */
	public MatchNotify getMatchNotify() {
		return this.matchNotify;
	}
	
}

