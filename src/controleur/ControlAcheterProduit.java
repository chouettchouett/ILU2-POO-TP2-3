package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;
import java.util.Scanner;
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
	        
	        // Vérification de l'identité de l'acheteur
	        if (!controlVerifierIdentite.verifierIdentite(nomAcheteur)) {
	            return "Désolé, vous devez être un habitant du village pour acheter au marché.";
	        }
	        
	        // Recherche des vendeurs de ce produit
	        Etal[] etals = controlTrouverEtalVendeur.trouverEtalsVendeurs(produit);
	        
	        if (etals.length == 0) {
	            return "Désolé, personne ne vend ce produit au marché.";
	        }
	        
	        // Affichage des vendeurs disponibles
	        chaine.append("Chez quel commerçant voulez-vous acheter " + produit + " ?\n");
	        for (int i = 0; i < etals.length; i++) {
	            chaine.append((i + 1) + " - " + etals[i].getVendeur().getNom() + "\n");
	        }
	        
	        // Demandez à l'utilisateur de choisir un étal
	        Scanner scanner = new Scanner(System.in);
	        int choixEtal = -1;
	        while (choixEtal < 1 || choixEtal > etals.length) {
	            System.out.print(chaine.toString());
	            System.out.print("Entrez le numéro de l'étal où vous voulez acheter : ");
	            choixEtal = scanner.nextInt();
	        }
	        
	        Etal etalChoisi = etals[choixEtal - 1];
	        
	        // Demandez la quantité souhaitée à l'acheteur
	        System.out.print("Quelle quantité de " + produit + " souhaitez-vous acheter ? ");
	        int quantiteSouhaitee = scanner.nextInt();
	        
	        // Achetez le produit
	        int quantiteAchete = etalChoisi.acheterProduit(quantiteSouhaitee);
	        
	        if (quantiteAchete == 0) {
	            chaine.append(nomAcheteur + " veut acheter " + quantiteSouhaitee + " " + produit + ", mais il n'y en a plus.");
	        } else if (quantiteAchete < quantiteSouhaitee) {
	            chaine.append(nomAcheteur + " veut acheter " + quantiteSouhaitee + " " + produit +
	                    ", mais l'étal n'en a que " + quantiteAchete + ". Il a acheté tout le stock disponible.");
	        } else {
	            chaine.append(nomAcheteur + " a acheté " + quantiteAchete + " " + produit + " chez " + etalChoisi.getVendeur().getNom() + ".");
	        }
	        
	        return chaine.toString();
	    }
}
