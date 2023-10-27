package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;
	private Chef abraracourcix;
	private Gaulois Bonemine;
	
	@BeforeEach
	public void initialiserSituation() { 
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5); 
		abraracourcix = new Chef ("Abraracourcix", 19, village); 
		village.setChef(abraracourcix);
		Gaulois Bonemine = new Gaulois("Bonemine", 6);
	}

	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);
		assertNotNull(controlPrendreEtal,"Ne renvoie pas null");
	}

	@Test
	void testResteEtals() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);
		assertTrue(controlPrendreEtal.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);
		assertNotNull(controlPrendreEtal.prendreEtal("Bonemine","salade",3));
		assertNull(controlPrendreEtal.prendreEtal("Bonemine","salade",3));
		assertNull(controlPrendreEtal.prendreEtal("Jhon","patate",3));
	}

	@Test
	void testVerifierIdentite() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite,village);
		assertTrue(controlPrendreEtal.verifierIdentite("Bonemine"));
		assertFalse(controlPrendreEtal.verifierIdentite("John"));
	}

}
