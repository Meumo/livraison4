package sn.objis.livraison4.service;

import java.util.logging.Logger;

/**
 * Date Juillet 23-2018 # La classe 'Menu' gere le menu general et les sous menu
 * de l'apllication
 * 
 * @author DIOUF Mamadou
 *
 */
public class Menu {
	private static Logger logger = Logger.getLogger("InfoLogging");
	/**
	 * La methode 'menu1()' static avec type de retour void code le menu general.
	 */
	public static void menu1() {
		logger.info("------------------------------------------------------------------\n");
		logger.info("\tBIENVENUE DANS NOTRE APPLICATION GESTION CLINIQUE\n");
		logger.info("------------------------------------------------------------------\n");
		logger.info("1.Gestion Medecin");
		logger.info("2.Gestion Patient");
		logger.info("3.Gestion Secretaire");
		logger.info("4.Quitter\n");

		logger.info("Faites votre choix(1/2/3/4)");
	}

	/**
	 * La methode 'menuMedecin()' static avec type de retour void code le menu d'un
	 * medecin.
	 */
	public static void menuMedecin() {
		logger.info("\t\nGESTION MEDECIN");
		logger.info("1.Creer un medecin");
		logger.info("2.Mettre a jour les donnees d'un medecin");
		logger.info("3.Supprimer un medecin");
		logger.info("4.Rechercher un medecin avec son code");
		logger.info("5.Lister les medecins");
		logger.info("6.Retour au menu precedent");

		logger.info("Faites votre choix(1/2/3/4/5/6)");
	}

	/**
	 * La methode 'menuPatient()' static avec type de retour void code le menu d'un
	 * patient.
	 */
	public static void menuPatient() {
		logger.info("\t\nGESTION PATIENT");
		logger.info("2.Mettre a jour les donnees d'un patient");
		logger.info("3.Supprimer un patient");
		logger.info("4.Rechercher un patient avec son code");
		logger.info("5.Lister les patients");
		logger.info("6.Retour au menu precedent");

		logger.info("Faites votre choix(1/2/3/4/5/6)");
	}

	/**
	 * La methode 'menuSecreatire()' static avec type de retour void code le menu
	 * d'une secretaire.
	 */
	public static void menuSecretaire() {
		logger.info("\t\nGESTION SECRETAIRE");
		logger.info("1.Creer une Secretaire");
		logger.info("2.Mettre a jour les donnees d'une secretaire");
		logger.info("3.Supprimer une scretaire");
		logger.info("4.Rechercher une secretaire avec son code");
		logger.info("5.Lister les secretaires");
		logger.info("6.Retour au menu precedent");

		logger.info("Faites votre choix(1/2/3/4/5/6)");
	}
}
