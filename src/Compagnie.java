/*
 *  @authors Samuel Bergeron, Mathieu Landreville, Ramatoulaye Barry
 */
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Compagnie {
	//Variable
	String nom;
	private List<Chauffeur> chauffeurs;
	private List<Limousine> limousines;
	private List<Trajet> trajets;
	
	//Constructeur Compagnie
	public Compagnie(String nom, String chauffeur, String limousine, String trajet) 
	{
		this.nom = nom;
		
		limousines = new ArrayList<Limousine>();
		chauffeurs = new ArrayList<Chauffeur>();
		trajets = new ArrayList<Trajet>();
		
		ajoutLimousine(limousine);
		ajoutChauf(chauffeur);
		ajoutTrajet(trajet);
	}
	
	//Méthode pour ajouter un chauffeur à la liste
	private void ajoutChauf(String filePath) {

		File file = new File(filePath);

		try (FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis);
				Scanner scan = new Scanner(bis);
				Scanner sc = new Scanner(bis)) {
			String total = "";

			while (scan.hasNextLine()) {

				total += scan.nextLine() + "\n";
			}

			String[] tab1 = total.split("\n");
			String[][] tab2 = new String[tab1.length][];
			
			for (int i = 0; i < tab1.length; i++) {
				tab2[i] = tab1[i].split("\t");
			}
			for (int i = 0; i < tab1.length; i++) {
				chauffeurs.add(new Chauffeur(tab2[i][0], tab2[i][1], tab2[i][2], tab2[i][3]));
			}

		} catch (FileNotFoundException e) {
			System.out.println("Le fichier n'a pas été trouvé!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.print("Les données dans " + filePath + " n'ont pas pus être lu\n");
		}

		
	}
	
	//Méthode pour ajouter une limousine à la liste
	private void ajoutLimousine(String filePath) {
		File file = new File(filePath);
		try (FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis);
				Scanner scan = new Scanner(bis);
				Scanner sc = new Scanner(bis)) {
			String total = "";

			while (scan.hasNextLine()) {
				total += scan.nextLine() + "\n";
			}

			String[] tab1 = total.split("\n");
			String[][] tab2 = new String[tab1.length][];
			for (int i = 0; i < tab1.length; i++) {
				tab2[i] = tab1[i].split("\t");
			}
			for (int i = 0; i < tab1.length; i++) {
				limousines.add(new Limousine(tab2[i][0], tab2[i][1], tab2[i][2]));
			}

		} catch (FileNotFoundException e) {
			System.out.println("Le fichier n'a pas été trouvé!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.print("Les donnée dans " + filePath + " n'ont pas pu être lus\n");
		}

	}
	
	//Méthode pour ajouter un trajet à la lsite
	private void ajoutTrajet(String filePath) {
		File file = new File(filePath);
		try (FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis);
				Scanner scan = new Scanner(bis);
				Scanner sc = new Scanner(bis)) {
			String total = "";

			while (scan.hasNextLine()) {
				total += scan.nextLine() + "\n";
			}

			String[] tab1 = total.split("\n");
			String[][] tab2 = new String[tab1.length][];
			
			for (int i = 0; i < tab1.length; i++) {
				tab2[i] = tab1[i].split("\t");
			}

			for (int i = 0; i < tab1.length; i++) {
				Chauffeur chauffeur = find(tab2[i][0].toLowerCase(),chauffeurs, Chauffeur.class);
				if (!(chauffeur == null)) 
				{
					trajets.add(
							new Trajet(
									tab2[i][0],
									tab2[i][1], 
									tab2[i][2], 
									tab2[i][3], 
									tab2[i][4], 
									find(tab2[i][5],limousines, Limousine.class)
									)
							);
					chauffeur.AddTrajet(trajets.get(i));
				} 
				else 
				{
					trajets.add(
							new Trajet(
									null, 
									tab2[i][1], 
									tab2[i][2], 
									tab2[i][3], 
									tab2[i][4],
									find(tab2[i][5],limousines,Limousine.class)
									)
							);
					System.out.print("Le trajet num:" + (i + 1) + " n'a pas de chauffeur");
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Le fichier n'a pas été trouvé!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.print("Les donnée dans " + filePath + " n'a pas pus être lu\n");
		}

	}
	
	//Interface
	private <T extends IGettable> T find(String num, List<? extends IGettable> list, Class<T> type){
		for(IGettable item : list) {
			if(item.getUniqueNumber().equals(num)) {
				return type.cast(item);
			}
		}
		return null;
	}
	
	
	//Get pour afficher les trajets d'une limousine
	public String getTrajetLimousine(String plaque) 
	{
		try 
		{
			return find(plaque,limousines,Limousine.class).toString() + "\nTrajet:\n" + affToutTrajetLimousine(plaque);
			
		} catch (NullPointerException e) {

			return null;
		}
	}
	
	//Méthode pour afficher les trajets d'une limousione
	private String affToutTrajetLimousine(String plaque) 
	{
		String returnText = "";
		for(Trajet trajet : trajets) 
		{
			if(trajet.getPlaque().equals(plaque)) 
			{
				returnText += trajet.toString() + "\n_____________________\n";
			}
		}
		if(returnText.contentEquals("")) {
			return "Il n'y a aucun trajet pour cette limousine";
		}
		return returnText;
	}
	
	
	//Méthode pour affichage des trajets
	public String affTrajets() 
	{
		String returnString = "";
		for(Trajet trajet: trajets) 
		{
			returnString += trajet.toString() + "\n\n";
		}
		
		return returnString;
		
	}
	
	//Méthode pour affichage du chauffeur d'une limousine
	public String affChauffeurLimousine(String numChauffeur) 
	{
		
		try 
		{
			return "\nImmatriculation des limousine de " + numChauffeur + ":\n" + find(numChauffeur, chauffeurs, Chauffeur.class).getLimo();
		}
		catch(Exception e) 
		{
			return "\nAucune limousine n'a été trouvé pour ce chauffeur";
		}
	}
	
	//Get des chauffeurs
	public String getAllChauffeur() {
		String returnString = "";
		for(Chauffeur chauffeur: chauffeurs) 
		{
			returnString += "\n" + chauffeur.getUniqueNumber();			
		}
		return returnString;
	}
	
	//Get des limousines
	public String getAllLimousine() {
		String returnString = "";
		for(Limousine limousine: limousines) 
		{
			returnString += "\n" + limousine.getUniqueNumber();			
		}
		return returnString;
	}
	
}
