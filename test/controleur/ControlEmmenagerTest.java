package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private Village village;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initialiserSituation() { 
		System.out.println("Initialisation...");
		village = new Village("le village des irr�ductibles", 10, 5); 
		abraracourcix = new Chef ("Abraracourcix", 19, village); 
		village.setChef(abraracourcix);
	}

	@Test
	void testControlEmmenager() {
		ControlEmmenager controlEmmenager = new ControlEmmenager (village); 
		assertNotNull(controlEmmenager, "Constructeur ne renvoie pas null");
	}

	@Test
	void testIsHabitant() {
		ControlEmmenager controlEmmenager  = new ControlEmmenager(village); 
		controlEmmenager.ajouterGaulois ("Bonemine", 10); 
		assertTrue(controlEmmenager.isHabitant("Bonemine")); 
		assertFalse (controlEmmenager.isHabitant("Existe pas")); 
		controlEmmenager.ajouterDuide("Panoramix", 10, 1, 5); 
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
	}

	@Test
	void testAjouterDuide() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village); 
		controlEmmenager.ajouterDuide("Panorasix", 10, 1, 5);
	}

	@Test
	void testAjouterGaulois() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
	}

}