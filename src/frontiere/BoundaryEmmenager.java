package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println("Mais vous Etes deja un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Etes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder villageois = new StringBuilder();
					villageois.append("Bienvenue villageois " + nomVisiteur + "\n");
					villageois.append("Quel est votre force ?\n");
					int force_villageois = -1;
					force_villageois = Clavier.entrerEntier(villageois.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, force_villageois);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
			
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder druide_emmenage = new StringBuilder();
		// force
		druide_emmenage.append("Bienvenue Druide " + nomVisiteur + "\n");
		druide_emmenage.append("Quel est votre force ?\n");
		int druide_force = -1;
		druide_force = Clavier.entrerEntier(druide_emmenage.toString());
		// potion
		int druide_effetPotionMin = -1;
		int druide_effetPotionMax = -2;	
		do{
			druide_emmenage.append("Quel est la potion la plus faible que vous produisez ? \n");
			druide_effetPotionMin = Clavier.entrerEntier(druide_emmenage.toString());
	
			druide_emmenage.append("Quel est la potion la plus forte que vous produisez ? \n");
			druide_effetPotionMax = Clavier.entrerEntier(druide_emmenage.toString());
			
			if(druide_effetPotionMax < druide_effetPotionMin) {
				druide_emmenage.append("Attention Druide, vous vous etes tromper entre le minimum et le maximum \n");
				}
		}while(druide_effetPotionMax < druide_effetPotionMin);
			
		controlEmmenager.ajouterDuide(nomVisiteur, druide_force, druide_effetPotionMin, druide_effetPotionMax);
	}
	
}
