package sn.objis.livraison4.dao;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import sn.objis.livraison4.domaine.Medecin;
/**
 * Date Juillet 23-2018 # La classe 'TestIdaoMedecinImpl' est connue pour tester
 * les differentes methodes de la classe 'IdaoMedecinImpl'
 * 
 * @author DIOUF Mamadou
 *
 */
public class TestIdaoMedecinImpl {
	Medecin medecin = new Medecin("TEST", "Test", "F", "CODETEST");

	/**
	 * Declaration d'une variable de type IDaoMedecinImpl
	 */
	IDaoMedecinImpl idaoMedecinImpl;

	/**
	 * cette methode sera executee avant le lancement des tests
	 */
	@Before
	public void init() {
		//idaoMedecinImpl = new IDaoMedecinImpl();
		idaoMedecinImpl = Mockito.mock(IDaoMedecinImpl.class);
	}

	@Test
	public void testCreate() {

		idaoMedecinImpl.create(medecin);
		Mockito.verify(idaoMedecinImpl).create(medecin);
	}

	@Test
	public void testRead() {
		List<Medecin> listMedecin = new ArrayList<Medecin>();
		listMedecin = idaoMedecinImpl.read();
		Assert.assertNotNull(listMedecin);
	}

	@Test
	public void testUpdate() {
		idaoMedecinImpl.update(medecin);
	}

	@Test
	public void testDelete() {
		idaoMedecinImpl.delete(medecin);
	}

	@Test
	public void testFindByCode() {
		//Medecin medecinTrouve=new Medecin();
		String code = "COMED0";
		Medecin medecinTrouve = idaoMedecinImpl.findByCode(code);
		//Assert.assertNotNull(medecinTrouve);
	}

}
