package s.objis.livraison4.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import sn.objis.livraison4.domaine.Medecin;
import sn.objis.livraison4.service.IServiceMedecinImpl;

/**
 * Date Juillet 23-2018 # La classe 'TestIserviceMedecinImpl' est con�ue pour
 * tester les differentes m�thodes de la classe 'IServiceMedecinImpl'
 * 
 * @author DIOUF Mamadou
 *
 */
public class TestIserviceMedecinImpl {
	Medecin medecin = new Medecin("TEST", "Test", "F", "CODETEST");

	/**
	 * Declaration d'une variable de type IServiceMedecinImpl
	 */
	IServiceMedecinImpl iServiceMedecinImpl;

	/**
	 * cette methode sera executee avant le lancement des tests
	 */
	@Before
	public void init() {
		iServiceMedecinImpl = Mockito.mock(IServiceMedecinImpl.class);
	}

	@Test
	public void testAjouter() {
		iServiceMedecinImpl.ajouter(medecin);
	}

	@Test
	public void testLire() {
		List<Medecin> listMedecin = new ArrayList<Medecin>();
		listMedecin = iServiceMedecinImpl.lire();
		Assert.assertNotNull(listMedecin);
	}

	@Test
	public void testModifier() {
		iServiceMedecinImpl.modifier(medecin);
	}

	@Test
	public void testSupprimer() {
		iServiceMedecinImpl.supprimer(medecin);
	}

	@Test
	public void testChercherParCode() {
		Medecin medecinTrouve;
		String code = "COMED0";
		medecinTrouve = iServiceMedecinImpl.chercherParCode(code);
		//Assert.assertNotNull(medecinTrouve);
	}

}
