package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private Chef abraracourcix;
	private ControlPrendreEtal controlPrendreEtal;
	
	@BeforeEach
	public void initialiserSituation() { 
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5); 
		abraracourcix = new Chef ("Abraracourcix", 19, village); 
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Asterix",10);
		village.ajouterHabitant(asterix);
		controlPrendreEtal = new ControlPrendreEtal(village);
	}

	@Test
	void testPrendreEtal() {
		assertNotNull(controlPrendreEtal.prendreEtal("Asterix","patate",10));
		assertTrue(controlPrendreEtal.resteEtals());
		assertTrue(controlPrendreEtal.verifierIdentite("Asterix"));
		assertFalse(controlPrendreEtal.verifierIdentite("Jhon"));
	}
	

}
