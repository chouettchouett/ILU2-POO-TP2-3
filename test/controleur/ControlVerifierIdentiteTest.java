package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private Chef abraracourcix;
	private Gaulois Bonemine;

	
	@BeforeEach
	public void initialiserSituation() { 
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5); 
		abraracourcix = new Chef ("Abraracourcix", 19, village); 
		village.setChef(abraracourcix);
	}
	
	@Test
	void testControlVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertNotNull(controlVerifierIdentite,"Ne renvoie pas null");
	}

	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertTrue(controlVerifierIdentite.verifierIdentite("abraracourcix"));
		assertNull(controlVerifierIdentite.verifierIdentite("Bonemine"));
		assertNull(controlVerifierIdentite.verifierIdentite(""));
	}

}
