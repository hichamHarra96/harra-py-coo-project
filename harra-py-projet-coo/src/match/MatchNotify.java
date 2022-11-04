package match;

import java.util.ArrayList;
import java.util.List;

import observer.Observer;

public class MatchNotify {
	protected  List <Observer> observers;
	public MatchNotify() {
	this.observers=new ArrayList<Observer>();
	}
	public void addObserver(Observer o) {
		this.observers.add(o);
	}
	public void removeObserver(Observer o) {
		this.observers.remove(o);
	}
	public void notifies(Match match) {
		for (Observer ob: this.observers) {
			ob.observe(match);
		}
	}
}
