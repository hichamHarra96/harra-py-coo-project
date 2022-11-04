package strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import competitor.Competitor;

public interface Strategy {
	public List<Competitor> getListOfwinners(List<HashMap<Competitor, Integer>> l);
	public int getNbOfWinnersInPoules();
}
