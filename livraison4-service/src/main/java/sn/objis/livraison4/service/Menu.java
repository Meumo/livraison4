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
	private static Logger LOGGER = Logger.getLogger("InfoLogging");
	/**
	 * La methode 'menu1()' static avec type de retour void code le menu general.
	 */
	public static void menu1() {
		LOGGER.info("------------------------------------------------------------------\n");
		LOGGER.info("\tBIENVENUE DANS NOTRE APPLICATION GESTION CLINIQUE\n");
		LOGGER.info("------------------------------------------------------------------\n");
		LOGGER.info("1.Gestion Medecin");
		LOGGER.info("2.Gestion Patient");
		LOGGER.info("3.Gestion Secretaire");
		LOGGER.info("4.Quitter\n");

		LOGGER.info("Faites votre choix(1/2/3/4)");
	}

	/**
	 * La methode 'menuMedecin()' static avec type de retour void code le menu d'un
	 * medecin.
	 */
	public static void menuMedecin() {
		LOGGER.info("\t\nGESTION MEDECIN");
		LOGGER.info("1.Creer un medecin");
		LOGGER.info("2.Mettre a jour les donnees d'un medecin");
		LOGGER.info("3.Supprimer un medecin");
		LOGGER.info("4.Rechercher un medecin avec son code");
		LOGGER.info("5.Lister les medecins");
		LOGGER.info("6.Retour au menu precedent");

		LOGGER.info("Faites votre choix(1/2/3/4/5/6)");
	}

	/**
	 * La methode 'menuPatient()' static avec type de retour void code le menu d'un
	 * patient.
	 */
	public static void menuPatient() {
		LOGGER.info("\t\nGESTION PATIENT");
		LOGGER.info("2.Mettre a jour les donnees d'un patient");
		LOGGER.info("3.Supprimer un patient");
		LOGGER.info("4.Rechercher un patient avec son code");
		LOGGER.info("5.Lister les patients");
		LOGGER.info("6.Retour au menu precedent");

		LOGGER.info("Faites votre choix(1/2/3/4/5/6)");
	}

	/**
	 * La methode 'menuSecreatire()' static avec type de retour void code le menu
	 * d'une secretaire.
	 */
	public static void menuSecretaire() {
		LOGGER.info("\t\nGESTION SECRETAIRE");
		LOGGER.info("1.Creer une Secretaire");
		LOGGER.info("2.Mettre a jour les donnees d'une secretaire");
		LOGGER.info("3.Supprimer une scretaire");
		LOGGER.info("4.Rechercher une secretaire avec son code");
		LOGGER.info("5.Lister les secretaires");
		LOGGER.info("6.Retour au menu precedent");

		LOGGER.info("Faites votre choix(1/2/3/4/5/6)");
	}
}
