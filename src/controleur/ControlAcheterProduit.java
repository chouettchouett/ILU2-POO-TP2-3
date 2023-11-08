package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

import java.util.Objects;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;
	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
								 ControlTrouverEtalVendeur controlTrouverEtalVendeur,
								 Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}


	public String[] obtenirMarchand(String produit){
		Gaulois[] listeMarchands = village.rechercherVendeursProduit(produit);
		StringBuilder chaine = new StringBuilder();
		String[] marchands = null;
		if(listeMarchands == null) {
			chaine.append("Désolé personne ne vend ce produit au marché.\n");
		} else {
			marchands = new String[listeMarchands.length];
			chaine.append("Chez quel commerçant voulez-vous acheter des ");
			chaine.append(produit);
			chaine.append(" ?\n");
			for (int i = 0; i < listeMarchands.length; i++) {
				int j = i + 1;
				chaine.append(j);
				chaine.append(" - ");
				chaine.append(listeMarchands[i].getNom());
				marchands[i]=listeMarchands[i].getNom();
			}
		}
		System.out.println(chaine);
		return marchands;
	}
	public boolean verifierIdentite(String nomVendeur){
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
	public int acheterProduit(String nomVendeur, int quantite){
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return etal.acheterProduit(quantite);
	}
}





//package controleur;
//
//import personnages.Gaulois;
//import villagegaulois.Etal;
//import villagegaulois.Village;
//
//public class ControlAcheterProduit {
//	private Village village;
//	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
//	private ControlVerifierIdentite controlVerifierIdentite;
//
//	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
//			ControlTrouverEtalVendeur controlTrouverEtalVendeur, Village village) {
//		this.village = village;
//		this.controlVerifierIdentite = controlVerifierIdentite;
//		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
//	}
//	
//	public boolean verifierIdentite(String acheteur) {
//		return controlVerifierIdentite.verifierIdentite(acheteur);
//	}
//
//	private Gaulois[] vendeurProduit(String produit) {
//		return village.rechercherVendeursProduit(produit);
//	}
//
//	public boolean possedeProduits(String produit) {
//		return vendeurProduit(produit) == null;
//	}
//
//	public String afficherEtalProduit(String produit) {
//		StringBuilder chaine = new StringBuilder();
//		Gaulois[] gauloisProduit;
//		gauloisProduit = vendeurProduit(produit);
//		for (int i = 0; i < gauloisProduit.length; i++) {
//			chaine.append(i + 1 + " - " + gauloisProduit[i].getNom() + "\n");
//		}
//		return chaine.toString();
//	}
//
//	public String acheterProduit(String nomVendeur,String produit, int numero, int quantite, String nomAcheteur) {
//		StringBuilder chaine = new StringBuilder();
//		Gaulois[] gauloisProduit;
//		Gaulois gaulois;
//		Etal etal;
//		int resultat;
//		gauloisProduit = vendeurProduit(produit);
//		gaulois = gauloisProduit[numero - 1];
//		etal = village.rechercherEtal(gaulois);
//		resultat = etal.acheterProduit(quantite);
//		if (resultat == 0) {
//			chaine.append(
//					nomAcheteur + " veut acheter " + quantite + " " + produit + " malheureusement il n y en a plus\n");
//		} else if (resultat < quantite) {
//			chaine.append(nomAcheteur + " veut acheter " + quantite + " " + produit
//					+ " malheureusement il n y en a pas suffisament\n" + nomAcheteur + " a acheter les " + resultat
//					+ " derniers.\n");
//		} else {
//			chaine.append(nomAcheteur + " a acheter " + resultat + " " + produit + " a " + nomVendeur + ".\n");
//		}
//		return chaine.toString();
//	}
//}