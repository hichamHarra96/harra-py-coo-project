package main;

import java.util.ArrayList;
import java.util.List;

import competition.Tournament;
import competitionTest.*;
import competitor.Competitor;
import exception.NotPowerOfTwoException;
import observer.Bookmaker;
import observer.Journalist;
import observer.Observer;

public class TournamentMain {

	public static void main(String[] args) throws NotPowerOfTwoException {
		List<Competitor> comp = new ArrayList<Competitor>();
	    comp.add(new Competitor("Hicham"));
	    comp.add(new Competitor("Alexandre"));
	    comp.add(new Competitor("Lynx"));
	    comp.add(new Competitor("Drift"));
	    Journalist j=new Journalist("journalist");
	    Bookmaker b=new Bookmaker("bookmaker",comp);
	    ArrayList<Observer>obs=new ArrayList<Observer>();
	    obs.add(j);
	   
	    Tournament t = new Tournament(comp,obs);
	   
	    t.play(); 
	}


}


