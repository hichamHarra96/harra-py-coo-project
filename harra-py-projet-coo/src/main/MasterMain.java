package main;

import java.util.ArrayList;
import java.util.List;

import competition.League;
import competition.Master;
import competitor.Competitor;
import exception.NotPowerOfTwoException;
import observer.Bookmaker;
import observer.Journalist;
import observer.Observer;
import strategy.ForPerGroupStrategy;
import strategy.Strategy;
import strategy.TwoPerGroupStrategy;
 
public class MasterMain {

	public static void main(String[] args) throws NotPowerOfTwoException{
		List<Competitor> comp = new ArrayList<Competitor>();
		comp.add(new Competitor("Hicham"));
	    comp.add(new Competitor("Alexandre"));
	    comp.add(new Competitor("Lynx"));
	    comp.add(new Competitor("Drift"));

	    comp.add(new Competitor("nadine"));
	    comp.add(new Competitor("ilyes"));
	    comp.add(new Competitor("j1"));
	    comp.add(new Competitor("j2"));
	    Strategy s =new ForPerGroupStrategy(); 
	    Journalist j=new Journalist("journalist");
	    Bookmaker b=new Bookmaker("bookmaker",comp);
	    ArrayList<Observer>obs=new ArrayList<Observer>();
	    obs.add(b);
	   Master m= new Master(comp,obs,2,s);
	 
	    m.play();
	}

}
