package competitor;

import java.util.Map;

public class Competitor {
	private int nbOfVictoires;
	private String name;
	private int nbrOfRounds;
	
	/**
	 * creat the competitor
	 * @param name name of competitors 
	 */
	public Competitor(String name) {
		this.name=name;
		this.nbOfVictoires=0;
		this.nbrOfRounds=0;
	}

	/** renvoie nombre du victoire du joueur
	 * @return the nbOfVictoires
	 */
	public int getNbOfVictoires() {
		return this.nbOfVictoires;
	}
	/**
	 * set nombre of victoirs
	 * @param i nombre a remplacer
	 */
	public void setVictoires(int i) {
		this.nbOfVictoires=i;
	}
	/**
	 * set number of rounds 
	 * @param i number remplaced
	 */
	public void setRounds(int i) {
		this.nbrOfRounds=i;
	}

	/**
	 * @param nbOfVictoires the nbOfVictoires to set
	 */
	public void addNbrOfRounds() {
		this.nbrOfRounds+=1;
	}	
	
	/**
	 * @param nbOfVictoires
	 */
	public void addNbOfVictoires(int nbOfVictoires) {
		this.nbOfVictoires = this.nbOfVictoires+nbOfVictoires;
	}

	/**
	 * @return the name of competitors
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param anObject
	 * @return
	 * @see java.lang.String#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof Competitor))
	         return false;
	    Competitor other = (Competitor) obj;
	    return this.getName().equals(((Competitor) obj).getName());    
	}


	/**
	 * return the number of rounds of a competitor
	 * @return the nbrOfRounds
	 */
	public int getNbrOfRounds() {
		return this.nbrOfRounds;
	}

	@Override
	public String toString() {
		return "Competitor [nbOfVictoires=" + nbOfVictoires + ", name=" + name + "]";
	}
	
	
}
