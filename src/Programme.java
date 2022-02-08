import java.util.InputMismatchException;
import java.util.Scanner;

public class Programme {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		boolean arret = false;
		int choix;
		while (!arret) {
			choix = menu();
			switch (choix) {
			case 1:

				break;
			case 2:

				break;
			case 0:
				arret = true;
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
			System.out.println("Entrer une valeur valide");
			return 10;
		}

	}

	public static void trouverTouteLimouse() {
	}

	public static void afficherTrajet() {
	}

}
