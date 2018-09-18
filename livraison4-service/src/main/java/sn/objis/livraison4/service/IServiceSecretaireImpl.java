package sn.objis.livraison4.service;

import java.util.List;

import sn.objis.livraison4.dao.IDaoSecretaireImpl;
import sn.objis.livraison4.domaine.Secretaire;

/**
 * Date Juillet 23-2018 # La classe 'IServiceSecretaireImpl' fourni une
 * implementation de notre interface 'IServiceSecretaire' qui etend l'interface
 * 'IServiceGenerique'.
 * 
 * @author DIOUF Mamadou
 * @see IServiceSecretaire
 */
public class IServiceSecretaireImpl implements IServiceSecretaire {

	/**
	 * Instanciation d'un objet de type IDaoSecretaireImpl
	 */
	IDaoSecretaireImpl idaoSecretaire = new IDaoSecretaireImpl();

	public void ajouter(Secretaire x) {
		idaoSecretaire.create(x);
	}

	public List<Secretaire> lire() {
		return idaoSecretaire.read();
	}

	public void modifier(Secretaire x) {
		idaoSecretaire.update(x);
	}

	public void supprimer(Secretaire x) {
		idaoSecretaire.delete(x);
	}

	public Secretaire chercherParCode(String code) {
		return idaoSecretaire.findByCode(code);
	}

}
