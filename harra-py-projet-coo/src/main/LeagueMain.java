package main;



import match.*;
import observer.Bookmaker;
import observer.Journalist;
import observer.Observer;

import java.util.ArrayList;
import java.util.List;

import competitor.*;
import exception.NotPowerOfTwoException;
import competition.Competition;
import competition.League;
public class LeagueMain {

	public static void main(String[] args) throws NotPowerOfTwoException {
		List<Competitor> comp = new ArrayList<Competitor>();
	    comp.add(new Competitor("Hicham"));
	    comp.add(new Competitor("Alexandre"));
	    comp.add(new Competitor("Lynx"));
	    comp.add(new Competitor("Drift"));
	    Journalist j=new Journalist("journalist");
	    Bookmaker b=new Bookmaker("bookmaker",comp);
	    ArrayList<Observer>obs=new ArrayList<Observer>();
	    obs.add(b);
	   
	    League l = new League(comp,obs);
	  
	    l.play();
	}

}
