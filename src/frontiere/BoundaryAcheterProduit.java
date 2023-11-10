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
		System.out.println("Quel produit voulez vous achetez ?\n");
		String produit = scan.next();
		String[] marchands = controlAcheterProduit.obtenirMarchand(produit);
		if(marchands==null){return;}
		int indiceVendeur = scan.nextInt();
		indiceVendeur--;
		if(controlAcheterProduit.verifierIdentite(marchands[indiceVendeur])) {
			System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur"  + marchands[indiceVendeur] + "\nBonjour " + nomAcheteur + "\nCombien de " + produit + " voulez-vous acheter ?\n");
			int quantite = scan.nextInt();
			int quantiteAchete = controlAcheterProduit.acheterProduit(marchands[indiceVendeur],quantite);
			if (quantiteAchete==0) {
				System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + " malheureusement il n'y en a plus.\n");
			} else if (quantite > quantiteAchete) {
				System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit +" malheureusement " + marchands[indiceVendeur]+ " n'en a plus que "+ quantiteAchete + "." + nomAcheteur + " achète tout le stock de "+ marchands[indiceVendeur]+".");
			}else {
				System.out.println(nomAcheteur+" achète "+quantiteAchete + " " + produit + " à "+ marchands[indiceVendeur]);
			}
		}
	}
}













//package frontiere;
//
//import java.util.Scanner;
//
//import controleur.ControlAcheterProduit;
//
//public class BoundaryAcheterProduit {
//	private Scanner scan = new Scanner(System.in);
//	private ControlAcheterProduit controlAcheterProduit;
//
//	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
//		this.controlAcheterProduit = controlAcheterProduit;
//	}
//
//	public void acheterProduit(String nomAcheteur,String nomVendeur) {
//		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
//			System.out.println("Je suis desole "+nomAcheteur+" mais il faut etre un habitant de notre village pour commercer ici.\n");
//		} else {
//			String produit;
//			String marchandProduit;
//			String resultat;
//			int numeroMarchand;
//			int nbProduit;
//			boolean possedeProduit;
//			System.out.println("Quel produit voulez vous acheter ?");
//			produit = scan.next();
//			possedeProduit = controlAcheterProduit.possedeProduits(produit);
//			if (possedeProduit) {
//				System.out.println("Desole mais personne ne vend ce produit au marche.\n");
//			} else {
//				marchandProduit = controlAcheterProduit.afficherEtalProduit(produit);
//				numeroMarchand = Clavier
//						.entrerEntier("Chez quel commercant voulez vous acheter des " + produit + " ?\n" + marchandProduit);
//				System.out.println(nomAcheteur + " se deplace jusqu a l etal du vendeur " + nomVendeur);
//				nbProduit = Clavier.entrerEntier("Bonjour " + nomAcheteur + "\nCombien de " + produit + " voulez vous ?\n");
//				resultat = controlAcheterProduit.acheterProduit(nomVendeurproduit, numeroMarchand, nbProduit, nomAcheteur);
//				System.out.println(resultat + "\n");
//			}
//		}
//	}
//}