
public class Limousine implements IGettable{
	
	String immatriculation,couleur,capac;
	
	public Limousine(String im, String cap, String coul) {
		immatriculation = im;
		couleur = coul;
		capac = cap;
	}
	public String getUniqueNumber() {
		return immatriculation;
	}
	
	public String toString() 
	{
		return "Immatriculation: " + immatriculation + "\nCouleur: " + couleur + "\nCapacit� au r�servoir: " + capac;
	}
}
