package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	private Village village;
	private Chef abraracourcix;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	
	private ControlPrendreEtal controlPrendreEtal;
	
	@BeforeEach
	public void initialiserSituation() { 
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5); 
		abraracourcix = new Chef ("Abraracourcix", 19, village); 
		Gaulois asterix = new Gaulois("Asterix",10);
		village.ajouterHabitant(asterix);
		village.setChef(abraracourcix);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlPrendreEtal = new ControlPrendreEtal(village);
	}

	@Test
	void testControlTrouverEtalVendeurExiste() {
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("Asterix"));
		assertNotNull(controlPrendreEtal.prendreEtal("Asterix","patate",10));
		assertNotNull(controlTrouverEtalVendeur.trouverEtalVendeur("Asterix"));
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("Jhon"));
	}

}
