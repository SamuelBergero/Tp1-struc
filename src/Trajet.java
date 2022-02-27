
public class Trajet {

	Limousine limousine;
	String chauffeur,villeD,villeA,kiloD,kiloA;
	public Trajet(String chauffeur, String villeDep, String villeArr, String kiloDep, String kiloArr, Limousine limo) {
		limousine = limo;
		this.chauffeur = chauffeur;
		villeD = villeDep;
		villeA = villeArr;
		kiloD = kiloDep;
		kiloA = kiloArr;
	}

	public String getPlaque() {
		return limousine.getUniqueNumber();
	}
	
	public Limousine getLimousine() {
		return limousine;
	}

	public String toString() {
		return "\tChauffeur:" + chauffeur + "\n\\tVille de départ: " + villeD + "\n\tVille d'arrivée" + villeA + "\n\tKillométrage au départ" + kiloD + "\nKilométrage à l'arrivée" + kiloA;
	}
}
