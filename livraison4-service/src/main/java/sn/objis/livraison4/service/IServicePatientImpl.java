package sn.objis.livraison4.service;

import java.util.List;

import sn.objis.livraison4.dao.IDaoPatientImpl;
import sn.objis.livraison4.domaine.Patient;

/**
 * Date Juillet 23-2018 # La classe 'IServicePatientImpl' fourni une
 * implementation de notre interface 'IServiceMedecin' qui etend l'interface
 * 'IServiceGenerique'.
 * 
 * @author DIOUF Mamadou
 * @see IServicePatient
 */
public class IServicePatientImpl implements IServicePatient {

	/**
	 * Instanciation d'un objet de type IDaoPatientImpl
	 */
	IDaoPatientImpl idaoPatient = new IDaoPatientImpl();

	public void ajouter(Patient x) {
		idaoPatient.create(x);
	}

	public List<Patient> lire() {
		return idaoPatient.read();
	}

	public void modifier(Patient x) {
		idaoPatient.update(x);
	}

	public void supprimer(Patient x) {
		idaoPatient.delete(x);
	}

	public Patient chercherParCode(String code) {
		return idaoPatient.findByCode(code);
	}

}
