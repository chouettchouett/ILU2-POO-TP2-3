package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis desole "+nomAcheteur+" mais il faut etre un habitant de notre village pour commercer ici.\n");
		} else {
			String produit;
			String marchandProduit;
			String resultat;
			int numeroMarchand;
			int nbProduit;
			boolean possedeProduit;
			System.out.println("Quel produit voulez vous acheter ?");
			produit = scan.next();
			possedeProduit = controlAcheterProduit.nonpossedeProduits(produit);
			if (possedeProduit) {
				System.out.println("Desole mais personne ne vend ce produit au marche.\n");
			} else {
				marchandProduit = controlAcheterProduit.afficherEtalProduit(produit);
				String nomVendeur;
				numeroMarchand = Clavier.entrerEntier("Chez quel commercant voulez vous acheter des " + produit + " ?\n" + marchandProduit);
				nomVendeur = controlAcheterProduit.nomVendeur(produit, numeroMarchand);
				System.out.println(nomAcheteur + " se deplace jusqu a l etal du vendeur " + nomVendeur);
				nbProduit = Clavier.entrerEntier("Bonjour " + nomAcheteur + "\nCombien de " + produit + " voulez vous ?\n");
				resultat = controlAcheterProduit.acheterProduit(produit, numeroMarchand, nbProduit, nomAcheteur);
				System.out.println(resultat + "\n");
				//
//				if (resultat == 0) {
//					System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + " malheureusement il n y en a plus\n");
//				} else if (resultat < quantite) {
//					System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit
//							+ " malheureusement il n y en a pas suffisament\n" + nomAcheteur + " a acheter les " + resultat
//							+ " derniers.\n");
//				} else {
//					System.out.println(nomAcheteur + " a acheter " + resultat + " " + produit + " a " + nomVendeur + ".\n");
//				}
			}
		}
	}
	
}
