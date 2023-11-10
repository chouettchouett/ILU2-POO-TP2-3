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
	private ControlVerifierIdentite controlVerifierIdentite;

	
	@BeforeEach
	public void initialiserSituation() { 
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5); 
		abraracourcix = new Chef ("Abraracourcix", 19, village); 
		Gaulois asterix = new Gaulois("Asterix",10);
		village.ajouterHabitant(asterix);
		village.setChef(abraracourcix);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
	}
	
	@Test
	void testControlVerifierIdentiteExiste() {
		assertTrue(controlVerifierIdentite.verifierIdentite("Asterix"));

	}

	@Test
	void testControlVerifierIdentiteNonExiste() {
		assertFalse( controlVerifierIdentite.verifierIdentite("Jhon"));
	}

}
