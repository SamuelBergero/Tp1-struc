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

	//Méthode toString
	public String toString() {
		return "\tChauffeur:" + chauffeur + "\n\\tVille de départ: " + villeD + "\n\tVille d'arrivée" + villeA + "\n\tKillométrage au départ" + kiloD + "\nKilométrage à l'arrivée" + kiloA;
	}
}
