package sn.objis.livraison4.utils;
/**
 * Cette classe met en oeuvre le design pattern singleton
 * elle permet de restreindre les acc�s � la base en une et une seule instance de
 * connection
 * @author DIOUF Mamadou
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Date Juillet 23-2018 # Cette classe met en oeuvre le design pattern singleton
 * elle permet de restreindre les acces � la base en une et une seule instance
 * de connection.
 * 
 * @author DIOUF Mamadou
 *
 */
public class MysqlConnection {

	/**
	 * url pour acceder � ala base de donnees
	 */
	private static String url = "jdbc:mysql://localhost/gestionclinique";
	/**
	 * Le nom d'utilisateur de la base de donnees
	 */
	private static String userDb = "mamadou";
	/**
	 * Le mot de passe de la base de donnees
	 */
	private static String pwdDb = "mamadou";
	/**
	 * l'unique instance de connexion � la base
	 */
	private static Connection conn = null;

	/**
	 * Constructeur prive pour blocquer la creation d'instance de la classe
	 */
	private MysqlConnection() {
		super();
	}

	/**
	 * Cette methode retourne l'unique instance de connection avec la base
	 * 
	 * @return conn retourne un objet de type connection
	 */
	public static Connection getInstanceConnection() {
		try {
			if (conn == null) {// Accune connexion avec la base
				conn = DriverManager.getConnection(url, userDb, pwdDb);
				System.out.println("\tConnexion �tablie avec la base");
				System.out.println("------------------------------------------------------------");
			}
		} catch (SQLException e) {
			System.out.println("Probl�me de connexion");
			e.printStackTrace();
		}
		return conn;
	}

}
