import java.util.InputMismatchException;
import java.util.Scanner;

public class Programme {
	static Compagnie compagnie;
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		compagnie = new Compagnie("autoDeluxe",args[0],args[1],args[2]);
		boolean arret = false;
		int choix;
		while (!arret) {
			choix = menu();
			switch (choix) {
			case 1:
				trouverTouteLimouse();
				break;
			case 2:
				afficherTrajet();
				break;
			case 0:
				arret = true;
				break;
			
			default:
				System.out.println("Entrer une valeur valide");
				break;
			}
		}
	}

	public static int menu() {
		try {
			System.out.println("----Menu----");
			System.out.println(
					"1-Trouver toutes les limousines conduites par un chauffeur, sélectionné à partir de son numéro d’identification.");
			System.out.println(
					"2-Afficher toutes les caractéristiques des trajets effectués ainsi que les caractéristiques des limousines utilisées");
			System.out.println("0-Quitter");
			int choice = scan.nextInt();
			scan.nextLine();
			return choice;
		} catch (InputMismatchException e) {
			scan.nextLine();
			return 10;
		}

	}

	public static void trouverTouteLimouse() 
	{
		System.out.println("Entrer le numéro du chauffeur");
		System.out.println("Numéro des chauffeurs:");
		System.out.println(compagnie.getAllChauffeur());
		System.out.println("Chauffeur choisie:");
		String reponse = scan.nextLine();
		
		System.out.println(compagnie.affChauffeurLimousine(reponse));
		
	}

	public static void afficherTrajet() 
	{
		System.out.println("Entrer de plaque de la limousine");
		System.out.println("Numéro des limousines:");
		System.out.println(compagnie.getAllLimousine());
		System.out.println("Plaque de la limousine choisie:");
		String reponse = scan.nextLine();
		
		System.out.println(compagnie.getTrajetLimousine(reponse));
		
	}

}
