package s.objis.livraison4.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import sn.objis.livraison4.domaine.Patient;
import sn.objis.livraison4.service.IServicePatientImpl;

/**
 * Date Juillet 23-2018 # La classe 'TestIservicePatientImpl' est connue pour
 * tester les differentes methodes de la classe 'IServicePatientImpl'
 * 
 * @author DIOUF Mamadou
 *
 */
public class TestIservicePatientImpl {
	Patient patient = new Patient("TEST", "Test", "F", 10, "TEST", "TEST", "TESTCODE");

	/**
	 * Declaration d'une variable de type IServicePatientImpl
	 */
	IServicePatientImpl iservicePatientImpl;

	/**
	 * cette methode sera executee avant le lancement des tests
	 */
	@Before
	public void init() {
		iservicePatientImpl = Mockito.mock(IServicePatientImpl.class);
	}

	@Test
	public void testAjouter() {
		iservicePatientImpl.ajouter(patient);
	}

	@Test
	public void testLire() {
		List<Patient> listPatient = new ArrayList<Patient>();
		listPatient = iservicePatientImpl.lire();
		Assert.assertNotNull(listPatient);
	}

	@Test
	public void testModifier() {
		iservicePatientImpl.modifier(patient);
	}

	@Test
	public void testSupprimer() {
		iservicePatientImpl.supprimer(patient);
	}

	@Test
	public void testChercherParCode() {
		Patient patientTrouve;
		String code = "COPAT0";
		patientTrouve = iservicePatientImpl.chercherParCode(code);
		//Assert.assertNotNull(patientTrouve);
	}

}
