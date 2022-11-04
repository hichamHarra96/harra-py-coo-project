package competition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import competitor.Competitor;
import exception.NotPowerOfTwoException;
import observer.Observer;

public class Tournament extends Competition {

	int nbTours;
	
	/**
	 * Constructor of a tournament
	 * @param comp list of competitors
	 */

	public Tournament(List <Competitor> comp,ArrayList<Observer> ob) {
		super(comp,ob);
	
	}
	/**
	 * play the tournament
	 */
	@Override
	protected void play(List<Competitor> c) throws NotPowerOfTwoException{
		int cpt=0;
		if(isPowerTwo(c.size())) {
			List<Competitor> res=c;
			while (res.size()>1){
				System.out.println("\n tour:" + (cpt+1)+"\n");
				Iterator<Competitor> it = res.iterator();
				while (it.hasNext()) {
					Competitor c1= it.next();
					if(it.hasNext()) {
						Competitor c2= it.next();
						this.playMatch(c1,c2);
					}	
				}
				cpt+=1; 
				res=this.filterListe(c, cpt);
				this.afficheResultTours(res);
			}
		
		}
		else{
			throw new NotPowerOfTwoException("number of competitors is not power of two");
		}
	
		this.afficheRanking(this.ranking());
	}
	/**
	 * filter la liste qui va jouer le tour suivant
	 * @param comp liste a trier 
	 * @param nbTours nobre de tours jouees
	 * @return
	 */
	private List<Competitor> filterListe(List<Competitor> comp,int nbTours) {
		List<Competitor> res = new ArrayList<Competitor>();
		for(Competitor c:comp){
			if(c.getNbrOfRounds()>=nbTours) {
				res.add(c);
			}
		}
		return res;
	}
	
	/**
	 * Display the results of the tours 
	 * @param c
	 */
	void afficheResultTours(List<Competitor> c) {
		String res="";
		for(Competitor comp:c) {
			res += comp.getName() +", ";
		}
		System.out.println(res);
	}
	


}



	
