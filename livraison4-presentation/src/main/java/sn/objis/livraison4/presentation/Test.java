package sn.objis.livraison4.presentation;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.stream.Stream;

import sn.objis.livraison4.domaine.Medecin;
import sn.objis.livraison4.domaine.Patient;
import sn.objis.livraison4.domaine.Secretaire;
import sn.objis.livraison4.service.ControleInt;
import sn.objis.livraison4.service.GenerateCode;
import sn.objis.livraison4.service.IServiceMedecinImpl;
import sn.objis.livraison4.service.IServicePatientImpl;
import sn.objis.livraison4.service.IServiceSecretaireImpl;
import sn.objis.livraison4.service.Menu;

/**
 * La classe principale 'Test', point d'entree de l'application permet de tester
 * les differents services de l'application
 * 
 * @author DIOUF Mamadou
 *
 */
public class Test {
	private static Logger LOGGER = Logger.getLogger("InfoLogging");

	public static void main(String[] args) {
		Menu.menu1();
		Scanner sc = new Scanner(System.in);
		int choix = ControleInt.controleEntier();
		int choix2;
		IServiceMedecinImpl iServiceMedecinImpl = new IServiceMedecinImpl();
		IServicePatientImpl iServicePatientImpl = new IServicePatientImpl();
		IServiceSecretaireImpl iServiceSecretaireImpl = new IServiceSecretaireImpl();
		GenerateCode generateCode = new GenerateCode();
		switch (choix) {

		case 1:
			String rep;
			do {
				Menu.menuMedecin();
				choix2 = ControleInt.controleEntier();
				switch (choix2) {

				case 1:
					Medecin medecin = new Medecin();
					LOGGER.info("Entrer le nom");
					medecin.setNomMedecin(sc.nextLine());
					LOGGER.info("Entrer le prenom");
					LOGGER.info("Entrer le sexe");
					medecin.setSexeMedecin(sc.nextLine());
					medecin.setCodeMedecin(generateCode.generateCodeMedecin());
					iServiceMedecinImpl.ajouter(medecin);
					break;
				case 2:
					LOGGER.info("Entrer le code du medecin a modifier");
					String code = sc.nextLine();
					Medecin nouveauMedecin = iServiceMedecinImpl.chercherParCode(code);
					if (nouveauMedecin != null) {
						LOGGER.info("Entrer le nouveau nom");
						nouveauMedecin.setNomMedecin(sc.nextLine());
						LOGGER.info("Entrer le nouveau prenom");
						nouveauMedecin.setPrenomMedecin(sc.nextLine());
						LOGGER.info("Entrer le nouveau sexe");
						nouveauMedecin.setSexeMedecin(sc.nextLine());
						iServiceMedecinImpl.modifier(nouveauMedecin);
					} else {
						LOGGER.info("Cet code n'existe pas");
					}
					break;
				case 3:
					LOGGER.info("Entrer le code du medecin a supprimer");
					Medecin medecinASupprimer = iServiceMedecinImpl.chercherParCode(sc.nextLine());
					if (medecinASupprimer != null)
						iServiceMedecinImpl.supprimer(medecinASupprimer);
					else
						LOGGER.info("cet medecin n'existe pas");
					break;
				case 4:
					LOGGER.info("Entrer le code du medecin a rechercher");
					Medecin medecinARechercher = iServiceMedecinImpl.chercherParCode(sc.nextLine());
					if (medecinARechercher != null)
						System.out.println(medecinARechercher);
					else
						LOGGER.info("cet medecin n'existe pas");
					break;
				case 5:
					List<Medecin> listMedecin = iServiceMedecinImpl.lire();
					if (listMedecin != null) {
						Stream<Medecin> str = listMedecin.stream();
						str.forEach(System.out::println);
					} else
						LOGGER.info("La liste des medecins est vide");
					break;
				case 6:
					Test.main(args);
					break;
				default:
					LOGGER.info("Verifiez votre choix");
					break;
				}
				LOGGER.info("Voulez-vous rester dans ce menu (o/n)?");
				rep = sc.nextLine();
			} while (rep.equals("o") || rep.equals("O"));
			Test.main(args);
			break;
		case 2:
			String rep1;
			do {
				Menu.menuPatient();
				choix2 = ControleInt.controleEntier();
				switch (choix2) {

				case 1:
					Patient patient = new Patient();
					LOGGER.info("Entrer le nom");
					patient.setNomPatient(sc.nextLine());
					LOGGER.info("Entrer le prenom");
					patient.setPrenomPatient(sc.nextLine());
					LOGGER.info("Entrer le sexe");
					patient.setSexePatient(sc.nextLine());
					LOGGER.info("Entrer l'age");
					int age = ControleInt.controleEntier();
					patient.setAgePatient(age);
					LOGGER.info("Entrer l'adresse");
					patient.setAdressePatient(sc.nextLine());
					LOGGER.info("Entrer l'assurance");
					patient.setAssurancePatient(sc.nextLine());
					patient.setCodePatient(generateCode.generateCodePatient());
					iServicePatientImpl.ajouter(patient);
					break;
				case 2:
					LOGGER.info("Entrer le code du patient a modifier");
					String code = sc.nextLine();
					Patient nouveauPatient = iServicePatientImpl.chercherParCode(code);
					if (nouveauPatient != null) {
						LOGGER.info("Entrer le nouveau nom");
						nouveauPatient.setNomPatient(sc.nextLine());
						LOGGER.info("Entrer le nouveau prenom");
						nouveauPatient.setPrenomPatient(sc.nextLine());
						LOGGER.info("Entrer le sexe");
						nouveauPatient.setSexePatient(sc.nextLine());
						LOGGER.info("Entrer l'age");
						int nouvoAge = ControleInt.controleEntier();
						nouveauPatient.setAgePatient(nouvoAge);
						LOGGER.info("Entrer le nouveau adresse");
						nouveauPatient.setAdressePatient(sc.nextLine());
						LOGGER.info("Entrer l'assurance");
						nouveauPatient.setAssurancePatient(sc.nextLine());
						iServicePatientImpl.modifier(nouveauPatient);
					} else {
						LOGGER.info("Le code n'existe pas");
					}
					break;
				case 3:
					LOGGER.info("Entrer le code du patient a supprimer");
					String codeSup = sc.nextLine();
					Patient patientASupprimer = iServicePatientImpl.chercherParCode(codeSup);
					if (patientASupprimer != null)
						iServicePatientImpl.supprimer(patientASupprimer);
					else
						LOGGER.info("cet patient n'existe pas");
					break;
				case 4:
					LOGGER.info("Entrer le code du patient a rechercher");
					String codePat = sc.nextLine();
					Patient patientARechercher = iServicePatientImpl.chercherParCode(codePat);
					if (patientARechercher != null)
						System.out.println(patientARechercher);
					else
						LOGGER.info("cet patient n'existe pas");
					break;
				case 5:
					List<Patient> listPatient = iServicePatientImpl.lire();
					if (listPatient != null) {
						Stream<Patient> str = listPatient.stream();
						str.forEach(System.out::println);
						LOGGER.info("");
					} else
						LOGGER.info("La liste des patients est vide");
					break;
				case 6:
					Test.main(args);
					break;
				default:
					LOGGER.info("Verifiez votre choix");
					break;
				}
				LOGGER.info("Voulez-vous rester dans ce menu (o/n)?");
				rep1 = sc.nextLine();
			} while (rep1.equals("o") || rep1.equals("O"));
			Test.main(args);
			break;
		case 3:
			String rep2;
			do {
				Menu.menuSecretaire();
				choix2 = ControleInt.controleEntier();
				switch (choix2) {

				case 1:
					Secretaire secretaire = new Secretaire();
					LOGGER.info("Entrer le nom");
					secretaire.setNomSecretaire(sc.nextLine());
					LOGGER.info("Entrer le prenom");
					secretaire.setPrenomSecretaire(sc.nextLine());
					secretaire.setCodeSecretaire(generateCode.generateCodeSecretaire());
					iServiceSecretaireImpl.ajouter(secretaire);
					break;
				case 2:
					LOGGER.info("Entrer le code secretaire a modifier");
					String code = sc.nextLine();
					Secretaire nouvelleSecretaire = iServiceSecretaireImpl.chercherParCode(code);
					if (nouvelleSecretaire != null) {
						LOGGER.info("Entrer le nouveau nom");
						nouvelleSecretaire.setNomSecretaire(sc.nextLine());
						LOGGER.info("Entrer le nouveau prenom");
						nouvelleSecretaire.setPrenomSecretaire(sc.nextLine());
						iServiceSecretaireImpl.modifier(nouvelleSecretaire);
					} else {
						LOGGER.info("Le code n'existe pas");
					}
					break;
				case 3:
					LOGGER.info("Entrer le code secretaire a supprimer");
					String codeSecASup = sc.nextLine();
					Secretaire secretaireASup = iServiceSecretaireImpl.chercherParCode(codeSecASup);
					if (secretaireASup != null)
						iServiceSecretaireImpl.supprimer(secretaireASup);
					else
						LOGGER.info("cette secretaire n'existe pas");
					break;
				case 4:
					LOGGER.info("Entrer le code secretaire a rechercher");
					String codeSecARech = sc.nextLine();
					Secretaire secretaireARech = iServiceSecretaireImpl.chercherParCode(codeSecARech);
					if (secretaireARech != null)
						System.out.println(secretaireARech);
					else
						LOGGER.info("cette secretaire n'existe pas");
					break;
				case 5:
					List<Secretaire> listSecretaire = iServiceSecretaireImpl.lire();
					if (listSecretaire != null) {
						Stream<Secretaire> str = listSecretaire.stream();
						str.forEach(System.out::println);
						LOGGER.info("");
					} else
						LOGGER.info("La liste des secretaires est vide");
					break;
				case 6:
					Test.main(args);
					break;
				default:
					LOGGER.info("Verifiez votre choix");
					break;
				}
				LOGGER.info("Voulez-vous rester dans ce menu (o/n)?");
				rep2 = sc.nextLine();
			} while (rep2.equals("o") || rep2.equals("O"));
			Test.main(args);
			break;
		case 4:
			LOGGER.info("Voulez-vous vraiment quitter l'application (o/n)?");
			String res = sc.nextLine();
			if (res.equals("o") || res.equals("O")) {
				LOGGER.info("Aurevoir A Bientot!!");
				System.exit(0);
			} else
				Test.main(args);
		default:
			LOGGER.info("Verifiez votre choix(1/2/3/4)");
			Test.main(args);
			break;
		}
		sc.close();
	}

}
