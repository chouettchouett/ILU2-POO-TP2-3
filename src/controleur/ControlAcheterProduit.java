package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;
//import controleur.controlTrouverEtalVendeur;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur, Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	
	public boolean verifierIdentite(String acheteur) {
		return controlVerifierIdentite.verifierIdentite(acheteur);
	}
	
	
	private Gaulois[] vendeurProduit(String produit) {
		return village.rechercherVendeursProduit(produit);
	}

	public String nomVendeur(String produit, int numero) {
		return vendeurProduit(produit)[numero - 1].getNom();
	}

	public boolean nonpossedeProduits(String produit) {
		return vendeurProduit(produit) == null;
	}

	public String afficherEtalProduit(String produit) {
		StringBuilder chaine = new StringBuilder();
		Gaulois[] gauloisProduit;
		gauloisProduit = vendeurProduit(produit);
		for (int i = 0; i < gauloisProduit.length; i++) {
			chaine.append(i + 1 + " - " + gauloisProduit[i].getNom() + "\n");
		}
		return chaine.toString();
	}
	public String acheterProduit(String nomAcheteur, String produit) {
	    StringBuilder chaine = new StringBuilder();
	    
	    // Vérifie l'identité de l'acheteur avec ControlVerifierIdentite
	    boolean acheteurValide = controlVerifierIdentite.verifierIdentite(nomAcheteur);
	    
	    if (!acheteurValide) {
	        return nomAcheteur + " n'est pas un villageois valide. L'achat est impossible.";
	    }
	    
	    // Trouve tous les étals qui vendent le produit demandé
	    List<Etal> etalsVendeurs = controlTrouverEtalVendeur.trouverEtalsVendeurs(produit);
	    
	    if (etalsVendeurs.isEmpty()) {
	        return "Désolé, personne ne vend " + produit + " au marché.";
	    }
	    
	    chaine.append("Chez quels commerçants voulez-vous acheter " + produit + " ?\n");
	    
	    for (int i = 0; i < etalsVendeurs.size(); i++) {
	        Etal etal = etalsVendeurs.get(i);
	        chaine.append(i + 1 + " - " + etal.getNomVendeur() + "\n");
	    }
	    
	    int choixEtal = /* Demande à l'utilisateur de choisir un étal */;
	    
	    if (choixEtal < 1 || choixEtal > etalsVendeurs.size()) {
	        return "Choix d'étal invalide. L'achat est annulé.";
	    }
	    
	    Etal etalChoisi = etalsVendeurs.get(choixEtal - 1);
	    
	    // Demandez la quantité souhaitée à l'acheteur
	    int quantiteSouhaitee = /* Demande à l'utilisateur la quantité souhaitée */;
	    
	    int quantiteAchete = etalChoisi.acheterProduit(produit, quantiteSouhaitee);
	    
	    if (quantiteAchete == 0) {
	        chaine.append(nomAcheteur + " veut acheter " + quantiteSouhaitee + " " + produit + ", malheureusement il n'y en a plus !");
	    } else if (quantiteAchete < quantiteSouhaitee) {
	        chaine.append(nomAcheteur + " veut acheter " + quantiteSouhaitee + " " + produit
	                + ", malheureusement il n'y en a pas suffisamment.\n" + nomAcheteur + " a acheté les " + quantiteAchete
	                + " derniers.");
	    } else {
	        chaine.append(nomAcheteur + " a acheté " + quantiteAchete + " " + produit + " chez " + etalChoisi.getNomVendeur() + ".");
	    }
	    
	    return chaine.toString();
	}

	
}
