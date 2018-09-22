package sn.objis.livraison4.service;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Date 2018-07-24 # Cette classe 'ControleInt' controle la saisie des entiers
 * 
 * @author DIOUF Mamadou
 *
 */
public class ControleInt {
	private static Logger logger = Logger.getLogger("InfoLogging");
	/**
	 * La methode 'controleEntier' satic ne recoit rien comme Parametre et renvoie
	 * un int
	 * 
	 * @return int (retourne un entier)
	 */
	public static int controleEntier() {
		Scanner sc = new Scanner(System.in);
		int numero;
		do {
			try {
				numero = Integer.parseInt(sc.nextLine());
				break;
			} catch (Exception e) {
				logger.info("Mettez un entier svp!");
			}
		} while (true);
		return numero;
	}
}
