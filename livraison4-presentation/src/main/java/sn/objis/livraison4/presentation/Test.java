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
	private static final String NOM="Entrer le nom";
	private static final String PRENOM="Entrer le prenom";
	private static final String CHOIX="Verifiez votre choix";
	private static final String MENU="Voulez-vous rester dans ce menu (o/n)?";
	
	private static final String SEXE="Entrer le sexe";
	private static Logger logger = Logger.getLogger("InfoLogging");

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
					logger.info(NOM);
					medecin.setNomMedecin(sc.nextLine());
					logger.info(PRENOM);
					logger.info(SEXE);
					medecin.setSexeMedecin(sc.nextLine());
					medecin.setCodeMedecin(generateCode.generateCodeMedecin());
					iServiceMedecinImpl.ajouter(medecin);
					break;
				case 2:
					logger.info("Entrer le code du medecin a modifier");
					String code = sc.nextLine();
					Medecin nouveauMedecin = iServiceMedecinImpl.chercherParCode(code);
					if (nouveauMedecin != null) {
						logger.info(NOM);
						nouveauMedecin.setNomMedecin(sc.nextLine());
						logger.info(PRENOM);
						nouveauMedecin.setPrenomMedecin(sc.nextLine());
						logger.info(SEXE);
						nouveauMedecin.setSexeMedecin(sc.nextLine());
						iServiceMedecinImpl.modifier(nouveauMedecin);
					} else {
						logger.info("Cet code n'existe pas");
					}
					break;
				case 3:
					logger.info("Entrer le code du medecin a supprimer");
					Medecin medecinASupprimer = iServiceMedecinImpl.chercherParCode(sc.nextLine());
					if (medecinASupprimer != null)
						iServiceMedecinImpl.supprimer(medecinASupprimer);
					else
						logger.info("cet medecin n'existe pas");
					break;
				case 4:
					logger.info("Entrer le code du medecin a rechercher");
					Medecin medecinARechercher = iServiceMedecinImpl.chercherParCode(sc.nextLine());
					if (medecinARechercher != null)
						logger.info(medecinARechercher.toString());
					else
						logger.info("cet medecin n'existe pas");
					break;
				case 5:
					List<Medecin> listMedecin = iServiceMedecinImpl.lire();
					if (listMedecin != null) {
						for (Medecin medecin2 : listMedecin) {
							logger.info(medecin2.toString());
						}
					} else {
						logger.info("La liste des medecins est vide");}
					break;
				case 6:
					Test.main(args);
					break;
				default:
					logger.info(CHOIX);
					break;
				}
				logger.info(MENU);
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
					logger.info(NOM);
					patient.setNomPatient(sc.nextLine());
					logger.info("PRENOM");
					patient.setPrenomPatient(sc.nextLine());
					logger.info(SEXE);
					patient.setSexePatient(sc.nextLine());
					logger.info("Entrer l'age");
					int age = ControleInt.controleEntier();
					patient.setAgePatient(age);
					logger.info("Entrer l'adresse");
					patient.setAdressePatient(sc.nextLine());
					logger.info("Entrer l'assurance");
					patient.setAssurancePatient(sc.nextLine());
					patient.setCodePatient(generateCode.generateCodePatient());
					iServicePatientImpl.ajouter(patient);
					break;
				case 2:
					logger.info("Entrer le code du patient a modifier");
					String code = sc.nextLine();
					Patient nouveauPatient = iServicePatientImpl.chercherParCode(code);
					if (nouveauPatient != null) {
						logger.info(NOM);
						nouveauPatient.setNomPatient(sc.nextLine());
						logger.info(PRENOM);
						nouveauPatient.setPrenomPatient(sc.nextLine());
						logger.info(SEXE);
						nouveauPatient.setSexePatient(sc.nextLine());
						logger.info("Entrer l'age");
						int nouvoAge = ControleInt.controleEntier();
						nouveauPatient.setAgePatient(nouvoAge);
						logger.info("Entrer le nouveau adresse");
						nouveauPatient.setAdressePatient(sc.nextLine());
						logger.info("Entrer l'assurance");
						nouveauPatient.setAssurancePatient(sc.nextLine());
						iServicePatientImpl.modifier(nouveauPatient);
					} else {
						logger.info("Le code n'existe pas");
					}
					break;
				case 3:
					logger.info("Entrer le code du patient a supprimer");
					String codeSup = sc.nextLine();
					Patient patientASupprimer = iServicePatientImpl.chercherParCode(codeSup);
					if (patientASupprimer != null)
						iServicePatientImpl.supprimer(patientASupprimer);
					else
						logger.info("cet patient n'existe pas");
					break;
				case 4:
					logger.info("Entrer le code du patient a rechercher");
					String codePat = sc.nextLine();
					Patient patientARechercher = iServicePatientImpl.chercherParCode(codePat);
					if (patientARechercher != null)
						logger.info(patientARechercher.toString());
					else
						logger.info("cet patient n'existe pas");
					break;
				case 5:
					List<Patient> listPatient = iServicePatientImpl.lire();
					if (listPatient != null) {
						for (Patient patient2 : listPatient) {
							logger.info(patient2.toString());
							logger.info("");
						}
		
					} else {
						logger.info("La liste des patients est vide");}
					break;
				case 6:
					Test.main(args);
					break;
				default:
					logger.info(CHOIX);
					break;
				}
				logger.info(MENU);
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
					logger.info(NOM);
					secretaire.setNomSecretaire(sc.nextLine());
					logger.info(PRENOM);
					secretaire.setPrenomSecretaire(sc.nextLine());
					secretaire.setCodeSecretaire(generateCode.generateCodeSecretaire());
					iServiceSecretaireImpl.ajouter(secretaire);
					break;
				case 2:
					logger.info("Entrer le code secretaire a modifier");
					String code = sc.nextLine();
					Secretaire nouvelleSecretaire = iServiceSecretaireImpl.chercherParCode(code);
					if (nouvelleSecretaire != null) {
						logger.info(NOM);
						nouvelleSecretaire.setNomSecretaire(sc.nextLine());
						logger.info(PRENOM);
						nouvelleSecretaire.setPrenomSecretaire(sc.nextLine());
						iServiceSecretaireImpl.modifier(nouvelleSecretaire);
					} else {
						logger.info("Le code n'existe pas");
					}
					break;
				case 3:
					logger.info("Entrer le code secretaire a supprimer");
					String codeSecASup = sc.nextLine();
					Secretaire secretaireASup = iServiceSecretaireImpl.chercherParCode(codeSecASup);
					if (secretaireASup != null)
						iServiceSecretaireImpl.supprimer(secretaireASup);
					else
						logger.info("cette secretaire n'existe pas");
					break;
				case 4:
					logger.info("Entrer le code secretaire a rechercher");
					String codeSecARech = sc.nextLine();
					Secretaire secretaireARech = iServiceSecretaireImpl.chercherParCode(codeSecARech);
					if (secretaireARech != null)
						logger.info(secretaireARech.toString());
					else
						logger.info("cette secretaire n'existe pas");
					break;
				case 5:
					List<Secretaire> listSecretaire = iServiceSecretaireImpl.lire();
					if (listSecretaire != null) {
						for (Secretaire secretaire2 : listSecretaire) {
							logger.info(secretaire2.toString());
							logger.info("");
						}
					} else {
						logger.info("La liste des secretaires est vide");}
					break;
				case 6:
					Test.main(args);
					break;
				default:
					logger.info(CHOIX);
					break;
				}
				logger.info(MENU);
				rep2 = sc.nextLine();
			} while (rep2.equals("o") || rep2.equals("O"));
			Test.main(args);
			break;
		case 4:
			logger.info("Voulez-vous vraiment quitter l'application (o/n)?");
			String res = sc.nextLine();
			if (res.equals("o") || res.equals("O")) {
				logger.info("Aurevoir A Bientot!!");
				System.exit(0);
			} else
				Test.main(args);
			break;
		default:
			logger.info(CHOIX+"(1/2/3/4)");
			Test.main(args);
			break;
		}
		sc.close();
	}

}
