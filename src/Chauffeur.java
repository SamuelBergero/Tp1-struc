/*
 *  @authors Samuel Bergeron, Mathieu Landreville, Ramatoulaye Barry
 */
import java.util.ArrayList;
import java.util.List;

public class Chauffeur implements IGettable{
	//Variable
	private String nom, prenom, annee, address, num;
	private List<Trajet> trajets;
	private List<Limousine> limousines;
	
	//Constructeur Chauffeur
	public Chauffeur(String nom, String prenom, String annee, String address) {
		this.nom = nom;
		this.prenom = prenom;
		this.annee = annee;
		this.address = address;
		num = creationNum();
		trajets = new ArrayList<Trajet>();
		limousines = new ArrayList<Limousine>();
		System.out.println(num);
	}
	//Getter
	public String getUniqueNumber() {return num;}
	public String getNom() {return nom;}
	public String getPreNom() {return prenom;}
	public String getAnnee() {return annee;}
	public String getAddress() {return address;}
	public String getLimo() 
	{
		String returnString = "Les plaque des limousine sont:\n";
		for(Limousine limousine: limousines) 
		{
			returnString += "\t"+limousine.getUniqueNumber() + "\n";
		}
		return returnString;
	}
	//Setter
	public void AddTrajet(Trajet trajet) {
		trajets.add(trajet);
		
		addLimousine(trajet.getLimousine());
	}

	public void addLimousine(Limousine limo) {
		limousines.add(limo);
	}

	//Méthode pour la création d'un numéro unique
	
	private String creationNum() {
	        String num="";
	        boolean arret=false;
	        int nameCounter = 0;
	        int compte = 0;
	        while(!arret) {
	            if(nom.charAt(nameCounter)=='\''||nom.charAt(nameCounter)==' '||nom.charAt(nameCounter)=='-')
	            {
	                
	            }
	            else {
	            try {
	                
	                num += nom.charAt(nameCounter);
	                compte++;
	            }
	            catch(Exception e){
	                arret=true;
	            }
	            }
	            if (compte == 3){
	                arret = true;
	                compte = 0;
	            }
	            nameCounter++;
	        }
	        arret = false;
	        nameCounter = 0;
	        while(!arret) {
	            if(prenom.charAt(nameCounter)=='\''||prenom.charAt(nameCounter)=='-'||prenom.charAt(nameCounter)==' ')
	            {
	            }
	            else {
	            try {
	                num += prenom.charAt(nameCounter);
	                compte++;
	            }
	            catch(Exception e){
	                arret = true;
	            }
	            }
	            if (compte == 1){
	                arret = true;
	            }
	            nameCounter++;
	        }
	        num += annee.substring(annee.length() -2 ,annee.length());
	        num = num.toLowerCase();
	        return num;
	    }
	
	//Méthode toString
	public String toString() 
	{
		return prenom + " " + nom + "\nNuméro d'identification: " + num + "\nAnnée d,embauche: " + annee + "\nAddresse: " + address;
	}
}
