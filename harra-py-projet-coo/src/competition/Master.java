package competition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import competitor.Competitor;
import exception.NotPowerOfTwoException;
import observer.Observer;
import strategy.Strategy;

public class Master extends Competition {
	int nbGroups;
	Strategy strategy;
	/**
	 * creat the Master
	 * @param comp list of competitors
	 * @param nbgrp nombre du groupe pour la premiere phase
	 * @param strat strategie avec n selectionne les joueurs qui passent  a la deuxieme phase 
	 */
	public Master(List <Competitor> comp,ArrayList<Observer> ob, int nbgrp, Strategy strat ) {
		super(comp,ob);
		this.strategy=strat;
		this.nbGroups=nbgrp;
	}
	/** renvoie nombre du groupe
	 * @return the nbGroups
	 */
	public int getNbGroups() {
		return this.nbGroups;
	}
	/**
	 * @return the strategy
	 */
	public Strategy getStrategy() {
		return this.strategy;
	}
	/**
	 * decompose la liste des jours au pouls
	 * @return la liste des pools
	 */
	public List<List<Competitor>> decomposionInGroups(){
		int n=this.getCompetitors().size()/this.getNbGroups();
		List<Competitor> comp = this.getCompetitors();
		List<List<Competitor>> l=new ArrayList<List<Competitor>>();
		Iterator<Competitor> it = comp.iterator();
		for(int i = 0; i<this.getNbGroups(); i++) {
			List<Competitor> lc= new ArrayList<Competitor>();
			int j=0;
			while(j<n){
				if(it.hasNext()) {
					lc.add(it.next());
				}
				j++;
			}
			l.add(lc);
		}
		return l;
	}
   /**
    * play th master
    */
	@Override
	protected void play(List<Competitor> comp) throws NotPowerOfTwoException {
		if(sizeOfCompetitorsAllowed()) {
			System.out.println(this.sizeOfCompetitorsAllowed());
			List<List<Competitor>> listPouls=this.decomposionInGroups();
			List<HashMap<Competitor, Integer>> win=this.playLeague(listPouls);
			List<Competitor> l = this.getStrategy().getListOfwinners(win);
			System.out.println("\n	Dexieme phase : \n");
			Tournament t=new Tournament(l,this.getObservers());
			System.out.println("\n taille de liste du tourrnament "+t.getCompetitors().size()+" \n");
			t.play(); 
		}
		else {

			throw new NotPowerOfTwoException("number of competitors is not power of two");

		}
	}
	/**
	 * joue la leaugue avec une poule
	 * @param l une poule du joueurs
	 * @return map of rankings
	 * @throws NotPowerOfTwoException
	 */
	private HashMap<Competitor, Integer> playLeaugueOneGroupe(List<Competitor> l) throws NotPowerOfTwoException{
		League league=new League(l,this.getObservers());
		league.play();
		return league.ranking();
		
	}
	/**
	 * joue la premier phase
	 * @param list liste des pools 
	 * @return list of rankings (de chaque pool)
	 * @throws NotPowerOfTwoException
	 */
	private List<HashMap<Competitor, Integer>> playLeague(List<List<Competitor>> list) throws NotPowerOfTwoException{
		System.out.println("	Premiere phase :\n");
		List<HashMap<Competitor, Integer>> res=new ArrayList<HashMap<Competitor, Integer>>();
		int j=1;
		Iterator<List<Competitor>>it= list.iterator();

		while(it.hasNext()) {
			System.out.println("\n league du groupe:" + j+"\n");
			res.add(this.playLeaugueOneGroupe(it.next()));
			j++;

		}
		return res;
	}
	/**
	 * verifie si la la strategie et le nombre du groupe vont donner une liste d'une taille puissance de 2 pour la deuxieme phase
	 * @return true si verifie
	 */
	public boolean sizeOfCompetitorsAllowed() {
		return this.isPowerTwo(this.getNbGroups()*this.strategy.getNbOfWinnersInPoules());
	}
	
	
}
