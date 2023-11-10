package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	
	private Village village;
	private Chef abraracourcix;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlLibererEtal controlLibererEtal;
	
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
		controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		
		controlPrendreEtal.prendreEtal("Asterix","patate",10);
	}
	
	@Test
	void testIsVendeur() {
		assertTrue(controlLibererEtal.isVendeur("Asterix"));
		assertFalse(controlLibererEtal.isVendeur("Jhon"));
	}

	@Test
	void testLibererEtal() {
		assertNull(controlLibererEtal.libererEtal("Jhon"));
		assertNotNull(controlLibererEtal.libererEtal("Asterix"));
		
	}

	// assertEquals(expected,actual) teste l'égalité(au sens du equals)entre param 1 et 2
	
}
