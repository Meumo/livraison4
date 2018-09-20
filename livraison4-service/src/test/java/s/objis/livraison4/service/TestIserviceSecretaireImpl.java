package s.objis.livraison4.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import sn.objis.livraison4.domaine.Secretaire;
import sn.objis.livraison4.service.IServiceSecretaireImpl;

/**
 * Date Juillet 23-2018 # La classe 'TestIserviceSecretaireImpl' est connue pour
 * tester les differentes methodes de la classe 'IServiceSecretaireImpl'
 * 
 * @author DIOUF Mamadou
 *
 */
public class TestIserviceSecretaireImpl {
	Secretaire secretaire = new Secretaire("TEST", "Test", "TESTCODE");

	/**
	 * Declaration d'une variable de type IServiceSecretaireImpl
	 */
	IServiceSecretaireImpl iServiceSecretaireImpl;

	/**
	 * cette methode sera execut�e avant le lancement des tests
	 */
	@Before
	public void init() {
		iServiceSecretaireImpl = Mockito.mock(IServiceSecretaireImpl.class);
	}

	@Test
	public void testAjouter() {
		iServiceSecretaireImpl.ajouter(secretaire);
	}

	@Test
	public void testLire() {
		List<Secretaire> listSecretaire = new ArrayList<Secretaire>();
		listSecretaire = iServiceSecretaireImpl.lire();
		Assert.assertNotNull(listSecretaire);
	}

	@Test
	public void testModifier() {
		iServiceSecretaireImpl.modifier(secretaire);
	}

	@Test
	public void testSupprimer() {
		iServiceSecretaireImpl.supprimer(secretaire);
	}

	@Test
	public void testChercherParCode() {
		Secretaire secretaireTrouve;
		String code = "COSEC1";
		secretaireTrouve = iServiceSecretaireImpl.chercherParCode(code);
		//Assert.assertNotNull(secretaireTrouve);
	}

}
