/*
 *  @authors Samuel Bergeron, Mathieu Landreville, Ramatoulaye Barry
 */
public class Trajet {
	//Variable
	Limousine limousine;
	String chauffeur,villeD,villeA,kiloD,kiloA;
	
	//Constructeur Trajet
	public Trajet(String chauffeur, String villeDep, String villeArr, String kiloDep, String kiloArr, Limousine limo) {
		limousine = limo;
		this.chauffeur = chauffeur;
		villeD = villeDep;
		villeA = villeArr;
		kiloD = kiloDep;
		kiloA = kiloArr;
	}
	
	//Accesseur Plaque de la limousine
	public String getPlaque() {
		return limousine.getUniqueNumber();
	}
	
	//Accesseur de La limousine
	public Limousine getLimousine() {
		return limousine;
	}

	//M�thode toString
	public String toString() {
		return "\tChauffeur:" + chauffeur + "\n\\tVille de d�part: " + villeD + "\n\tVille d'arriv�e" + villeA + "\n\tKillom�trage au d�part" + kiloD + "\nKilom�trage � l'arriv�e" + kiloA;
	}
}
