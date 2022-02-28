/*
 *  @authors Samuel Bergeron, Mathieu Landreville, Ramatoulaye Barry
 */
public class Limousine implements IGettable{
	//Variable
	String immatriculation,couleur,capac;
	
	//Constructeur Limousine
	public Limousine(String im, String cap, String coul) {
		immatriculation = im;
		couleur = coul;
		capac = cap;
	}
	
	//Accesseur num�ro unique de la limousine
	public String getUniqueNumber() {
		return immatriculation;
	}
	
	//M�thode toString
	public String toString() 
	{
		return "Immatriculation: " + immatriculation + "\nCouleur: " + couleur + "\nCapacit� au r�servoir: " + capac;
	}
}
