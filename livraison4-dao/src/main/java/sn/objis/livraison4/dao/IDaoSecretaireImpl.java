package sn.objis.livraison4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sn.objis.livraison4.domaine.Secretaire;
import sn.objis.livraison4.utils.MysqlConnection;

/**
 * Date Juillet 23-2018 # La classe 'IDaoSecretaireImpl' fourni une
 * implementation de notre interface 'IDaoSecretaire' qui etend l'interface
 * 'IDaoGenerique'.
 * 
 * @author DIOUF Mamadou
 * @see IDaoSecretaire
 */
public class IDaoSecretaireImpl implements IDaoSecretaire {
	/**
	 * Creation d'une instance de connexion pour acceder a la base de donnees
	 */
	Connection con = MysqlConnection.getInstanceConnection();

	public void create(Secretaire x) {
		try {
			String sql = "INSERT INTO secretaire(nom_secretaire,prenom_secretaire,code_secretaire) values (?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, x.getNomSecretaire());
			ps.setString(2, x.getPrenomSecretaire());
			ps.setString(3, x.getCodeSecretaire());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Secretaire> read() {
		List<Secretaire> listSecretaire = new ArrayList<Secretaire>();
		try {
			String sql = "SELECT * FROM secretaire";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Secretaire secretaire = new Secretaire();

				secretaire.setIdSecretaire(rs.getLong("id_secretaire"));
				secretaire.setNomSecretaire(rs.getString("nom_secretaire"));
				secretaire.setPrenomSecretaire(rs.getString("prenom_secretaire"));
				secretaire.setCodeSecretaire(rs.getString("code_secretaire"));

				listSecretaire.add(secretaire);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listSecretaire;
	}

	public void update(Secretaire x) {
		try {
			String sql = "UPDATE secretaire SET nom_secretaire=?, prenom_secretaire=?  WHERE code_secretaire=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, x.getNomSecretaire());
			ps.setString(2, x.getPrenomSecretaire());
			ps.setString(3, x.getCodeSecretaire());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Secretaire x) {
		try {
			String sql = "DELETE FROM secretaire WHERE code_secretaire=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, x.getCodeSecretaire());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Secretaire findByCode(String code) {
		Secretaire secretaireRecup = null;
		try {
			String sql = "SELECT * FROM secretaire WHERE code_secretaire=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, code);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				secretaireRecup = new Secretaire(rs.getLong("id_secretaire"), rs.getString("nom_secretaire"),
						rs.getString("prenom_secretaire"), rs.getString("code_secretaire"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return secretaireRecup;
	}

}
