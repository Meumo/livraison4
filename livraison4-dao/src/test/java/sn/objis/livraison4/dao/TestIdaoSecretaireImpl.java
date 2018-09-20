package sn.objis.livraison4.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import junit.framework.Assert;
import sn.objis.livraison4.domaine.Secretaire;

/**
 * Date Juillet 23-2018 # La classe 'TestIdaoSecreatireImpl' est connue pour
 * tester les differentes m�thodes de la classe 'IdaoSecreatireImpl'
 * 
 * @author DIOUF Mamadou
 *
 */
public class TestIdaoSecretaireImpl {
	Secretaire secretaire = new Secretaire("TEST", "Test", "TESTCODE");

	/**
	 * Declaration d'une variable de type IDaoSecretaireImpl
	 */
	IDaoSecretaireImpl idaoSecretaireImpl;

	/**
	 * cette methode sera executee avant le lancement des tests
	 */
	@Before
	public void init() {
		idaoSecretaireImpl = Mockito.mock(IDaoSecretaireImpl.class);
	}

	@Test
	public void testCreate() {
		idaoSecretaireImpl.create(secretaire);
	}

	@Test
	public void testRead() {
		List<Secretaire> listSecretaire = new ArrayList<Secretaire>();
		listSecretaire = idaoSecretaireImpl.read();
		Assert.assertNotNull(listSecretaire);
	}

	@Test
	public void testUpdate() {
		idaoSecretaireImpl.update(secretaire);
	}

	@Test
	public void testDelete() {
		idaoSecretaireImpl.delete(secretaire);
	}

	@Test
	public void testFindByCode() {
		Secretaire secretaireTrouve;
		String code = "COSEC1";
		secretaireTrouve = idaoSecretaireImpl.findByCode(code);
		//Assert.assertNotNull(secretaireTrouve);
	}

}
